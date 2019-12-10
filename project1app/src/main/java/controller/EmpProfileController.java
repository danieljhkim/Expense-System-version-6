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
import expenseSysModels.Employee;
import expenseSysModels.Reimbursement;

public class EmpProfileController {
	
	public static void ViewPastTickets(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			ArrayList<Reimbursement> ar_re = reDao.selectAllEmpReimb(emp.getUserID());
		
			//sending the array_list of reimbursements back to the web server	
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void AddReimbusementRequest(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			
			int reimID =0;
			java.sql.Timestamp submitted = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			java.sql.Timestamp resolved = null;
			String description= request.getParameter("description");
			int author = emp.getUserID();
			int resolver = 0;
			int status = 1;	
			int type = Integer.parseInt(request.getParameter("type"));	
			double amount = Double.parseDouble(request.getParameter("amount"));

			Reimbursement re = new Reimbursement(reimID, amount, submitted, resolved, description, author, resolver, status, type); 
			reDao.insertReimb(re);
			
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();
		    out.println("<h5>Sbumitssion Successful</h5><br><hr> ");
		    out.println("<b>Author:</b> " + re.getAuthor());
		    out.println("<b>Amount:</b> " + re.getAmount());
		    out.println("<b>Status:</b> " + re.getStatus());
		    out.println("<b>Type:</b> " + re.getType());
		    out.println("<b>Submitted Date:</b> " + re.getSubmitted());
		    
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}	

}
