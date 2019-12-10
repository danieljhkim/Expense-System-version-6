package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.Reimbursement;

public class EmpServlet extends HttpServlet {

       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			ArrayList<Reimbursement> ar_re = reDao.selectAllEmpReimb(emp.getUserID());
		
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
