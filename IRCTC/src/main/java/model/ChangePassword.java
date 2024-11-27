package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangePassword {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public String changeUserPassword(String userId,String oldPassword,String newPassword)  {
	      // Open a connection

	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         Statement newStmt = conn.createStatement();
	         String query="select * from users where user_id='"+userId+"';";
	         String changePasswordQuery = "update users set user_password='"+newPassword+"' where user_id='"+userId+"';";
	         System.out.println(query);
	         
	         ResultSet rs = stmt.executeQuery(query);
		      
	         // Extract data from result set
	           
	         while (rs.next()) {
	            // Retrieve by column name
	        	 String oldFetchedPassword = rs.getString("user_password");
	           if(oldFetchedPassword.equals(oldPassword)) {
	        	   System.out.println(changePasswordQuery);
	        	   int success = newStmt.executeUpdate(changePasswordQuery);  
	        	   conn.close();
	  	           return "success!";
	           }
	           
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return "failed!";
	   }
}
