/** Justin Pope */

package advancedJavaFXAndDatabaseProject;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Register {

	ListView<String> courses;
	
	ArrayList<String> userSelectedCourses;
	
	DBUtil dbUtil = new DBUtil();
	
	Label selectACourse;

	ObservableList<String> courseItems;
	
	ArrayList<String> courseList;
	
	Scene registerPage;
	
	Button cancel;
	Button add;

	public Register() {
		
		createRegisterPage();
		
	}
	
	public void createRegisterPage() {
		
		Pane pane = new Pane();
		
		selectACourse = new Label(null);
		
		Pane upperPane = new Pane();
		Pane lowerPane = new Pane();
		
		Label title = new Label("Classes:");

		courseList = new ArrayList<>();
		getCourseList();
		
		courseItems = FXCollections.observableArrayList(courseList);
		
		courses = new ListView<>(courseItems);
		courses.setPrefWidth(285);
		courses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		userSelectedCourses = new ArrayList<>();

		cancel = new Button("Cancel");
		
		VBox ListViewVBox = new VBox(5);
		ListViewVBox.getChildren().addAll(title, courses, selectACourse);
		ListViewVBox.setPadding(new Insets(10, 10, 50, 10));
		
		upperPane.getChildren().add(ListViewVBox);
		
		add = new Button("Add");

		HBox registerButtons = new HBox(5);
		registerButtons.setPadding(new Insets(10, 10, 10, 10));
		registerButtons.getChildren().addAll(cancel, add);
		
		lowerPane.getChildren().add(registerButtons);
		
		VBox registerLayout = new VBox(5);
		registerLayout.setPadding(new Insets(10, 10, 10, 10));
		registerLayout.getChildren().addAll(upperPane, lowerPane);
		
		cancel.setOnAction(e -> cancelButton());
		add.setOnAction(e -> register());
		
		pane.getChildren().add(registerLayout);
		
		registerPage = new Scene(pane);
		
	}

	public Scene getScene() {
		return registerPage;
	}
	
	public void cancelButton() {
		courses.getSelectionModel().clearSelection();
		Login.stage.setScene(Login.myClasses.classesPage);
	}

	public void register() {
		Login.register.insertCourses(Login.register.userSelectedCourses);
		Login.myClasses.taCourses.setText(Login.myClasses.getCourseInfo());
		Login.register.selectACourse.setText(null);
		Login.refresh();
	}
	
	public void connectToDB() {
		try {
			dbUtil.connect();
			dbUtil.login(Login.ssnNumber);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
	
	public void getCourseList() {
		try {
			if (courseList.isEmpty() == false) courseList.clear();
			connectToDB();
			courseList.addAll(dbUtil.getUnregisteredCourses());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
	
	public void insertCourses(ArrayList<String> userSelectedCourses) {
		try {
			userSelectedCourses.addAll(courses.getSelectionModel().getSelectedItems());
			ArrayList<String> coursesToInsert = new ArrayList<String>();
			for (int i = 0; i < userSelectedCourses.size(); i++) {
				coursesToInsert.add(userSelectedCourses.get(i).substring(0, 5));
			}
			try {
				connectToDB();
				dbUtil.insertCourse(coursesToInsert);
				getCourseList();
				userSelectedCourses.clear();
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		catch (NullPointerException e) {
			selectACourse.setText("Please select a course first");
		}
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
	
	public void updateListView() {
		getCourseList();
		courseItems.clear();
		courseItems.addAll(courseList);
	}
	
}
