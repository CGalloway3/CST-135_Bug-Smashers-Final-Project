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
    private final ArrayList<InventoryManager.InventoryItem> localInventoryList = new ArrayList<>();
    private final ArrayList<InventoryManager.InventoryItem> remoteInventoryList = new ArrayList<>();
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
        localInventoryList.add(new InventoryManager().new InventoryItem(product, location, quantity));
    }
    
    // Add an item to remote inventory
    public void addRemoteInventoryItem(Product product, String location, int quantity){
        remoteInventoryList.add(new InventoryManager(). new InventoryItem(product, location, quantity));
    }

    // Returns the array list of items in the local dispensers inventory.
    public ArrayList<InventoryManager.InventoryItem> getLocalInventoryList() {
        return this.localInventoryList;
    }
    
    public ArrayList<InventoryManager.InventoryItem> getRemoteInventoryList(){
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
                    addLocalInventoryItem(new Drink(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Local machime", Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Candy":
                    addLocalInventoryItem(new Candy(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Local machime", Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Chips":
                    addLocalInventoryItem(new Chips(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Local machime", Integer.parseInt(scannedLineArray[2]));
                    break;
                case "Gum":
                    addLocalInventoryItem(new Gum(scannedLineArray[0], Double.parseDouble(scannedLineArray[3])), "Local machime", Integer.parseInt(scannedLineArray[2]));
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
    
    private static void sortAlpha(ArrayList<InventoryManager.InventoryItem> a) {
        Quicksort.sortAlpha(a);
        
        final Stage alphaStage = new Stage();
        alphaStage.initModality(Modality.APPLICATION_MODAL);
        alphaStage.setAlwaysOnTop(true); 

        TableView<InventoryManager.InventoryItem> alphaTable = new TableView<>(FXCollections.observableArrayList(a));

        TableColumn<InventoryManager.InventoryItem, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryManager.InventoryItem, String> itemLocationColumn = new TableColumn<>("Location");
        itemLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumn = new TableColumn<>("Quantity");
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        alphaTable.getColumns().addAll(itemNameColumn, itemLocationColumn, itemQuantityColumn);
        alphaTable.setItems(FXCollections.observableArrayList(a));

        Scene alphaScene = new Scene(alphaTable, 400, 400);
        alphaStage.setScene(alphaScene);
        alphaStage.show();
        
    }

    public void sortNumLocal() {
    	sortNum(getLocalInventoryList());
    }
    
    public void sortNumRemote() {
    	sortNum(getRemoteInventoryList());
    }
    
   private static void sortNum(ArrayList<InventoryManager.InventoryItem> a) {
        Quicksort.sortNum(a);
        
        final Stage alphaStage = new Stage();
        alphaStage.initModality(Modality.APPLICATION_MODAL);
        alphaStage.setAlwaysOnTop(true); 

        TableView<InventoryManager.InventoryItem> numTable = new TableView<>(FXCollections.observableArrayList(a));

        TableColumn<InventoryManager.InventoryItem, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryManager.InventoryItem, String> itemLocationColumn = new TableColumn<>("Location");
        itemLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumn = new TableColumn<>("Quantity");
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        numTable.getColumns().addAll(itemNameColumn, itemLocationColumn, itemQuantityColumn);
        numTable.setItems(FXCollections.observableArrayList(a));

        Scene alphaScene = new Scene(numTable, 400, 400);
        alphaStage.setScene(alphaScene);
        alphaStage.show();
        
    }
}


  