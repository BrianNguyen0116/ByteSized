
public class Item {

	String name;
	int price; //200 is equivalent to $2.00
	
	Item(String name){
		this.name = name;
		this.price = 0;
	}
	
	Item(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	// GETTERS
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	// SETTERS
	private String setName(String name) {
		return this.name = name;
	}
	
	private int setPrice(int price) {
		return this.price = price;
	}
	
}
