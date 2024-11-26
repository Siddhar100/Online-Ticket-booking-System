package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddPassenger {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public String addPassenger(String aadher,String name,int age,String gender,String userId)  {
	      // Open a connection

	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();	      
	         String query="insert into Passenger values('"+aadher+"','"+name+"',"+age+",'"+gender+"','"+userId+"');";
	         
	         System.out.println(query);
	         int rs = stmt.executeUpdate(query);
	      
	         // Extract data from result set
	         if(rs>0) {
	        	 conn.close();
	        	 System.out.println("Success!");
	        	 return "success!";
	         }
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return "failed!";
	   }
}
