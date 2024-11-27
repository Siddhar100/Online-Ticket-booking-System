package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookTicket {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public String bookTicket(String userId,String aadher,String name,int age,String gender,String depart,String arrive,String date,int fare)  {
	      // Open a connection

	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();	      
	         Statement wallet = conn.createStatement();
	         Statement deductBalance = conn.createStatement();
	         Statement transaction = conn.createStatement();
	         String fetchBalance = "select * from wallet where user_id='"+userId+"';";
	         String query="insert into Tickets values('"+userId+"','"+aadher+"','"+name+"',"+age+",'"+gender+"','"+depart+"','"+arrive+"','"+date+"',"+fare+");";
	         
	         
	         ResultSet rs = stmt.executeQuery(fetchBalance);
	         System.out.println(fetchBalance);
	      
	         // Extract data from result set
	         if(rs.next()) {
	        	 int balance = rs.getInt("user_balance");
	        	 if(fare <= balance) {
	        		 balance = balance-fare;
	        		 String deductQuery="update wallet set user_balance="+balance+" where user_id='"+userId+"';";
	        		 System.out.println(deductQuery);
	        		 int success=deductBalance.executeUpdate(deductQuery);
	        		 System.out.println(query);
	        		 stmt.executeUpdate(query);
	        		 String transQuery="insert into transactions values('"+userId+"','"+date+"',"+fare+",'success','successFull');";
	        		 transaction.executeUpdate(transQuery);
	        		 System.out.println(transQuery);
	        		 conn.close();
	        		 return "Ticket Booking seccess!";
	        		 
	        	 }else {
	        		 String transQuery="insert into transactions values('"+userId+"','"+date+"',"+fare+",'Insufficent balance','Failed');";
	        		 transaction.executeUpdate(transQuery);
	        		 return "Ticket Booking failed!";
	        		 
	        	 }
	         }
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return "Ticket Booking failed!";
	   }
}
