package ProtectionPlan.controller.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ProtectionPlan.dbhelper.readQuery;

/**
 * Servlet implementation class userList
 */
@WebServlet("/userList")
public class userList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
       readQuery rq = new readQuery();

		

		rq.userList();

		String table = "";

		try {

			table = rq.getHTMLTable();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		

		request.setAttribute("table", table);

		String redirectUrl = "/userAccounts.jsp";

		

		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);

		dispatcher.forward(request, response);

	}

}
