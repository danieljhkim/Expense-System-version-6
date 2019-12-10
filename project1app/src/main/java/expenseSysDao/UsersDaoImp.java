package expenseSysDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import expenseSysModels.User;

public class UsersDaoImp implements UsersDao{

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
	public void insertUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Ers_Users VALUES(?,?,?,?,?,?,?)");	//putting in a native SQL query 
			ps.setInt(1, u.getUserID());
			ps.setString(2, u.getUserName()); 
			ps.setString(3, u.getPassword()); 
			ps.setString(4, u.getFirstName()); 
			ps.setString(5, u.getLastName()); 
			ps.setString(6, u.getEmail()); 
			ps.setInt(7, u.getRole()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User selectUserById(int id) {
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Users WHERE ers_user_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("password"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getInt("role"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public ArrayList<User> selectAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void updateUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Ers_Users SET ers_password=?, email=? WHERE ers_user_id=?");
			ps.setString(1, u.getPassword()); 
			ps.setString(2, u.getEmail()); 
			ps.setInt(3, u.getUserID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Ers_Users WHERE ers_user_id=?"); 
			ps.setInt(1, u.getUserID()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User selectUserByUserName(String userName) {
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ers_Users WHERE ers_username=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}