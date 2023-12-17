

package screensframework;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author Libetoe
 */
public class Screen1Controller implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label isValid;
    @FXML
    private JFXRadioButton student;
    @FXML
    private ToggleGroup userType;
    @FXML
    private JFXRadioButton admin;
    @FXML
    private JFXRadioButton lectureRadio;
    static String loggedStudentName;
    static String loggedStudentPass;
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
        String UserName = username.getText();
        String PassWord = password.getText();
        
    }

    @FXML
    private void loginButton(MouseEvent event) {
        DBConnect connection = new DBConnect();
        String UserName = username.getText();
        String PassWord = password.getText();
        loggedStudentName = username.getText();
        loggedStudentPass = password.getText();
        
        try {
            //Student login******************************************
            if(student.isSelected() == true){
               String que = "select password from students where username ='"+UserName+"' ";
               ResultSet resultSet = connection.st.executeQuery(que); 
               if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
                 while (resultSet.next()) {
                            if (resultSet.getString("password").equals(password.getText())) {
                                myController.setScreen(ScreensFramework.screen4ID);
                                username.setText("");
                                password.setText("");

                            }
                            else{
                                isValid.setText(" INCORRECT USERNAME OR PASSWORD!!!!!!!!!!!!!");
                                username.setText("");
                                password.setText("");
                            }
                     
                    }  
                }
            }
            //***************************End of student login**************
            //admin login******************************************************
            else if (admin.isSelected() == true) {
                String que = "select password from adminuser where username ='"+UserName+"' ";
                ResultSet resultSet = connection.st.executeQuery(que);
                if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
                    while (resultSet.next()) {
                            if (resultSet.getString("Password").equals(password.getText())) {
                                myController.setScreen(ScreensFramework.screen2ID);
                                username.setText("");
                                password.setText("");

                            }
                            else{
                                isValid.setText(" INCORRECT USERNAME OR PASSWORD!!!!!!!!!!!!!");
                                username.setText("");
                                password.setText("");
                            }

                        }
                    
                }
                
            }
            //****************************End of Admin login*********************
            //Lecture login******************************************************
            else if (lectureRadio.isSelected() == true) {
                String que = "select password from lectures where username ='"+UserName+"' ";
                ResultSet resultSet = connection.st.executeQuery(que);
                if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
                    while (resultSet.next()) {
                            //String Password = resultSet.getString("Password");
                            if (resultSet.getString("Password").equals(password.getText())) {
                                myController.setScreen(ScreensFramework.screen3ID);
//                                isValid.setText(" LOGING SUCCESSFUL!!!!!!!!!!!!!");
                                username.setText("");
                                password.setText("");
//                                isValid.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat,aqua 0%, red 50%);");
//                                isValid.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));

                            }
                            else{
                                isValid.setText(" INCORRECT USERNAME OR PASSWORD!!!!!!!!!!!!!");
                                username.setText("");
                                password.setText("");
                                
                            }

                        }
                    
                }
                
            }
            //****************************End of lecture login*******************
            else{
                isValid.setText(" FILL ALL FIELDS!!!!!!!!!!!!!");
                username.setText("");
                password.setText("");
            }
        } catch (Exception e) {
            System.err.println("Errorrrrr" + e); 
        }
        
        
        
        try {
            /*
            if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
                
                //*********************Update Query********************
                //String query = ("INSERT INTO test(username,password) values('"+UserName+"','"+PassWord+"')");
                //connection.st.executeUpdate(query);
                
                //*********************End of Update Query********************************
               
                //****************Login verify Query**************
                String que = "select password from adminuser where username ='"+UserName+"' ";
                ResultSet resultSet = connection.st.executeQuery(que);
                while(resultSet.next()){
                    String Password = resultSet.getString("password");
                    if (resultSet.getString("password").equals(password.getText())) {
                        myController.setScreen(ScreensFramework.screen2ID);
                        isValid.setText(" LOGING SUCCESSFUL!!!!!!!!!!!!!");
                        username.setText("");
                        password.setText("");
                        isValid.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat,aqua 0%, red 50%);");
                        isValid.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
            
                    }
                    else{
                        username.setText("");
                        password.setText("");
                        isValid.setText(" INCORRECT username or password!!!");
                        isValid.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat,aqua 0%, red 50%);");
                        isValid.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
             
                    }
                    
                }
                //*****************ENd of login query*************
                
            }
            else{
               isValid.setText("Fill all fields......");
               isValid.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat,aqua 0%, red 50%);");
               isValid.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
            }*/
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
        //myController.setScreen(ScreensFramework.screen20ID);
       // myController.setScreen(ScreensFramework.screen3ID);
       // myController.setScreen(ScreensFramework.screen4ID);
    }
}
