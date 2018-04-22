//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Chips.java
*    Summary: Chips subclass of Snack class inherited from Product.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine.products;

public class Chips extends Snack{

    // Public constructors
    
	public Chips() {
		super();
	}
	public Chips(String name, String location, int quantity, double price) {
		super(name, location, quantity, (int)(price * 100));
		
	}
	public Chips(Product copy) {    //overloaded constructor that copies another objects fields
		super(copy);
		
	}
	
    // Additional public methods   
        
        @Override
	public String toString() {     //toString method
		return String.format(this.getName() + "\n$" + this.getPrice() / 100 + ".%02d", this.getPrice() % 100);
	}
	
}
