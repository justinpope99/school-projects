package DBUtil;

import java.sql.*;

public class SimpleJdbc {

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
    Statement statement = connection.createStatement();
   
    // Execute a statement
    ResultSet resultSet = statement.executeQuery ("select * from Students");
    while (resultSet.next())
      System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)+ "\t" + resultSet.getString(4));

    // Close the connection
    resultSet.close();

    connection.close();
    System.out.println("Database closed");

  }
}