package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChangePassword;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChangePassword changePassword = new ChangePassword();
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("user_id");
		String oldPassword = request.getParameter("old_password");
		String newPassword = request.getParameter("new_password");
		String output = changePassword.changeUserPassword(userId, oldPassword, newPassword);
		if(output.equals("success!")) {
			System.out.println("Password has been changed!");
			request.setAttribute("message", "Password has been changed!");
		}else {
			System.out.println("Password change failed!");
			request.setAttribute("message", "Password change failed!");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/websites/ChangePassword.jsp");
		rd.forward(request, response);
	}

}
