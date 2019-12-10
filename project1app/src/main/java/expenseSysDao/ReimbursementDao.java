package expenseSysDao;


import java.util.ArrayList;

import expenseSysModels.Reimbursement;

public interface ReimbursementDao {

	//CREATE
	public void insertReimb(Reimbursement r);
	
	//READ
	public Reimbursement selectReimbById(int id);
	
	
	public ArrayList<Reimbursement> selectAllReimb();
	
	
	public ArrayList<Reimbursement> selectAllEmpReimb(int id);
	
	
	//UPDATE
	public void updateReimb(Reimbursement r);
	
	//DELETE
	public void deleteReimb(Reimbursement r);
	
	public ArrayList<Reimbursement> filterReimbByStatus(int status);
}