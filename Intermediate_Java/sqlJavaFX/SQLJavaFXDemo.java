package sqlJavaFX;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SQLJavaFXDemo extends Application {

	public static void main(String[] args) {
		
		launch(args);

	}
	
	TextField tfLogin = new TextField();
	TextField tfPassword = new TextField();
	TextArea taCourses = new TextArea();
	
	@Override
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		
		HBox hBox1 = new HBox(5);
		hBox1.setPadding(new Insets(5, 5, 5, 5));
		hBox1.getChildren().addAll(new Label("Login ID:\t"), tfLogin);
		
		HBox hBox2 = new HBox(5);
		hBox2.setPadding(new Insets(5, 5, 5, 5));
		hBox2.getChildren().addAll(new Label("Password:\t"), tfPassword);

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(5, 5, 5, 5));
		vBox.getChildren().addAll(hBox1, hBox2);
		Button btTable = new Button("Login");
		btTable.setOnAction(e -> taCourses.setText(courseOutput()));
		vBox.getChildren().addAll(btTable, new Label("Courses:"), taCourses);

		pane.getChildren().add(vBox);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Project 10");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public String courseOutput() {
		
		DBUtil dbUtil = new DBUtil();
		String loginID = tfLogin.getText();
		String password = tfPassword.getText();
		String courses = "";
		
		try {
			dbUtil.connect(loginID, password);
			courses = dbUtil.query();
			dbUtil.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

		return courses;
		
	}

}
