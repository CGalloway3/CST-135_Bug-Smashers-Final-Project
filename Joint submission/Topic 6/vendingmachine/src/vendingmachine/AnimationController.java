//CST-135 group assignment for Topic 6, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: AnimationController.java
*    Summary: Class to control item falling into basket animations
*    Author: Chad Galloway
*    Date Created: April 24th, 2018
*    Last Update: April 24th, 2018
**/

package vendingmachine;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class AnimationController {
    
    public static void animateButtonToCart(Button startButton, Button endButton) {
        
        // Find the Parent of the button we will be animating.
        GridPane animationGrid = (GridPane)startButton.getParent();
        
        // Declare the new button to animating.
        Button animation = new Button();
        
        // Set the properties of the new button animation.
        animation.setPrefSize(startButton.getPrefWidth(), startButton.getPrefHeight());
        animation.setLayoutX(startButton.getLocalToSceneTransform().getTx());
        animation.setGraphic(startButton.getGraphic());
        animation.setOpacity(.8);

        // Derermine the starting location of the animating button from the index of the passed startButton.
        animationGrid.add(animation, (int)(animationGrid.getChildren().indexOf(startButton) % 3), (int)(animationGrid.getChildren().indexOf(startButton) / 3));
        
        // Difine the animations.
        ScaleTransition st = new ScaleTransition(Duration.seconds(1.5), animation);
        st.setToX(.25);
        st.setToY(.25);
        
        TranslateTransition tt = new TranslateTransition(Duration.seconds(2.0), animation);
        tt.setToX(endButton.getLocalToSceneTransform().getTx() - startButton.getLocalToSceneTransform().getTx());
        tt.setToY(endButton.getLocalToSceneTransform().getTy() - startButton.getLocalToSceneTransform().getTy());
        tt.setAutoReverse(false);
        
        // Play animation
        tt.play();
        st.play();
        
        // Remove animation button when animation finishes.
        tt.setOnFinished((e) -> {
            animationGrid.getChildren().remove(animation);
        });
    }
}
