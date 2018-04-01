package vendingmachine;

public class Drink extends Product {

	public Drink() {
		
	}
	
	public Drink(String name, String location, int quantity, double price) {
		productName = name;
		productLocation = location;
		productQuantity = quantity;
		productPrice = price;
	}
	
	public Drink(Product copy) {    //overloaded constructor that copies another objects fields
		productName = copy.getName();
		productLocation = copy.getLocation();
		productQuantity = copy.getQuantity();
		productPrice = copy.getPrice();
	}
	
	public String toString() {     //toString method
		return productName + ", " + productLocation + ", " + productQuantity + ", " + productPrice;
	}

}
