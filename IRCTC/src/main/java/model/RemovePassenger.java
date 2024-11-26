package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemovePassenger {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public String removePassenger(String aadher)  {
	      // Open a connection

	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();	      
	         String query="delete from passenger where aadher_no='"+aadher+"';";
	         
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
