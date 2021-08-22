package Phase1Project;

import java.io.Serializable;

public class Users implements Serializable {

	// Create POJO class for userCredentials with below data members and getter ,
	// setter methods.

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String emailID;
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users() {
		super();
	}

	public Users(String userName, String password, String emailID, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailID = emailID;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserCredentials [userName=" + userName + ", password=" + password + ", emailID=" + emailID + ", role=" + role + "]";
	}
}
