
public class Pizza {
	
	public String size;
	public Item[] toppings;
	public Item crescent;
	public Item[] sauces;
	public String special_instructions;
	
	
	public Pizza(String size, String special_instructions, String crescent, String[] toppings, String[] sauces){
		this.size = size;
		this.special_instructions = special_instructions;
		this.crescent = new Item(crescent);
		
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
	
	public Item getCrescent() {
		return this.crescent;
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
	
	public void setCrescent(String crescent) {
		this.crescent = new Item(crescent);
	}
	
	public void setToppings(String[] toppings) {
		this.toppings = new Item[toppings.length];
		for (int i = 0; i < toppings.length; i++) {
			  this.toppings[i] = new Item(toppings[i]);
		}
	}
	
	public void setsauces(String[] sauces) {
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