package vendingmachine;

public abstract class Snack extends Product implements Comparable<Snack> {

	public Snack() {
		
	}
	
	public Snack(String name, String location, int quantity, double price) {
		super(name, location, quantity, price);
	}
	
	public Snack(Product copy) {    //overloaded constructor that copies another objects fields
		super(copy);
	}
	
	public String toString() {     //toString method
		return this.getName() + ", " + this.getLocation() + ", " + this.getQuantity() + ", " + this.getPrice();
	}
	
	@Override
	public int compareTo(Snack o) {
		
		return getName().compareTo(o.getName());
		
	}
	
}
