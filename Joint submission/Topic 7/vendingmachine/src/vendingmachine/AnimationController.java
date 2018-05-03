//CST-135 group assignment for Topic 6, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: AnimationController.java
*    Summary: Class to control item falling into basket animations
*    Author: Chad Galloway
*    Date Created: April 24th, 2018
*    Last Update: April 27th, 2018
**/

package vendingmachine;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class AnimationController {
    
    /**
     *
     * @param startButton the button that is to be animated.
     * @param endButton the location that the animation will finish at
     */
    public void animateButtonToCart(Button startButton, Button endButton) {
        
        // Find the Parent of the button we will be animating, label this parent animationGrid.
        GridPane animationGrid = (GridPane)startButton.getParent();
        
        // Declare a new button to be the object doing the animation.
        Button animation = new Button();
        
        // Set the properties of the new button animation.
        animation.setPrefSize(startButton.getPrefWidth(), startButton.getPrefHeight());
        animation.setLayoutX(startButton.getLocalToSceneTransform().getTx());
        animation.setGraphic(startButton.getGraphic());
        animation.setOpacity(.8);

        // Derermine the starting location of the animating button from the index of the passed startButton.
        // Use calculations based on a 3x3 item gridpane.
        animationGrid.add(animation, (int)(animationGrid.getChildren().indexOf(startButton) % 3), (int)(animationGrid.getChildren().indexOf(startButton) / 3));
        
        // Difine the animations.
          //Scale animation to reduce size during travel
        ScaleTransition st = new ScaleTransition(Duration.seconds(1.1), animation);
        st.setToX(.35);
        st.setToY(.35);
        
          // Translate animation to move the animation button
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1.5), animation);
        tt.setToX(endButton.getLocalToSceneTransform().getTx() - startButton.getLocalToSceneTransform().getTx()-5);
        tt.setToY(endButton.getLocalToSceneTransform().getTy() - startButton.getLocalToSceneTransform().getTy()-30);
        tt.setAutoReverse(false);
        
        // Play both animations
        tt.play();
        st.play();
        
        // Remove animation button when animation finishes.
        tt.setOnFinished((e) -> {
            animationGrid.getChildren().remove(animation);
        });
    }
}
