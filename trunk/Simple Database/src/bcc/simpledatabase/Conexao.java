package bcc.simpledatabase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;  


/**
 *
 * @author Douglas
 */
public class Conexao {
     
  private static final String JavaDBDriver = "org.apache.derby.jdbc.ClientDriver";  
  
   public static Connection conexao(String url, String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {           
         Class.forName(JavaDBDriver);  
      return DriverManager.getConnection(url, nome, senha);  
   }  
}
  