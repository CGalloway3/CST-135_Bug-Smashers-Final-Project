//CST-135 group assignment for Topic 6, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: InventoryManager.java
*    Summary: Inventory management of products in and out.
*    Author: Chad Galloway
*    Date: April 22th, 2018
*    Last Update: April 27th, 2018
**/

package vendingmachine;

import java.util.ArrayList;
import vendingmachine.products.Candy;
import vendingmachine.products.Chips;
import vendingmachine.products.Drink;
import vendingmachine.products.Gum;
import vendingmachine.products.Product;

public class InventoryManager {

    // Private array lists for storing inventory items and items selected by the user for purchase.
    private final ArrayList<InventoryItem> dispenserInventoryList = new ArrayList<>();
    private final ArrayList<InventoryItem> itemsSelectedForPurchase = new ArrayList<>();

    // Public default constructor that reads in the inventory file
    public InventoryManager(){
        // Read in inventory list from file.
        generateInventoryList(); // file access not currently implemented generateInventoryList is a place holder method.
    }

    // Add an item to inventory
    public void addInventoryItem(Product product, String location, int quantity){
        dispenserInventoryList.add(new InventoryItem(product, location, quantity));
    }
    
    // Returns items in the itemsSelectedForPurchase array list to the dispenserInventoryList.
    // Used for cases where the user cancels a transaction.
    public void returnItemsSelectedForPurchase() {
        itemsSelectedForPurchase.forEach((i) -> {
            i.addOneItemToStock();
        });
        itemsSelectedForPurchase.clear();
    }

    // Returns the array list of the items selected for purchase.
    public ArrayList<InventoryItem> getItemsSelectedForPurchase() {
        return this.itemsSelectedForPurchase;
    }

    // Returns the array list of items in the dispensers inventory.
    public ArrayList<InventoryItem> getDispenserInventoryList() {
        return this.dispenserInventoryList;
    }

    // Adds user selected item to the list of items they have selected for purchase.
    public void addItemToProductsSelectedForPurchase(InventoryItem i) {
        itemsSelectedForPurchase.add(i);
        i.getOneItemFromStock();
    }
	
    // Removes an item from the list of items the user has selected for purchase.
    public void removeItemFromProductsSelectedForPurchase(InventoryItem i) {
        itemsSelectedForPurchase.remove(i);
        i.addOneItemToStock();
    }

    // Clears the array list of items the user selected for purchase because the user paid for them.
    public void completePurchase() {
        itemsSelectedForPurchase.clear();
    }

    // Place holder method to temporarily load inventory items until file access is implemented.
    private void generateInventoryList() {
        // Add some Drinks
        addInventoryItem(new Drink("Pepsi", 1.25), "A1", 10);
        addInventoryItem(new Drink("Diet Pepsi", 1.25), "A2", 10);
        addInventoryItem(new Drink("Cherry Pepsi", 1.50), "A3", 10);
        addInventoryItem(new Drink("Pepsi Vanilla", 1.25), "A4", 10);
        addInventoryItem(new Drink("Mountain Dew", 1.25), "A5", 1);
        addInventoryItem(new Drink("Mountain Dew Code Red", 1.50), "A6", 10);
        addInventoryItem(new Drink("Dr.Pepper", 1.25), "A7", 10);
        addInventoryItem(new Drink("Diet Dr.Pepper", 1.25), "A8", 10);
        addInventoryItem(new Drink("Dr. Pepper Cherry", 1.50), "A9", 10);
        addInventoryItem(new Drink("Fuze Ice Tea", 1.00), "B1", 10);
        addInventoryItem(new Drink("Lipton Peach Ice Tea", 1.00), "B2", 10);
        addInventoryItem(new Drink("Minute Maid Lemonade", 1.00), "B3", 10);
        addInventoryItem(new Drink("Monster", 1.75), "B4", 10);
        addInventoryItem(new Drink("Rockstar", 1.75), "B5", 10);
        addInventoryItem(new Drink("Sierra Mist", 1.25), "B6", 10);
        addInventoryItem(new Drink("7-Up", 1.25), "B7", 10);
        
        // Add some candy
        addInventoryItem(new Candy("M&M", 0.75), "A1", 10);
        addInventoryItem(new Candy("Kit Kat", 0.75), "A2", 10);
        addInventoryItem(new Candy("Reeses Pieces", 0.75), "A4", 10);
        addInventoryItem(new Candy("Baby Ruth", 0.50), "A5", 10);
        addInventoryItem(new Candy("Snickers", 0.75), "A6", 10);
        
        // Add some chips
        addInventoryItem(new Chips("Ruffles", 1.00), "A1", 1);
        addInventoryItem(new Chips("Cheetoes", 1.00), "A2", 10);
        addInventoryItem(new Chips("Doritos", 1.00), "A3", 10);
        addInventoryItem(new Chips("Hot Fries", 0.75), "A5", 10);
        addInventoryItem(new Chips("Lays", 1.00), "B2", 10);
        
        // Add some gum
        addInventoryItem(new Gum("Orbit", 0.50), "A1", 10);
        addInventoryItem(new Gum("Five", 0.75), "A2", 10);
        addInventoryItem(new Gum("Trident", 0.50), "A3", 0);
        addInventoryItem(new Gum("Juicy Fruit", 0.25), "A4", 10);
        addInventoryItem(new Gum("Bubble Yum", 0.50), "A5", 10);
        
    }

    // Public inner Class InventoryItem turns products into items in the machines inventory.
    public class InventoryItem {
        private final Product product;
        private String location;
        private int quantity;
        
        // Inventory Item constructor.
        public InventoryItem(Product product, String location, int quantity){
           this.product = product;
           this.location = location;
           this.quantity = quantity;
        }
       
        // Add one item to the quantity of items in the machine
        public void addOneItemToStock() {
            this.quantity += 1;
        }
        
        // Remove on item from the quantity of items in the machine.
        public void getOneItemFromStock() {
            this.quantity -= 1;
        }
        
        // Gets the product that is this current inventory item.
        public Product getProduct() {
            return this.product;
        }

        // Gets the location where the inventory item is store in the vending machine.
        public String getLocation() {
            return this.location;
        }

        // Gets the name of the product.
        public String getName() {
            return this.product.getName();
        }
        
        // get the price of the product.
        public int getPrice() {
            return this.product.getPrice();
        }
        
        // get the quantity of items stocked in the vending machine for this inventory item.
        public int getQuantity() {
            return this.quantity;
        }
        
        // Get the type of inventory item. (Drink, Chip, Candy, etc.)
        public String getInventoryItemType() {
            return product.getClass().getSimpleName();
        }
    }
}
