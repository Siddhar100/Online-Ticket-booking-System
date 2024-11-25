package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserAuthentaion {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	 public String authUserAndPassword(String userId,String userPassword)  {
	      // Open a connection
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         
	         String query="select * from users where user_id='"+userId+"' and user_password='"+userPassword+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           if(userPassword.equals(rs.getString("user_password"))) {        	   
	        	   String msg="success-"+rs.getString("user_id");
	        	   conn.close();
	        	   System.out.println(msg);
	        	   return msg;
	           }else {
	        	   conn.close();
	        	   return "Login failed due to invalid password!";
	           }
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      return "Login failed due to Invalid User!";
	     
	   }
}
