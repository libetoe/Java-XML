//Courses Page
package screensframework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen5Controller implements Initializable, ControlledScreen {
     ScreensController myController;
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
     /* Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
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
    private void backButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen4ID);
    }

    @FXML
    private void finishButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen4ID);
    }
    
}
