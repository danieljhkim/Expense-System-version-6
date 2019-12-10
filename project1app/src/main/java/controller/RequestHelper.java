package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import controller.ManagerProfileController;
import javax.servlet.http.HttpServletResponse;
import controller.EmpProfileController;
public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		switch(request.getRequestURI()) {
		
		case "/project1app/Login.do":
			LoginController.Login(request, response);
			
		case "/project1app/Register.do":
			RegisterController.Register(request, response);
			
		case "/project1app/Home.do":
			HomeController.Home(request, response);

		case "/project1app/ViewAllReimbursements.do":
			ManagerProfileController.ViewAllReimbursements(request, response);

		case "/project1app/ApproveReimbursements.do":
			ManagerProfileController.ApproveReimbursements(request, response);

		case "/project1app/FilterByStatus.do":
			ManagerProfileController.FilterByStatus(request, response);

		case "/project1app/ViewPastTickets.do":
			EmpProfileController.ViewPastTickets(request, response);

		case "/project1app/AddReimbusementRequest.do":
			EmpProfileController.AddReimbusementRequest(request, response);
			
		default:

		}
	}
	
}
