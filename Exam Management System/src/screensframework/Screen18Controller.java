/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen18Controller implements Initializable,ControlledScreen {
    ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void backButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen3ID);
    }

    @FXML
    private void finishButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen3ID);
    }
    
}
