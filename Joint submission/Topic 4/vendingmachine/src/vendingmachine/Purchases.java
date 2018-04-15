//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Purchases.java
*    Summary: class for purchased item tracking and transaction processing.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

import java.util.ArrayList;

public class Purchases {
    
    // Private fields
    private ArrayList<Product> purchasedProducts = new ArrayList<Product>();

    public Purchases() {
        
    }
    
    public void addPurchasedProduct(Product product){
        purchasedProducts.add(product);
    }
    
    public void removePurchasedProduct(Product product){
        purchasedProducts.remove(product);
    }
    
    public void displayPurchasedProducts(){
        
    }
}
