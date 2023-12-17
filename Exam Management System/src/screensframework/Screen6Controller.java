//Results Page
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
public class Screen6Controller implements Initializable,ControlledScreen {
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
        myController.setScreen(ScreensFramework.screen4ID);
    }

    @FXML
    private void finishButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen4ID);
    }
    
}
