package bcc.IDataBase.Conexao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author douglas
 */
public class Conexao {
     
  
  public Connection getConection(){           
        try {
            return DriverManager.getConnection("jdbc:derby//localhost:1527/IBusinessBD", "DHSS" , "ibusiness");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
   } 
  
}
  