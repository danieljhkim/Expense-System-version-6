package servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import controller.RequestHelper;
import expenseSysDao.ReimbursementDaoImp;
import expenseSysModels.Reimbursement;

public class ReimServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		ArrayList<Reimbursement> ar_re = reDao.selectAllReimb();

		System.out.println(ar_re);
		try {
			//sending the array_list of reimbursements back to the web server
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response); 
	}
	

}
