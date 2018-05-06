//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: CustomerDisplay.java
 *    Summary: An animated queue for displaying virtual customers.
 *    Author: Chad Galloway
 *    Date: May 04, 2018
 * Last Update: May 04, 2018
 **/
package vendingmachine;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerDisplay {
    
    private TextField queueDisplay = new TextField();
    private ImageView vendingMachineImage = new ImageView(new Image(getClass().getResourceAsStream("images/VendingMachine.png"), 150, 150, true, true));
    private ImageView firstCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 100, 100, true, true));
    private ImageView secondCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 75, 75, true, true));
    private ImageView thirdCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 50, 50, true, true));
    private ImageView fourthCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 25, 25, true, true));
    private ImageView currentCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CurrentCustomer.png"), 125, 125, true, true));

    public CustomerDisplay () {
        
    }
    
    public void lineCustomersUp () {
        final Stage queueStage = new Stage();
        queueStage.initModality(Modality.APPLICATION_MODAL);
        queueStage.setAlwaysOnTop(true);
        
        AnchorPane queuePane = new AnchorPane();
        
        queueDisplay.setLayoutX(30);
        queueDisplay.setLayoutY(30);
        
        queueDisplay.setPrefSize(640, 210);
        
        vendingMachineImage.setLayoutX(30);
        vendingMachineImage.setLayoutY(280);
        
        currentCustomer.setLayoutX(150);
        currentCustomer.setLayoutY(305);
        
        firstCustomer.setLayoutX(280);
        firstCustomer.setLayoutY(320);
        
        secondCustomer.setLayoutX(390);
        secondCustomer.setLayoutY(340);
        
        thirdCustomer.setLayoutX(500);
        thirdCustomer.setLayoutY(360);

        fourthCustomer.setLayoutX(600);
        fourthCustomer.setLayoutY(380);

        queuePane.getChildren().addAll(queueDisplay, vendingMachineImage, currentCustomer, firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);
        
        
        Scene queueScene = new Scene(queuePane, 700, 500);
        queueStage.setScene(queueScene);
        queueStage.show();

        
    }
    
    public void nextCustomer() {
        
    }
    
    
}
