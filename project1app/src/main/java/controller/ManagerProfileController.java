package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysModels.FinanceManager;
import expenseSysModels.Reimbursement;

public class ManagerProfileController {
	
	public static void ViewAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		//FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
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
	
	public static void ApproveReimbursements(HttpServletRequest request, HttpServletResponse response) {
		FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			//selecting the reimbursement
			int reimID = Integer.parseInt(request.getParameter("reimID"));
			Reimbursement re = reDao.selectReimbById(reimID);
		
			int status = Integer.parseInt(request.getParameter("status"));
			re.setStatus(status);
			
			//updating resolver attribute
			re.setResolver(manager.getUserID());
			
			//updating resolved date attribute
			java.sql.Timestamp resolved = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			re.setResolved(resolved);
			
			reDao.updateReimb(re);
			
			//sending the approved/denied reimbursement back
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();
		    out.println("<h4>Sbumitssion Successful</h4><hr> ");
		    out.println("<b>Manager ID:</b> " + manager.getUserName());
		    out.println("<b>Reimbursement ID:</b> " + re.getReimbID());
		    out.println("<b>Employee ID:</b> " + re.getAuthor());
		    out.println("<b>Amount:</b> " + re.getAmount());
		    out.println("<b>Status:</b> " + re.getStatus());
		    out.println("<b>Resolved Date:</b> " + re.getResolved());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void FilterByStatus(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		int status = Integer.parseInt(request.getParameter("status"));
		ArrayList<Reimbursement> reimbs = reDao.filterReimbByStatus(status);
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbs));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
