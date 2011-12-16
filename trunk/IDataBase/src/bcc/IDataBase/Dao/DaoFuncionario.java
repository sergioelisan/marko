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
public class DaoFuncionario {
    
    private Connection conexao2;
    public DaoFuncionario() throws ClassNotFoundException{
        this.conexao2= new Conexao().conectar();
    }
    
    public void addFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionario (CODIGO,NOME,CPF,MATRICULA,ENDERECO"
                + ",FONE,CELULAR,CNTPS,SALARIO,EMAIL) VALUES (?,?,?,?,?,?,?,?,?,?)"; 
        try {
            PreparedStatement stmt = conexao2.prepareStatement(sql);
            stmt.setLong(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getMatricula());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setString(6, funcionario.getFone());
            stmt.setString(7, funcionario.getCelular());
            stmt.setString(8, funcionario.getCntps());
            stmt.setDouble(9, funcionario.getSalario());
            stmt.setString(10, funcionario.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    public ArrayList<Funcionario> listarFuncionarios(){
     
        ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>() ;
        String sql = "SELECT * FROM funcionario";
     
        try {
        
            PreparedStatement stmt = conexao2.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("CODIGO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setMatricula(rs.getString("MATRICULA"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setFone(rs.getString("FONE"));
                funcionario.setCelular(rs.getString("CELULAR"));
                funcionario.setCntps(rs.getString("CNTPS"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                funcionario.setEmail(rs.getString("EMAIL"));
                Funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return Funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCliente(Funcionario funcionario){
     
        String sql = "UPDATE funcionario SET CODIGO=?,NOME=?, CPF=?, MATRICULA=?, "
                + "ENDERECO=?, FONE=?, CELULAR=?, CNTPS=?,SALARIO=? ,EMAIL=? WHERE ID=?";
        
     try {
            PreparedStatement stmt = conexao2.prepareStatement(sql);
            stmt.setLong(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getMatricula());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setString(6, funcionario.getFone());
            stmt.setString(7, funcionario.getCelular());
            stmt.setString(8, funcionario.getCntps());
            stmt.setDouble(9, funcionario.getSalario());
            stmt.setString(10, funcionario.getEmail());
            stmt.setLong(11, funcionario.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void rmFuncionario(Funcionario funcionario){
        String sql="DELETE FROM funcionario WHERE ID=?";
        try {
            PreparedStatement stmt = conexao2.prepareStatement(sql);
            stmt.setLong(1, funcionario.getId());
            
            stmt.execute();
            stmt.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Funcionario buscaFuncionario(CPF cpf){
        String sql = "SELECT * FROM Funcionario";
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement stmt = conexao2.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("CPF").equals(cpf.getCpf())){
                funcionario.setId(rs.getLong("CODIGO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setMatricula(rs.getString("MATRICULA"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setFone(rs.getString("FONE"));
                funcionario.setCelular(rs.getString("CELULAR"));
                funcionario.setCntps(rs.getString("CNTPS"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                funcionario.setEmail(rs.getString("EMAIL"));
                return funcionario;
                }
            }
            rs.close();
            stmt.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Funcionario buscaFuncionario(String nome){
        String sql = "SELECT * FROM funcionario";
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement stmt = conexao2.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getString("NOME").equals(nome)){
                funcionario.setId(rs.getLong("CODIGO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setMatricula(rs.getString("MATRICULA"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setFone(rs.getString("FONE"));
                funcionario.setCelular(rs.getString("CELULAR"));
                funcionario.setCntps(rs.getString("CNTPS"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                funcionario.setEmail(rs.getString("EMAIL"));
                return funcionario;
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
