/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen12Controller implements Initializable, ControlledScreen {
    ScreensController myController;
    @FXML
    private ChoiceBox<String> selectCourse;
    @FXML
    private JFXTextArea questionString;
    @FXML
    private JFXTextField option1;
    @FXML
    private ChoiceBox<String> chooseCorrect;
    @FXML
    private JFXTextField option2;
    @FXML
    private JFXTextField option3;
    @FXML
    private JFXTextField option4;
    DBConnect connect= new DBConnect();
    
    
    @FXML
    private ChoiceBox<?> viewselectCourse;
    @FXML
    private JFXTextArea viewquestionString;
    @FXML
    private JFXTextField viewoption1;
    @FXML
    private ChoiceBox<?> viewchooseCorrect;
    @FXML
    private JFXTextField viewoption2;
    @FXML
    private JFXTextField viewoption3;
    @FXML
    private JFXTextField viewoption4;

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
    private void cancelButton(MouseEvent event) {
    }

    @FXML
    private void editButton(MouseEvent event) {
    }

    @FXML
    private void addUserButton(MouseEvent event) {
    }

    @FXML
    private void backButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen2ID);
    }

    @FXML
    private void finishButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen2ID);
    }
}
