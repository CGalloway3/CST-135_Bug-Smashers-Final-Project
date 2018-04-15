//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Drink.java
*    Summary: Drink subclass inherited from Product.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

public class Drink extends Product implements Comparable<Drink> {

    // Public constructors
        
        public Drink() {
            super();
	}
	public Drink(String name, String location, int quantity, double price) {
            super(name, location, quantity, (int)(price * 100));
	}
	public Drink(Product copy) {    //overloaded constructor that copies another objects fields
            super(copy);
	}
        
    // Additional public methods
        
        @Override
	public String toString() {     //toString method
		return String.format(this.getName() + "\n$" + this.getPrice() / 100 + ".%02d", this.getPrice() % 100);
	}

	@Override
	public int compareTo(Drink o) {
		
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
