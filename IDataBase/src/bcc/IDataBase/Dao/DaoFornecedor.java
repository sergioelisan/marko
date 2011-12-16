/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bcc.IDataBase.Dao;

import bcc.IDataBase.Conexao.Conexao;
import bcc.ibusiness.dominio.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author douglas
 */
public class DaoFornecedor {
    private Connection conexao3;
    
    public DaoFornecedor() throws ClassNotFoundException{
        this.conexao3= new Conexao().conectar();
    }
    
    public void addFornecedor(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (CODIGO,RAZAO_SOCIAL,CNPJ,ENDERECO,"
                + "FONE,FAX,REPRESENTANTE) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = conexao3.prepareStatement(sql);
            stmt.setLong(1, fornecedor.getId());
            stmt.setString(2, fornecedor.getRazao());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setString(5, fornecedor.getFone());
            stmt.setString(6, fornecedor.getFax());
            stmt.setString(7, fornecedor.getRepresentante());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    public ArrayList<Fornecedor> listarFornecedor(){
     
        ArrayList<Fornecedor> Fornecedores = new ArrayList<Fornecedor>() ;
        String sql = "SELECT * FROM fornecedor";
     
        try {
        
            PreparedStatement stmt = conexao3.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getLong("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));
                
                Fornecedores.add(fornecedor);
            }
            rs.close();
            stmt.close();
            return Fornecedores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateFornecedor(Fornecedor fornecedor){
     
        String sql = "UPDATE fornecedor SET CODIGO=?,RAZAO_SOCIAL=?,CNPJ=?,ENDERECO=?,"
                + "FONE=?,FAX=?,REPRESENTANTE=? WHERE CODIGO=?";
        
     try {
            PreparedStatement stmt = conexao3.prepareStatement(sql);
            stmt.setLong(1, fornecedor.getId() );
            stmt.setString(2, fornecedor.getRazao());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setString(5, fornecedor.getFone());
            stmt.setString(6, fornecedor.getFax());
            stmt.setString(7, fornecedor.getRepresentante());
            stmt.setLong(8, fornecedor.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void rmFornecedor(Fornecedor fornecedor){
        String sql="DELETE FROM fornecedor WHERE CODIGO=?";
        try {
            PreparedStatement stmt = conexao3.prepareStatement(sql);
            stmt.setLong(1, fornecedor.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Fornecedor buscaFornecedor(CNPJ cnpj){
        String sql = "SELECT * FROM fornecedor";
        Fornecedor fornecedor = new Fornecedor();
        try {
            PreparedStatement stmt = conexao3.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("CNPJ").equals(cnpj.getCnpj())){
                fornecedor.setId(rs.getLong("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));
                return fornecedor;
                }
            }
            rs.close();
            stmt.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Fornecedor buscaCliente(String nome){
        String sql = "SELECT * FROM fornecedor";
        Fornecedor fornecedor = new Fornecedor();
        try {
            PreparedStatement stmt = conexao3.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("NOME").equals(nome)){
                fornecedor.setId(rs.getLong("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));
                return fornecedor;
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
