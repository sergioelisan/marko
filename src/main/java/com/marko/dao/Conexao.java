package com.marko.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 * @author douglas
 */
public class Conexao {

    private String user;
    private String senha;
    private String banco;
    private String url;
    private String driver;

    public Conexao() {
        ResourceBundle rb = ResourceBundle.getBundle("connection");
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
}
