
package screensframework;

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
public class Screen15Controller implements Initializable, ControlledScreen {
    ScreensController myController;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField course;
    @FXML
    private JFXTextField search;
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
            DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT firstname,lastname FROM lectures");
            while(DBConnect.res.next()){
                 selectlecture.getItems().add(DBConnect.res.getString("firstname")+" "+DBConnect.res.getString("lastname"));
                //res.getString("CourseName")
            }
        } catch (Exception e) {
        }
        
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
    private void cancelButton(MouseEvent event) {
    }

    @FXML
    private void editButton(MouseEvent event) {
    }

    @FXML
    private void addUserButton(MouseEvent event) {
        DBConnect connection = new DBConnect();
        String FirstName = firstname.getText();
        String LastName = lastname.getText();
        String UserName = username.getText();
        String PassWord = password.getText();
        String Course = course.getText();
        String Lecture = selectlecture.getValue();
        
        if(!firstname.getText().equals("") && !lastname.getText().equals("") && !username.getText().equals("") && !password.getText().equals("") && !course.getText().equals("") && !selectlecture.getValue().equals("")){
            try {
                String query = ("INSERT INTO students(firstname,lastname,username,course,lecture,password) values('"+FirstName+"','"+LastName+"','"+UserName+"','"+Course+"','"+Lecture+"','"+PassWord+"')");
                connection.st.executeUpdate(query);
                System.out.println("Update succussful");
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }
    }

    @FXML
    private void backButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen3ID);
    }

    @FXML
    private void finishButton(MouseEvent event) {
        myController.setScreen(ScreensFramework.screen3ID);
    }

    @FXML
    private void updateButton(MouseEvent event) {
        DBConnect connection = new DBConnect();
        String FirstName = firstname.getText();
        String LastName = lastname.getText();
        String UserName = username.getText();
        String PassWord = password.getText();
        String Course = course.getText();
        String Lecture = selectlecture.getValue();
        
        if(!firstname.getText().equals("") && !lastname.getText().equals("") && !username.getText().equals("") && !password.getText().equals("") && !course.getText().equals("") && !selectlecture.getValue().equals("")){
            try {
                String query = ("INSERT INTO students(firstname,lastname,username,course,lecture,password) values('"+FirstName+"','"+LastName+"','"+UserName+"','"+Course+"','"+Lecture+"','"+PassWord+"')");
                connection.st.executeUpdate(query);
                System.out.println("Update succussful");
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }
    }
    
}
