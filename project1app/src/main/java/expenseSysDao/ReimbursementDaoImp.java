package expenseSysDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import expenseSysModels.Reimbursement;

public class ReimbursementDaoImp implements ReimbursementDao{

	static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	private static String url = "jdbc:oracle:thin:@revtraindb.ckjisqlnth7g.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "ExpReimbursementSys";
	private static String password = "p4ssw0rd";
	
	@Override
	public void insertReimb(Reimbursement r) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Ers_Reimbursements VALUES(?,?,?,?,?,?,?,?,?)"); 
			ps.setInt(1, r.getReimbID());
			ps.setDouble(2, r.getAmount());
			ps.setTimestamp(3, r.getSubmitted());
			ps.setTimestamp(4, r.getResolved());
			ps.setString(5, r.getDescription());
			ps.setInt(6, r.getAuthor());
			ps.setInt(7, r.getResolver());
			ps.setInt(8, r.getStatus());
			ps.setInt(9, r.getType()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Reimbursement selectReimbById(int id) {
		Reimbursement reimb = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Reimbursements WHERE reimb_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimb = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), 
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	@Override
	public ArrayList<Reimbursement> selectAllReimb() {
		ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Reimbursements");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	@Override
	public ArrayList<Reimbursement> selectAllEmpReimb(int id) {
		ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Reimbursements WHERE reimb_author=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	@Override
	public void updateReimb(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Ers_Reimbursements SET reimb_resolver=?, reimb_resolved=?, reimb_status_id=? WHERE reimb_id=?");
			ps.setInt(1, r.getResolver());
			ps.setTimestamp(2, r.getResolved()); 
			ps.setInt(3, r.getStatus()); 
			ps.setInt(4, r.getReimbID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteReimb(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Ers_Reimbursements WHERE reimb_id=?"); 
			ps.setInt(1, r.getReimbID()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Reimbursement> filterReimbByStatus(int status) {
		ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Reimbursements WHERE status=?"); 
			ps.setInt(1, status); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9) ));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	
	}
	
}