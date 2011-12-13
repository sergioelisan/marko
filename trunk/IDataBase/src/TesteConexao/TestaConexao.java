/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteConexao;


import java.sql.*;
import bcc.IDataBase.Conexao.Conexao;


/**
 *
 * @author douglas
 */
public class TestaConexao {
    
    
    public static void main(String Args[]) throws ClassNotFoundException, SQLException {
        Connection conn = new Conexao().getConection();
        System.out.print("conexão aberta");
        conn.close();
    }
    
}
