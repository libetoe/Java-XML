//Examinations Page
package screensframework;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import static screensframework.Screen20Controller.numberOfquestions;


/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen8Controller implements Initializable,ControlledScreen {
     ScreensController myController;
    @FXML
    private ChoiceBox<String> selectCourse;
    @FXML
    private JFXButton start;
    static String examCourse;
    ExaminationQuestions exam;
    ArrayList<ExaminationQuestions> examQuestions = new ArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
             DBConnect connect= new DBConnect();
             DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT CourseName FROM courses");
             while(DBConnect.res.next()){
                 selectCourse.getItems().add(DBConnect.res.getString("CourseName"));
                 //res.getString("CourseName")
             }
         } catch (SQLException ex) {
             Logger.getLogger(Screen8Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
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

    @FXML
    private void startExamination(ActionEvent event) {
        
        
        System.out.println("The Timer Has Started successfully.....");
//        Screen20Controller.currSeconds = hmsToSeconds(0, 0, 15);
//        hours.setText("00");
//        minutes.setText("00");
//        seconds.setText("00");
//        startCountDown();
         // Screen20Controller starter = new Screen20Controller();
          //starter.currSeconds = starter.hmsToSeconds(01, 00, 15);
          //starter.startCountDown();
        System.out.println("***************************************");
        examCourse = selectCourse.getValue();
        System.out.println("Exam Course: "+ examCourse);
        
        myController.setScreen(ScreensFramework.screen20ID);
      // Screen20Controller myexam = new Screen20Controller();
       // System.out.println(Screen20Controller.position);
       //myexam.getExamQuestions(Screen20Controller.position);
       System.out.println("Looged user: "+ Screen1Controller.loggedStudentName);
       System.out.println("Looged user: "+ Screen1Controller.loggedStudentPass);
    }
    public String selected(){
        return selectCourse.getValue();
    }
    
    
    
}
