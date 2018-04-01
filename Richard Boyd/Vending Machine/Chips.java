package vendingmachine;

public class Chips extends Snack{

	public Chips() {
		
	}
	
	public Chips(String name, String location, int quantity, double price) {
		productName = name;
		productLocation = location;
		productQuantity = quantity;
		productPrice = price;
	}
	
	public Chips(Product copy) {    //overloaded constructor that copies another objects fields
		productName = copy.getName();
		productLocation = copy.getLocation();
		productQuantity = copy.getQuantity();
		productPrice = copy.getPrice();
	}
	
	public String toString() {     //toString method
		return productName + ", " + productLocation + ", " + productQuantity + ", " + productPrice;
	}
	
}
