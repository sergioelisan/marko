package br.bcc.ufrpe.idatabase.conexao;

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
     
  
  public Connection conectar() throws ClassNotFoundException{           
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_projeto_java", "root" , "dhss05091990");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
   }

  
}
  