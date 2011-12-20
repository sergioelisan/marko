package br.ufrpe.bcc.ibusiness.funcionario;
import br.ufrpe.bcc.ibusiness.database.Conexao;
import br.ufrpe.bcc.ibusiness.database.DAOUtil;
import java.util.*;
import java.sql.*;

/**
 * Objeto de acesso aos dados de funcionarios
 * 
 * @author douglas
 */
public class DAOFuncionario implements IFuncionario {

    private Connection conexao;

    public DAOFuncionario() {
        try {
            this.conexao = new Conexao().conectar();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Adiciona um funcionario
     * @param funcionario 
     */
    public void inserirFuncionario(Funcionario funcionario) {
        String sql = DAOUtil.getQuery("funcionario.insert");
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getLogin());
            stmt.setString(2, funcionario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao cadastrar funcionario");
        }

    }

    /**
     * Lista todos os funcionarios da base
     * @return uma lista com todos os funcionarios
     */
    public ArrayList<Funcionario> listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = DAOUtil.getQuery("funcionario.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("CODIGO"));
                funcionario.setLogin(rs.getString("LOGIN"));
                funcionario.setSenha(rs.getString("SENHA"));
                funcionarios.add(funcionario);
            }

            rs.close();
            return funcionarios;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao listar os funcionarios");
        }
    }

    /**
     * Altera os dados de um funcionario
     * @param funcionario 
     */
    public void atualizarFuncionario(Funcionario funcionario) {
        String sql = DAOUtil.getQuery("funcionario.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getSenha());
            stmt.setLong(2, funcionario.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao alterar um funcionario");
        }
    }

    /**
     * Remove um funcionario do banco
     * @param funcionario 
     */
    public void removerFuncionario(int id) {
        String sql = DAOUtil.getQuery("funcionario.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao remover um funcionario");
        }
    }

}