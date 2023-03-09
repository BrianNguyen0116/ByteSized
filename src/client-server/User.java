import java.util.Objects;

public class User {
	private String username;
	private String password;
	private boolean loggedin;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedin = false;
	}
	
	// Class getters
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean isLoggedIn() {
		return this.loggedin;
	}

	
	// Class setters
	public String setUsername(String username) {
		this.username = username;
		return username;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedin = loggedIn;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }
	
    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedin +
                '}';
    }
}
