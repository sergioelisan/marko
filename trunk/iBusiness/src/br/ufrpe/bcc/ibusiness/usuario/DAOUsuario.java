package br.ufrpe.bcc.ibusiness.usuario;

import br.ufrpe.bcc.ibusiness.funcionario.Funcionario;
import br.ufrpe.bcc.idatabase.Conexao;
import br.ufrpe.bcc.idatabase.DAOUtil;
import java.sql.*;
import java.util.*;

/**
 *
 * Objeto de acesso aos dados para usuarios
 * 
 * @author douglas
 */
public class DAOUsuario implements IUsuario {

    private Connection conexao;

    public DAOUsuario() {
        try {
            this.conexao = new Conexao().conectar();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage() );
        }
    }

    /**
     * Adiciona um usuario ao banco de dados
     * @param usuario 
     */
    public void addUsuario(Usuario usuario) {
        String sql = DAOUtil.getQuery("usuario.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPasswd());
            stmt.setString(3, usuario.getFuncionario().getNome());
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao cadastrar usuario");
        }

    }

    /**
     * Lista todos os usuarios do banco
     * @return uma lista de usuarios
     */
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = DAOUtil.getQuery("usuario.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                usuario.setId(rs.getLong("CODIGO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setPasswd(rs.getString("SENHA"));
                funcionario.setNome(rs.getString("FUNCIONARIO"));
                usuario.setFuncionario(funcionario);

                usuarios.add(usuario);
            }

            return usuarios;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao listar usuario");
        }
    }

    /**
     * Atualiza usuarios 
     * @param usuario 
     */
    public void updateUsuario(Usuario usuario) {
        String sql = DAOUtil.getQuery("usuario.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPasswd());
            stmt.setString(3, usuario.getFuncionario().getNome());

            stmt.setLong(4, usuario.getId());

            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao alterar usuario");
        }
    }

    /**
     * Remove usuarios
     * @param usuario 
     */
    public void rmUsuario(Usuario usuario) {
        String sql = DAOUtil.getQuery("usuario.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, usuario.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao remover usuario");
        }
    }

    /**
     * Busca por usuarios
     * @param login
     * @return 
     */
    public Usuario buscaUsuario(String login) {
        String sql = DAOUtil.getQuery("usuario.login");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, login);            
            ResultSet rs = stmt.executeQuery();                        
            Usuario usuario = new Usuario();
            
            while (rs.next()) {                
                usuario.setId(rs.getLong("CODIGO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setPasswd(rs.getString("SENHA"));
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("NOME"));
                usuario.setFuncionario(funcionario);
            }
            rs.close();            
            return usuario;
            
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao buscar pelo login do usuario");
        }
    }
    
}
