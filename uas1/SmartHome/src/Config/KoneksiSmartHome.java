    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Config;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahroi
 */
public class KoneksiSmartHome {
    
    private static Connection conn;
        public static Connection getConnection () {
        if (conn == null) {
        try{
        String url = "jdbc:mysql://localhost:3306/iot";
        String user = "root";
        String pass = "";
        DriverManager.registerDriver (new com.mysql.jdbc.Driver());
        conn = (Connection) DriverManager.getConnection (url,user,pass);
       
        } catch (Exception e) {
            Logger.getLogger(KoneksiSmartHome.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return conn;
    } 
}
    

