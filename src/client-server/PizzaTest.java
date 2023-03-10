import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PizzaTest {
	
	// test pizza creation
	@Test
	void test1() {
		Pizza test_pizza = new Pizza("small", "extra time in the oven", "thick", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		assertEquals("small", test_pizza.getSize());
	}
	
	// test changing size
	@Test
	void test2() {
		Pizza test_pizza = new Pizza("small", "extra time in the oven", "thick", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		test_pizza.setSize("medium");
		assertEquals("medium", test_pizza.getSize());
	}
	
	// test changing crust
	@Test
	void test3() {
		Pizza test_pizza = new Pizza("small", "extra time in the oven", "thin", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		test_pizza.setCrust("thick");
		Item test_item = new Item("thick");
		if (test_item.getName() == test_pizza.getCrust().getName()) {
			assertEquals(0, 0);
		} else {
			assertEquals(0, 1);
		}
	}
	
	// test changing instructions
	@Test
	void test4() {
		Pizza test_pizza = new Pizza("small", "default instructions", "thin", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		test_pizza.setInstructions("instructions updated");
		assertEquals("instructions updated", test_pizza.getInst());
	}
	
	// test deleting instructions
	@Test
	void test5() {
		Pizza test_pizza = new Pizza("small", "default instructions", "thin", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		test_pizza.removeInstructions();
		assertEquals("", test_pizza.getInst());
	}
	
	// test changing toppings
	@Test
	void test6() {
		Pizza test_pizza = new Pizza("small", "default instructions", "thin", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		test_pizza.setToppings(new String[] {"mushrooms", "olives"});
		assertEquals(new String[]{"mushrooms", "olives"}, test_pizza.getToppings());
	}
	
	// test changing sauces
	@Test
	void test7() {
		Pizza test_pizza = new Pizza("small", "default instructions", "thin", new String[]{"cheese", "barbeque"}, new String[]{"cheese", "barbeque"});
		test_pizza.setSauces(new String[] {"tomatoe sauce"});
		assertEquals(new String[] {"tomatoe sauce"}, test_pizza.getSauces());
	}
}
