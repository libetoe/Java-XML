  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen9Controller implements Initializable, ControlledScreen {
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
        //loadAdminUsers();
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
    /*
    public void loadAdminUsers(String sql){
        JFXTreeTableColumn<AdminUsers,String> userId = new JFXTreeTableColumn<>("User Id"); 
        userId.setPrefWidth(100);
        userId.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().userId;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> firstname = new JFXTreeTableColumn<>("First Name"); 
        firstname.setPrefWidth(100);
        firstname.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().firstname;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> lastname = new JFXTreeTableColumn<>("Last Name"); 
        lastname.setPrefWidth(100);
        lastname.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().lastname;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> email = new JFXTreeTableColumn<>("Email"); 
        email.setPrefWidth(100);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().email;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> course = new JFXTreeTableColumn<>("Course"); 
        course.setPrefWidth(100);
        course.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().course;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> username = new JFXTreeTableColumn<>("User Name"); 
        username.setPrefWidth(100);
        username.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().username;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> usertype = new JFXTreeTableColumn<>("User Type"); 
        usertype.setPrefWidth(100);
        usertype.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().usertype;
            }
        });
        JFXTreeTableColumn<AdminUsers,String> password = new JFXTreeTableColumn<>("Password"); 
        password.setPrefWidth(100);
        password.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<AdminUsers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AdminUsers, String> param) {
                return param.getValue().getValue().password;
            }
        });
        
        ObservableList<AdminUsers> adminusers = FXCollections.observableArrayList();
        DBConnect connection = new DBConnect();
        try {
            if (!this.firstname.getText().isEmpty() &&
                !this.lastname.getText().isEmpty() &&
                !this.email.getText().isEmpty() &&
                !this.usename.getText().isEmpty() &&
                !this.password.getText().isEmpty() &&
                !this.usertype.getText().isEmpty() &&
                !this.course.getText().isEmpty() 
                    ) {
                
                
                //String query = ("INSERT INTO lecture(userId,firstname,lastname,email,course,username,usertype,password) VALUES('"+this.firstname.getText()+"','"+this.lastname.getText()+"','"+this.email.getText()+"','"+this.course.getText()+"','"+usename.getText()+"','"+this.usertype.getText()+"','"+this.password.getText()+"')");
                //String query = "select * from lecture";
                //ResultSet res = connection.st.executeQuery(query);
                PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
                ResultSet res = ps.executeQuery();
                while(res.next()){
                    adminusers.add(new AdminUsers(res.getInt(1)+"",res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8)));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Screen9Controller.class.getName()).log(Level.SEVERE,null, e);
        }
        final TreeItem<AdminUsers> root = new RecursiveTreeItem<AdminUsers>(adminusers,RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(userId,firstname,lastname,email,course,username,usertype,password);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }
    */
    
    
    
    
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
        
        if(!firstname.getText().equals("") && !lastname.getText().equals("") && !username.getText().equals("") && !password.getText().equals("") && !course.getText().equals("")){
            try {
                String query = ("INSERT INTO lectures(firstname,lastname,username,course,password) values('"+FirstName+"','"+LastName+"','"+UserName+"','"+Course+"','"+PassWord+"')");
                connection.st.executeUpdate(query);
                System.out.println("Update succussful");
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
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

    @FXML
    private void updateButton(MouseEvent event) {
    }
    
}
