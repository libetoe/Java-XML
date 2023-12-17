/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen11Controller implements Initializable, ControlledScreen {
    ScreensController myController;
    //******************Declaration of Textfields************************
    @FXML
    private ChoiceBox<Integer> Nofquestions; 
    @FXML
    private ChoiceBox<Integer> marksPerQxns;

    @FXML
    private ChoiceBox<Double> examDuration;
    @FXML
    private JFXButton addCourse;
    @FXML
    private JFXTextField courseName;
    @FXML
    private JFXTextField courseID;
    //*********** End of textfields declaratio**************************
    
    //****************Table view variables******************************
    @FXML
    private TableColumn<Courses, Integer> CourseID;
    @FXML
    private TableColumn<Courses, String> CourseName;
    @FXML
    private TableColumn<Courses, Integer> NumberOfQuestions;
    @FXML
    private TableColumn<Courses, Integer> MarksPerQuestions;
    @FXML
    private TableColumn<Courses, Double> ExamDuration;
    @FXML
    private TableView<Courses> data;
    //****************End of Table view variables******************************
    final ObservableList<Courses> objlist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Nofquestions.setValue(20);
          Nofquestions.getItems().addAll(10,20,30,40,50,100);
          examDuration.setValue(0.30);
          examDuration.getItems().addAll(0.30,1.00,1.15,1.20,1.30,1.40,2.00,2.10,2.20,2.30,2.40,3.00);
          marksPerQxns.setValue(1);
          marksPerQxns.getItems().addAll(1,2,3);        
        try {
            
            DBConnect connect= new DBConnect();
            DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM courses");
              while (DBConnect.res.next()) {                  
                  objlist.add(new Courses(DBConnect.res.getInt("CourseId"), DBConnect.res.getString("CourseName"), DBConnect.res.getInt("NoOfQuestions"), DBConnect.res.getInt("MarksPerQuestion"),DBConnect.res.getDouble("ExamDuration")));
                }
             CourseID.setCellValueFactory(new PropertyValueFactory<Courses,Integer>("Id"));
             CourseName.setCellValueFactory(new PropertyValueFactory<Courses,String>("course"));
             NumberOfQuestions.setCellValueFactory(new PropertyValueFactory<Courses,Integer>("questionsNumber"));
             MarksPerQuestions.setCellValueFactory(new PropertyValueFactory<Courses,Integer>("marks"));
             ExamDuration.setCellValueFactory(new PropertyValueFactory<Courses,Double>("duration"));

             data.setItems(objlist);
        } catch (Exception e) {
        }
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
        DBConnect connection = new DBConnect();
        String courseName = this.courseName.getText();
        int courseid = Integer.valueOf(this.courseID.getText());
        int noOfQxns = Nofquestions.getValue();
        int marksperpxns = this.marksPerQxns.getValue();
        double examduration  = this.examDuration.getValue();
        data.setItems(objlist);
        try {
            if (!this.courseName.getText().equals("") && !this.courseID.getText().equals("")) {
                String query = ("INSERT INTO courses(CourseId,CourseName,NoOfQuestions,MarksPerQuestion,ExamDuration) values('"+courseid+"','"+courseName+"','"+noOfQxns+"','"+marksperpxns+"','"+examduration+"')");
                connection.st.executeUpdate(query);
                System.out.println("UPDate succussful");
        }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
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
