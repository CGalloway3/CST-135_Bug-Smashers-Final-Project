//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Snack.java
*    Summary: Snack subclass implemented from Product and extendable.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine.products;

import vendingmachine.products.Product;

public abstract class Snack extends Product implements Comparable<Snack> {

    // Public construstors
    
        public Snack() {
            super();
	}
	public Snack(String name, int price) {
            super(name, price);
	}
	public Snack(Product copy) {    //overloaded constructor that copies another objects fields
            super(copy);
	}
	
    // Additional public methods

        @Override
        public String toString() {     //toString method
		return String.format(this.getName() + "\n$" + this.getPrice() / 100 + ".%02d", this.getPrice() % 100);
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
