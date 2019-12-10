package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysDao.UsersDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.User;

public class RegisterController {
	
	public static void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsersDaoImp userDao = new UsersDaoImp();
		
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");;
		String email = request.getParameter("email");
		String str_role = request.getParameter("role");
		int role = Integer.parseInt(str_role);
		User user = new User(userName, password, firstName, lastName, email, role); 
		userDao.insertUser(user);
		request.getRequestDispatcher("Login.html").forward(request, response);
	}
}
