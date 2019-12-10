package servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  


public class LogoutServlet extends HttpServlet { 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {             
            request.getRequestDispatcher("Login.html").include(request, response);               
            HttpSession session=request.getSession();  
            session.invalidate();  
    }  

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  	
    	doGet(request, response);	
    }
    
}
    
    