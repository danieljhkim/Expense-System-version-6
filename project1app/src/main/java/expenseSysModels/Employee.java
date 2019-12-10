package expenseSysModels;

public class Employee extends User{

	public Employee(String userName, String password, String firstName, String lastName, String email) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email; 
		this.role = 0;
	}
	
	public Employee(User user) {
		this.userID = user.userID;
		this.userName = user.userName;
		this.password = user.password;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email; 
		this.role = 0; 
	}	
	
	//submit
	
	//view all
	
	//view one

}