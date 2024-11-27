package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchWallet {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	 public int fetchBalance(String userId)  {
	      // Open a connection
		 int balance=0;
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         
	         String query="select * from wallet where user_id='"+userId+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         
	         while (rs.next()) {
	            // Retrieve by column name
	           balance=rs.getInt("user_balance");
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      return balance;
	     
	   }
}
