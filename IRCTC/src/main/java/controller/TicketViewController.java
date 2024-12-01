package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketViewController
 */
@WebServlet("/TicketViewController")
public class TicketViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketViewController() {
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
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String aadher = request.getParameter("aadher");
		String depart = request.getParameter("depart");
		String arrive = request.getParameter("arrive");
		request.setAttribute("date", date);
		request.setAttribute("name", name);
		request.setAttribute("aadher", aadher);
		request.setAttribute("depart", depart);
		request.setAttribute("arrive", arrive);
		RequestDispatcher rd = request.getRequestDispatcher("/websites/TicketView.jsp");
		rd.include(request, response);
		
	}

}
