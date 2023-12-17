
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
 * @author Liau Libetoe
 */
public class Screen2Controller implements Initializable , ControlledScreen {

    ScreensController myController;
    @FXML
    private Pane adminUser;
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
/*
    private void goToScreen1(ActionEvent event){
       myController.setScreen(ScreensFramework.screen1ID);
    }
    
    private void goToScreen3(ActionEvent event){
       myController.setScreen(ScreensFramework.screen3ID);
    }*/

    @FXML
    private void gotoAdminUsers(MouseEvent event) {
        adminUser.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
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
    private void gotoAdminUsersExited(MouseEvent event) {
        adminUser.setStyle("-fx-background-color: white; -fx-background-radius: 6px;-fx-border-color:#2A5058;");
    }

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
    private void AdminUsers(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen9ID);
    }

    @FXML
    private void results(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen13ID);
    }

    private void Students(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen10ID);
    }

    @FXML
    private void examinations(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen12ID);
    }

    @FXML
    private void coursesButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen11ID);
        
    }

    @FXML
    private void StudentButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen10ID);
    }


    


}
