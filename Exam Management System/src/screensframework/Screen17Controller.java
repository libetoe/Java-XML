/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen17Controller implements Initializable, ControlledScreen {
    ScreensController myController;
    @FXML
    private JFXTextArea questionString;
    @FXML
    private JFXTextField option1;
    @FXML
    private ChoiceBox<String> chooseCorrect;
    @FXML
    private JFXTextField option2;
    @FXML
    private JFXTextField option3;
    @FXML
    private JFXTextField option4;
    
    @FXML
    private JFXButton save;
    
    @FXML
    private Label verify;
    @FXML
    private Label courseName;
    private Pane QuestionLog;
    @FXML
    private TableView<ExamQuestions> data;
    @FXML
    private TableColumn<ExamQuestions, Integer> QuestionID;
    @FXML
    private TableColumn<ExamQuestions, String> CourseName;
    @FXML
    private TableColumn<ExamQuestions, String> QuestionString;
    @FXML
    private TableColumn<ExamQuestions, String> OptionOne;
    @FXML
    private TableColumn<ExamQuestions, String> OptionTwo;
    @FXML
    private TableColumn<ExamQuestions, String> OptionThree;
    @FXML
    private TableColumn<ExamQuestions, String> OptionFour;
    @FXML
    private TableColumn<ExamQuestions, String> Correct;
    
    final ObservableList<ExamQuestions> objlist = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> Courses;

    /**
     * Initializes the controller class.
     */
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             DBConnect connect= new DBConnect();
             DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT CourseName FROM courses");
             System.out.println("before Listing the courses");
             while(DBConnect.res.next()){
                 System.out.println("Listing the courses");
                 Courses.getItems().add(DBConnect.res.getString("CourseName"));
             }
             
            DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM questions");
              while (DBConnect.res.next()) {                  
                  //objlist.add(new ExamQuestions(DBConnect.res.getInt("QuestionID"), DBConnect.res.getString("course"), DBConnect.res.getString("questionString"), DBConnect.res.getString("option1"),DBConnect.res.getString("option2"),DBConnect.res.getString("option3"),DBConnect.res.getString("option4"),DBConnect.res.getString("correctOption")));
                  objlist.add(new ExamQuestions(DBConnect.res.getInt("QuestionID"), DBConnect.res.getString("course"), DBConnect.res.getString("questionString"), DBConnect.res.getString("option1"), DBConnect.res.getString("option2"), DBConnect.res.getString("option3"), DBConnect.res.getString("option4"), DBConnect.res.getString("correctOption")));
              }
            QuestionID.setCellValueFactory(new PropertyValueFactory<ExamQuestions,Integer>("QuestionID"));
            CourseName.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("course"));
            QuestionString.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("questionString"));
            OptionOne.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option1"));
            OptionTwo.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option2"));
            OptionThree.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option3"));
            OptionFour.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option4"));
            Correct.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("correctOption"));
            System.out.println("Course: "+DBConnect.res.getString("course"));
            data.setItems(objlist);
        } catch (Exception e) {
        }
        
        //chooseCorrect.getItems().addAll("option1","option2","option3","option4");
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
        String qustion = questionString.getText();
        String option1 = this.option1.getText();
        String option2 = this.option2.getText();
        String option3 = this.option3.getText();
        String option4 = this.option4.getText();
        String course = Courses.getValue();
        String correct = chooseCorrect.getValue();
        DBConnect connect= new DBConnect();
        try {
            if (!this.questionString.getText().equals("") && !this.option1.getText().equals("") &&
                !this.option2.getText().equals("") &&  !this.option3.getText().equals("") &&  
                !this.option4.getText().equals("") && !this.Courses.getValue().equals("")  &&    
                !this.chooseCorrect.getValue().equals("") ) {
                
                if(this.option1.getText().equals(this.option2.getText()) || this.option1.getText().equals(this.option3.getText()) || this.option1.getText().equals(this.option4.getText()) ||
                   this.option2.getText().equals(this.option3.getText()) || this.option2.getText().equals(this.option4.getText()) ||
                   this.option3.getText().equals(this.option4.getText())){
                    
                    verify.setText("You Entered the same options!!");
                }
                else{
                    String query = ("INSERT INTO questions(course,questionString,option1,option2,option3,option4,correctOption) values('"+course+"','"+qustion+"','"+option1+"','"+option2+"','"+option3+"','"+option4+"','"+correct+"')");
                    connect.st.executeUpdate(query);
                    System.out.println("UPDate succussful");
                    questionString.setText(" ");
                    this.option1.setText(" ");
                    this.option2.setText(" ");
                    this.option3.setText(" ");
                    this.option4.setText(" ");
                    Courses.setValue(" ");
                    chooseCorrect.setValue(" ");
                }
                
            }
            else{
                verify.setText("Please fill all the fields!!!");
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
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
    }

    @FXML
    private void getUserInput(MouseEvent event) {
        if (chooseCorrect.isPressed()) {
            chooseCorrect.getItems().addAll(this.option1.getText(),this.option2.getText(),this.option3.getText(),this.option4.getText());
        }
    }

    @FXML
    private void viewQuestions(Event event) {
        try {
            DBConnect connect= new DBConnect();
            DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM questions");
              while (DBConnect.res.next()) {                  
                  //objlist.add(new ExamQuestions(DBConnect.res.getInt("QuestionID"), DBConnect.res.getString("course"), DBConnect.res.getString("questionString"), DBConnect.res.getString("option1"),DBConnect.res.getString("option2"),DBConnect.res.getString("option3"),DBConnect.res.getString("option4"),DBConnect.res.getString("correctOption")));
                  objlist.add(new ExamQuestions(DBConnect.res.getInt("QuestionID"), DBConnect.res.getString("course"), DBConnect.res.getString("questionString"), DBConnect.res.getString("option1"), DBConnect.res.getString("option2"), DBConnect.res.getString("option3"), DBConnect.res.getString("option4"), DBConnect.res.getString("correctOption")));
              }
            QuestionID.setCellValueFactory(new PropertyValueFactory<ExamQuestions,Integer>("questionId"));
            QuestionString.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("questionString"));
            OptionOne.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option1"));
            OptionTwo.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option2"));
            OptionThree.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option3"));
            OptionFour.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("option4"));
            Correct.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("correctOption"));
            CourseName.setCellValueFactory(new PropertyValueFactory<ExamQuestions,String>("course"));
            data.setItems(objlist);
        } catch (Exception e) {
        }
    }
    
}
