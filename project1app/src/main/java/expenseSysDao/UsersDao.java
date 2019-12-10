package expenseSysDao;

import java.util.ArrayList;

import expenseSysModels.User;

public interface UsersDao {

	//CREATE
	public void insertUser(User u);
	
	//READ
	public User selectUserById(int id);
	public User selectUserByUserName(String userName);
	public ArrayList<User> selectAllUsers();
	
	//UPDATE
	public void updateUser(User u);
	
	//DELETE
	public void deleteUser(User u);

}