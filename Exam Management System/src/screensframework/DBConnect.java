/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LIBETOE
 */
public class DBConnect {
    static Connection con;
    static Statement st;
    static ResultSet res;
    public DBConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplechoiceexamserver","root","");
            st = con.createStatement();
            System.out.println("connection Successful");
        }
        catch (Exception e){
            System.err.println("ERROR!!!: "+e);
        }
        
        
    }
   
    
}
