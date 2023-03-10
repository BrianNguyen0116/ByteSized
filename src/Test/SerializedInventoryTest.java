import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SerializedInventoryTest {

	@Test
	void test() {
		SerializedInventory sinv = SerializedInventory.getInstance();
		
		sinv.getInventory().getItem("Tomato Sauce").setPrice(2);
		assertEquals(2, sinv.getInventory().getItem("Tomato Sauce").getPrice());
	}

}
