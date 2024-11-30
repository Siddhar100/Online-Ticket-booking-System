package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	         Statement dateChange = conn.createStatement();
	        
	         String query="select * from users where user_id='"+userId+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           if(userPassword.equals(rs.getString("user_password"))) {  
	        	   Date date = new Date();  
	        	    SimpleDateFormat formatter = new SimpleDateFormat("YYY/MM/dd");  
	        	    String strDate= formatter.format(date); 
	        	    System.out.println(strDate);
	        	    String dateChangeQuery="update users set user_login_time='"+strDate+"' where user_id='"+userId+"';";
	        	    int success = dateChange.executeUpdate(dateChangeQuery);
	        	    System.out.println(dateChangeQuery);
	        	   String login_time_fetched = rs.getString("user_login_time");
	        	   String user_login_time = login_time_fetched.replace('-','/');
	        	   String msg="success-"+rs.getString("user_id")+"-"+user_login_time;
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
