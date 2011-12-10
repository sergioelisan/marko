/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bcc.IDataBase.Dao;


import java.sql.*;
import bcc.ibusiness.dominio.*;
import bcc.IDataBase.Conexao.*;

/**
 *
 * @author douglas
 */
public class DaoCliente {
    
    private final String URL = "jdbc:derby://localhost:1527/IBusinessBD"; 
    private final String usuario = "root", senha = "senha";
   
    private Connection conexao;  
    private Statement  comando; 
    
    private void conectar() {  
      try {  
         conexao = Conexao.conexao(URL, usuario , senha);  
         comando = conexao.createStatement();    
      } catch (ClassNotFoundException e) {  
         System.out.println("Erro ao carregar o driver");  
      } catch (SQLException e) {  
         System.out.println("Erro ao conectar");  
      }  
   }  
    private void fechar() {  
      try {  
         comando.close();  
         conexao.close();  
         System.out.println("Conexão Fechada");  
      } catch (SQLException e) {  
         System.out.println("Erro ao fechar conexão");  
      }  
   }
    
    
}
