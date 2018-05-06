//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: CustomerDisplay.java
 *    Summary: An animated queue for displaying virtual customers.
 *    Author: Chad Galloway
 *    Date: May 04, 2018
 * Last Update: May 04, 2018
 **/
package vendingmachine;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CustomerDisplay {
    
    private TextArea queueDisplay = new TextArea();
    private ImageView vendingMachineImage = new ImageView(new Image(getClass().getResourceAsStream("images/VendingMachine.png"), 150, 150, true, true));
    private ImageView firstCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 100, 100, true, true));
    private ImageView secondCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 75, 75, true, true));
    private ImageView thirdCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 50, 50, true, true));
    private ImageView fourthCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 25, 25, true, true));
    private ImageView currentCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CurrentCustomer.png"), 125, 125, true, true));

    private Dispenser dispenser;
    
    public CustomerDisplay (Dispenser dispenser) {
        this.dispenser = dispenser;
    }
    
    public void lineCustomersUp () {
        final Stage queueStage = new Stage();
        queueStage.initModality(Modality.APPLICATION_MODAL);
        queueStage.setAlwaysOnTop(true);
        
        AnchorPane queuePane = new AnchorPane();
        
        //queueDisplay.
        
        queueDisplay.setLayoutX(30);
        queueDisplay.setLayoutY(30);
        
        queueDisplay.setPrefSize(640, 210);
        
        vendingMachineImage.setLayoutX(30);
        vendingMachineImage.setLayoutY(280);
        
        currentCustomer.setLayoutX(150);
        currentCustomer.setLayoutY(305);
        currentCustomer.setVisible(false);
        
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
        // Button 4
        TranslateTransition fourthCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), fourthCustomer);
        ScaleTransition fourthCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), fourthCustomer);
        
        fourthCustomerTranslateTransition.setToX(thirdCustomer.getLocalToSceneTransform().getTx() - fourthCustomer.getLocalToSceneTransform().getTx());       
        fourthCustomerTranslateTransition.setToY(thirdCustomer.getLocalToSceneTransform().getTy() - fourthCustomer.getLocalToSceneTransform().getTy());
        
        fourthCustomerScaleTransition.setToX(2);
        fourthCustomerScaleTransition.setToY(2);
        
        // button 3
        TranslateTransition thirdCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), thirdCustomer);
        ScaleTransition thirdCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), thirdCustomer);
        
        thirdCustomerTranslateTransition.setToX(secondCustomer.getLocalToSceneTransform().getTx() - thirdCustomer.getLocalToSceneTransform().getTx());       
        thirdCustomerTranslateTransition.setToY(secondCustomer.getLocalToSceneTransform().getTy() - thirdCustomer.getLocalToSceneTransform().getTy());
        
        thirdCustomerScaleTransition.setToX(2);
        thirdCustomerScaleTransition.setToY(2);
        
        // button 2
        TranslateTransition secondCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), secondCustomer);
        ScaleTransition secondCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), secondCustomer);

        secondCustomerTranslateTransition.setToX(firstCustomer.getLocalToSceneTransform().getTx() - secondCustomer.getLocalToSceneTransform().getTx());       
        secondCustomerTranslateTransition.setToY(firstCustomer.getLocalToSceneTransform().getTy() - secondCustomer.getLocalToSceneTransform().getTy());
        
        secondCustomerScaleTransition.setToX(2);
        secondCustomerScaleTransition.setToY(2);
        
        // button 1
        TranslateTransition firstCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), firstCustomer);
        ScaleTransition firstCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), firstCustomer);
        
        firstCustomerTranslateTransition.setToX(currentCustomer.getLocalToSceneTransform().getTx() - firstCustomer.getLocalToSceneTransform().getTx());       
        firstCustomerTranslateTransition.setToY(currentCustomer.getLocalToSceneTransform().getTy() - firstCustomer.getLocalToSceneTransform().getTy());
        
        firstCustomerScaleTransition.setToX(2);
        firstCustomerScaleTransition.setToY(2);
        
        
        fourthCustomerScaleTransition.play();
        fourthCustomerTranslateTransition.play();
        
        thirdCustomerScaleTransition.play();
        thirdCustomerTranslateTransition.play();

        secondCustomerScaleTransition.play();
        secondCustomerTranslateTransition.play();

        firstCustomerScaleTransition.play();
        firstCustomerTranslateTransition.play();
        
        fourthCustomerTranslateTransition.setOnFinished((event) -> {
            fourthCustomer.setTranslateX(0);
            fourthCustomer.setTranslateY(0);
            
        });
        thirdCustomerTranslateTransition.setOnFinished((event) -> {
            thirdCustomer.setTranslateX(0);
            thirdCustomer.setTranslateY(0);
            
        });
        secondCustomerTranslateTransition.setOnFinished((event) -> {
            secondCustomer.setTranslateX(0);
            secondCustomer.setTranslateY(0);
           
        });
        firstCustomerTranslateTransition.setOnFinished((event) -> {
            firstCustomer.setTranslateX(0);
            firstCustomer.setTranslateY(0);
            
        });

    }
    
    public boolean customerDone(String s) {
        dispenser.processCustomerQueue.out();
        String newText = queueDisplay.getText() + s;
        queueDisplay.setText(newText) ;
        return true;
    }
}
