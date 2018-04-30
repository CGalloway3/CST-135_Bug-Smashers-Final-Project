package vendingmachine;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Restock extends Global_Inventory_Management{
	
    private ArrayList<InventoryItem> lowLocal = new ArrayList<>();
    private ArrayList<InventoryItem> lowRemote = new ArrayList<>();

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

        TableView<Global_Inventory_Management.InventoryItem> restockTableLocal = new TableView<>(FXCollections.observableArrayList(lowLocal));

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemNameColumnLocal = new TableColumn<>("Product Name");
        itemNameColumnLocal.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Global_Inventory_Management.InventoryItem, String> itemLocationColumnLocal = new TableColumn<>("Location");
        itemLocationColumnLocal.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemQuantityColumnLocal = new TableColumn<>("Quantity");
        itemQuantityColumnLocal.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTableLocal.getColumns().addAll(itemNameColumnLocal, itemLocationColumnLocal, itemQuantityColumnLocal);
        restockTableLocal.setItems(FXCollections.observableArrayList(lowLocal));

        Scene restockSceneLocal = new Scene(restockTableLocal);
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
        Button btnRemoteRestock = new Button("Click to order products to fill");
        VBox remoteRestock = new VBox(15);
        remoteRestock.setAlignment(Pos.CENTER);
        remoteRestock.setPadding(new Insets(10));

        TableView<Global_Inventory_Management.InventoryItem> restockTableRemote = new TableView<>(FXCollections.observableArrayList(lowRemote));

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemNameColumnRemote = new TableColumn<>("Product Name");
        itemNameColumnRemote.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Global_Inventory_Management.InventoryItem, String> itemLocationColumnRemote = new TableColumn<>("Location");
        itemLocationColumnRemote.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Global_Inventory_Management.InventoryItem, String> itemQuantityColumnRemote = new TableColumn<>("Quantity");
        itemQuantityColumnRemote.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTableRemote.getColumns().addAll(itemNameColumnRemote, itemLocationColumnRemote, itemQuantityColumnRemote);
        restockTableRemote.setItems(FXCollections.observableArrayList(lowRemote));
        
        remoteRestock.getChildren().addAll(restockTableRemote, btnRemoteRestock);
        Scene restockSceneRemote = new Scene(remoteRestock, 309, 500);
        restockStage.setScene(restockSceneRemote);
        restockStage.show();
        
        btnRemoteRestock.setOnAction((ActionEvent event)-> {
        	generatePurchaseOrder();
        });
        
    }
    
    
    
    public static void generatePurchaseOrder() {
        
    }
	
}
