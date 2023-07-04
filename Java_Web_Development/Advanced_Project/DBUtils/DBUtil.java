package DBUtils;

import java.sql.*;
import java.util.HashMap;

public class DBUtil {
	private static Connection connection;
	private ResultSet resultset;
	
	private static String ssn;
	
	// Open Connection to database
	public void connectDB(String ID, String password){
		try{
			Class.forName("org.postgresql.Driver");
			System.out.println("JDBC Driver loaded. Connecting to database....");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School",
		            ID, password);
			System.out.println("Database Connected.");
		}catch(ClassNotFoundException | SQLException ex){
			ex.printStackTrace();					
		}
	}
	
	// Run Query to get result set
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultset;
	}	

	public String getCourses() throws SQLException, ClassNotFoundException {
		String resultList="";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT  courseID, title, numOfCredits FROM Courses;");
			while (resultset.next())
			{
				resultList= resultList + "<li>" + resultset.getString(1) + "\t" 
						+ resultset.getString(2) + "\t" + resultset.getString(3) + "</li>\n";			
			}
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultList;
	}
	// Insert values into database
	public void updateValues(String table, String query)throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
	}
	
	public boolean validateLogin(String ssn) {
		boolean valid = false;
		Statement statement;
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT ssn "
					 + "FROM Enrollment "
					 + "WHERE ssn = '" + ssn + "';");
			if (resultset.next()) {
				valid = true;
				setSsn(ssn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valid;
	}
	
	public void setSsn(String ssn) {
		DBUtil.ssn = ssn; 
	}
	
	public HashMap<String, String> getStudentInfo(String ssn) {
		HashMap<String, String> studentInfo = new HashMap<>();
		Statement statement;
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT *"
					 + "FROM Students "
					 + "WHERE ssn = '" + ssn + "';");
			while (resultset.next()) {
					studentInfo.put("ssn", resultset.getString(1));
					studentInfo.put("fname", resultset.getString(2));
					studentInfo.put("mname", resultset.getString(3));
					studentInfo.put("lname", resultset.getString(4));
					studentInfo.put("dob", resultset.getString(5));
					studentInfo.put("address", resultset.getString(6));
					studentInfo.put("phone", resultset.getString(7));
					studentInfo.put("zip", resultset.getString(8));
					studentInfo.put("deptId", resultset.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentInfo;
	}
	
	public String getStudentCourses(String ssn) {
		String resultList="";
		
		String beginTable = null;
		
		String endTable = null;
		
		String tableHeader = "<th style=\"padding:10px\">Course ID</th><th style=\"padding:10px\"> "
						   + "Course Title</th><th style=\"padding:10px\"> Grade </th>";
		
		String query = "SELECT Enrollment.courseId, title, grade "
					 + "FROM Enrollment, Courses "
					 + "WHERE Enrollment.courseId = Courses.courseID "
					 + "AND ssn = '" + ssn + "';";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			beginTable = "<table border=\"1\">";
			while (resultset.next())
			{
				resultList= resultList + "<tr><td style=\"padding:10px\">" + resultset.getString(1)
						+ "</td><td style=\"padding:10px\">" + resultset.getString(2) 
						+ "</td><td style=\"padding:10px\">" + resultset.getString(3) + "</td></tr>";			
			}
			endTable = "</table>";
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return beginTable + tableHeader + resultList + endTable;
	}
	
	public String studentCourseUpdate() {
		return getStudentCourses(DBUtil.ssn);
	}
	
	public String getCourseBox() {
		String selectBegin = "<select name =\"courseList\"";
		String query = "SELECT title "
					 + "FROM Courses, Enrollment "
					 + "WHERE Courses.courseID = Enrollment.courseId";
		String options = "";
		try {
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				String result = resultset.getString(1);
				options = options + "<option value='" + result + "'>" + result + "</option>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String selectEnd = "</select>";
		return selectBegin + options + selectEnd;
	}
	
	public boolean registerClass(String courseID, String grade) {
		boolean alreadyEnrolled = checkEnrollment(courseID);
		if (!alreadyEnrolled) {
			String updateStatement = "INSERT INTO Enrollment VALUES ('" + DBUtil.ssn + "', '"+ courseID + "', '2022-12-11', '" + grade + "');";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(updateStatement);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean dropClass(String courseID) {
		boolean alreadyEnrolled = checkEnrollment(courseID);
		
		if (alreadyEnrolled) {
			String updateStatement = "DELETE from Enrollment "
								   + "WHERE courseId='" + courseID + "'"
								   + "AND ssn = '" + DBUtil.ssn + "';";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(updateStatement);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean checkEnrollment(String courseID) {
		boolean enrolled = false;
		String query = "SELECT courseID "
					 + "FROM Enrollment "
					 + "WHERE courseID ='" + courseID + "'"
					 + "AND ssn = '" + DBUtil.ssn + "';";
		try {
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			if (resultset.next()) {
				enrolled = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enrolled;
	}
	
	public HashMap<String, String> getCourseMap() {
		HashMap<String, String> courseMap = new HashMap<>();
		String query = "SELECT title, Enrollment.courseId "
					 + "FROM Courses, Enrollment "
					 + "WHERE Courses.courseID = Enrollment.courseId;";
		
		try {
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
			courseMap.put(resultset.getString(1), resultset.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseMap;
	}
	
	// Closes database connection
	public void closeConn() throws SQLException{

		connection.close();
	}
}