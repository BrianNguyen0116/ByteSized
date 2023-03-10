import java.io.Serializable;

public class Item implements Serializable {

	String name;
	int price;
	int total = 0;
	
	Item(String name, int price, int total){
		this.name = name;
		this.price = price;
		this.total = total;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		String ret = name + ": " + price + "\n";
		return ret;
	}
}
