package databaseConnectionDemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class SQLClientFX extends Application {
	private DBUtil MyDB;
	// Text area to enter SQL commands
	private TextArea jtasqlCommand = new TextArea();
	// Text area to display results form SQL commands
	private TextArea jtaSQLResult = new TextArea();
	private ComboBox<String> jcboURL = new ComboBox<>();
	private ComboBox<String> jcboDriver = new ComboBox<>();
	private TextField jtfUsername = new TextField();
	private PasswordField jpfPassword = new PasswordField();
	Button jbtExecuteSQL = new Button("Execute SQL Command");
	Button jbtClearSQLCommand = new Button("Clear");
	Button jbtConnectDB1 = new Button("Connect to Database");
	Button jbtClearSQLResult = new Button("Clear Result");
	Label jlblConnectionStatus = new Label("No connection now");

	ResultSet resultSet = null;
	
	// JDBC info for a database connection
	@Override
	public void start(Stage stage) throws Exception {
		
		/** Menu */
        BorderPane root = new BorderPane();   
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
        
        DatabaseMenu1.setOnAction(e -> connectToDB());
        SQLMenu1.setOnAction(e -> executeSQL());
        SQLMenu2.setOnAction(e -> jtasqlCommand.setText(null));
        SQLMenu3.setOnAction(e -> jtaSQLResult.setText(null));
        
		jtfUsername = new TextField();
		jpfPassword = new PasswordField();
		jcboURL = new ComboBox<>();
		jcboURL.getItems().addAll(
				"jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false",
			    "jdbc:mysql://liang.armstrong.edu/javabook",
			    "jdbc:odbc:exampleMDBDataSource",
			    "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
			    "jdbc:postgresql://localhost:5432/School");
		jcboDriver = new ComboBox<>();
		jcboDriver.getItems().addAll(
				"com.microsoft.sqlserver.jdbc.SQLServerDriver",
			    "com.mysql.jdbc.Driver", "sun.jdbc.odbc.JdbcOdbcDriver",
			    "oracle.jdbc.driver.OracleDriver",
			    "org.postgresql.Driver");
		
		GridPane gridPane = new GridPane();
		gridPane.add((jcboDriver), 1, 0);
		gridPane.add((jcboURL), 1, 1);
		gridPane.add((jtfUsername), 1, 2);
		gridPane.add((jpfPassword), 1, 3);
		gridPane.add(new Label("JDBC Driver"), 0, 0);
		gridPane.add(new Label("Database URL\t"), 0, 1);
		gridPane.add(new Label("Username\t"), 0, 2);
		gridPane.add(new Label("Password\t\t"), 0, 3);
		
		HBox hBoxConnection = new HBox();
		hBoxConnection.getChildren().addAll(
				jlblConnectionStatus, jbtConnectDB1);
		hBoxConnection.setAlignment(Pos.CENTER_RIGHT);
		
		VBox vBoxConnection = new VBox();
		vBoxConnection.getChildren().addAll(
				//new Label("Enter Database Information");
				gridPane, hBoxConnection);
		//gridPane.setStyle("-fx-border-color: black;");
		TitledPane titledPaneDBInfo = new TitledPane("Enter Database Information", vBoxConnection);
		//titledPane.setCollapsible(false);
		
		HBox hBoxSQLCommand = new HBox(5);
		hBoxSQLCommand.getChildren().addAll(
				jbtClearSQLCommand, jbtExecuteSQL);
		hBoxSQLCommand.setAlignment(Pos.CENTER_RIGHT);
		
		//BorderPane borderMenuBar = new BorderPane();
		
		BorderPane borderPaneSqlCommand = new BorderPane();
		//borderPaneSqlCommand.setTop(new Label("Enter an SQL Command"));
		borderPaneSqlCommand.setCenter(new ScrollPane(jtasqlCommand));
		borderPaneSqlCommand.setBottom(hBoxSQLCommand);
		TitledPane titledPaneSQLCmd = new TitledPane("Enter an SQL Command", borderPaneSqlCommand);
		
		HBox hBoxConnectionCommand = new HBox(10);
		hBoxConnectionCommand.getChildren().addAll(titledPaneDBInfo, titledPaneSQLCmd);
		
		BorderPane borderPaneExecutionResult = new BorderPane();
		borderPaneExecutionResult.setCenter(jtaSQLResult);
		borderPaneExecutionResult.setBottom(jbtClearSQLResult);
		TitledPane titledPaneExecutionResult = new TitledPane("SQL Execution Result", borderPaneExecutionResult);
		
		VBox vBoxMain = new VBox();
		vBoxMain.getChildren().addAll(root, hBoxConnectionCommand);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(vBoxMain);
		borderPane.setCenter(titledPaneExecutionResult);
		
		// Create a scene and place it in the stage
		
		Scene scene = new Scene(borderPane, 1250, 500);
		
		stage.setTitle("SQLClient"); // Set the stage title
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); // Display the stage
		
		MyDB = new DBUtil();
		
		jbtConnectDB1.setOnAction(e -> connectToDB());
		jbtExecuteSQL.setOnAction(e -> executeSQL());
		jbtClearSQLCommand.setOnAction(e -> jtasqlCommand.setText(null));
		jbtClearSQLResult.setOnAction(e -> jtaSQLResult.setText(null));	
	}
	
	/** Connect to DB */
	private void connectToDB() {
		try {
			MyDB.connect(jtfUsername.getText().trim(),
					jpfPassword.getText().trim(),
					jcboDriver.getSelectionModel().getSelectedItem(),
					jcboURL.getSelectionModel().getSelectedItem());
			jlblConnectionStatus.setText("Connected to " + jcboURL.getSelectionModel().getSelectedItem());
		}
		catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	/** Execute SQL commands */
	private void executeSQL() {
		if (MyDB.connection == null) {
			jtaSQLResult.setText("Please connect to a database first");
			return;
		}
		else {
			String sqlCommands = jtasqlCommand.getText().trim();
			String[] commands = sqlCommands.replace('\n', ' ').split(";");
			
			for (String aCommand: commands) {
				if (aCommand.trim().toUpperCase().startsWith("SELECT")) {
					jtaSQLResult.appendText(MyDB.processSQLSelect(aCommand));
				}
				else {
					jtaSQLResult.appendText(MyDB.processSQLNonSelect(aCommand));
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
