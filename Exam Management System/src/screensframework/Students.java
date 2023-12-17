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
public class Students {
    int studentid;
    String firstname;
    String lastname;
    String username;
    String course;
    String password;
    String lecture;

    public Students(int studentid,String firstname, String lastname, String username, String course, String password, String lecture) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.course = course;
        this.password = password;
        this.lecture = lecture;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }
    
    
    
}
