package ProtectionPlan.controller.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import GroupActivityWeek12.dbHelpers.D_88_AddQuery;
//import GroupActivityWeek12.model.M_88_Friends;
import ProtectionPlan.dbhelper.writeQuery;
import ProtectionPlan.model.users;

//import GroupActivityWeek12.dbHelpers.D_88_AddQuery;
//import GroupActivityWeek12.model. M_88_Friends;

/**
 * Servlet implementation class Add
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String cell = request.getParameter("cell");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
//		if(name.isEmpty() || email.isEmpty() || favColor.isEmpty()) {
//			response.setContentType("text/html");
//            response.setStatus(500);
//            return;
//		}
//		M_88_Friends friend = new  M_88_Friends(name, email, age, favColor);
//		D_88_AddQuery cf = new D_88_AddQuery();
//		int result = cf.createFriend(friend);
		
		users user = new  users(username, password, cell, email,name,address);
		writeQuery reg = new  writeQuery();
		int result = reg.insertUser(user);

		

//		if(result == 1) {
//			response.sendRedirect("C_88_Read");
//			
//		} else {
//			response.setContentType("text/html");
//            response.setStatus(500);
//		}
		String redirectUrl = "/login.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);

		dispatcher.forward(request, response);

	}
	}


