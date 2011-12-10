package bcc.IDataBase.Conexao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;  


/**
 *
 * @author douglas
 */
public class Conexao {
     
  private static final String JavaDBDriver = "org.apache.derby.jdbc.ClientDriver";  
  
  public static Connection conexao(String url, String nome, String senha
          ) throws ClassNotFoundException, SQLException {           
         Class.forName(Conexao.JavaDBDriver);  
      return DriverManager.getConnection(url, nome, senha);  
   }  
}
  