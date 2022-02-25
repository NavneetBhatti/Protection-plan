package ProtectionPlan.controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ProtectionPlan.dbhelper.readQuery;
import ProtectionPlan.dbhelper.writeQuery;
import ProtectionPlan.model.users;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUser() {
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
	
//	users user = new  users(username, password);
//	writeQuery reg = new  writeQuery();
//	int result = reg.insertUser(user);

	

	users user = new users(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
	 
    user.setUsername(username); //setting the username and password through the loginBean object then only you can get it in future.
     user.setPassword(password);

    readQuery login = new readQuery(); 
     String userValidate = login.authenticateUser(user); //Calling authenticateUser function

     if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
      {
         // request.setAttribute("username", username); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
          request.getRequestDispatcher("/registerProduct.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
      }
      else
      {
          request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
          request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
      }
	 
	

}
}
