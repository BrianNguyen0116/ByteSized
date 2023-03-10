import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class IntegrationTest {

	@Test
	void test1() {
		SerializedInventory sinv = SerializedInventory.getInstance();
		
		sinv.getInventory().getItem("Pepperoni").setPrice(137);
		sinv.getInventory().getItem("Tomato Sauce").setPrice(1000);
		sinv.getInventory().getItem("Homestyle").setPrice(1);
		
		HashMap<String, Integer> toppings = Main.getToppingPrices();
		HashMap<String, Integer> sauce = Main.getSaucePrices();
		HashMap<String, Integer> dough = Main.getDoughPrices();
		
		assertEquals(toppings.get("Pepperoni"),137);
		assertEquals(sauce.get("Tomato Sauce"), 1000);
		assertEquals(dough.get("Homestyle"), 1);
		
		sinv.getInventory().getItem("Pepperoni").setPrice(12);
		sinv.getInventory().getItem("Tomato Sauce").setPrice(99);
		sinv.getInventory().getItem("Homestyle").setPrice(100);
		
		toppings = Main.getToppingPrices();
		sauce = Main.getSaucePrices();
		dough = Main.getDoughPrices();
		
		assertEquals(toppings.get("Pepperoni"),12);
		assertEquals(sauce.get("Tomato Sauce"), 99);
		assertEquals(dough.get("Homestyle"), 100);
	}
	
	@Test
	void test2() {//singleton principle
		SerializedInventory sinv = SerializedInventory.getInstance();
		sinv.getInventory().getItem("Pepperoni").setPrice(137);
		
		SerializedInventory prince = SerializedInventory.getInstance();
		
		prince.getInventory().getItem("Homestyle").setPrice(67);
		prince.getInventory().getItem("Tomato Sauce").setPrice(99);
		sinv.getInventory().getItem("Tomato Sauce").setPrice(13);
		prince.getInventory().getItem("Alfredo").setPrice(37);
		
		
		HashMap<String, Integer> toppings = Main.getToppingPrices();
		HashMap<String, Integer> sauce = Main.getSaucePrices();
		HashMap<String, Integer> dough = Main.getDoughPrices();
		
		assertEquals(toppings.get("Pepperoni"),137);
		assertEquals(dough.get("Homestyle"), 67);
		assertEquals(sauce.get("Tomato Sauce"), 13);
		assertEquals(sauce.get("Alfredo"), 37);

	}
	

}
