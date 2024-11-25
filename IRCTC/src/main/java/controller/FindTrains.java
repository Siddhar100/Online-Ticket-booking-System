package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetTrains;
import model.Train;

/**
 * Servlet implementation class FindTrains
 */
@WebServlet("/FindTrains")
public class FindTrains extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindTrains() {
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
		// TODO Auto-generated method stub
		GetTrains gt = new GetTrains();
		String fromStation = request.getParameter("from_station");
		String toStation = request.getParameter("to_station");
		String date=request.getParameter("date");
		List<Train> trains = gt.getTrain(fromStation,toStation,date);
		request.setAttribute("trains", trains);
		RequestDispatcher rd = request.getRequestDispatcher("/websites/TrainList.jsp");
		rd.include(request, response);
		//response.sendRedirect(request.getContextPath() + "/websites/TrainList.jsp");
	}

}
