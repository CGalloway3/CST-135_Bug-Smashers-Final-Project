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
    
	private final ArrayList<Product> productList = new ArrayList<>();
	
    // Public constructors
        
	public Dispenser() {
                createProducts();
	}

    // Additional private methods
        
	private void createProducts() {              //creates products
		
		// Create an empty drink product to test default constructor.
                Product empty = new Drink();
                productList.add(empty);
            
                
                // Create a drink product to test overloaded constructor with parameter list.
                Drink pepsi = new Drink("Pepsi", "A1", 10, 1.75);
		productList.add(pepsi);
		
		// Create a drink product to test copy constructor and renaming functionality.
                Drink dietpepsi = new Drink(pepsi);
		dietpepsi.renameProduct("Diet Pepsi");
		dietpepsi.relocateProduct("A2");
		productList.add(dietpepsi);
		
                
		// Create an empty chips product to test default constructor.
                empty = new Chips();
                productList.add(empty);
                
                // Create a chip product to test overloaded constructor with parameter list.
		Chips ruffles = new Chips("Ruffles", "B1", 5, 1.00);
		productList.add(ruffles);
		
		// Create a chip product to test copy constructor and renaming functionality.
		Chips doritos = new Chips(ruffles);
		doritos.renameProduct("Doritos");
		doritos.relocateProduct("B2");
		productList.add(doritos);
		
		
		// Create an empty candy procust to test default constructor.
                empty = new Candy();
                productList.add(empty);
                
                // Create a candy product to test overloaded constructor with parameter list.
		Candy kitkat = new Candy("Kit Kat", "C1", 12, .75);
		productList.add(kitkat);
		
		// Create a candy product to test copy constructor and renaming functionality.
		Candy snickers = new Candy(kitkat);
		snickers.renameProduct("Snickers");
		snickers.relocateProduct("C2");
		productList.add(snickers);
		
		
 		// Create an empty gum product to test default constructor.
                empty = new Gum();
                productList.add(empty);
                
               // Create a gum product to test overloaded constructor with parameter list.
		Gum orbitpep = new Gum("Orbit Peppermint", "D1", 15, .50);
		productList.add(orbitpep);
		
		// Create a gum product to test copy constructor and renaming functionality.
		Gum orbitspear = new Gum(orbitpep);
		orbitspear.renameProduct("Orbit Spearmint");
		orbitspear.relocateProduct("D2");
		productList.add(orbitspear);
	}
	
    // Additional public methods
        
        public void displayProducts() {   //Displays products on their own line using a simple loop
		
		int counter = 0;
		
		while (counter < productList.size()) {
			
			System.out.println(productList.get(counter).toString());
			
			counter++;
			
		}
		
	}
	
}
