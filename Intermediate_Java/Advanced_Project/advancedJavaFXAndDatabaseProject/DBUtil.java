/** Justin Pope */

package advancedJavaFXAndDatabaseProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class DBUtil {

	public static Connection connection;
	private Statement statement;
	
	private boolean validStudent = false;
	private String ssn;
	
	public boolean isValidStudent() {
		return validStudent;
	}

	public void setValidStudent(boolean validStudent) {
		this.validStudent = validStudent;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		

	}
	
    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    	connection = DriverManager.getConnection
    			("jdbc:postgresql://localhost:5432/School" , "postgres", "password123");
    }

	public void CloseDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);;
		}
	}

	public String login(String ssn) throws SQLException {
		
		statement = connection.createStatement();
		String ssnResult = "";
		
		String ssnLogin = "SELECT ssn "
						+ "FROM Students "
						+ "WHERE ssn = '"+ ssn +"';";
		
		ResultSet resultSet = statement.executeQuery(ssnLogin);

		while (resultSet.next())
			ssnResult = resultSet.getString(1);
		if(ssnResult.equals(ssn)) {
			validStudent = true;
			setSsn(ssnResult);
		}
		else
			validStudent = false;
		return ssnResult;
	}
	
	public String getStudentCourseInfo() throws ClassNotFoundException, SQLException {
	    
	    statement = connection.createStatement();
	    
	    String queryString = "SELECT Courses.courseID, Courses.title, Enrollment.grade "
	    		+ "FROM Courses "
	    		+ "INNER JOIN Enrollment "
	    		+ "ON Enrollment.courseId = Courses.courseID "
	    		+ "WHERE Enrollment.ssn = '"+ getSsn() +"';";

	    String resultString = "CourseID" + "\t\t" + "Name" + "\t\t\t\t\t" + "Grade";
	    ResultSet resultSet = statement.executeQuery(queryString);
	    while (resultSet.next()) {
	    	if (resultSet.getString(2).length() <= 9)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(2).length() <= 13)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(2).length() <= 14)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(2).length() <= 17)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(1).equals("AFR12"))
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(2).length() <= 18)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(2).length() <= 23)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3);
	    	else if (resultSet.getString(2).length() <= 28)
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t" + resultSet.getString(3);
	    	else
	    		resultString += "\n" + resultSet.getString(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t" + resultSet.getString(3);
	    }
		return resultString;
	}
	
	public String getStudentName() throws ClassNotFoundException, SQLException {
	    
	    statement = connection.createStatement();
	    
	    String queryString = "SELECT firstName, lastName "
	    					+ "FROM Students "
	    					+ "WHERE ssn = '"+ getSsn() +"';";

	    String resultString = "";
	    ResultSet resultSet = statement.executeQuery(queryString);
	    while (resultSet.next())
	    	resultString = resultSet.getString(1) + " " + resultSet.getString(2);
		return resultString;
	}
	
	public String getStudentCourseList() throws ClassNotFoundException, SQLException {
	    
	    statement = connection.createStatement();
	    
	    String queryString = "SELECT Courses.courseID, Courses.title "
	    				   + "FROM Courses "
	    				   + "INNER JOIN Enrollment "
	    				   + "ON Enrollment.courseId = Courses.courseID "
	    				   + "WHERE Enrollment.ssn = '"+ getSsn() +"';";

	    String resultString = "";
	    ResultSet resultSet = statement.executeQuery(queryString);
	    while (resultSet.next())
	    	resultString += resultSet.getString(1) + " - " + resultSet.getString(2) + ",";
		return resultString;
	}
	
	public void deleteCourses(ArrayList<String> coursesToDelete) throws SQLException {
		for (int i = 0; i < coursesToDelete.size(); i++) {
		    String courseID = coursesToDelete.get(i);
		    statement = connection.createStatement();
		    
		    String queryString = "DELETE FROM Enrollment WHERE ssn = '"+ getSsn() +"' AND courseId = '"+ courseID +"';";

		    statement.executeUpdate(queryString);
		}
	}
	
	public TreeSet<String> getUnregisteredCourses() throws SQLException, ClassNotFoundException {
		
		String[] resultArray;
	    
	    statement = connection.createStatement();
	    
	    String queryString = "SELECT Courses.courseID, Courses.title "
	    				   + "FROM Courses "
	    				   + "INNER JOIN Enrollment "
	    				   + "ON Enrollment.courseId = Courses.courseID "
	    				   + "WHERE Enrollment.ssn != '"+ getSsn() +"';";

	    String resultString = "";
	    ResultSet resultSet = statement.executeQuery(queryString);
	    while (resultSet.next())
	    	resultString += resultSet.getString(1) + " - " + resultSet.getString(2) + ",";
	    
	    resultArray = resultString.split(",");
	    String[] registeredCourses = getStudentCourseList().split(",");
	    
	    TreeSet<String> unregisteredSet = new TreeSet<>();
	    TreeSet<String> registeredSet = new TreeSet<>();
	    for (int i = 0; i < resultArray.length; i++) {
	    	unregisteredSet.add(resultArray[i]);
	    }
	    
	    for (int i = 0; i < registeredCourses.length; i++) {
	    	registeredSet.add(registeredCourses[i]);
	    }
	    
    	unregisteredSet.removeAll(registeredSet);
	    
		return unregisteredSet;
	}
	
	public void insertCourse(ArrayList<String> coursesToInsert) throws SQLException, ClassNotFoundException {
		for (int i = 0; i < coursesToInsert.size(); i++) {
		    String courseID = coursesToInsert.get(i);
		    statement = connection.createStatement();
		    
		    String queryString = "INSERT into Enrollment "
		    				   + "(ssn, courseId, dateRegistered, grade) "
		    				   + "VALUES "
		    				   + "('"+ getSsn() +"', '"+ courseID +"', '2022-05-11 00:00:00', 'A')";

		    statement.executeUpdate(queryString);
		}
	}
	
}
