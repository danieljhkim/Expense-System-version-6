package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import expenseSysModels.Employee;
import expenseSysModels.FinanceManager;  

public class LoginServlet extends HttpServlet {  
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    request.getRequestDispatcher("header.html").include(request, response);

        HttpSession session=request.getSession(false);  
        if(session!=null){  
        	Employee emp =(Employee)session.getAttribute("object");
        	request.getRequestDispatcher("index.html").include(request, response);
            out.print("<b>Hello, "+ emp.getUserName() +". Welcome to your profile page.</b>");
            request.getRequestDispatcher("EmployeeHome.html").include(request, response);
        	
        }else {
			 request.getRequestDispatcher("index.html").include(request, response);
			 out.print("<div style='text-align:center'><b style='color:red'>Session is empty. Please log in again:</b> <a id='linkk' href=\"Login.html\">Login</a></div>");
        }
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}	
}