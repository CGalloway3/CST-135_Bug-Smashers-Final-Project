//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Chips.java
*    Summary: Chips subclass of Snack class inherited from Product.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

public class Chips extends Snack{

    // Public constructors
    
	public Chips() {
		super();
	}
	public Chips(String name, String location, int quantity, double price) {
		super(name, location, quantity, price);
		
	}
	public Chips(Product copy) {    //overloaded constructor that copies another objects fields
		super(copy);
		
	}
	
    // Additional public methods   
        
        @Override
	public String toString() {     //toString method
		return this.getName() + ", " + this.getLocation() + ", " + this.getQuantity() + ", " + this.getPrice();
	}
	
}
