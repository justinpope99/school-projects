package simpleJdbc;

import java.sql.*;
import java.util.Scanner;
//import javax.swing.JOptionPane;

public class SimpleJdbc {

private static PreparedStatement preparedStatement;
	
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    //Class.forName("com.mysql.jdbc.Driver");
    Class.forName("org.postgresql.Driver");
    System.out.println("Driver loaded");

    // Connect to a database
    Connection connection = DriverManager.getConnection
    	      ("jdbc:postgresql://localhost:5432/School",
            "postgres", "password123");
    
    System.out.println("Database connected");
    
    // Create a statement
    //Statement statement = connection.createStatement();

    String queryString = "select firstName, mi, " +
            "lastName, title, grade from Students, Enrollment, Courses " +
            "where Students.ssn = ? and Enrollment.courseId = ? " +
            "and Enrollment.courseId = Courses.courseId";

    // Create a statement
    preparedStatement = connection.prepareStatement(queryString);    

    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Enter SSN: ");
    String ssn = keyboard.nextLine();
    System.out.println("Enter Course ID: ");
    String courseId = keyboard.nextLine();
    keyboard.close();
    
    try {
        preparedStatement.setString(1, ssn);
        preparedStatement.setString(2, courseId);
        ResultSet rset = preparedStatement.executeQuery();

        if (rset.next()) {
          String lastName = rset.getString(1);
          String mi = rset.getString(2);
          String firstName = rset.getString(3);
          String title = rset.getString(4);
          String grade = rset.getString(5);

          System.out.println(firstName + " " + mi +
                  " " + lastName + "'s grade on course " + title + " is " +
                  grade);
        }
        else {
        	System.out.println("Not found");
        }
        rset.close();       
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }  
    
    
    connection.close();
    System.out.println("Database closed");
    //keyboard.close();
  }
}