package sqlJavaFX;

import java.sql.*;

public class DBUtil {
	
	private String databaseID;
	private String password;
	
	static Connection connection;
	
	public DBUtil() {
		
	}
	
    public void connect(String loginID, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    	databaseID = loginID;
    	this.password = password;
    	connection = DriverManager.getConnection
    ("jdbc:postgresql://localhost:5432/School",
    		databaseID, this.password);
    }

	public String query() throws ClassNotFoundException, SQLException {
	    Class.forName("org.postgresql.Driver");

	    Statement statement = connection.createStatement();
	    
	    String queryString = "SELECT Courses.courseID, title, numOfCredits "
				    	   + "FROM Courses "
				    	   + "INNER JOIN Enrollment "
				    	   + "ON Enrollment.courseId = Courses.courseID "
				    	   + "WHERE Enrollment.ssn = '777888999'";

	    String resultString = "CourseID" + "\t\t" + "Title" + "\t\t\t\t\t\t" + "Credits";
	    ResultSet resultSet = statement.executeQuery(queryString);
	    while (resultSet.next())
	    	resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t" + resultSet.getString(3);
		return resultString;
	}

	  public void close() throws SQLException {
		  connection.close();
	  }
}
