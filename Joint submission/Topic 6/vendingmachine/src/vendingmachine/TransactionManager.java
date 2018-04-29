//CST-135 group assignment for Topic 6, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: AnimationController.java
*    Summary: Class to manage transactions
*    Author: Chad Galloway
*    Date Created: April 24th, 2018
*    Last Update: April 24th, 2018
**/

package vendingmachine;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TransactionManager {

    private Dispenser dispenser = null;
    private final StringProperty productsCostPropertyString = new SimpleStringProperty("$0.00");
    private final StringProperty moneyInsertedPropertyString = new SimpleStringProperty("$0.00");
    private int productsCost = 0;
    private int moneyInserted = 0;
    private final Text txtReceiptCost = new Text("$0.00");
    private final Text txtReceiptFunds = new Text("$0.00");

    public TransactionManager( Dispenser dispenser ) {
        this.dispenser = dispenser;
        txtReceiptCost.textProperty().bind(this.productCostProperty());
        txtReceiptFunds.textProperty().bind(this.moneyInsertedProperty());
        txtReceiptFunds.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtReceiptFunds.setFill(Paint.valueOf("Black"));
        txtReceiptFunds.setStroke(Paint.valueOf("Green"));
        txtReceiptCost.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtReceiptCost.setFill(Paint.valueOf("Black"));
        txtReceiptCost.setStroke(Paint.valueOf("Red"));

    }
    public final int getProductsCost() {
        return productsCost;
    }
    public final void setProductsCost(int i) {
        productsCost = i;
        productsCostPropertyString.setValue(String.format("$" + productsCost / 100 + ".%02d", productsCost % 100));
    }
    public final void addProductsCost(int i) {
        productsCost += i;
        productsCostPropertyString.setValue(String.format("$" + productsCost / 100 + ".%02d", productsCost % 100));
    }
    public final void removeProductsCost(int i) {
        productsCost -= i;
        productsCostPropertyString.setValue(String.format("$" + productsCost / 100 + ".%02d", productsCost % 100));
    }
    public final StringProperty productCostProperty() {
        return productsCostPropertyString;
    }
    
    
    public final int getMoneyInserted() {
        return moneyInserted;
    }
    public void setMoneyInserted(int i) {
        moneyInserted = i;
        moneyInsertedPropertyString.setValue(String.format("$" + moneyInserted / 100 + ".%02d", moneyInserted % 100));
    }    
    void addMoneyInserted(int i) {
        moneyInserted += i;
        moneyInsertedPropertyString.setValue(String.format("$" + moneyInserted / 100 + ".%02d", moneyInserted % 100));
    }
    public final StringProperty moneyInsertedProperty() {
        return moneyInsertedPropertyString;
    }
    
    public void completeTransaction (Global_Inventory_Management iM) {
        final Stage receiptStage = new Stage();
        receiptStage.initModality(Modality.APPLICATION_MODAL);
        receiptStage.setAlwaysOnTop(true);

        VBox receiptVBox = new VBox(5);
        receiptVBox.setPadding(new Insets(10));

        if (iM.getItemsSelectedForPurchase().isEmpty()) {
            receiptVBox.getChildren().add(new Text("Your have not selected anything to buy."));
        }

        else if ( getMoneyInserted() < getProductsCost() ) {
            receiptVBox.getChildren().add(new Text("Insufficient Funds"));
            receiptVBox.getChildren().add(new Text("Please insert cash before continuing"));
        }

        else {
            for (Global_Inventory_Management.InventoryItem i : iM.getItemsSelectedForPurchase()) {
                Button btnReceiptItem = new Button(i.getProduct().toString());
                receiptVBox.getChildren().add(btnReceiptItem); 
                btnReceiptItem.prefWidthProperty().bind(receiptVBox.widthProperty());
            }
            iM.completePurchase();
            receiptVBox.getChildren().add(new Text("Total: "));
            receiptVBox.getChildren().add(txtReceiptCost);
            setMoneyInserted(getMoneyInserted() - getProductsCost());
            receiptVBox.getChildren().add(new Text("Thank you for shopping with us!"));
            if (getMoneyInserted() != 0) {
                   receiptVBox.getChildren().add(new Text("Change dispensed:"));
                receiptVBox.getChildren().add(txtReceiptFunds);
            }
            dispenser.nextCustomerReset();
        }

        Button btnSeperator = new Button();
        btnSeperator.setVisible(false);
        receiptVBox.getChildren().add(btnSeperator);

        Button btnClose = new Button("Close");
        btnClose.prefWidthProperty().bind(receiptVBox.widthProperty());
        btnClose.setOnAction((event) -> {
            receiptStage.close();

        });
        receiptVBox.getChildren().add(btnClose);

        Scene receiptScene = new Scene(receiptVBox);
        receiptStage.setScene(receiptScene);
        receiptStage.show();
            
    }
    public void displayCart (Global_Inventory_Management iM) {
        final Stage cartStage = new Stage();
        cartStage.initModality(Modality.APPLICATION_MODAL);
        VBox cartVBox = new VBox(5);
        cartVBox.setPadding(new Insets(10));
        if (iM.getItemsSelectedForPurchase().isEmpty()) {
                cartVBox.getChildren().add(new Text("Your cart is empty"));
        }
        else {
                // Added functionallity for dynamically added and removed buttons.
                cartVBox.getChildren().add(new Text("Click on an item to remove it"));
                for (Global_Inventory_Management.InventoryItem i : iM.getItemsSelectedForPurchase()) {
                    Button btnCartItem = new Button(i.getProduct().toString());
                    btnCartItem.prefWidthProperty().bind(cartVBox.widthProperty());
                    btnCartItem.setContentDisplay(ContentDisplay.TOP);                                     
                    cartVBox.getChildren().add(btnCartItem);
                    btnCartItem.setOnAction((event) -> {
                        cartVBox.getChildren().remove(btnCartItem);
                        iM.removeItemFromProductsSelectedForPurchase(i);
                        removeProductsCost(i.getProduct().getPrice());
                        dispenser.populateItemGrid();
                        cartStage.hide();
                        displayCart(iM);
                    });
                }
        Button btnSeperator = new Button();
        btnSeperator.setVisible(false);
        cartVBox.getChildren().add(btnSeperator);
        
        Button btnClose = new Button("Close");
        btnClose.prefWidthProperty().bind(cartVBox.widthProperty());
        btnClose.setOnAction((event) -> {
            cartStage.close();
        });
        cartVBox.getChildren().add(btnClose);
        
        
        Scene cartScene = new Scene(cartVBox);
        cartStage.setScene(cartScene);
        cartStage.show();        

        }
    }
}
