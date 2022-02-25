package ProtectionPlan.controller.Product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProtectionPlan.dbhelper.writeQuery;
import ProtectionPlan.model.protectionPlan;
import ProtectionPlan.model.users;

/**
 * Servlet implementation class RegisterProductCustomer
 */
@WebServlet("/RegisterProductCustomer")
public class RegisterProductCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProductCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("user");
		String productName = request.getParameter("productName");
		String serialNumber = request.getParameter("serialNumber");
		String purchaseDate = request.getParameter("purchaseDate");
		//String productID = request.getParameter("productID");
		
		protectionPlan pp = new  protectionPlan(username, productName, serialNumber, purchaseDate);
		
		writeQuery reg = new  writeQuery();
		

		int result = reg.insertProductToPlan(pp);
		
		String redirectUrl = "/login.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);

		dispatcher.forward(request, response);
		
	}

}
