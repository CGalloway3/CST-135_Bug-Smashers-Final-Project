//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Snack.java
*    Summary: Snack subclass implemented from Product and extendable.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

public abstract class Snack extends Product implements Comparable<Snack> {

    // Public construstors
    
        public Snack() {
            super();
	}
	public Snack(String name, String location, int quantity, double price) {
            super(name, location, quantity, price);
	}
	public Snack(Product copy) {    //overloaded constructor that copies another objects fields
            super(copy);
	}
	
    // Additional public methods

        @Override
        public String toString() {     //toString method
            return this.getName() + ", " + this.getLocation() + ", " + this.getQuantity() + ", " + this.getPrice();
	}
        
        @Override
	public int compareTo(Snack o) {
		
		if (getName().compareTo(o.getName()) == 0) {
			
			if (getPrice() > o.getPrice()) {
				return 1;
			}
			
			else if (getPrice() < o.getPrice()) {
				return -1;
			}
			
			else return 0;
			
		}
		
		else return getName().compareTo(o.getName());
		
	}

}
