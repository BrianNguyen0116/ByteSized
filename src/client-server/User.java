import java.util.Objects;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class User {
	private String username;
	private String password;
	private String role;
	private boolean loggedin;
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.loggedin = false;
	}

	public User Signup(){
		String jsonText = null;
		JsonArray jsonObject = null;

		try {
			jsonText = new String(Files.readAllBytes(Paths.get("users.json")));
		}catch(IOException e) {
			System.out.println("threw an error trying to read json for the first time - check file format");
			throw new RuntimeException();
		}

		System.out.println("Successfully read files from the users json");

		// read and hold users array
		try {
			jsonObject = (JsonArray)Jsoner.deserialize(jsonText);
		}catch(JsonException e) {
			System.out.println("threw an error while reading users array");
			System.out.println(e);
			throw new RuntimeException();
		}

		// check that object does not already exist in the db
		for (Object obj : jsonObject) {
			JsonObject jo = (JsonObject)obj;
			System.out.println("\nusername is: " + jo.get("username") + "and passowrd is: " + jo.get("password"));
			System.out.println("\n====== compared to new user ======\n");
			System.out.println("username is: " + this.username + " and password is: " + this.password);

			if (jo.get("username").equals(this.username)) {
				// user already exists in the database 
				System.out.println("user already in the db - returning null");
				return null;
			}
		}
		// continue if user does not exist
		jsonObject.add(this.toJsonObject());
		jsonText = Jsoner.serialize(jsonObject);
		
		File myObj = new File("users.json"); 
		myObj.delete();
		
		try{
			Files.write(Paths.get("users.json"), jsonText.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e){
			System.out.println("Error writing the json file at the final step");
		}

		System.out.println("successfully added the user to the db - returning user");

		// set user to loggedin before returning it
		this.loggedin = true;
		return this;
		
	
	}

	public User Login() {
		
		String jsonText = null;
		JsonArray jsonObject = null;
		System.out.println("reached loging function 1");
		try {
			jsonText = new String(Files.readAllBytes(Paths.get("users.json")));
		}catch(IOException e) {
			System.out.println("threw an error");
			throw new RuntimeException();
		}
		System.out.println(jsonText);
		System.out.println("reached loging function 2");
		 try {
			 jsonObject = (JsonArray)Jsoner.deserialize(jsonText);
		 }	catch(JsonException e) {
			System.out.println("threw an error");
			 System.out.println(e);
			 throw new RuntimeException();
			 
		 }
		 
		 System.out.println("reached loging function 3");
		 // iterate over the database of users
		 for (Object obj : jsonObject) {
			 JsonObject jo = (JsonObject)obj;
			 System.out.println("username is: " + jo.get("username") + "and passowrd is: " + jo.get("password"));
			 
			 System.out.println("condition one is: " + jo.get("username").equals(this.username));

			 if (jo.get("username").equals(this.username) && jo.get("password").equals(this.password)) {
				 // user found, fill it in a user class and return class
				 System.out.println("User successfully logged in");
				 this.loggedin = true;
				 this.role = jo.get("role").toString();
				 return this;
			 }
		 }
		 // if code reaches here, then user is not found
		 System.out.println("user not in the db - returning null");
		 return null;

	}

	// convert object to a json object
	public JsonObject toJsonObject(){
		JsonObject jo = new JsonObject();
		jo.put("username", this.username);
		jo.put("password", this.password);
		jo.put("role", this.role);
		return jo;
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

	public String setRole(String role) {
		this.role = role;
		return role;
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
