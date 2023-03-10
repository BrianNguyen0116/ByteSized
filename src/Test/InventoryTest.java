import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryTest {

	@Test
	void testSauce() {
		Inventory inv = new Inventory();
		assertEquals(inv.getItem("Tomato Sauce").getTotal(), 100);
		inv.getItem("Tomato Sauce").setTotal(25);
		assertEquals(inv.getItem("Tomato Sauce").getTotal(), 25);
	}

	@Test
	void testToppings() {
		Inventory inv = new Inventory();
		assertEquals(inv.getItem("Pepperoni").getTotal(), 100);
		inv.getItem("Pepperoni").setTotal(25);
		assertEquals(25, inv.getItem("Pepperoni").getTotal());
	}

	@Test
	void testDough() {
		Inventory inv = new Inventory();
		assertEquals(inv.getItem("Stuffed").getTotal(), 100);
		inv.getItem("Stuffed").setTotal(25);
		assertEquals(25, inv.getItem("Stuffed").getTotal());
	}

}
