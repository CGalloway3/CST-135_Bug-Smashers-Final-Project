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
import java.util.Collections;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vendingmachine.products.Candy;
import vendingmachine.products.Chips;
import vendingmachine.products.Drink;
import vendingmachine.products.Gum;
import vendingmachine.products.Product;

public class Global_Inventory_Management {

    // Private array lists for storing inventory items and items selected by the user for purchase.
    private final ArrayList<InventoryItem> localInventoryList = new ArrayList<>();
    private final ArrayList<InventoryItem> remoteInventoryList = new ArrayList<>();
    private int drinkItemSlot = -1;
    private int candyItemSlot = -1;
    private int chipsItemSlot = -1;
    private int gumItemSlot = -1;

    // Public default constructor that reads in the inventory file
    public Global_Inventory_Management(){
        // Read in inventory list from file.
        loadInventoryList(); // Proposed inventory file loading method
    }

    // Add an item to local inventory
    public void addLocalInventoryItem(Product product, String location, int quantity){
        localInventoryList.add(new InventoryItem(product, location, quantity));
    }
    
    // Add an item to remote inventory
    public void addRemoteInventoryItem(Product product, String location, int quantity){
        remoteInventoryList.add(new InventoryItem(product, location, quantity));
    }

    // Returns the array list of items in the local dispensers inventory.
    public ArrayList<InventoryItem> getLocalInventoryList() {
        return this.localInventoryList;
    }
    
    public ArrayList<InventoryItem> getRemoteInventoryList(){
    	return this.remoteInventoryList;
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
        Scanner remoteInventoryFileScanner = new Scanner(getClass().getResourceAsStream("files/product lists/Clean Coders Product List.csv"));
        while (remoteInventoryFileScanner.hasNextLine()) {
            String scannedLine = remoteInventoryFileScanner.nextLine();
            String[] scannedLineArray = scannedLine.split(",");
            switch ( scannedLineArray[1] ) {
                case "Drink":
                    addRemoteInventoryItem(new Drink(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Not in local machine", Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Candy":
                    addRemoteInventoryItem(new Candy(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Not in local machine", Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Chips":
                    addRemoteInventoryItem(new Chips(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Not in local machine", Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Gum":
                    addRemoteInventoryItem(new Gum(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Not in local machine", Integer.parseInt(scannedLineArray[2]));
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported file type.");
            }
        }
    }
    
    public void sortAlphaLocal() {
    	sortAlpha(getLocalInventoryList());
    }
    
    public void sortAlphaRemote() {
    	sortAlpha(getRemoteInventoryList());
    }
    
    private static void sortAlpha(ArrayList<InventoryItem> a) {
        Collections.sort(a);
        
        final Stage alphaStage = new Stage();
        alphaStage.initModality(Modality.APPLICATION_MODAL);
        alphaStage.setAlwaysOnTop(true); 

        TableView<InventoryItem> alphaTable = new TableView<>(FXCollections.observableArrayList(a));

        TableColumn<InventoryItem, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryItem, String> itemLocationColumn = new TableColumn<>("Location");
        itemLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<InventoryItem, String> itemQuantityColumn = new TableColumn<>("Quantity");
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        alphaTable.getColumns().addAll(itemNameColumn, itemLocationColumn, itemQuantityColumn);
        alphaTable.setItems(FXCollections.observableArrayList(a));

        Scene alphaScene = new Scene(alphaTable);
        alphaStage.setScene(alphaScene);
        alphaStage.show();
        
    }

    public void sortNumLocal() {
    	sortNum(getLocalInventoryList());
    }
    
    public void sortNumRemote() {
    	sortNum(getRemoteInventoryList());
    }
    
    private static void sortNum(ArrayList<InventoryItem> a) {
        sort(a, 0, a.size() - 1, 0);
        final Stage numStage = new Stage();
        numStage.initModality(Modality.APPLICATION_MODAL);
        numStage.setAlwaysOnTop(true); 

        TableView<InventoryItem> numTable = new TableView<>(FXCollections.observableArrayList(a));

        TableColumn<InventoryItem, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryItem, String> itemLocationColumn = new TableColumn<>("Location");
        itemLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<InventoryItem, String> itemQuantityColumn = new TableColumn<>("Quantity");
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        numTable.getColumns().addAll(itemNameColumn, itemLocationColumn, itemQuantityColumn);
        numTable.setItems(FXCollections.observableArrayList(a));

        Scene numScene = new Scene(numTable);
        numStage.setScene(numScene);
        numStage.show();
    }

    private static void sort(ArrayList<InventoryItem> a, int low, int high, int d) {
        if (high <= low) return;
        int lt = low, gt = high;
        int v = a.get(low).getQuantity();
        int i = low + 1;
        while (i <= gt)
        {
            int t = a.get(i).getQuantity();
            if (t < v) exchange(a, lt++, i++);
            else if (t > v) exchange(a, i, gt--);
            else
                i++;
        }

        // Recursive call
        sort(a, low, lt-1, d);
        if(v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, high, d);
    }
 
    private static void exchange(ArrayList<InventoryItem> a, int i, int i1) {
        InventoryItem temp = a.get(i);
        a.add(i, a.get(i1));
        a.add(i1, temp);
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
    public class InventoryItem implements Comparable<InventoryItem>{
        private final Product product;
        private final String productName;
        private final double productPrice;
        private String location;
        private int quantity;
        
        // Inventory Item constructor.
        public InventoryItem(Product product, String location, int quantity){
           this.product = product;
           this.productName = product.getName();
           this.productPrice = ( product.getPrice() / 100 );
           this.location = location;
           this.quantity = quantity;
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

		@Override
		public int compareTo(InventoryItem item) {
			if(this.getName() != null && item.getName() != null) {
				return this.getName().compareToIgnoreCase(item.getName());
			}
			return 0;
		}
    }
}
