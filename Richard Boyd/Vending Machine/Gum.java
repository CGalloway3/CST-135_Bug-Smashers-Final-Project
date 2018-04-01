package vendingmachine;

public class Gum extends Snack{

	
	public Gum() {
		
	}
	
	public Gum(String name, String location, int quantity, double price) {
		super(name, location, quantity, price);
	}
	
	public Gum(Product copy) {    //overloaded constructor that copies another objects fields
		super(copy);
	}
	
	public String toString() {     //toString method
		return this.getName() + ", " + this.getLocation() + ", " + this.getQuantity() + ", " + this.getPrice();
	}
}
