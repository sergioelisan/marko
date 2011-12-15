/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bcc.IDataBase.Dao;

import java.sql.*;
import bcc.IDataBase.Conexao.Conexao;
import bcc.ibusiness.dominio.*;
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
    public void updateCliente(Cliente cliente){
     
        String sql = "UPDATE cliente SET NOME=?, CPF=?, ENDERECO=?, FONE=?, EMAIL=? WHERE ID=?";
        
     try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getFone());
            stmt.setString(5, cliente.getEmail());
            stmt.setLong(6, cliente.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void rmCliente(Cliente cliente){
        String sql="DELETE FROM cliente WHERE ID=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, cliente.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Cliente buscaCliente(CPF cpf){
        String sql = "SELECT * FROM cliente";
        Cliente cliente = new Cliente();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("CPF").equals(cpf.getCpf())){
                cliente.setId(rs.getLong("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setFone(rs.getString("FONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                return cliente;
                }
            }
            rs.close();
            stmt.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Cliente buscaCliente(String nome){
        String sql = "SELECT * FROM cliente";
        Cliente cliente = new Cliente();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("NOME").equals(nome)){
                cliente.setId(rs.getLong("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setFone(rs.getString("FONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                return cliente;
                }
            }
            rs.close();
            stmt.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
