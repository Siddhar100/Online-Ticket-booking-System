package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchTransactions {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public List<Transaction> getTransactions(String userId)  {
	      // Open a connection
		  ArrayList<Transaction> transactions = new ArrayList<>();
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();	      
	         String query="select * from transactions where transaction_id='"+userId+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           Transaction tans = new Transaction();
	           tans.setTransaction_id(rs.getString("transaction_id"));
	           tans.setTransaction_date(rs.getString("transaction_date"));
	           tans.setTransaction_amount(rs.getInt("transaction_amount"));
	           tans.setTransaction_reason(rs.getString("transaction_reason"));
	           tans.setTransaction_status(rs.getString("transaction_status"));
	           transactions.add(tans);
	           
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return transactions;
	   }
}
