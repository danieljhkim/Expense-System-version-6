package expenseSysModels;

public class FinanceManager extends User{

	public FinanceManager(int userID, String userName, String password, String firstName, String lastName, String email) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email; 
		this.role = 1;
	}
	
	public FinanceManager(User user) {
		this.userID = user.userID;
		this.userName = user.userName;
		this.password = user.password;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email; 
		this.role = 1;
	}	
	
	
	//view requests
	
	//manage requests(approve/decline)
	
	//view employees
	
	//view employee history
	
	//add employee

}