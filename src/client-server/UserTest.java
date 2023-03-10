import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
	
	// Test getting user and password
	@Test
	void test1() {
		User test_user = new User("username1", "password1");
		assertEquals("username1", test_user.getUserName());
	}
	
	@Test
	void test2() {
		User test_user = new User("username1", "password1");
		assertEquals("password1", test_user.getPassword());
	}
	
	// Test channging username and password
	@Test
	void test3() {
		User test_user = new User("username1", "password1");
		test_user.setUsername("new username");
		assertEquals("new username", test_user.getUserName());
	}
	
	@Test
	void test4() {
		User test_user = new User("username1", "password1");
		test_user.setPassword("new password");
		assertEquals("new password", test_user.getPassword());
	}
	
	// Test user loggedout by default
	@Test
	void test5() {
		User test_user = new User("username1", "password1");
		assertEquals(false, test_user.isLoggedIn());
	}
	
	// Test logging a user in and out
	@Test
	void test6() {
		User test_user = new User("username1", "password1");
		test_user.setLoggedIn(true);
		assertEquals(true, test_user.isLoggedIn());
	}
	
	@Test
	void test7() {
		User test_user = new User("username1", "password1");
		test_user.setLoggedIn(true);
		test_user.setLoggedIn(false);
		assertEquals(false, test_user.isLoggedIn());
	}

}
