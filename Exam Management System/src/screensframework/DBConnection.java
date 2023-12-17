 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensframework;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LIBETOE
 */
public class DBConnection {
    static Connection connection = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/multiplechoiceexamserver";
            connection = DriverManager.getConnection(url,"root","");
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Error in connecting"+ e);
        }
        return connection;
    }
    public static void main(String[] args){
        getConnection();
    }
    
}
