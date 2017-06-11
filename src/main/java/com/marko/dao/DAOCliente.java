package com.marko.dao;

import com.marko.interfaces.ICliente;
import com.marko.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Objeto de acesso aos dados de clientes
 *
 * @author Douglas Henrique e Francisco Fernandes
 */
public class DAOCliente implements ICliente {

    /**
     * Atributo de conexão
     */
    private Connection conexao;

    public DAOCliente() {
        this.conexao = new Conexao().conectar();
    }

    /**
     * Adiciona um cliente
     */
    public void inserirCliente(Cliente cliente) throws Exception {
        String sql = DAOUtil.getQuery("cliente.insert");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCelular());
            stmt.setString(6, cliente.getEmail());
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao adicionar um cliente ao banco");
        }
    }

    /**
     * Lista os clientes do banco
     *
     * @return
     */
    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = DAOUtil.getQuery("cliente.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setTelefone(rs.getString("FONE"));
                cliente.setCelular(rs.getString("CEL"));
                cliente.setEmail(rs.getString("EMAIL"));
                clientes.add(cliente);
            }
            rs.close();

            return clientes;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao listar clientes");
        }
    }

    /**
     * Alterar clientes
     */
    public void atualizarCliente(Cliente cliente) {
        String sql = DAOUtil.getQuery("cliente.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCelular());
            stmt.setString(6, cliente.getEmail());
            stmt.setLong(7, cliente.getId());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Remover clientes
     */
    public void removerCliente(int id) {
        String sql = DAOUtil.getQuery("cliente.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca Clientes por cpf
     */
    public Cliente buscarClienteCPF(String cpf) {
        String sql = DAOUtil.getQuery("cliente.cpf");
        Cliente cliente = new Cliente();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setTelefone(rs.getString("FONE"));
                cliente.setCelular(rs.getString("CEL"));
                cliente.setEmail(rs.getString("EMAIL"));
            }
            rs.close();
            return cliente;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar cliente pelo cpf");
        }
    }

    /**
     * Busca Clientes por nome
     */
    public Cliente buscarClienteNome(String nome) {
        String sql = DAOUtil.getQuery("cliente.nome");
        Cliente cliente = new Cliente();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setTelefone(rs.getString("FONE"));
                cliente.setCelular(rs.getString("CEL"));
                cliente.setEmail(rs.getString("EMAIL"));
            }
            rs.close();
            return cliente;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar cliente pelo nome");
        }
    }
}
