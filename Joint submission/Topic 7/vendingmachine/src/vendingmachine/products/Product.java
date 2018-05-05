//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Product.java
*    Summary: Base class for products to be sold in the dispenser.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine.products;

public abstract class Product {
	
    // Private fields
    
	private String productName;          
	private int productPrice;
	
	
    // Public constructors
        
        public Product() {	//no argument constructor
            productName = "";
            productPrice = 0;
        }
	
	public Product(String name, int price) {   //overloaded constructor with parameters
		productName = name;
		productPrice = price;
	}
	
	public Product(Product copy) {    //overloaded constructor that copies another objects fields
		productName = copy.getName();
		productPrice = copy.getPrice();		
	}
	
	
    // Public accessors for private fields.
	
	public String getName() {
		return this.productName;
	}
	public int getPrice() {
		return this.productPrice;
	}
	public void renameProduct(String newName) {    
		this.productName = newName;
	}
        public void repriceProduct(int newPrice) {
		this.productPrice = newPrice;
	}
        
    // Additional public methods

        @Override
        public String toString() {     //toString method
		return String.format(this.getName() + "\n$" + this.getPrice() / 100 + ".%02d", this.getPrice() % 100);
	}
	
		
}