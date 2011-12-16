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
public class DaoUsuario {
    
    private Connection conexao4;
    
    public DaoUsuario() throws ClassNotFoundException{
        this.conexao4= new Conexao().conectar();
    }
    
    public void addUsuario(Usuario usuario){
        String sql = "INSERT INTO usuario (LOGIN,SENHA,FUNCIONARIO) VALUES (?,?,?)";
        
        try {
            PreparedStatement stmt = conexao4.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPasswd());
            stmt.setString(3, usuario.getFuncionario().getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    public ArrayList<Usuario> listarUsuarios(){
     
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>() ;
        String sql = "SELECT * FROM usuario";
     
        try {
        
            PreparedStatement stmt = conexao4.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                usuario.setId(rs.getLong("CODIGO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setPasswd(rs.getString("SENHA"));
                funcionario.setNome(rs.getString("FUNCIONARIO"));
                usuario.setFuncionario(funcionario);
                
                Usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            return Usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateUsuario(Usuario usuario){
     
        String sql = "UPDATE usuario SET LOGIN=?,SENHA=?,FUNCIONARIO=? WHERE CODIGO=?";
        
     try {
            PreparedStatement stmt = conexao4.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPasswd());
            stmt.setString(3, usuario.getFuncionario().getNome());
        
            stmt.setLong(4, usuario.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void rmUsuario(Usuario usuario){
        String sql="DELETE FROM usuario WHERE CODIGO=?";
        try {
            PreparedStatement stmt = conexao4.prepareStatement(sql);
            stmt.setLong(1, usuario.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Usuario buscaUsuario(String login){
        String sql = "SELECT * FROM usuario";
        Usuario usuario = new Usuario();
        try {
            PreparedStatement stmt = conexao4.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("LOGIN").equals(login)){
                usuario.setId(rs.getLong("CODIGO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setPasswd(rs.getString("SENHA"));
                Funcionario funcionario= new Funcionario();
                funcionario.setNome(rs.getString("NOME"));
                usuario.setFuncionario(funcionario);
               
                return usuario;
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
