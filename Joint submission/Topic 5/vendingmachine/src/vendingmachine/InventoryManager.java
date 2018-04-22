//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: InventoryManager.java
*    Summary: Inventory management of products in and out.
*    Author: Chad Galloway
*    Date: April 22th, 2018
**/

package vendingmachine;

import java.util.ArrayList;
import vendingmachine.products.Candy;
import vendingmachine.products.Chips;
import vendingmachine.products.Drink;
import vendingmachine.products.Gum;
import vendingmachine.products.Product;

public class InventoryManager {

    private final ArrayList<InventoryItem> masterInventoryList = new ArrayList<>();
    private final ArrayList<InventoryItem> itemsSelectedForPurchase = new ArrayList<>();

    public InventoryManager(){
        generateInventoryList();
    }

    void addInventoryItem(Product product, String location, int quantity){
        masterInventoryList.add(new InventoryItem(product, location, quantity));
    }
    
    
    void returnItemsSelectedForPurchase() {
        itemsSelectedForPurchase.forEach((i) -> {
            i.addOneItemToStock();
        });
        itemsSelectedForPurchase.clear();
    }

    ArrayList<InventoryItem> getItemsSelectedForPurchase() {
        return this.itemsSelectedForPurchase;
    }

    ArrayList<InventoryItem> getMasterInventoryList() {
        return this.masterInventoryList;
    }

    void addItemToProductsSelectedForPurchase(InventoryItem i) {
        itemsSelectedForPurchase.add(i);
        i.getOneItemFromStock();
    }
	
    void removeItemFromProductsSelectedForPurchase(InventoryItem i) {
        itemsSelectedForPurchase.remove(i);
        i.addOneItemToStock();
    }

    void completePurchase() {
        itemsSelectedForPurchase.clear();
    }

    private void generateInventoryList() {
        // Add some Drinks
        addInventoryItem(new Drink("Pepsi", 1.25), "A1", 10);
        addInventoryItem(new Drink("Diet Pepsi", 1.25), "A2", 10);
        addInventoryItem(new Drink("Cherry Pepsi", 1.50), "A3", 10);
        addInventoryItem(new Drink("Coke", 1.25), "A4", 10);
        addInventoryItem(new Drink("Diet Coke", 1.25), "A5", 1);
        addInventoryItem(new Drink("Cherry Coke", 1.50), "A6", 10);
        addInventoryItem(new Drink("Dr.Pepper", 1.25), "A7", 10);
        addInventoryItem(new Drink("Diet Dr.Pepper", 1.25), "A8", 10);
        addInventoryItem(new Drink("Cherry Vanillia Dr.Pepper", 1.50), "A9", 10);
        addInventoryItem(new Drink("Fanta Orange", 1.25), "C1", 10);
        addInventoryItem(new Drink("Fanta Grape", 1.25), "B2", 0);
        addInventoryItem(new Drink("Fanta Strawberry", 1.25), "B3", 10);
        addInventoryItem(new Drink("Mug Root Beer", 1.25), "B4", 10);
        addInventoryItem(new Drink("Mug Cream Soda", 1.00), "B5", 10);
        addInventoryItem(new Drink("Sprite", 1.25), "B6", 10);
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

    public class InventoryItem {
        private final Product product;
        private String location;
        private int quantity;
        
        public InventoryItem(Product product, String location, int quantity){
           this.product = product;
           this.location = location;
           this.quantity = quantity;
        }
       
        public void addOneItemToStock() {
            this.quantity += 1;
        }
        
        public void getOneItemFromStock() {
            this.quantity -= 1;
        }
         public Product getProduct() {
             return this.product;
         }

        public String getLocation() {
            return this.location;
        }

        public String getName() {
            return this.product.getName();
        }
        
        public int getPrice() {
            return this.product.getPrice();
        }
        
        public int getQuantity() {
            return this.quantity;
        }
        
        public String getInventoryItemType() {
            return product.getClass().getSimpleName();
        }
    }
}
