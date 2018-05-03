//CST-135 group assignment for Topic 6, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: InventoryManager.java
*    Summary: Inventory management of products in and out.
*    Author: Chad Galloway, Richard Boyd
*    Date: April 22th, 2018
*    Last Update: April 29th, 2018
**/

package vendingmachine;

import java.util.ArrayList;
import java.util.Scanner;
import vendingmachine.products.Candy;
import vendingmachine.products.Chips;
import vendingmachine.products.Drink;
import vendingmachine.products.Gum;
import vendingmachine.products.Product;

public class InventoryManager {

    // Private array lists for storing inventory items and items selected by the user for purchase.
    private final ArrayList<InventoryItem> localInventoryList = new ArrayList<>();
    private final ArrayList<InventoryItem> itemsSelectedForPurchase = new ArrayList<>();
    private int drinkItemSlot = -1;
    private int candyItemSlot = -1;
    private int chipsItemSlot = -1;
    private int gumItemSlot = -1;

    // Public default constructor that reads in the inventory file
    public InventoryManager(){
        // Read in inventory list from file.
        loadInventoryList(); // Proposed inventory file loading method
    }

    // Add an item to local inventory
    public void addLocalInventoryItem(Product product, String location, int quantity){
        localInventoryList.add(new InventoryItem(product, location, quantity));
    }
      
    // Returns items in the itemsSelectedForPurchase array list to the localinventoryList.
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

    // Returns the array list of items in the local dispensers inventory.
    public ArrayList<InventoryItem> getLocalInventoryList() {
        return this.localInventoryList;
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
        // saveInventoryList(); // Proposed inventory file saving method.
    }

    // Loads inventory from the file.
    private void loadInventoryList() {
        Scanner localInventoryFileScanner = new Scanner(getClass().getResourceAsStream("files/product lists/Bug Smashers Product List.csv"));
        while (localInventoryFileScanner.hasNextLine()) {
            String scannedLine = localInventoryFileScanner.nextLine();
            String[] scannedLineArray = scannedLine.split(",");
            switch ( scannedLineArray[1] ) {
                case "Drink":
                    addLocalInventoryItem(new Drink(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), setItemsLocation("Drink"), Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Candy":
                    addLocalInventoryItem(new Candy(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), setItemsLocation("Candy"), Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Chips":
                    addLocalInventoryItem(new Chips(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), setItemsLocation("Chips"), Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Gum":
                    addLocalInventoryItem(new Gum(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), setItemsLocation("Gum"), Integer.parseInt(scannedLineArray[2]));
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported file type.");
            }
        }
    }

    private void saveInventoryList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String setItemsLocation(String category) {
        switch ( category ) {
            case "Drink":
                drinkItemSlot++;
                //System.out.println("Drink: " +(String.valueOf((char)(65+drinkItemSlot / 9))) + (drinkItemSlot % 9 + 1));
                return (String.valueOf((char)(65+drinkItemSlot / 9))) + (drinkItemSlot % 9 + 1);
            case "Candy":
                candyItemSlot++;
                //System.out.println("Candy: " + (String.valueOf((char)(65+candyItemSlot / 9))) + (candyItemSlot % 9 + 1));
                return (String.valueOf((char)(65+candyItemSlot / 9))) + (candyItemSlot % 9 + 1);
            case "Chips":
                chipsItemSlot++;
                //System.out.println("Chips: " + (String.valueOf((char)(65+chipsItemSlot / 9))) + (chipsItemSlot % 9 + 1));
                return (String.valueOf((char)(65+chipsItemSlot / 9))) + (chipsItemSlot % 9 + 1);
            case "Gum":
                gumItemSlot++;
                //System.out.println("Gum: " + (String.valueOf((char)(65+gumItemSlot / 9))) + (gumItemSlot % 9 + 1));
                return (String.valueOf((char)(65+gumItemSlot / 9))) + (gumItemSlot % 9 + 1);
            default:
                return "ERROR";
        }
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
