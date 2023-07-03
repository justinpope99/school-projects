package javaFXDemo;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;

public class JavaFXBarChartDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		int width = 60;
		int height = 60;
		int arcWidth = 100;
		int arcHeight = 60;
		
		Label l1 = new Label("Project --20%");
		Label l2 = new Label("Quiz --10%");
		Label l3 = new Label("Midterm --30%");
		Label l4 = new Label("Final --40%");
		
		Rectangle r1 = new Rectangle(width, height, arcWidth, arcHeight);
		r1.setFill(Color.RED);
		Rectangle r2 = new Rectangle(width, height/2, arcWidth, arcHeight/2);
		r2.setFill(Color.BLUE);
		Rectangle r3 = new Rectangle(width, height*1.5, arcWidth, arcHeight*1.5);
		r3.setFill(Color.GREEN);
		Rectangle r4 = new Rectangle(width, height*2, arcWidth, arcHeight*2);
		r4.setFill(Color.ORANGE);

		VBox vBox1 = new VBox();
		vBox1.setAlignment(Pos.BOTTOM_CENTER);
		vBox1.setPadding(new Insets(5, 5, 5, 5));
		vBox1.getChildren().add(l1);
		vBox1.getChildren().add(r1);
		
		VBox vBox2 = new VBox();
		vBox2.setAlignment(Pos.BOTTOM_CENTER);
		vBox2.setPadding(new Insets(5, 5, 5, 5));
		vBox2.getChildren().add(l2);
		vBox2.getChildren().add(r2);
		
		VBox vBox3 = new VBox();
		vBox3.setAlignment(Pos.BOTTOM_CENTER);
		vBox3.setPadding(new Insets(5, 5, 5, 5));
		vBox3.getChildren().add(l3);
		vBox3.getChildren().add(r3);
		
		VBox vBox4 = new VBox();
		vBox4.setAlignment(Pos.BOTTOM_CENTER);
		vBox4.setPadding(new Insets(5, 5, 5, 5));
		vBox4.getChildren().add(l4);
		vBox4.getChildren().add(r4);
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(0, 4, 2, 4));

		pane.add(vBox1, 0, 0);
		GridPane.setValignment(vBox1, VPos.BOTTOM);
		pane.add(vBox2, 1, 0);
		GridPane.setValignment(vBox2, VPos.BOTTOM);
		pane.add(vBox3, 2, 0);
		GridPane.setValignment(vBox3, VPos.BOTTOM);
		pane.add(vBox4, 3, 0);
		GridPane.setValignment(vBox4, VPos.BOTTOM);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Project 8");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	 public static void main(String[] args) { 

		  launch(args);

		 }
	}
