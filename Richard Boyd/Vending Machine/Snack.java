package vendingmachine;

public abstract class Snack extends Product{

	public Snack() {
		
	}
	
	public Snack(String name, String location, int quantity, double price) {
		productName = name;
		productLocation = location;
		productQuantity = quantity;
		productPrice = price;
	}
	
	public Snack(Product copy) {    //overloaded constructor that copies another objects fields
		productName = copy.getName();
		productLocation = copy.getLocation();
		productQuantity = copy.getQuantity();
		productPrice = copy.getPrice();
	}
	
	public String toString() {     //toString method
		return productName + ", " + productLocation + ", " + productQuantity + ", " + productPrice;
	}
	
}
