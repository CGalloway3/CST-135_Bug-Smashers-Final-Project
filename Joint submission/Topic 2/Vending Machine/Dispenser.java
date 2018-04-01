//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Dispenser.java
*    Summary: Initial implementation of Dispenser class to be designed for dispensing products to the user.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

import java.util.ArrayList;

public class Dispenser {
	
    // Private fields
    
	private final ArrayList<Product> productlist = new ArrayList<>();
	
    // Public constructors
        
	public Dispenser() {
                createProducts();
	}

    // Additional private methods
        
	private void createProducts() {              //creates products
		
		// Create an empty product to test default constructor.
                Product empty = new Drink();
                productlist.add(empty);
            
                
                // Create a drink product to test overloaded constructor with parameter list.
                Drink pepsi = new Drink("Pepsi", "A1", 10, 1.75);
		productlist.add(pepsi);
		
		// Create a drink product to test copy constructor and renaming functionality.
                Drink dietpepsi = new Drink(pepsi);
		dietpepsi.renameProduct("Diet Pepsi");
		dietpepsi.relocateProduct("A2");
		productlist.add(dietpepsi);
		
                
                // Create a chip product to test overloaded constructor with parameter list.
		Chips ruffles = new Chips("Ruffles", "B1", 5, 1.00);
		productlist.add(ruffles);
		
		// Create a chip product to test copy constructor and renaming functionality.
		Chips doritos = new Chips(ruffles);
		doritos.renameProduct("Doritos");
		doritos.relocateProduct("B2");
		productlist.add(doritos);
		
		
                // Create a candy product to test overloaded constructor with parameter list.
		Candy kitkat = new Candy("Kit Kat", "C1", 12, .75);
		productlist.add(kitkat);
		
		// Create a candy product to test copy constructor and renaming functionality.
		Candy snickers = new Candy(kitkat);
		snickers.renameProduct("Snickers");
		snickers.relocateProduct("C2");
		productlist.add(snickers);
		
		
                // Create a gum product to test overloaded constructor with parameter list.
		Gum orbitpep = new Gum("Orbit Peppermint", "D1", 15, .50);
		productlist.add(orbitpep);
		
		// Create a gum product to test copy constructor and renaming functionality.
		Gum orbitspear = new Gum(orbitpep);
		orbitspear.renameProduct("Orbit Spearmint");
		orbitspear.relocateProduct("D2");
		productlist.add(orbitspear);
	}
	
    // Additional public methods
        
        public void displayProducts() {   //Displays products on their own line using a simple loop
		
		int counter = 0;
		
		while (counter < productlist.size()) {
			
			System.out.println(productlist.get(counter).toString());
			
			counter++;
			
		}
		
	}
	
}
