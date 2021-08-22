package PhaseOneProject;

import java.io.*;

class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Private class variables

	private String username;
	private String password;
	private String emailID;

	// Class Constructor
	/*
	 * Users(String name, String pwd) { password = pwd; username = name; }
	 */
	
	public Users(String username, String password, String emailID) {
		super();
		this.username = username;
		this.password = password;
		this.emailID = emailID;
	}


	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Getter methods of class variables
	// public String getCustomerName() { return username; }
	// public String getAccountNumber() { return password; }
}