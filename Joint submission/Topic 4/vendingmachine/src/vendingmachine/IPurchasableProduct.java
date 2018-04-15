/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Office Computer
 */
public interface IPurchasableProduct {
    
    public static final ArrayList<Product> productsSelectedForPurchase = new ArrayList<>();
    
    public void addProductToProductsSelectedForPurchase();
    
    public void removeProductFromProductsForPurchase();
    
    public static void completeTransaction() {            
        
        Stage transactionDialog = new Stage();
        transactionDialog.initModality(Modality.APPLICATION_MODAL);

        AnchorPane transactionPane = new AnchorPane();

        Button btn_close = new Button("Close");
        btn_close.setLayoutX(210);
        btn_close.setLayoutY(188);
        btn_close.setOnAction((event) -> {
            transactionDialog.close();
        });

        transactionPane.getChildren().add(btn_close);
        
        StackPane baseStackPane = new StackPane();        
        baseStackPane.getChildren().addAll(transactionPane );
        Scene detailsDialogScene = new Scene(baseStackPane, 450, 225);

        transactionDialog.setTitle("Player Details");
        transactionDialog.setScene(detailsDialogScene);
        transactionDialog.show();
    }
}  