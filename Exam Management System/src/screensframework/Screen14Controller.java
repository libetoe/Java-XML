/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Screen14Controller implements Initializable,ControlledScreen {
    ScreensController myController;
     @FXML
    private TableColumn<Lecture, Integer> lectureID;
    @FXML
    private TableColumn<Lecture, String> firstName;
    @FXML
    private TableColumn<Lecture, String> lastName;
    @FXML
    private TableColumn<Lecture, String> userName;
    @FXML
    private TableColumn<Lecture, String> Course;
    @FXML
    private TableColumn<Lecture, String> passWord;
    @FXML
    private TableView<Lecture> lectureTable;
    
    final ObservableList<Lecture> objlist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
          DBConnect connect= new DBConnect(); 
          DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM lectures");
          
          while (DBConnect.res.next()) {                  
                  objlist.add(new Lecture(DBConnect.res.getInt("lectureId"), DBConnect.res.getString("firstname"), DBConnect.res.getString("lastname"), DBConnect.res.getString("username"), DBConnect.res.getString("course"), DBConnect.res.getString("password")));
          }
          lectureID.setCellValueFactory(new PropertyValueFactory<Lecture,Integer>("lectureid"));
          firstName.setCellValueFactory(new PropertyValueFactory<Lecture,String>("firstname"));
          lastName.setCellValueFactory(new PropertyValueFactory<Lecture,String>("lastname"));
          userName.setCellValueFactory(new PropertyValueFactory<Lecture,String>("username"));
          Course.setCellValueFactory(new PropertyValueFactory<Lecture,String>("course"));
          passWord.setCellValueFactory(new PropertyValueFactory<Lecture,String>("password"));
          lectureTable.setItems(objlist);
          
        } catch (Exception e) {
        }
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
