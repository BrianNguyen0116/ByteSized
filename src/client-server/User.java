import java.util.Objects;
//import org.json.simple.JSONObject;
import java.io.FileWriter;
//import org
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

// commit from Mustafa? 
public class User {
	private String username;
	private String password;
	private String role;
	private boolean loggedin;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.role = "user";
		this.loggedin = false;
		
		
		// when initiating a user, save it in a json file
		//Creating a JSONObject object
		JsonObject json = new JsonObject();

		json.put("username", this.username);
		json.put("password", this.password);
		json.put("role", this.role);
		
		try {
			FileWriter file = new FileWriter("output.json");
			file.write(json.toJson());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Class getters
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
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
