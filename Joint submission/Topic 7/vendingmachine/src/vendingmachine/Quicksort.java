//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: Product.java
 *    Summary: Base class for products to be sold in the dispenser.
 *    Author: Richard Boyd
 *    Date: April 28, 2018
 **/
package vendingmachine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Quicksort {
        
    private static ArrayList<InventoryManager.InventoryItem> searchResults = new ArrayList<>();
    
    public static void sortAlpha(ArrayList<InventoryManager.InventoryItem> a) {
        alphaSort(a, 0, a.size() - 1, 0);
    }

    private static void alphaSort(ArrayList<InventoryManager.InventoryItem> a, int low, int high, int d) {
        if (high <= low) return;
        int lt = low, ht = high;
        if ( a.get(low).getName().length() <= d ) return;
        int v = a.get(low).getName().charAt(d);
        int i = low + 1;
        while (i <= ht)
        {
            if ( a.get(i).getName().length() <= d ) return;
            int t = a.get(i).getName().charAt(d);
            if (t < v) exchange(a, lt++, i++);
            else if (t > v) exchange(a, i, ht--);
            else
                i++;
        }

        // Recursive call
        alphaSort(a, low, lt-1, d);
        if(v >= 0) alphaSort(a, lt, ht, d+1);
        alphaSort(a, ht+1, high, d);
    }
 
     public static void sortNum(ArrayList<InventoryManager.InventoryItem> a) {
        numericSort(a, 0, a.size() - 1);
    }

    private static void numericSort(ArrayList<InventoryManager.InventoryItem> a, int low, int high) {
        if (high <= low) return;
        int lt = low, ht = high;
        int v = a.get(low).getQuantity();
        int i = low + 1;
        while (i <= ht)
        {
            int t = a.get(i).getQuantity();
            if (t < v) exchange(a, lt++, i++);
            else if (t > v) exchange(a, i, ht--);
            else
                i++;
        }

        // Recursive call
        numericSort(a, low, lt-1);
        numericSort(a, ht+1, high);    
    }

    private static void exchange(ArrayList<InventoryManager.InventoryItem> a, int i, int i1) {
        InventoryManager.InventoryItem temp = a.get(i);
        a.set(i, a.get(i1));
        a.set(i1, temp);
    }
    
    public static void itemSearch(ArrayList<InventoryManager.InventoryItem> list) {
        final Stage searchStage = new Stage();
        searchStage.initModality(Modality.APPLICATION_MODAL);
        searchStage.setAlwaysOnTop(true);
        
        TextField txtSearch = new TextField();
        Button btnSearch = new Button("Search");
        VBox vboxSearch = new VBox(txtSearch, btnSearch);
        vboxSearch.setAlignment(Pos.CENTER);
        vboxSearch.setSpacing(10);
        
        Scene searchScene = new Scene(vboxSearch, 200, 75);
        searchStage.setScene(searchScene);
        searchStage.show();
        
        btnSearch.setOnAction((event) -> {
            searchForInventoryItem(list, txtSearch.getText());

            TableView<InventoryManager.InventoryItem> searchTable = new TableView<>(FXCollections.observableArrayList(searchResults));

            TableColumn<InventoryManager.InventoryItem, String> itemNameColumnLocal = new TableColumn<>("Product Name");
            itemNameColumnLocal.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<InventoryManager.InventoryItem, String> itemLocationColumnLocal = new TableColumn<>("Location");
            itemLocationColumnLocal.setCellValueFactory(new PropertyValueFactory<>("location"));                  

            TableColumn<InventoryManager.InventoryItem, String> itemQuantityColumnLocal = new TableColumn<>("Quantity");
            itemQuantityColumnLocal.setCellValueFactory(new PropertyValueFactory<>("quantity"));            

            searchTable.getColumns().addAll(itemNameColumnLocal, itemLocationColumnLocal, itemQuantityColumnLocal);
            searchTable.setItems(FXCollections.observableArrayList(searchResults));

            Scene searchResultsScene = new Scene(searchTable, 400, 400);
            searchStage.setScene(searchResultsScene);
        });

    }

    private static ArrayList<InventoryManager.InventoryItem> searchForInventoryItem(ArrayList<InventoryManager.InventoryItem> list, String text){
        
        searchResults.clear();
        
        if ( text.isEmpty() || list.isEmpty() ) return searchResults;
        try (FileWriter writer = new FileWriter("SearchStackTrace.txt")) {
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        search(list, text, 0, list.size() - 1);
        
        return searchResults;
    }

    private static void search(ArrayList<InventoryManager.InventoryItem> list, String text, int low, int high) {
        try (FileWriter writer = new FileWriter("SearchStackTrace.txt", true)) {
        	writer.append("vendingmachine.Quicksort.search(" + list.getClass().getTypeName() + ", " + text + ", " + low + ", " + high + ")");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	
        if ( high <= low ) return;
        if ( list.get(low).getName().equalsIgnoreCase(text) ){
            searchResults.add(list.get(low));
        }
        search(list, text, ++low, high);
    }
}