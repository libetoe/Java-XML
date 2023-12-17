/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen4Controller implements Initializable, ControlledScreen {
    ScreensController myController;

    @FXML
    private Pane course;
    @FXML
    private Pane result;
    @FXML
    private Pane student;
    @FXML
    private Pane examination;
    @FXML
    private Pane logout;

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
    private void gotoCourses(MouseEvent event) {
        course.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoResults(MouseEvent event) {
        result.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoStudents(MouseEvent event) {
        student.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoExaminations(MouseEvent event) {
        examination.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoHomepage(MouseEvent event) {
        logout.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    
    //*********************************EXIT*************************************
    @FXML
    private void gotoResultsExited(MouseEvent event) {
        result.setStyle("-fx-background-color: white; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoStudentsExited(MouseEvent event) {
        student.setStyle("-fx-background-color: white; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoExaminationsExited(MouseEvent event) {
        examination.setStyle("-fx-background-color: white; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoHomepageExited(MouseEvent event) {
        logout.setStyle("-fx-background-color: white; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void gotoCoursesExited(MouseEvent event) {
        course.setStyle("-fx-background-color: white; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

    @FXML
    private void goToScreen1(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen1ID);
    }

    @FXML
    private void courses(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen5ID);
    }

    @FXML
    private void results(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen6ID);
    }

    @FXML
    private void students(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen7ID);
    }

    @FXML
    private void examinations(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen8ID);
    }
    
}
