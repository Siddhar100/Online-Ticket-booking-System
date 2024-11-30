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

import model.Passenger;
import model.UserAuthentaion;

/**
 * Servlet implementation class UserAuth
 */
@WebServlet("/UserAuth")
public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuth() {
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
		UserAuthentaion userAuth = new UserAuthentaion();
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		String authOutput = userAuth.authUserAndPassword(user_id,user_password);
		if(authOutput.split("-")[0].equals("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", authOutput.split("-")[1]);
			session.setAttribute("login_time",authOutput.split("-")[2] );
			ArrayList<Passenger> passengers = new ArrayList<>();
			session.setAttribute("addedPassengers", passengers);
			System.out.println(session.getAttribute("user_id"));
			response.sendRedirect(request.getContextPath() + "/websites/homePage.jsp");
		}else {
			request.setAttribute("authMessage", authOutput);
			System.out.println(authOutput);
			response.sendRedirect(request.getContextPath() + "/websites/loginPage.jsp");
		}
		
	}

}
