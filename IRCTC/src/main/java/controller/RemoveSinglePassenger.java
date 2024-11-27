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
 * Servlet implementation class RemoveSinglePassenger
 */
@WebServlet("/RemoveSinglePassenger")
public class RemoveSinglePassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveSinglePassenger() {
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
		Train tr = (Train) session.getAttribute("train");
		String userId = (String)session.getAttribute("user_id");
		String Aadher = request.getParameter("aadher");
		ArrayList<Passenger> passengers = (ArrayList)session.getAttribute("addedPassengers");
		for(int i=0;i<passengers.size();i++) {
			if(passengers.get(i).getAadher_no().equals(Aadher)) {
				passengers.remove(i);
			}
		}
		session.setAttribute("addedPassengers",passengers);
		request.setAttribute("addedPassengers", passengers);
		Train sessionTrain = (Train)session.getAttribute("train");
		GetPassengerDetails passengersDetails = new GetPassengerDetails();
		List<Passenger> passengerDetails = passengersDetails.getPassengers(userId);
		request.setAttribute("passengers",passengerDetails);
		request.setAttribute("train_no",sessionTrain.getTrain_no() );
		request.setAttribute("departed_form",sessionTrain.getDeparted_form() );
		request.setAttribute("reached_to",sessionTrain.getReached_to() );
		request.setAttribute("date",sessionTrain.getDate() );
		RequestDispatcher rd = request.getRequestDispatcher("/websites/PassengerPayment.jsp");
		rd.include(request, response);
	}

}
