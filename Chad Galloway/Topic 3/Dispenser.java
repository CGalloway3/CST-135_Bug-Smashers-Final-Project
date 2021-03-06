//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Dispenser.java
*    Summary: Initial implementation of Dispenser class to be designed for dispensing products to the user.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

import java.util.ArrayList;
import java.util.Collections;

public class Dispenser {
	
    // Private fields
	
	ArrayList<Product> productlist = new ArrayList<Product>();
	
    // Public constructors
	
	public Dispenser() {
		createProducts();
	}
	
    // Additional private methods
        
	private ArrayList<Product> createProducts() {              //creates products
		
		ArrayList<Drink> drinklist = new ArrayList<Drink>();
		
		Drink pepsi = new Drink("Pepsi", "A1", 10, 1.75);       //predetermined drink properties
		drinklist.add(pepsi);                                   //code allows to add or remove drinks here
		                                                        //will still alphebetize 
		Drink fanta = new Drink(pepsi);                         //dynamic code also applied to snacks below
		fanta.renameProduct("Fanta Orange");
		fanta.relocateProduct("A3");
		drinklist.add(fanta);
		
		Drink dietpepsi = new Drink(pepsi);
		dietpepsi.renameProduct("Diet Pepsi");
		dietpepsi.relocateProduct("A2");
		drinklist.add(dietpepsi);
		
		for (int x = 1; x < drinklist.size(); x++) {           //Insertion sort that alphebetizes drinks
			for (int y = x; y > 0 && drinklist.get(y - 1).compareTo(drinklist.get(y)) > 0; y = y - 1) {
				Collections.swap(drinklist, y, y - 1);
			}
		}
		
		for (int i = 0; i < drinklist.size(); i++) {           //loop that adds newly alphebetized drinks to productlist
			productlist.add(drinklist.get(i));	
		}
		
		
		ArrayList<Snack> snacklist = new ArrayList<Snack>();
		
		Chips ruffles = new Chips("Ruffles", "B1", 5, 1.00);
		snacklist.add(ruffles);
		
		// Create a chip product to test copy constructor and renaming functionality.
		Chips doritos = new Chips(ruffles);
		doritos.renameProduct("Doritos");
		doritos.relocateProduct("B2");
		snacklist.add(doritos);
		
		
		Candy kitkat = new Candy("Kit Kat", "C1", 12, .75);
		snacklist.add(kitkat);
		
		Candy snickers = new Candy(kitkat);
		snickers.renameProduct("Snickers");
		snickers.relocateProduct("C2");
		snacklist.add(snickers);
		
		
		Gum orbitpep = new Gum("Orbit Peppermint", "D1", 15, .50);
		snacklist.add(orbitpep);
		
		Gum orbitspear = new Gum(orbitpep);
		orbitspear.renameProduct("Orbit Spearmint");
		orbitspear.relocateProduct("D2");
		snacklist.add(orbitspear);
		
		for (int x = 1; x < snacklist.size(); x++) {           //Insertion sort that alphebetizes snacks
			for (int y = x; y > 0 && snacklist.get(y - 1).compareTo(snacklist.get(y)) > 0; y = y - 1) {
				Collections.swap(snacklist, y, y - 1);
			}
		}
		
		for (int i = 0; i < snacklist.size(); i++) {           //loop that adds newly alphebetized snacks to productlist
			productlist.add(snacklist.get(i));	
		}
		
		return productlist;
		
	}
	
    // Additional public methods
        
	public void displayProducts() {   //Displays products on their own line using a simple loop
		
		for (int i = 0; i < productlist.size(); i++) {
			
			System.out.println(productlist.get(i).toString());
			
		}
		
	}
	
}
