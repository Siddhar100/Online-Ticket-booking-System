package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookTicket;
import model.Passenger;
import model.Train;

/**
 * Servlet implementation class TicketBookingController
 */
@WebServlet("/TicketBookingController")
public class TicketBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Passenger> passengers = (ArrayList)session.getAttribute("addedPassengers");
		String userId = (String)session.getAttribute("user_id");
		Train train = (Train)session.getAttribute("train");
		BookTicket book = new BookTicket();
		if(userId != null && passengers != null && passengers.size() > 0) {
		   for(int i=0;i<passengers.size();i++) {
			Passenger item = passengers.get(i);
			String output = book.bookTicket(userId,item.getAadher_no(),item.getName(),item.getAge(),item.getGender(),train.getDeparted_form(),train.getReached_to(),train.getDate(),train.getFare());
			System.out.println(output);
		   }
		}else {
			System.out.println("Ticket Booking Failed!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/websites/homePage.jsp");
		rd.include(request, response);
		
	}

}
