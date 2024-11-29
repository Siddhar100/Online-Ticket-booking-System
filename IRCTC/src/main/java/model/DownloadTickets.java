package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DownloadTickets {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   
	   public List<Ticket> getTickets(String userId)  {
	      // Open a connection
		  ArrayList<Ticket> tickets = new ArrayList<>();
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();	      
	         String query="select * from Tickets where transaction_id='"+userId+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           Ticket ticket = new Ticket();
	           ticket.setTransaction_id(rs.getString("transaction_id"));
	           ticket.setPassenger_aadher(rs.getString("passenger_aadher"));
	           ticket.setPassenger_name(rs.getString("passenger_name"));
	           ticket.setPassenger_age(rs.getInt("passenger_age"));
	           ticket.setPassenger_gender(rs.getString("passenger_gender"));
	           ticket.setPassenger_depart(rs.getString("passenger_depart"));
	           ticket.setPassenger_arrive(rs.getString("passenger_arrive"));
	           ticket.setBooking_date(rs.getString("booking_date"));
	           ticket.setFare(rs.getInt("fare"));
	           tickets.add(ticket);
	           
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return tickets;
	   }
}
