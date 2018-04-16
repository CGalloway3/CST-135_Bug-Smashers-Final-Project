//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Product.java
*    Summary: Base class for products to be sold in the dispenser.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

public abstract class Product {
	
    // Private fields
    
	private String productName;          
	private String productLocation;
	private int productQuantity;
	private double productPrice;
	
    // Public constructors
        
        public Product() {	//no argument constructor
            productName = "";
            productLocation = "";
            productQuantity = 0;
            productPrice = 0.0;
        }
	
	public Product(String name, String location, int quantity, double price) {   //overloaded constructor with parameters
		productName = name;
		productLocation = location;
		productQuantity = quantity;
		productPrice = price;
	}
	
	public Product(Product copy) {    //overloaded constructor that copies another objects fields
		productName = copy.getName();
		productLocation = copy.getLocation();
		productQuantity = copy.getQuantity();
		productPrice = copy.getPrice();
	}
	
	
    // Public accessors for private fields.
	
	public String getName() {
		return this.productName;
	}
	public String getLocation() {
		return this.productLocation;
	}
	public int getQuantity() {
		return this.productQuantity;
	}
	public double getPrice() {
		return this.productPrice;
	}
        
    // Public inventory management methods
        
	public void renameProduct(String newName) {    
		this.productName = newName;
	}
	public void relocateProduct(String newLocation) {
		this.productLocation = newLocation;
	}
	public void restockProduct(int newQuantity) {     //restock and reprice methods
		this.productQuantity = newQuantity;
	}
        public void repriceProduct(double newPrice) {
		this.productPrice = newPrice;
	}
	
    // Additional public methods
        
	@Override
        public String toString() {     //toString method
		return productName + "\n " + productPrice;
	}
	
		
}