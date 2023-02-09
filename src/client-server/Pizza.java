
public class Pizza {
	
	public String size;
	public String[] toppings;
	public String crescent;
	public String[] sauces;
	public String special_instructions;
	
	
	public Pizza(String size, String special_instructions, String crescent, String[] toppings, String[] sauces){
		this.size = size;
		this.crescent = crescent;
		this.toppings = toppings;
		this.sauces = sauces;
		this.special_instructions = special_instructions;
	}
	
	//GETTERS
	public String getSize() {
		return this.size;
	}
	
	public String getCrescent() {
		return this.crescent;
	}
	
	public String[] getToppings() {
		return this.toppings;
	}
	
	public String[] getSauces() {
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
		this.crescent = crescent;
	}
	
	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}
	
	public void setsauces(String[] sauces) {
		this.sauces = sauces;
	}
	
	public void setInstructions(String instructions) {
		this.special_instructions = instructions;
	}
	
	public void removeInstructions() {
		this.special_instructions = "";
	}
	
	public String[] addTopping(String topping) {
		toppings[toppings.length] = topping;
		return toppings;
	}
	
	public String[] addSauce(String sauce) {
		sauces[sauces.length] = sauce;
		return sauces;
	}

    public String[] removeTopping(String[] toppings, int index){
        String[] newToppingsArr = new String[toppings.length - 1];
        for (int i = 0, k = 0; i < toppings.length; i++) {
            if (i == index) {
                continue;
            }
            // if the index is not
            // the removal element index
            newToppingsArr[k++] = toppings[i];
        }
 
        // return the resultant array
        return newToppingsArr;
    }
    
    public String[] removeSauce(String[] sauces, int index){
        String[] newSaucesArr = new String[sauces.length - 1];
        for (int i = 0, k = 0; i < sauces.length; i++) {
            if (i == index) {
                continue;
            }
            // if the index is not
            // the removal element index
            newSaucesArr[k++] = sauces[i];
        }
 
        // return the resultant array
        return newSaucesArr;
    }
}