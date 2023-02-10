
public class Pizza {
	
	public String size;
	public Item crust;
	public String special_instructions;
	public Item[] toppings;
	public Item[] sauces;
	
	
	public Pizza(String size, String special_instructions, String crust, String[] toppings, String[] sauces){
		this.size = size;
		this.special_instructions = special_instructions;
		this.crust = new Item(crust);
		
		// Loop through array of input topping strings and create an item for each
		this.toppings = new Item[toppings.length];
		for (int i = 0; i < toppings.length; i++) {
			  this.toppings[i] = new Item(toppings[i]);
		}
		
		// Loop through array of input sauces strings and create an item for each
		this.sauces = new Item[sauces.length];
		for (int i = 0; i < sauces.length; i++) {
			  this.sauces[i] = new Item(sauces[i]);
		}
	}
	
	//GETTERS
	public String getSize() {
		return this.size;
	}
	
	public Item getCrust() {
		return this.crust;
	}
	
	public Item[] getToppings() {
		return this.toppings;
	}
	
	public Item[] getSauces() {
		return this.sauces;
	}
	
	public String getInst() {
		return this.special_instructions;
	}
	
	// SETTERS
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setCrust(String crust) {
		this.crust = new Item(crust);
	}
	
	public void setToppings(String[] toppings) {
		this.toppings = new Item[toppings.length];
		for (int i = 0; i < toppings.length; i++) {
			  this.toppings[i] = new Item(toppings[i]);
		}
	}
	
	public void setSauces(String[] sauces) {
		this.sauces = new Item[sauces.length];
		for (int i = 0; i < sauces.length; i++) {
			  this.sauces[i] = new Item(sauces[i]);
		}
	}
	
	public void setInstructions(String instructions) {
		this.special_instructions = instructions;
	}
	
	public void removeInstructions() {
		this.special_instructions = "";
	}
}