package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetPassengerDetails {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public List<Passenger> getPassengers(String userId)  {
	      // Open a connection
		  ArrayList<Passenger> passengers = new ArrayList<>();
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();	      
	         String query="select * from Passenger where user_id='"+userId+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           Passenger passenger = new Passenger();
	           passenger.setAadher_no(rs.getString("aadher_no"));
	           passenger.setName(rs.getString("name"));
	           passenger.setAge(rs.getInt("age"));
	           passenger.setGender(rs.getString("gender"));
	           passengers.add(passenger);
	           
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return passengers;
	   }
}
