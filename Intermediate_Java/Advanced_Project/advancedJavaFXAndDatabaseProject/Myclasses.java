/** Justin Pope */

package advancedJavaFXAndDatabaseProject;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Myclasses {

	Pane pane;
	Scene classesPage;
	VBox myClassesLayout;

	Scene removeScene;
	Stage primaryStage;
	BorderPane root;
	Stage confirm;
	Scene optionScene;

	Label welcome = new Label("Welcome");
	TextArea taCourses = new TextArea();
	ArrayList<String> selectedCourses;
	Label selectACourse;	
	ListView<String> courses;	
	ObservableList<String> courseItems;	
	ArrayList<String> courseList;
	DBUtil dbUtil = new DBUtil();
	String ssnNumber;
	
	Stage stage = Login.stage;
	
	Register register = Login.register;
	
	MenuItem manageClass1;
	MenuItem manageClass2;
	MenuItem exitMenu1;
	
	Button add;
	Button remove;
	
	Button removePaneCancel;
	Button removePaneRemove;
	
	Button yes;
	Button no;
	

	public Myclasses() {
		
		createMyclassesPane();
		
	}

	public void createMyclassesPane() {
		
		/** Menu */
        root = new BorderPane();   
        MenuBar menubar = new MenuBar();  
        Menu manageClass = new Menu("Manage Class");  
        manageClass1=new MenuItem("Add Class");  
        manageClass2=new MenuItem("Remove Class");
        Menu exit=new Menu("Exit");  
        exitMenu1=new MenuItem("Exit");  
        manageClass.getItems().addAll(manageClass1,manageClass2);  
        root.setTop(menubar);  
        exit.getItems().add(exitMenu1);  
        menubar.getMenus().addAll(manageClass,exit);  

        pane = new Pane();
        
        welcome.setText(getUserName());

		add = new Button("Add");
		remove = new Button("Remove");

		HBox optionButtons = new HBox(5);
		optionButtons.getChildren().addAll(add, remove);

		taCourses.setEditable(false);
		taCourses.setText(getCourseInfo());
		
		myClassesLayout = new VBox(5);
		myClassesLayout.setPadding(new Insets(10, 10, 10, 10));
		myClassesLayout.getChildren().addAll(root, welcome, taCourses, optionButtons);
		
		pane.getChildren().add(myClassesLayout);
		
		/** Start of Remove Pane */
		Pane removePane = new Pane();
		
		Label removePaneTitle = new Label("Select the courses you want to remove");

		removePaneCancel = new Button("Cancel");
		removePaneRemove = new Button("Remove");

		courseList = new ArrayList<>();
		updateCourseList();

		courseItems = FXCollections.observableArrayList(courseList);
		
		courses = new ListView<>(courseItems);
		courses.setPrefWidth(285);
		
		courses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		selectedCourses = new ArrayList<>();
		
		VBox removePaneCourses = new VBox(5);
		removePaneCourses.getChildren().addAll(removePaneTitle, courses);
		removePaneCourses.setPadding(new Insets(10, 10, 50, 10));
		
		HBox removePaneButtons = new HBox(5);
		removePaneButtons.setPadding(new Insets(10, 10, 10, 10));
		removePaneButtons.getChildren().addAll(removePaneCancel, removePaneRemove);
		
		VBox removePaneLayout = new VBox(5);
		removePaneLayout.setPadding(new Insets(10, 10, 10, 10));
		removePaneLayout.getChildren().addAll(removePaneCourses, removePaneButtons);
		
		removePane.getChildren().add(removePaneLayout);
		
		removeScene = new Scene(removePane);
		/** End of Remove Pane */
		
		/** Start of Option Pane */
		StackPane optionPane = new StackPane();
		
		Label optionTitle = new Label("Are you sure?");
		selectACourse = new Label("");

		yes = new Button("Yes");
		no = new Button("No");

		HBox optionPaneButtons = new HBox(5);
		optionPaneButtons.setPadding(new Insets(10, 10, 10, 10));
		optionPaneButtons.setAlignment(Pos.CENTER);
		optionPaneButtons.getChildren().addAll(yes, no);
		
		VBox optionPaneLayout = new VBox(5);
		optionPaneLayout.setPadding(new Insets(10, 10, 10, 10));
		optionPaneLayout.setAlignment(Pos.CENTER);
		optionPaneLayout.getChildren().addAll(optionTitle, optionPaneButtons, selectACourse);
		
		optionPane.getChildren().add(optionPaneLayout);
		
		manageClass1.setOnAction(e -> Login.stage.setScene(Login.register.registerPage));
		manageClass2.setOnAction(e -> Login.stage.setScene(Login.myClasses.removeScene));
		exitMenu1.setOnAction(e -> System.exit(0));
		
		add.setOnAction(e -> Login.stage.setScene(Login.register.registerPage));
		remove.setOnAction(e -> Login.stage.setScene(Login.myClasses.removeScene));
		
		removePaneCancel.setOnAction(e -> cancelButton());
		removePaneRemove.setOnAction(e -> removeButton());
		
		yes.setOnAction(e -> yesButton());
		no.setOnAction(e -> Login.stage.setScene(Login.myClasses.removeScene));
		

		optionScene = new Scene(optionPane, 300, 150);
		/** End of Option Pane */

		classesPage = new Scene(pane);

	}

	public Scene getScene() {
		return classesPage;
	}

	public void removeButton() {
		selectACourse.setText(null);
		Login.stage.setScene(Login.myClasses.optionScene);
	}
	
	public void yesButton() {
		removeCourses(Login.myClasses.selectedCourses);
		taCourses.setText(Login.myClasses.getCourseInfo());
		Login.refresh();
		Login.stage.setScene(Login.myClasses.removeScene);
	}
	
	public void cancelButton() {
		courses.getSelectionModel().clearSelection();
		Login.stage.setScene(Login.myClasses.classesPage);
	}
	
	public void connectToDB() {
		try {
			dbUtil.connect();
			dbUtil.login(Login.ssnNumber);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
	
	public String getCourseInfo() {
		String studentCourses = "";
		try {
			connectToDB();
			studentCourses = dbUtil.getStudentCourseInfo();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return studentCourses;
	}
	
	public String[] getCourseList() {
		String[] courseArray = null;
		try {
			connectToDB();
			courseArray = dbUtil.getStudentCourseList().split(",");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return courseArray;
	}
	
	public void removeCourses(ArrayList<String> selectedCourses) {
		try {
			selectedCourses.addAll(courses.getSelectionModel().getSelectedItems());
			ArrayList<String> coursesToDelete = new ArrayList<String>();
			for (int i = 0; i < selectedCourses.size(); i++) {
				coursesToDelete.add(selectedCourses.get(i).substring(0, 5));
			}
			try {
				connectToDB();
				dbUtil.deleteCourses(coursesToDelete);
				updateCourseList();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		catch (NullPointerException e) {
			selectACourse.setText("Please select a course first");
		}
	}

	public String getUserName() {
		String name = "";
		try {
			connectToDB();
			name = "Welcome, " + dbUtil.getStudentName();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return name;
	}
	
	public String ArrayListToString(ArrayList<String> arrayList) {
		String array = "";
		for (int i = arrayList.size()-1; i >= 0; i--) {
			if (i == 0)
				array += arrayList.get(i);
			else
				array += arrayList.get(i) + ", ";
		}
		return array;
	}
	
	public void updateCourseList() {
		if (courseList.isEmpty() == false) courseList.clear();
		for (int i = 0; i < getCourseList().length; i++)
			courseList.add(i, getCourseList()[i]);
	}
	
	public void updateListView() {
		courseItems.clear();
		courseItems.addAll(courseList);
	}
}
