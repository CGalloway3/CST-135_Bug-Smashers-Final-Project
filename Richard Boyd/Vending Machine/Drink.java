package vendingmachine;

public class Drink extends Product implements Comparable<Drink> {

	public Drink() {
		
	}
	
	public Drink(String name, String location, int quantity, double price) {
		super(name, location, quantity, price);
	}
	
	public Drink(Product copy) {    //overloaded constructor that copies another objects fields
		super(copy);
	}
	
	public String toString() {     //toString method
		return this.getName() + ", " + this.getLocation() + ", " + this.getQuantity() + ", " + this.getPrice();
	}

	@Override
	public int compareTo(Drink o) {
		
		return getName().compareTo(o.getName());
		
	}

}
