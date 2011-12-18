package br.ufrpe.bcc.ibusiness.cliente;

import java.sql.*;
import br.ufrpe.bcc.ibusiness.util.CPF;
import br.ufrpe.bcc.idatabase.Conexao;
import br.ufrpe.bcc.idatabase.DAOUtil;
import java.util.*;

/**
 * Objeto de acesso aos dados de clientes
 * @author douglas
 */
public class DAOCliente implements ICliente {

    private Connection conexao;

    public DAOCliente() {
        try {
            this.conexao = new Conexao().conectar();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Adiciona um cliente
     * @param cliente 
     */
    public void addCliente(Cliente cliente) throws Exception {
        String sql = DAOUtil.getQuery("cliente.insert");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf().getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getFone());
            stmt.setString(5, cliente.getEmail());
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao adicionar um cliente ao banco");
        }
    }

    /**
     * Lista os clientes do banco
     * @return 
     */
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = DAOUtil.getQuery("cliente.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(new CPF(rs.getString("CPF")));
                cliente.setEndereco(rs.getString("ENDE"));
                cliente.setFone(rs.getString("FONE"));
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
     * @param cliente 
     */
    public void updateCliente(Cliente cliente) {
        String sql = DAOUtil.getQuery("cliente.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf().getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getFone());
            stmt.setString(5, cliente.getEmail());
            stmt.setLong(6, cliente.getId());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rmCliente(Cliente cliente) {
        String sql = DAOUtil.getQuery("cliente.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, cliente.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente buscaCliente(CPF cpf) {
        String sql = DAOUtil.getQuery("cliente.cpf");
        Cliente cliente = new Cliente();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getLong("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(new CPF(rs.getString("CPF")));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setFone(rs.getString("FONE"));
                cliente.setEmail(rs.getString("EMAIL"));
            }
            rs.close();
            return cliente;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar cliente pelo cpf");
        }
    }

    public Cliente buscaCliente(String nome) {
        String sql = DAOUtil.getQuery("cliente.nome");
        Cliente cliente = new Cliente();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getLong("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(new CPF(rs.getString("CPF")));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setFone(rs.getString("FONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                rs.close();
            }
            return cliente;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar cliente pelo nome");
        }
    }
    
}
