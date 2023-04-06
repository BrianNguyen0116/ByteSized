import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements Serializable{

    HashMap<String, Item> toppings = new HashMap<>();
	HashMap<String, Item> dough = new HashMap<>();
	HashMap<String, Item> sauces = new HashMap<>();
	ArrayList<Pizza> orders = new ArrayList<Pizza>();

	HashMap<String, ArrayList<Item>> toppingInv = new HashMap<>();

	protected Inventory() {
		populateToppings();
		populateDough();
		populateSauces();

	}

	private void populateToppings() {
		
		toppings.put("Pepperoni", new Item("Pepperoni", 50, 100));
		toppings.put("Bacon", new Item("Bacon", 50, 100));
		toppings.put("Italian Sausage", new Item("Italian Sausage", 50, 100));
		toppings.put("Jalapenos", new Item("Jalapenos", 125, 100));
		toppings.put("Mushroom", new Item("Mushroom", 75, 100));
		toppings.put("Pineapple", new Item("Pineapple", 290, 100));
		toppings.put("Mozzarella Cheese", new Item("Mozzarella Cheese", 35, 100));
		toppings.put("Green Peppers", new Item("Green Peppers", 90, 100));
		toppings.put("Olives", new Item("Olives", 45, 100));


	}

	private void populateDough() {
		dough.put("Stuffed", new Item("Stuffed", 500, 100));
		dough.put("Pan", new Item("Pan", 300, 100));
		dough.put("Homestyle", new Item("Homestyle", 300, 100));
		dough.put("Thin", new Item("Thin", 300, 100));
	}

	private void populateSauces() {
		sauces.put("Tomato Sauce", new Item("Tomato Sauce", 300, 100));
		sauces.put("BBQ Sauce", new Item("BBQ Sauce", 300, 100));
		sauces.put("Alfredo", new Item("Alfredo Sauce", 300, 100));
		sauces.put("Pesto Sauce", new Item("Pesto Sauce", 300, 100));
	}

	public Item getItem(String item) {

		if(toppings.containsKey(item))
			return toppings.get(item);
		else if(dough.containsKey(item))
			return dough.get(item);
		else if(sauces.containsKey(item))
			return sauces.get(item);
		else
			throw new IllegalArgumentException("Item does not exist.\n");
	}
	
	public ArrayList<Pizza> getOrders() {
		return orders;
	}
	
	public void putOrder(Pizza order) {
		orders.add(0, order);
	}
	
	public HashMap<String, Integer> getpricemap(String choice){
		
		HashMap<String, Item> target = null;
		if(choice == "sauce") target = this.sauces;
		if(choice == "toppings") target = this.toppings;
		if(choice == "dough") target = this.dough;
		if(target == null) return null;
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		for (String i:target.keySet()) {
			System.out.println(this.getItem("Tomato Sauce").getPrice());
			result.put(i, target.get(i).getPrice());
		}
		
		return result;
	}
}
