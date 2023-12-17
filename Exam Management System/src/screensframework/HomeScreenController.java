/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class HomeScreenController implements Initializable, ControlledScreen {
    ScreensController myController;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fade = new FadeTransition(Duration.millis(500),image);
        fade.setFromValue(1.0);
        fade.setToValue(0);
        
        fade.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myController.setScreen(ScreensFramework.screen1ID);
            }
        });
        fade.play();
                
    }  
   /* 
    private void goToScreen3(ActionEvent event) {
        myController.setScreen(ScreensFramework.screen3ID);
    }

    private void goToScreen2(ActionEvent event) {
        myController.setScreen(ScreensFramework.screen2ID);
    }

    private void goToScreen1(ActionEvent event) {
        myController.setScreen(ScreensFramework.screen1ID);
    }*/
    public static void main(String[] args) {
        System.out.println("The program has reached here:");
    }
    
}
