//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: CustomerDisplay.java
 *    Summary: An animated queue for displaying virtual customers.
 *    Author: Chad Galloway
 *    Date: May 04, 2018
 * Last Update: May 04, 2018
 **/
package vendingmachine;

import javafx.animation.FadeTransition;
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
    private ImageView currentCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CurrentCustomer.png"), 125, 125, true, true));
    private ImageView firstCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 100, 100, true, true));
    private ImageView secondCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 75, 75, true, true));
    private ImageView thirdCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 50, 50, true, true));
    private ImageView fourthCustomer = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 25, 25, true, true));
    private ImageView nextCustomerInLine = new ImageView(new Image(getClass().getResourceAsStream("images/CustomerInLine.png"), 25, 25, true, true));

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
        if ( dispenser.processCustomerQueue.length() < 1 ) firstCustomer.setVisible(false);
        
        secondCustomer.setLayoutX(390);
        secondCustomer.setLayoutY(340);
        if ( dispenser.processCustomerQueue.length() < 2 ) secondCustomer.setVisible(false);
        
        thirdCustomer.setLayoutX(500);
        thirdCustomer.setLayoutY(360);
        if ( dispenser.processCustomerQueue.length() < 3 ) thirdCustomer.setVisible(false);

        fourthCustomer.setLayoutX(600);
        fourthCustomer.setLayoutY(380);
        if ( dispenser.processCustomerQueue.length() < 4 ) fourthCustomer.setVisible(false);
        
        nextCustomerInLine.setLayoutX(600);
        nextCustomerInLine.setLayoutY(380);
        nextCustomerInLine.setOpacity(0);

        queuePane.getChildren().addAll(queueDisplay, vendingMachineImage, currentCustomer, firstCustomer, secondCustomer, thirdCustomer, fourthCustomer, nextCustomerInLine);
        
        
        Scene queueScene = new Scene(queuePane, 700, 500);
        queueStage.setScene(queueScene);
        queueStage.show();

        
    }
    
    public void nextCustomer() {
        if ( dispenser.processCustomerQueue.isEmpty() ) {
            queueDisplay.setText("No customers in the Queue") ;
            return;
        }
        
        

        // Button 4
        TranslateTransition fourthCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), fourthCustomer);
        ScaleTransition fourthCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), fourthCustomer);
        
        fourthCustomerTranslateTransition.setToX(thirdCustomer.getLocalToSceneTransform().getTx() - fourthCustomer.getLocalToSceneTransform().getTx() + 12);       
        fourthCustomerTranslateTransition.setToY(thirdCustomer.getLocalToSceneTransform().getTy() - fourthCustomer.getLocalToSceneTransform().getTy() + 12);
        
        fourthCustomerScaleTransition.setToX(2);
        fourthCustomerScaleTransition.setToY(2);
        
        // button 3
        TranslateTransition thirdCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), thirdCustomer);
        ScaleTransition thirdCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), thirdCustomer);
        
        thirdCustomerTranslateTransition.setToX(secondCustomer.getLocalToSceneTransform().getTx() - thirdCustomer.getLocalToSceneTransform().getTx() + 12);       
        thirdCustomerTranslateTransition.setToY(secondCustomer.getLocalToSceneTransform().getTy() - thirdCustomer.getLocalToSceneTransform().getTy() + 12);
        
        thirdCustomerScaleTransition.setToX(1.5);
        thirdCustomerScaleTransition.setToY(1.5);
        
        // button 2
        TranslateTransition secondCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), secondCustomer);
        ScaleTransition secondCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), secondCustomer);

        secondCustomerTranslateTransition.setToX(firstCustomer.getLocalToSceneTransform().getTx() - secondCustomer.getLocalToSceneTransform().getTx() + 12);       
        secondCustomerTranslateTransition.setToY(firstCustomer.getLocalToSceneTransform().getTy() - secondCustomer.getLocalToSceneTransform().getTy() + 12);
        
        secondCustomerScaleTransition.setToX(1.33);
        secondCustomerScaleTransition.setToY(1.33);
        
        // button 1
        TranslateTransition firstCustomerTranslateTransition = new TranslateTransition(Duration.seconds(1.5), firstCustomer);
        ScaleTransition firstCustomerScaleTransition = new ScaleTransition(Duration.seconds(1.5), firstCustomer);
        
        firstCustomerTranslateTransition.setToX(currentCustomer.getLocalToSceneTransform().getTx() - firstCustomer.getLocalToSceneTransform().getTx() + 12);       
        firstCustomerTranslateTransition.setToY(currentCustomer.getLocalToSceneTransform().getTy() - firstCustomer.getLocalToSceneTransform().getTy() + 12);
        
        firstCustomerScaleTransition.setToX(1.25);
        firstCustomerScaleTransition.setToY(1.25);
        
        FadeTransition nextCustomerFadeTransition = new FadeTransition(Duration.seconds(1.6), nextCustomerInLine);
        
        nextCustomerFadeTransition.setFromValue(0);
        nextCustomerFadeTransition.setToValue(.74);
        
        // Play animations
        nextCustomerFadeTransition.play();

        fourthCustomerScaleTransition.play();
        fourthCustomerTranslateTransition.play();
        
        thirdCustomerScaleTransition.play();
        thirdCustomerTranslateTransition.play();

        secondCustomerScaleTransition.play();
        secondCustomerTranslateTransition.play();

        firstCustomerScaleTransition.play();
        firstCustomerTranslateTransition.play();
        
        fourthCustomerTranslateTransition.setOnFinished((event) -> {
            if ( dispenser.processCustomerQueue.length() < 5 ) fourthCustomer.setVisible(false);
            nextCustomerInLine.setOpacity(0);
            fourthCustomer.setTranslateX(0);
            fourthCustomer.setTranslateY(0);
            fourthCustomer.setScaleX(1);
            fourthCustomer.setScaleY(1);
        });
        
        thirdCustomerTranslateTransition.setOnFinished((event) -> {
            if ( dispenser.processCustomerQueue.length() < 4 ) thirdCustomer.setVisible(false);
            thirdCustomer.setTranslateX(0);
            thirdCustomer.setTranslateY(0);
            thirdCustomer.setScaleX(1);
            thirdCustomer.setScaleY(1);        
        });
        
        secondCustomerTranslateTransition.setOnFinished((event) ->  {
            if ( dispenser.processCustomerQueue.length() < 3 ) secondCustomer.setVisible(false);
            secondCustomer.setTranslateX(0);
            secondCustomer.setTranslateY(0);
            secondCustomer.setScaleX(1);
            secondCustomer.setScaleY(1);        
        });
        
        firstCustomerTranslateTransition.setOnFinished((event) -> {
            if ( dispenser.processCustomerQueue.length() < 2 ) firstCustomer.setVisible(false);
            currentCustomer.setVisible(true);
            firstCustomer.setTranslateX(0);
            firstCustomer.setTranslateY(0);
            firstCustomer.setScaleX(1);
            firstCustomer.setScaleY(1);        
        });
        
        nextCustomerFadeTransition.setOnFinished((event) -> {
            dispenser.processCustomerQueue.processCurrentCustomerInQueue(this);
            if ( dispenser.processCustomerQueue.length() < 5 ) nextCustomerInLine.setVisible(false);

        });
    }
    
    public void customerDone(String s) {
        dispenser.processCustomerQueue.out();
        String newText = queueDisplay.getText() + s;
        queueDisplay.setText(newText) ;
        
        TranslateTransition currentCustomerTranslateTransition = new TranslateTransition(Duration.seconds(2), currentCustomer);
        currentCustomerTranslateTransition.setToX(-250);
        
        currentCustomerTranslateTransition.play();
        
        currentCustomerTranslateTransition.setOnFinished((event) -> {
            currentCustomer.setVisible(false);
            currentCustomer.setTranslateX(0);
            if ( !dispenser.processCustomerQueue.isEmpty() ) {
                nextCustomer();
            }
        });
        
        if ( dispenser.processCustomerQueue.isEmpty() ) {
            newText = queueDisplay.getText() + "Completed Processing Customer Queue!";
            queueDisplay.setText(newText) ;
            
        }
        
    }
}
