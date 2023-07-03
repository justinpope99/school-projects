package databaseConnectionDemo;

import java.sql.*;

public class DBUtil {

	public static Connection connection;
	private Statement statement;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	}
	
	public void connect(String userID, String password, String driver, String URL) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		connection = DriverManager.getConnection(URL, userID, password);
	}
	
	public void CloseDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Execute SQL SELECT commands */
	public String processSQLSelect(String sqlCommand) {
		String row = "";
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			int columnCount = resultSet.getMetaData().getColumnCount();
			
			// Display column names
			for (int i = 1; i <= columnCount; i++) {
				row += resultSet.getMetaData().getColumnName(i) + "\t";
			}
			row +='\n';
			
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					row += resultSet.getString(i) + "\t";
				}
				row +='\n'; 
			}
			row +='\n';
		}
		catch (SQLException ex) {
			return(ex.toString());
		}
		
		return row;
	}
	
	/** Execute SQL DDL, and modification commands */
	public String processSQLNonSelect(String sqlCommand) {
		try {
			// Get a new statement for the current connection
			statement = connection.createStatement();
			
			// Execute a non-SELECT SQL command
			statement.executeUpdate(sqlCommand);
			
			return ("SQL command executed");
		}
		catch (SQLException ex) {
			return(ex.toString());
		}
	}


}
