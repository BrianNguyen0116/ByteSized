import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Infotest {

	@Test
	void testSetAddress() {
		Info info = new Info();
        info.setAddress("123 Hello Street");
		assertEquals(info.getAddress(), "123 Hello Street");
	}

	@Test
	void testSetName() {
		Info info = new Info();
        info.setAddress("Power Pizza");
		assertEquals(info.getName(), "Power Pizza");
	}
	@Test
	void testSetPhoneNumber() {
		Info info = new Info();
        info.setPhoneNumber("416-666-5555");
		assertEquals(info.getPhoneNumber(), "416-666-5555");
	}

    @Test
	void testSetMoto() {
		Info info = new Info();
        info.setMoto("I'm Lovin' It!");
		assertEquals(info.getMoto(), "I'm Lovin' It!");
	}    

}