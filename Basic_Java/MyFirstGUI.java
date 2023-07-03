// Justin Pope

import javafx.application.*;
import javafx.stage.*;

/**
 * A simple JavaFX GUI application
 */

public class MyFirstGUI extends Application
{
	public static void main(String[] args)
	{
		// Launch the application
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		// Set the window's title.
		primaryStage.setTitle("Justin Pope");
		
		// Show the window
		primaryStage.show();
	}
}
