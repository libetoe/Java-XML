/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

/**
 *
 * @author LIBETOE
 */
public class Courses {
      int Id;
      String  course;
      int  questionsNumber;
      int  marks;
      double  duration;
      

    public Courses(int Id, String course, int questionsNumber, int marks, double duration) {
        this.Id = Id;
        this.course = course;
        this.questionsNumber = questionsNumber;
        this.marks = marks;
        this.duration = duration;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getQuestionsNumber() {
        return questionsNumber;
    }

    public void setQuestionsNumber(int questionsNumber) {
        this.questionsNumber = questionsNumber;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    
    
    
    
    
}
