package PhaseOneProject;

import java.io.Serializable;

class UserCredentials implements Serializable {

	private static final long serialVersionUID = 1L;

	private String siteName;
	private String loggedInUser;
	private String username;
	private String password;

	public UserCredentials() {
	}

	public UserCredentials(String siteName, String loggedInUser, String username, String password) {
		this.siteName = siteName;
		this.loggedInUser = loggedInUser;
		this.username = username;
		this.password = password;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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

}
