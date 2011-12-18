package br.ufrpe.bcc.idatabase.dao;

import br.ufrpe.bcc.businesscore.entidades.CNPJ;
import br.ufrpe.bcc.businesscore.entidades.Fornecedor;
import br.ufrpe.bcc.idatabase.conexao.Conexao;
import java.sql.*;
import java.util.*;

/**
 * Objeto de acesso aos dados de Fornecedores
 * @author douglas
 */
public class DaoFornecedor {

    private Connection conexao;

    public DaoFornecedor() throws ClassNotFoundException {
        this.conexao = new Conexao().conectar();
    }

    /**
     * Adiciona um fornecedor ao banco
     * @param fornecedor 
     */
    public void addFornecedor(Fornecedor fornecedor) {
        String sql = DaoUtil.getQuery("fornecedor.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getRazao());
            stmt.setString(2, fornecedor.getCnpj().getCNPJ());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getFone());
            stmt.setString(5, fornecedor.getFax());
            stmt.setString(6, fornecedor.getRepresentante());
            stmt.execute();

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao adicionar fornecedor ao banco");
        }
    }

    /**
     * lista os fornecedores do banco
     * @return 
     */
    public List<Fornecedor> listarFornecedor() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = DaoUtil.getQuery("fornecedor.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getLong("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(new CNPJ(rs.getString("CNPJ")) );
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));

                fornecedores.add(fornecedor);
            }
            rs.close();

            return fornecedores;
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao listas funcionarios do banco");
        }
    }

    /**
     * Altera os fornecedores do banco
     * @param fornecedor 
     */
    public void updateFornecedor(Fornecedor fornecedor) {
        String sql = DaoUtil.getQuery("fornecedor.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getRazao());
            stmt.setString(2, fornecedor.getCnpj().getCNPJ());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getFone());
            stmt.setString(5, fornecedor.getFax());
            stmt.setString(6, fornecedor.getRepresentante());
            stmt.setLong(7, fornecedor.getId());

            stmt.execute();

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao alterar um fornecedor no banco");
        }
    }

    /**
     * Remove um fornecedor do banco
     * @param fornecedor 
     */
    public void rmFornecedor(Fornecedor fornecedor) {
        String sql = DaoUtil.getQuery("fornecedor.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, fornecedor.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao remover um fornecedor");
        }
    }

    /**
     * Busca um fornecedor pelo cnpj
     * @param cnpj
     * @return 
     */
    public Fornecedor buscaFornecedor(CNPJ cnpj) {
        String sql = DaoUtil.getQuery("fornecedor.cnpj");
        Fornecedor fornecedor = new Fornecedor();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cnpj.getCNPJ());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornecedor.setId(rs.getLong("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(new CNPJ(rs.getString("CNPJ")) );
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));
            }

            rs.close();
            return fornecedor;

        } catch (SQLException e) {
            throw DaoUtil.exception(e, "Problemas ao buscar um fornecedor pelo cnpj");
        }
    }

    /**
     * busca fornecedores pelo nome
     * @param nome
     * @return 
     */
    public Fornecedor buscaFornecedor(String nome) {
        String sql = DaoUtil.getQuery("fornecedor.nome");
        Fornecedor fornecedor = new Fornecedor();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornecedor.setId(rs.getLong("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(new CNPJ(rs.getString("CNPJ")) );
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));                
            }
            
            rs.close();
            return fornecedor;
        } catch (SQLException e) {
            throw DaoUtil.exception(e, "problemas ao buscar fornecedor pelo nome");
        }
    }
}
