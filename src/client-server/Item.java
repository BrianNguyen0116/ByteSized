
public class Item {

	String name;
	int price;
	
	Item(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	// GETTERS
	public int getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	// SETTERS
	private void setPrice(int price) {
		this.price = price;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
}
