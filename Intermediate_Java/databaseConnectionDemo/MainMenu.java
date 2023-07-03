package databaseConnectionDemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMenu extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();  
        Scene scene = new Scene(root,200,300);  
        MenuBar menubar = new MenuBar();  
        Menu DatabaseMenu = new Menu("Database");  
        MenuItem DatabaseMenu1=new MenuItem("Connect DB");  
        Menu SQLMenu=new Menu("SQL");  
        MenuItem SQLMenu1=new MenuItem("Execute SQL");  
        MenuItem SQLMenu2=new MenuItem("Clear");  
        MenuItem SQLMenu3=new MenuItem("Clear Result");  
        SQLMenu.getItems().addAll(SQLMenu1,SQLMenu2,SQLMenu3);  
        root.setTop(menubar);  
        DatabaseMenu.getItems().add(DatabaseMenu1);  
        menubar.getMenus().addAll(DatabaseMenu,SQLMenu);  
        
        DatabaseMenu1.setOnAction((ActionEvent e) -> {
            System.out.println("Process New");
        });
        SQLMenu1.setOnAction((ActionEvent e) -> {
            System.out.println("Process Save");
        });  
        SQLMenu2.setOnAction((ActionEvent e) -> {
            System.out.println("Process Save");
        });  
        SQLMenu3.setOnAction((ActionEvent e) -> {
            System.out.println("Process Save");
        });  
        
        primaryStage.setScene(scene);  
        primaryStage.show();  
        
	}

	public static void main(String[] args) {
		launch(args);
	}
}
