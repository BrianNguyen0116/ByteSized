
public class Item {

	String name;
	
	Item(String name){
		this.name = name;
	}
	
	// GETTERS
	public String getName() {
		return this.name;
	}
	
	// SETTERS
	private String setName(String name) {
		return this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
