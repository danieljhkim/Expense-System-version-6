package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import expenseSysDao.UsersDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.FinanceManager;
import expenseSysModels.User;

public class LoginController {
	
	public static void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
		String userName = request.getParameter("id");
		String password = request.getParameter("password");
		
		UsersDaoImp usersDaoImp = new UsersDaoImp();
		User user = usersDaoImp.selectUserByUserName(userName);
		
		 if (userName.equals(user.getUserName()) && password.equals(user.getPassword()) && user.getRole()==1){
			 	FinanceManager manager = new FinanceManager(user); 
		        request.getSession().setAttribute("role", "manager");
				request.getSession().setAttribute("object", manager);
				//String targetURL = "/ManagerHome.html";
				request.getRequestDispatcher("UserInfoServlet").forward(request, response);
				System.out.println("#Forward to ManagerHome success.#");
				
		 }else if (userName.equals(user.getUserName()) && password.equals(user.getPassword())){
			request.getSession().setAttribute("role", "employee");
			Employee emp = new Employee(user);
			request.getSession().setAttribute("object", emp);
			request.getRequestDispatcher("LoginServlet").forward(request, response);
			System.out.println("#Forward to EmployeeHome success.#");

		 } else {
			 System.out.println("#Unable to process forward.#");
			 request.getRequestDispatcher("header.html").include(request, response);
			 request.getRequestDispatcher("index.html").include(request, response);
			 out.print("<div style='text-align:center'><b style='color:red'>Invalid password. Please try again.</b></div>");
		 }
	}
}
