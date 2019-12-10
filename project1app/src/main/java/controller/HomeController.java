package controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import expenseSysModels.Employee; 
import expenseSysModels.FinanceManager; 

public class HomeController {
	
	public static void Home(HttpServletRequest request, HttpServletResponse response) {
		
		String role = (String)request.getSession().getAttribute("role");
		
		
		if (role.equals("employee")) {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			try {
				response.getWriter().write(new ObjectMapper().writeValueAsString(emp));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (role.equals("manager")){
			FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
			try {
				response.getWriter().write(new ObjectMapper().writeValueAsString(manager));
				System.out.println(manager);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}	
		
	}

}
