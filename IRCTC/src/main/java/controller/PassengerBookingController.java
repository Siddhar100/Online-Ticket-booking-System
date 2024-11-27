package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetPassengerDetails;
import model.Passenger;
import model.Train;

/**
 * Servlet implementation class PassengerBookingController
 */
@WebServlet("/PassengerBookingController")
public class PassengerBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerBookingController() {
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
		String train_no = request.getParameter("train_no");
		String deprted_form = request.getParameter("departed_form");
		String reached_to = request.getParameter("reached_to");
		int fare = Integer.parseInt(request.getParameter("fare"));
		String date = request.getParameter("date");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("user_id");
		GetPassengerDetails passengersDetails = new GetPassengerDetails();
		List<Passenger> passengers = passengersDetails.getPassengers(userId);
		request.setAttribute("passengers",passengers);
		Train tr = new Train();
		tr.setTrain_no(train_no);tr.setDeparted_form(deprted_form);tr.setReached_to(reached_to);
		tr.setFare(fare);tr.setDate(date);
		ArrayList<Passenger> passengerAdded = (ArrayList)session.getAttribute("addedPassengers");
		request.setAttribute("addedPassengers", passengerAdded);
		session.setAttribute("train", tr);
		Train sessionTrain = (Train)session.getAttribute("train");
		request.setAttribute("train_no",sessionTrain.getTrain_no() );
		request.setAttribute("departed_form",sessionTrain.getDeparted_form() );
		request.setAttribute("reached_to",sessionTrain.getReached_to() );
		request.setAttribute("date",sessionTrain.getDate() );
		RequestDispatcher rd = request.getRequestDispatcher("/websites/PassengerPayment.jsp");
		rd.forward(request, response);
	}

}
