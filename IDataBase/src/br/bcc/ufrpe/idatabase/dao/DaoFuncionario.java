package br.bcc.ufrpe.idatabase.dao;

import br.bcc.ufrpe.businesscore.entidades.CPF;
import br.bcc.ufrpe.idatabase.conexao.Conexao;
import br.bcc.ufrpe.businesscore.entidades.Funcionario;

import java.util.*;
import java.sql.*;

/**
 * Objeto de acesso aos dados de funcionarios
 * 
 * @author douglas
 */
public class DaoFuncionario {

    private Connection conexao;

    public DaoFuncionario() throws ClassNotFoundException {
        this.conexao = new Conexao().conectar();
    }

    /**
     * Adiciona um funcionario
     * @param funcionario 
     */
    public void addFuncionario(Funcionario funcionario) {
        String sql = DaoUtil.getQuery("funcionario.insert");
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf().getCpf());
            stmt.setString(3, funcionario.getMatricula());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getFone());
            stmt.setString(6, funcionario.getCelular());
            stmt.setString(7, funcionario.getCntps());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setString(9, funcionario.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao cadastrar funcionario");
        }

    }

    /**
     * Lista todos os funcionarios da base
     * @return uma lista com todos os funcionarios
     */
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = DaoUtil.getQuery("funcionario.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("CODIGO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(new CPF(rs.getString("CPF")) );
                funcionario.setMatricula(rs.getString("MATRICULA"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setFone(rs.getString("FONE"));
                funcionario.setCelular(rs.getString("CELULAR"));
                funcionario.setCntps(rs.getString("CNTPS"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                funcionario.setEmail(rs.getString("EMAIL"));
                funcionarios.add(funcionario);
            }

            rs.close();
            return funcionarios;
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao listar os funcionarios");
        }
    }

    /**
     * Altera os dados de um funcionario
     * @param funcionario 
     */
    public void updateFuncionario(Funcionario funcionario) {
        String sql = DaoUtil.getQuery("funcionario.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf().getCpf());
            stmt.setString(3, funcionario.getMatricula());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getFone());
            stmt.setString(6, funcionario.getCelular());
            stmt.setString(7, funcionario.getCntps());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setString(9, funcionario.getEmail());
            stmt.setLong(10, funcionario.getId());

            stmt.execute();

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao alterar um funcionario");
        }
    }

    /**
     * Remove um funcionario do banco
     * @param funcionario 
     */
    public void rmFuncionario(Funcionario funcionario) {
        String sql = DaoUtil.getQuery("funcionario.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, funcionario.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao remover um funcionario");
        }
    }

    /**
     * Busca por um funcionario pelo CPF
     * @param cpf
     * @return 
     */
    public Funcionario buscaFuncionario(CPF cpf) {
        String sql = DaoUtil.getQuery("funcionario.cpf");
        Funcionario funcionario = new Funcionario();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf.getCpf());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario.setId(rs.getLong("CODIGO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(new CPF(rs.getString("CPF")) );
                funcionario.setMatricula(rs.getString("MATRICULA"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setFone(rs.getString("FONE"));
                funcionario.setCelular(rs.getString("CELULAR"));
                funcionario.setCntps(rs.getString("CNTPS"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                funcionario.setEmail(rs.getString("EMAIL"));
            }
            rs.close();

            return funcionario;
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao buscar por um funcionario pelo CPF");
        }
    }

    /**
     * Busca um funcionario pelo nome
     * @param nome
     * @return 
     */
    public Funcionario buscaFuncionario(String nome) {
        String sql = DaoUtil.getQuery("funcionario.nome");
        Funcionario funcionario = new Funcionario();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario.setId(rs.getLong("CODIGO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setCpf(new CPF(rs.getString("CPF")) );
                funcionario.setMatricula(rs.getString("MATRICULA"));
                funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setFone(rs.getString("FONE"));
                funcionario.setCelular(rs.getString("CELULAR"));
                funcionario.setCntps(rs.getString("CNTPS"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                funcionario.setEmail(rs.getString("EMAIL"));
            }
            rs.close();

            return funcionario;
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao buscar um funcionario pelo nome");
        }
    }
}
