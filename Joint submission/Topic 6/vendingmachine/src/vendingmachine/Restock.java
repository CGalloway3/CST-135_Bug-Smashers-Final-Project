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
	
    private ArrayList<InventoryManager.InventoryItem> lowLocal = new ArrayList<>();
    private ArrayList<InventoryManager.InventoryItem> lowRemote = new ArrayList<>();

    public Restock() {

    }

    public void getLowLocal() {
        for (int i = 0; i < getLocalInventoryList().size(); i++ ) {
            if (getLocalInventoryList().get(i).getQuantity() <= 3) {
                lowLocal.add(getLocalInventoryList().get(i));
                System.out.println("vendingmachine.Restock.getLowLocal() Adding: " + getLocalInventoryList().get(i).getName());
            }
        }

        final Stage restockStage = new Stage();
        restockStage.initModality(Modality.APPLICATION_MODAL);
        restockStage.setAlwaysOnTop(true); 

        TableView<InventoryManager.InventoryItem> restockTableLocal = new TableView<>(FXCollections.observableArrayList(lowLocal));

        TableColumn<InventoryManager.InventoryItem, String> itemNameColumnLocal = new TableColumn<>("Product Name");
        itemNameColumnLocal.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryManager.InventoryItem, String> itemLocationColumnLocal = new TableColumn<>("Location");
        itemLocationColumnLocal.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumnLocal = new TableColumn<>("Quantity");
        itemQuantityColumnLocal.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTableLocal.getColumns().addAll(itemNameColumnLocal, itemLocationColumnLocal, itemQuantityColumnLocal);
        restockTableLocal.setItems(FXCollections.observableArrayList(lowLocal));

        Scene restockSceneLocal = new Scene(restockTableLocal, 400, 400);
        restockStage.setScene(restockSceneLocal);
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

        TableView<InventoryManager.InventoryItem> restockTableRemote = new TableView<>(FXCollections.observableArrayList(lowRemote));

        TableColumn<InventoryManager.InventoryItem, String> itemNameColumnRemote = new TableColumn<>("Product Name");
        itemNameColumnRemote.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryManager.InventoryItem, String> itemLocationColumnRemote = new TableColumn<>("Location");
        itemLocationColumnRemote.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumnRemote = new TableColumn<>("Quantity");
        itemQuantityColumnRemote.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTableRemote.getColumns().addAll(itemNameColumnRemote, itemLocationColumnRemote, itemQuantityColumnRemote);
        restockTableRemote.setItems(FXCollections.observableArrayList(lowRemote));

        Scene restockSceneRemote = new Scene(restockTableRemote, 400, 400);
        restockStage.setScene(restockSceneRemote);
        restockStage.show();

    }
    
    public void generatePurchaseOrder() {
        
    }
	
}
