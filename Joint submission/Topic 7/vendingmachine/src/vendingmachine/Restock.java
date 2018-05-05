//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Restock.java
*    Summary: Class to manage purchase orders
*    Author: Richard Boyd
*    Date Created: April 28th, 2018
*    Last Update: May 4th, 2018
**/
package vendingmachine;

import java.io.FileWriter;
import java.io.IOException;
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
        Button btnLocalRestock = new Button("Click to order products to fill");
        VBox localRestock = new VBox(15);
        localRestock.setAlignment(Pos.CENTER);
        localRestock.setPadding(new Insets(10));
        
        TableView<InventoryManager.InventoryItem> restockTableLocal = new TableView<>(FXCollections.observableArrayList(lowLocal));

        TableColumn<InventoryManager.InventoryItem, String> itemNameColumnLocal = new TableColumn<>("Product Name");
        itemNameColumnLocal.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryManager.InventoryItem, String> itemLocationColumnLocal = new TableColumn<>("Location");
        itemLocationColumnLocal.setCellValueFactory(new PropertyValueFactory<>("location"));                  

        TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumnLocal = new TableColumn<>("Quantity");
        itemQuantityColumnLocal.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTableLocal.getColumns().addAll(itemNameColumnLocal, itemLocationColumnLocal, itemQuantityColumnLocal);
        restockTableLocal.setItems(FXCollections.observableArrayList(lowLocal));

        localRestock.getChildren().addAll(restockTableLocal, btnLocalRestock);
        Scene restockSceneLocal = new Scene(localRestock, 350, 500);
        restockStage.setScene(restockSceneLocal);
        restockStage.show();
        
        btnLocalRestock.setOnAction((ActionEvent event)-> {
        	try {
				generatePurchaseOrder(lowLocal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
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

        TableView<InventoryManager.InventoryItem> restockTableRemote = new TableView<>(FXCollections.observableArrayList(lowRemote));

        TableColumn<InventoryManager.InventoryItem, String> itemNameColumnRemote = new TableColumn<>("Product Name");
        itemNameColumnRemote.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<InventoryManager.InventoryItem, String> itemLocationColumnRemote = new TableColumn<>("Location");
        itemLocationColumnRemote.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumnRemote = new TableColumn<>("Quantity");
        itemQuantityColumnRemote.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

        restockTableRemote.getColumns().addAll(itemNameColumnRemote, itemLocationColumnRemote, itemQuantityColumnRemote);
        restockTableRemote.setItems(FXCollections.observableArrayList(lowRemote));
        
        remoteRestock.getChildren().addAll(restockTableRemote, btnRemoteRestock);
        Scene restockSceneRemote = new Scene(remoteRestock, 309, 500);


        restockStage.setScene(restockSceneRemote);
        restockStage.show();
        
        btnRemoteRestock.setOnAction((ActionEvent event)-> {
        	try {
				generatePurchaseOrder(lowRemote);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        
    }
    
    
    
    public void generatePurchaseOrder(ArrayList<InventoryManager.InventoryItem> list) throws IOException {
        FileWriter writer = new FileWriter("Purchase Order.csv");
        try {
        	writer.append("Item Name,Quantity Ordered\n");
        	for (int i=0; i < list.size(); i++) {
        		writer.append(list.get(i).getName() + " , " + Integer.toString(10 - list.get(i).getQuantity()) + "\n");
        	}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
