/** Justin Pope */

package advancedJavaFXAndDatabaseProject;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Application {

	Label ssnValidation = new Label("Enter your ssn");
	Label ssn = new Label("SSN: ");
	TextField jtfSSN = new TextField();
	
	DBUtil dbUtil = new DBUtil();
	
	static Pane pane = new Pane();
	static Scene loginPage = new Scene(pane);
	public static Stage stage;

	public static Myclasses myClasses = new Myclasses();
	Scene scene2 = myClasses.getScene();
	
	public static Register register = new Register();
	Scene scene3 = register.getScene();
	
	public static String ssnNumber;

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Login.stage = primaryStage;
		
		HBox title = new HBox(ssnValidation);
		title.setPadding(new Insets(10, 70, 10, 10));

		HBox ssnField = new HBox(ssn, jtfSSN);
		ssnField.setPadding(new Insets(10, 70, 10, 10));

		Button exit = new Button("Exit");
		Button login = new Button("Login");

		exit.setOnAction(e -> System.exit(0));
		login.setOnAction(new LoginHandler());

		HBox loginOptions = new HBox(54);
		loginOptions.setPadding(new Insets(20, 70, 10, 10));
		loginOptions.getChildren().addAll(exit, login);
		loginOptions.setAlignment(Pos.CENTER);

		VBox loginVBox = new VBox(title, ssnField, loginOptions);
		loginVBox.setPadding(new Insets(10, 70, 60, 10));

		pane.getChildren().add(loginVBox);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(loginPage);
		primaryStage.show();
		
	}
	
	class LoginHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
			
			if(login() == true)
				stage.setScene(scene2);
		}
	}

	public boolean login() {
			boolean ok = false;
			try {
				ssnNumber = jtfSSN.getText();
				if(DBUtil.connection == null)
					dbUtil.connect();
				String valid = dbUtil.login(ssnNumber);
				if(dbUtil.isValidStudent() == false) {
					ssnValidation.setText("Error: Student not found");
					dbUtil.setValidStudent(true);
				}
				else { 
					ssnValidation.setText("Connected to: " + valid); ok = true;
					dbUtil.setSsn(valid);
					myClasses.welcome.setText(myClasses.getUserName());
					myClasses.taCourses.setText(myClasses.getCourseInfo());
					refresh();
				}
			} 
			catch (SQLException | ClassNotFoundException e) {
				System.out.println(e);
			}
			catch (NullPointerException e) {
				System.out.println(e);
			}
			return ok;
	}

	public static void refresh() {
		myClasses.updateCourseList();
		myClasses.updateListView();
		myClasses.courses.refresh();
		register.updateListView();
	}
	
}
