package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FetchTransactions;
import model.FetchWallet;
import model.Transaction;

/**
 * Servlet implementation class WalletController
 */
@WebServlet("/WalletController")
public class WalletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FetchWallet wallet = new FetchWallet();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		int balance = wallet.fetchBalance(userId);
		FetchTransactions trans = new FetchTransactions();
		List<Transaction> transactions =  trans.getTransactions(userId);
		request.setAttribute("balance", balance);
		request.setAttribute("transactions", transactions);
		RequestDispatcher rd = request.getRequestDispatcher("/websites/wallet.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
