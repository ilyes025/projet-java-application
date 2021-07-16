/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnect {
    private static  Connection cnx;
    public static Connection openConnection() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/javadatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "samir");
            System.out.println("Connected!");
        }
        catch(SQLException e)
        {
            System.out.println("erreur de connexion, sql erreur: "+e.getMessage());
        }
        catch(ClassNotFoundException e){
            
        }
        return cnx;
    }
    
    public static void closeConnection()
    {
        try
        {
            cnx.close();
            System.out.println("Closed");
        }
        catch(SQLException e)
        {
            System.out.println("erreur de fermetture de connexion"+e.getMessage());
        }
    }
}
