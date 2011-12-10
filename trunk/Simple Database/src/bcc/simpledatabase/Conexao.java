package bcc.simpledatabase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;  


/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Serginho
 */
public class Conexao {
     
  private static final String MySQLDriver = "org.apache.derby.jdbc.ClientDriver";  
  
   public static Connection conexao(String url, String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {           
         Class.forName(MySQLDriver);  
      return DriverManager.getConnection(url, nome, senha);  
   }  
}
  