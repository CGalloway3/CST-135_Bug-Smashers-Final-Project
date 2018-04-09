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
		
		Dispenser main = new Dispenser();
		main.displayProducts();
                
                System.out.println("To select a product please type its name. To enter administration mode type \"admin\"");
                Scanner input = new Scanner(System.in);
                Boolean productFound = false;
                String i = "";
                
                while ( !i.equalsIgnoreCase("x") ) {                
                    
                    i = input.nextLine();
                    productFound = false;
                    if ( i.equalsIgnoreCase("admin") ) {
                        System.out.print("Please enter the admin password: ");
                        i = input.nextLine();
                        System.out.println("Password is invalid");
                    }
                    for ( Product p : main.productlist ) {
                        if( p.getName().equals(i) ) {
                            if ( p.getQuantity() > 0 ) {
                                productFound = true;
                                p.restockProduct( p.getQuantity() - 1 );
                                System.out.println( "Dispensing... " + p.toString() );
                            }
                            else {
                                System.out.println("That product is out of stock.");
                            }
                        }
                    }
                
                    if ( !productFound ) {
                        System.out.println("Prodduct not in the list.");
                    }
                }   
	}


}
