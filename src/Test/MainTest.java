import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testsortprice() {
		HashMap<String, Integer> input = new HashMap<String, Integer>();
		
		input.put("Small", 300);
		input.put("Medium", 400);
		input.put("Large", 600);
		input.put("X-Large", 800);
		
		ArrayList<Item> pricesorted = Main.sortedBy(input, true);
		ArrayList<Item> pricegoal = new ArrayList<Item>();
		pricegoal.add(new Item("Small"));
		pricegoal.add(new Item("Medium"));
		pricegoal.add(new Item("Large"));
		pricegoal.add(new Item("X-Large"));
		
		for (int i = 0; i < 4; i++) {
			assertEquals(pricegoal.get(i).getName() , pricesorted.get(i).getName());
		}
	}
	@Test
	void testsortalpha() {
		HashMap<String, Integer> input = new HashMap<String, Integer>();
		
		input.put("Small", 300);
		input.put("Medium", 400);
		input.put("Large", 600);
		input.put("X-Large", 800);
		
		ArrayList<Item> pricesorted = Main.sortedBy(input, false);
		ArrayList<Item> pricegoal = new ArrayList<Item>();
		pricegoal.add(new Item("Large"));
		pricegoal.add(new Item("Medium"));
		pricegoal.add(new Item("Small"));
		pricegoal.add(new Item("X-Large"));
		
		for (int i = 0; i < 4; i++) {
			assertEquals(pricegoal.get(i).getName() , pricesorted.get(i).getName());
		}
	}

}
