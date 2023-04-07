import java.io.Serializable;

public class Discount implements Serializable{
	
	String name;
	int percent;
	boolean expire;
	
	public Discount() {
	}
	
	Discount(String name, int percent, boolean expire) {
		this.name = name;
		this.percent = percent;
		this.expire = expire; 
	}
	
	Discount(String name) {
		this.name = name;
		this.percent = 0;
		this.expire = false;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return this.percent;
	}
	
	public void setDiscount(int percent) {
		this.percent = percent;
	}

	public boolean getExpirationState() {
		return expire;
	}

	public void setExpirationState(boolean expire) {
		this.expire = expire;
	}
	
}
