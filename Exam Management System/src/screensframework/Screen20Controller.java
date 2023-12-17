 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author LIBETOE
 */
public class Screen20Controller implements Initializable,ControlledScreen {
    ScreensController myController;
    @FXML
    private JFXButton previous;
    @FXML
    private JFXButton next;
    @FXML
    private Label questionNumber;
    @FXML
    private Label questionString;
    @FXML
    private JFXRadioButton option1;
    @FXML
    private ToggleGroup options;
    @FXML
    private JFXRadioButton option2;
    @FXML
    private JFXRadioButton option3;
    @FXML
    private JFXRadioButton option4;
    @FXML
    private JFXButton submit;
    @FXML
    private Label timer;
    @FXML
    private Label course;
    
    static int position = 0;
    static int numberOfquestions;
    static int marks;
    String selectedCourse;
    ExaminationQuestions exam;
    ArrayList<ExaminationQuestions> examQuestions = new ArrayList();
    @FXML
    public Text hours;
    @FXML
    public Text minutes;
    @FXML
    public Text seconds;

    
    
    Integer currSeconds;
    Thread thrd;
    @FXML
    private JFXButton startExam;
    //int myTime  = Integer.valueOf(currSeconds);
    Integer hmsToSeconds(Integer h,Integer m, Integer s){
        Integer hToSeconds = h*3600;
        Integer mToSeconds = m*60;
        Integer total = hToSeconds + mToSeconds + s;
        return total;
        
    }
    LinkedList<Integer> secondsToHMms(Integer currSecond){
        Integer hours = currSecond/3600;
        currSecond = currSecond % 3600;
        Integer minutes = currSecond / 60;
        currSecond = currSecond % 60;
        Integer seconds = currSecond;
        LinkedList<Integer> answer = new LinkedList<>();
        answer.add(hours);
        answer.add(minutes);
        answer.add(seconds);
        return answer;
        
    }
    void startCountDown(){
        thrd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                      //count down code TO DO here
                      setOutput(); 
                      Thread.sleep(1000);
                        if (currSeconds.equals(0)) {
                            thrd.stop();
                            System.exit(0);
                            System.out.println("Finished!!!");
                        }
                      System.out.println("Current Seconds:"+currSeconds);
                      currSeconds -=1;
                    }
                } catch (Exception e) {
                    //exception Handling
                    
                }
            }
        });
        thrd.start();
    }
    void setOutput(){
        LinkedList<Integer> currHms = secondsToHMms(currSeconds);
        System.out.println(currHms.get(0) + "-"+currHms.get(1)+"-"+currHms.get(2));
        String hour = String.valueOf(currHms.get(0));
        String minunte = String.valueOf(currHms.get(1));
        String second = String.valueOf(currHms.get(2));
        
        hours.setText(hour +":");
        minutes.setText(minunte+":");
        seconds.setText(second);
    }
    /**
     * Initializes the controller class. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void previous(MouseEvent event) {
            
//            System.out.println("PREVIOUS: "+position--);
        if(position > 0){
            position = position-1;
            previous.setDisable(false);
            getExamQuestions(position,Screen8Controller.examCourse);
            //position--;
            System.out.println("PREVIOUS: "+ position);
        }
        else if(position < 0){
            getExamQuestions(1,Screen8Controller.examCourse);
            previous.setDisable(true);
        }
    }
    int value;
    @FXML
    private void next(MouseEvent event) {
        try {
              System.out.println("Before test case");
              if(option1.isSelected()){
                    String opt1 = exam.getOption1();
                    String opt2 = exam.getOption2();
                    String opt3 = exam.getOption3();
                    String opt4 = exam.getOption4();
                    String correctOpt = exam.getCorrect();
                    System.out.println("Selected: "+opt1 + " Correct: "+correctOpt);
                    System.out.println(""+opt1.compareTo(correctOpt));
                    System.out.println("");
                    System.out.println(""+correctOpt.compareTo(opt1));
                    
                  if(opt1.compareTo(correctOpt) == 0){
                      System.out.println("Option 1 Selected");
                      value+=5;
                  }else{
                      System.out.println("Incorrect Option");
                  }
                  
              }
              else if(option2.isSelected()){
                  if(exam.getOption2().compareTo(exam.getCorrect()) == 0){
                      System.out.println("Option 2 Selected");
                      value+=5;
                  }else{
                      System.out.println("Incorrect Option");
                  }
              }
              else if(option3.isSelected()){
                  if(exam.getOption3().compareTo(exam.getCorrect()) == 0){
                      System.out.println("Option 3 Selected");
                      value+=5;
                  }else{
                      System.out.println("Incorrect Option");
                  }
              }
              else if(option4.isSelected()){
                  if(exam.getOption4().compareTo(exam.getCorrect()) == 0){
                      System.out.println("Option 4 Selected");
                      value+=5;
                  }else{
                      System.out.println("Incorrect Option");
                  }
              }
              
             // System.out.println("Marks: "+ marks + " The selected option" + exam.getOption4());
             // System.out.println("Correct option:"+exam.getCorrect());
              
              
              if(position <  numberOfquestions){
                  next.setDisable(false);
                  position = position+1;
                  getExamQuestions(position,Screen8Controller.examCourse);
                  System.out.println("OPTION 1:" +DBConnect.res.getString("option1"));
                  position++;
                  System.out.println("NEXT:"+position);
               }
              else if(position > numberOfquestions-1){
                   getExamQuestions(numberOfquestions,Screen8Controller.examCourse);
                   next.setDisable(true);
                   next.isDisabled();
               }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }

    @FXML
    private void select(ActionEvent event) {
    }

    @FXML
    private void submit(MouseEvent event) {
    }
    public void getExamQuestions(int position, String selectedCourse){
        try {
            DBConnect connect= new DBConnect();
            DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM questions where course='"+selectedCourse+"' ");
            //DBConnect.res = DBConnect.con.createStatement().executeQuery("SELECT * FROM questions");
            ArrayList<ExaminationQuestions> examQuestions = new ArrayList();
            
            while (DBConnect.res.next()) {
                exam = new ExaminationQuestions(DBConnect.res.getString("questionString"), DBConnect.res.getString("option1"), DBConnect.res.getString("option2"), DBConnect.res.getString("option3"), DBConnect.res.getString("option4"), DBConnect.res.getString("correctOption"), DBConnect.res.getString("course"));
                examQuestions.add(exam);
            }
               setQuestions(examQuestions,position);
               System.out.println("There "+examQuestions.size()+" questions");
               numberOfquestions = examQuestions.size();
               course.setText(exam.getCourse()); 
            
        } catch (SQLException ex) {
            Logger.getLogger(Screen20Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void setQuestions(ArrayList<ExaminationQuestions> examQuestions1, int position) {
        
            System.out.println("");
            questionNumber.setText("Question "+(position+1));
            questionString.setText("" + examQuestions1.get(position).getQuestionString() + "\n");
            option1.setText(examQuestions1.get(position).getOption1() + "\n");
            option2.setText(examQuestions1.get(position).getOption2() + "\n");
            option3.setText(examQuestions1.get(position).getOption3() + "\n");
            option4.setText(examQuestions1.get(position).getOption4() + "\n");
            
        
    }
    

    @FXML
    private void startExamination(ActionEvent event) {
        System.out.println("Selected Course: "+ Screen8Controller.examCourse);
        getExamQuestions(position,Screen8Controller.examCourse);
        
         DBConnect connect= new DBConnect();
        try {
            DBConnect.res = DBConnect.con.createStatement().executeQuery("select ExamDuration from courses where CourseName ='"+Screen8Controller.examCourse+"' ");
            System.out.println("Trying to find Exam Duration");
            while(DBConnect.res.next()){
                System.out.println("In duration");
                System.out.println(""+ DBConnect.res.getDouble("ExamDuration"));
                if(DBConnect.res.getDouble("ExamDuration") == 0.3){
                    currSeconds = hmsToSeconds(0, 30, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 1.0){
                    currSeconds = hmsToSeconds(1, 0, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 1.2){
                    currSeconds = hmsToSeconds(1, 20, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 1.3){
                    currSeconds = hmsToSeconds(1, 30, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 1.4){
                    currSeconds = hmsToSeconds(1, 40, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 2.0){
                    currSeconds = hmsToSeconds(2, 0, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 2.1){
                    currSeconds = hmsToSeconds(2, 10, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 2.2){
                    currSeconds = hmsToSeconds(2, 20, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 2.3){
                    currSeconds = hmsToSeconds(2, 30, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 2.4){
                    currSeconds = hmsToSeconds(2, 40, 0);
                }
                else if(DBConnect.res.getDouble("ExamDuration") == 3.0){
                    currSeconds = hmsToSeconds(3, 0, 0);
                }
            }
        
        }
        catch (SQLException ex) {
            Logger.getLogger(Screen20Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       // currSeconds = hmsToSeconds(0, 0, 15);
        hours.setText("00");
        minutes.setText("00");
        seconds.setText("00");
        startCountDown();
        position = 0;
        
    }
}
