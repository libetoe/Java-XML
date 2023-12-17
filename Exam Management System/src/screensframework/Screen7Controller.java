//Students Page
package screensframework;

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
public class Screen7Controller implements Initializable,ControlledScreen {
     ScreensController myController;
    @FXML
    private ChoiceBox<String> selectlecture;
    @FXML
    private TableColumn<Students, Integer> studentID;
    @FXML
    private TableView<Students> studentTable;
    @FXML
    private TableColumn<Students, String> firstName;
    @FXML
    private TableColumn<Students, String> lastName;
    @FXML
    private TableColumn<Students, String> userName;
    @FXML
    private TableColumn<Students, String> Course;
    @FXML
    private TableColumn<Students, String> Lecture;
    @FXML
    private TableColumn<Students, String> passWord;
    
    final ObservableList<Students> objlist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
          DBConnect connect= new DBConnect(); 
          DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM students");
          
          while (DBConnect.res.next()) {                  
                  objlist.add(new Students(DBConnect.res.getInt("studentId"), DBConnect.res.getString("firstname"), DBConnect.res.getString("lastname"), DBConnect.res.getString("username"), DBConnect.res.getString("course"), DBConnect.res.getString("password"),DBConnect.res.getString("lecture")));
                }
          studentID.setCellValueFactory(new PropertyValueFactory<Students,Integer>("studentid"));
          firstName.setCellValueFactory(new PropertyValueFactory<Students,String>("firstname"));
          lastName.setCellValueFactory(new PropertyValueFactory<Students,String>("lastname"));
          userName.setCellValueFactory(new PropertyValueFactory<Students,String>("username"));
          Course.setCellValueFactory(new PropertyValueFactory<Students,String>("course"));
          Lecture.setCellValueFactory(new PropertyValueFactory<Students,String>("lecture"));
          passWord.setCellValueFactory(new PropertyValueFactory<Students,String>("password"));
          studentTable.setItems(objlist);
          
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
