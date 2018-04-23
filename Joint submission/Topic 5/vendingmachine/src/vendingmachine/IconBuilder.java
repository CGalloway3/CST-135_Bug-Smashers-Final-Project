/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author Office Computer
 */
public class IconBuilder {
    public static StackPane buildButtonIcon(InventoryManager.InventoryItem i) {
        StackPane imageStack = new StackPane();
        BorderPane imageBorder = new BorderPane();
        
        imageStack.getChildren().add(new ImageView(i.getImage()));
        if ( i.getQuantity() < 1 ) {
            try {
                Image img = new Image(new FileInputStream("/images/OutOfStock.png"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IconBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Text nameText = new Text(i.getName());
        BorderPane.setAlignment(nameText, Pos.TOP_CENTER);
        
        Text priceText = new Text(String.format("$" + i.getPrice() / 100 + ".%02d", i.getPrice() % 100));
        BorderPane.setAlignment(priceText, Pos.BOTTOM_CENTER);
        
        imageBorder.setTop(nameText);
        imageBorder.setBottom(priceText);
        imageStack.getChildren().add(imageBorder);
        return imageStack; 
    }
}
