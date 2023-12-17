/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author LIBETOE
 */
public class AdminUsers extends RecursiveTreeObject<AdminUsers> {
    StringProperty userId;
    StringProperty firstname;
    StringProperty lastname;
    StringProperty email;
    StringProperty course;
    StringProperty username;
    StringProperty usertype;
    StringProperty password;
    
    public AdminUsers(){
        super();
    }

    public AdminUsers(String userId, String firstname, String lastname, String email, String course, String username, String usertype, String password) {
        this.userId = new SimpleStringProperty(userId);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.course = new SimpleStringProperty(course);
        this.username = new SimpleStringProperty(username);
        this.usertype = new SimpleStringProperty(usertype);
        this.password = new SimpleStringProperty(password);
    }
    
}
