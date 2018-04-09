//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: main.java
*    Summary: Driver class for functionality testing.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		// Create main dispenser and print out products
                Dispenser main = new Dispenser();
		main.displayProducts();
                
                // Initialize main loop
                System.out.println("To select a product please type its name. To enter administration mode type \"admin\"");
                Scanner input = new Scanner(System.in);
                Boolean productFound;
                String i = "";
                
                // Main loop
                while ( !i.equalsIgnoreCase("x") ) {     // Exits loop with "x"           
                    
                    // Initialize each loop iteration.
                    System.out.print("Selection: ");
                    i = input.nextLine();
                    productFound = false;
                    
                    // Catch administrative mode entrance and prompt for password.
                    if ( i.equalsIgnoreCase("admin") ) {
                        System.out.print("Please enter the admin password: ");
                        productFound = true;
                        i = input.nextLine();
                        System.out.println("Password is invalid"); // No valid password implemented.
                    }
                    
                    // Itterate through product list looking for a match
                    for ( Product p : main.productlist ) {
                        if( p.getName().equals(i) ) {
                            //Match found
                            if ( p.getQuantity() > 0 ) {  // Check for in stock
                                // Product is in stock
                                productFound = true;
                                p.restockProduct( p.getQuantity() - 1 );
                                System.out.println( "Dispensing... " + p.toString() );
                            }
                            else {
                                // Product out of stock.
                                System.out.println("That product is out of stock.");
                            }
                        }
                    }
                
                    // Product was not found
                    if ( !productFound ) {
                        System.out.println("Product not in the list.");
                    }
                }   
	}


}
