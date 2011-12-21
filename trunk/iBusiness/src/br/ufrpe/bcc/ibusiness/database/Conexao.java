package br.ufrpe.bcc.ibusiness.database;

import java.sql.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author douglas
 */
public class Conexao {

    public Conexao() {
        ResourceBundle rb = ResourceBundle.getBundle("br/ufrpe/bcc/ibusiness/database/connection");
        user = rb.getString("user");
        senha = rb.getString("senha");
        banco = rb.getString("banco");
        url = rb.getString("url");
        driver = rb.getString("driver");
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url + banco, user, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar com o banco!\n" + e);
            return null;
        }
    }
    private String user;
    private String senha;
    private String banco;
    private String url;
    private String driver;
}
