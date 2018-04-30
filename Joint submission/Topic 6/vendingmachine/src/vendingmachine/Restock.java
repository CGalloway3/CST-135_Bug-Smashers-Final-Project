package vendingmachine;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Restock extends Global_Inventory_Management{
	
    public ArrayList<InventoryItem> lowLocal = new ArrayList<>();
    public ArrayList<InventoryItem> lowRemote = new ArrayList<>();
    public ArrayList<InventoryItem> alphLocal = new ArrayList<>();
    public ArrayList<InventoryItem> alphRemote = new ArrayList<>();
    public ArrayList<InventoryItem> numLocal = new ArrayList<>();
    public ArrayList<InventoryItem> numRemote = new ArrayList<>();

    public Restock() {

    }

    public void getLowLocal() {
        for (int i = 0; i < getLocalInventoryList().size(); i++ ) {
            if (getLocalInventoryList().get(i).getQuantity() <= 3) {
                lowLocal.add(getLocalInventoryList().get(i));
                System.out.println("vendingmachine.Restock.getLowLocal() Adding: " + getLocalInventoryList().get(i));
            }
        }

        final Stage restockStage = new Stage();
        restockStage.initModality(Modality.APPLICATION_MODAL);
        restockStage.setAlwaysOnTop(true); 

        TableView<Global_Inventory_Management.InventoryItem> restockTable = new TableView<>(FXCollections.observableArrayList(lowLocal));

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Global_Inventory_Management.InventoryItem, String> itemLocationColumn = new TableColumn<>("Location");
        itemLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemQuantityColumn = new TableColumn<>("Quantity");
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTable.getColumns().addAll(itemNameColumn, itemLocationColumn, itemQuantityColumn);
        restockTable.setItems(FXCollections.observableArrayList(lowLocal));

        Scene restockScene = new Scene(restockTable);
        restockStage.setScene(restockScene);
        restockStage.show();
    }

    public void getLowRemote() {
        for (int i = 0; i < getRemoteInventoryList().size(); i++ ) {
            if (getRemoteInventoryList().get(i).getQuantity() <= 3) {
                lowRemote.add(getRemoteInventoryList().get(i));
            }
        }
        final Stage restockStage = new Stage();
        restockStage.initModality(Modality.APPLICATION_MODAL);
        restockStage.setAlwaysOnTop(true); 

        TableView<Global_Inventory_Management.InventoryItem> restockTable = new TableView<>(FXCollections.observableArrayList(lowLocal));

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemQuantityColumn = new TableColumn<>("Quantity");
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTable.getColumns().addAll(itemNameColumn, itemQuantityColumn);
        restockTable.setItems(FXCollections.observableArrayList(lowLocal));

        Scene restockScene = new Scene(restockTable);
        restockStage.setScene(restockScene);
        restockStage.show();

    }
    
    public void generatePurchaseOrder() {
        
    }
	
}
