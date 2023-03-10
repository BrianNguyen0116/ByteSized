import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryTest {

	@Test
	void testGetItem() {
		Inventory inv = new Inventory();
		
		assertEquals(inv.getItem("Tomato Sauce").getTotal(), 100);
		inv.getItem("Tomato Sauce").setTotal(25);
		assertEquals(inv.getItem("Tomato Sauce").getTotal(), 25);
	}

}
