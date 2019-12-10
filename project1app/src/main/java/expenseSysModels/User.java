package expenseSysModels;

public class User {

	int userID;
	String userName;
	String password;
	String firstName;
	String lastName;
	String email;
	int role;
	
	public String getUserName() {
		return userName;
	}
	public User(String userName, String password, String firstName, String lastName, String email, int role) {
		//this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role; 
	}
	public User(int userID, String userName, String password, String firstName, String lastName, String email, int role) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	public User() {
	}
	public void setUserName(String un) {
		this.userName = un;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pw) {
		this.password = pw;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int r) {
		this.role = r; 
	}
	
}