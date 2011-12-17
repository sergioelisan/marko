package br.bcc.ufrpe.idatabase.dao;

import br.bcc.ufrpe.businesscore.entidades.*;
import br.bcc.ufrpe.idatabase.conexao.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author douglas
 */
public class DaoVendas {

    private Connection conexao5;

    public DaoVendas() throws ClassNotFoundException {
        this.conexao5 = new Conexao().conectar();
    }

    public void submeterVenda(Venda venda) {
        String sql = DaoUtil.getQuery("venda.insert");

        try (PreparedStatement stmt = conexao5.prepareStatement(sql)) {
            stmt.setString(1, venda.getCliente().getNome());
            stmt.setString(2, venda.getUsuario().getFuncionario().getNome());

            java.util.Date utilDate = venda.getHorario();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(3, sqlDate);

            stmt.execute();
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao adicionar fornecedor ao banco");
        }

    }

    public List<Venda> listarVendas() {
        List<Venda> Vendas = new ArrayList<>();
        String sql = DaoUtil.getQuery("venda.select");

        try (PreparedStatement stmt = conexao5.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                Cliente cliente = new Cliente();
                Usuario usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("VENDEDOR"));
                usuario.setFuncionario(funcionario);
                cliente.setNome(rs.getString("CLIENTE"));
                java.sql.Date sqlDate = rs.getDate("HORARIO");  // import java.util.Date;  
                java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                venda.setId(rs.getLong("CODIGO_VENDA"));
                venda.setCliente(cliente);
                venda.setUsuario(usuario);
                venda.setHorario(utilDate);
                Vendas.add(venda);
            }
            rs.close();
            return Vendas;
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao cadastrar funcionario");
        }
    }

    public Venda buscarVenda(Integer codigo) {
        String sql = DaoUtil.getQuery("venda.codigo");

        try (PreparedStatement stmt = conexao5.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            Venda venda = new Venda();

            while (rs.next()) {
                venda.setId(rs.getLong("CODIGO"));
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("CLIENTE"));
                venda.setCliente(cliente);
                Usuario usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("VENDEDOR"));
                usuario.setFuncionario(funcionario);
                venda.setUsuario(usuario);
                java.sql.Date sqlDate = rs.getDate("HORARIO");  // import java.util.Date;  
                java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                venda.setHorario(utilDate);
            }
            rs.close();
            return venda;

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Erro ao buscar pelo login do usuario");
        }
    }

    public List<Venda> buscarVenda(Usuario usuario) {
        String sql = DaoUtil.getQuery("venda.usuario");
        List<Venda> Vendas = new ArrayList<>();

        try (PreparedStatement stmt = conexao5.prepareStatement(sql)) {
            stmt.setString(1, usuario.getFuncionario().getNome());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getLong("CODIGO"));
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("CLIENTE"));
                venda.setCliente(cliente);
                venda.setUsuario(usuario);
                java.sql.Date sqlDate = rs.getDate("HORARIO");  // import java.util.Date;  
                java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                venda.setHorario(utilDate);
                Vendas.add(venda);
            }
            rs.close();
            return Vendas;

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Erro ao buscar pelo login do usuario");
        }

    }

    public List<Venda> buscarVenda(Cliente cliente){
       String sql = DaoUtil.getQuery("venda.cliente");
        List<Venda> Vendas = new ArrayList<>();

        try (PreparedStatement stmt = conexao5.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getLong("CODIGO"));
                venda.setCliente(cliente);
                Usuario usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("VENDEDOR"));
                usuario.setFuncionario(funcionario);
                venda.setUsuario(usuario);
                venda.setUsuario(usuario);
                java.sql.Date sqlDate = rs.getDate("HORARIO");  // import java.util.Date;  
                java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                venda.setHorario(utilDate);
                Vendas.add(venda);
            }
            rs.close();
            return Vendas;

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Erro ao buscar pelo login do usuario");
        }   
    }
}
