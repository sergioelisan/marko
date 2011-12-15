/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bcc.IDataBase.Dao;

import java.sql.*;
import bcc.IDataBase.Conexao.Conexao;
import bcc.ibusiness.dominio.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;



/**
 *
 * @author douglas
 */
public class DaoCliente {
    
    private Connection conexao;
    
    public DaoCliente() throws ClassNotFoundException{
        this.conexao= new Conexao().conectar();
    }
    
    public void addClientes(Cliente cliente){
        String sql = "INSERT INTO cliente (CODIGO,NOME,CPF,ENDERECO,FONE,EMAIL) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getFone());
            stmt.setString(6, cliente.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    public ArrayList<Cliente> listarClientes(){
     
        ArrayList<Cliente> Clientes = new ArrayList<Cliente>() ;
        String sql = "SELECT * FROM cliente";
     
        try {
        
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDE"));
                cliente.setFone(rs.getString("FONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                Clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            return Clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
