package model;
import java.sql.*;
import java.util.*;
public class GetTrains {
	static final String DB_URL = "jdbc:mysql://localhost:3306/IRCTC";
	   static final String USER = "root";
	   static final String PASS = "123456";
	   

	   public List<Train> getTrain(String fromStation,String ToStation,String date)  {
	      // Open a connection
		  ArrayList<Train> trains = new ArrayList<>();
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         
	         System.out.println(date);
	         String query="select * from train_table where departed_form='"+fromStation+"' and reached_to='"+ToStation+"' and Date_Time ='"+date+"';";
	         System.out.println(query);
	         ResultSet rs = stmt.executeQuery(query);
	      
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           Train train = new Train();
	           train.setTrain_no(rs.getString("train_no"));
	           train.setDeparted_form(rs.getString("departed_form"));
	           train.setReached_to(rs.getString("reached_to"));
	           train.setFare(rs.getInt("fare"));
	           train.setDate(rs.getString("Date_Time"));
	           System.out.println(train.getTrain_no());
	           trains.add(train);
	         }  
	         conn.close();
	      } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	      } 
	      
	      return trains;
	   }
}
