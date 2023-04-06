import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class InfoTest {

	@Test
	void test_set_and_get_Address() {
		Info info = new Info();
        info.setAddress("123 Hello Street");
		assertEquals(info.getAddress(), "123 Hello Street");
	}

	@Test
	void test_set_and_get_name() {
		Info info = new Info();
        info.setName("Power Pizza");
		assertEquals(info.getName(), "Power Pizza");
	}
	@Test
	void test_set_and_get_phoneNumber() {
		Info info = new Info();
        info.setPhoneNumber("416-666-5555");
		assertEquals(info.getPhoneNumber(), "416-666-5555");
	}

    @Test
	void test_set_and_get_moto() {
		Info info = new Info();
        info.setMoto("I'm Lovin' It!");
		assertEquals(info.getMoto(), "I'm Lovin' It!");
	}    

}