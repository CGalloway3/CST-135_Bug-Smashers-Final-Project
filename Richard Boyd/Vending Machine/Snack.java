package vendingmachine;

public abstract class Snack extends Product{

	public Snack() {
		
	}
	
	public Snack(String name, String location, int quantity, double price) {
		super(name, location, quantity, price);
	}
	
	public Snack(Product copy) {    //overloaded constructor that copies another objects fields
		super(copy.getName(), copy.getLocation(), copy.getQuantity(), copy.getPrice());
	}
	
	public String toString() {     //toString method
		return this.getName() + ", " + this.getLocation() + ", " + this.getQuantity() + ", " + this.getPrice();
	}
	
}
