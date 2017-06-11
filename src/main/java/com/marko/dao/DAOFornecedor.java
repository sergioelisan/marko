package com.marko.dao;


import com.marko.interfaces.IFornecedor;
import com.marko.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Objeto de acesso aos dados de Fornecedores
 *
 * @author Douglas Henrique e Francisco Fernandes
 */
public class DAOFornecedor implements IFornecedor {
    /**
     * atributo de conexao
     */
    private Connection conexao;

    public DAOFornecedor() throws ClassNotFoundException {
        this.conexao = new Conexao().conectar();
    }

    /**
     * Adiciona um fornecedor ao banco
     *
     * @param fornecedor
     */
    public void inserirFornecedor(Fornecedor fornecedor) {
        String sql = DAOUtil.getQuery("fornecedor.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getRazao());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getFone());
            stmt.setString(5, fornecedor.getFax());
            stmt.setString(6, fornecedor.getRepresentante());
            stmt.execute();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao adicionar fornecedor ao banco");
        }
    }

    /**
     * lista os fornecedores do banco
     *
     * @return
     */
    public ArrayList<Fornecedor> listarFornecedores() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = DAOUtil.getQuery("fornecedor.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));

                fornecedores.add(fornecedor);
            }
            rs.close();

            return fornecedores;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao listar funcionarios do banco");
        }
    }

    /**
     * Altera os fornecedores do banco
     *
     * @param fornecedor
     */
    public void atualizarFornecedor(Fornecedor fornecedor) {
        String sql = DAOUtil.getQuery("fornecedor.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getRazao());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getFone());
            stmt.setString(5, fornecedor.getFax());
            stmt.setString(6, fornecedor.getRepresentante());
            stmt.setLong(7, fornecedor.getId());

            stmt.execute();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao atualizar um fornecedor no banco");
        }
    }

    /**
     * Remove um fornecedor do banco
     *
     * @param fornecedor
     */
    public void removerFornecedor(int id) {
        String sql = DAOUtil.getQuery("fornecedor.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao remover um fornecedor");
        }
    }

    /**
     * Busca um fornecedor pelo cnpj
     *
     * @param cnpj
     * @return
     */
    public Fornecedor buscarFornecedorCNPJ(String cnpj) {
        String sql = DAOUtil.getQuery("fornecedor.cnpj");
        Fornecedor fornecedor = new Fornecedor();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornecedor.setId(rs.getInt("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));
            }

            rs.close();
            return fornecedor;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao buscar um fornecedor pelo cnpj");
        }
    }

    /**
     * busca fornecedores pelo nome
     *
     * @param nome
     * @return
     */
    public Fornecedor buscarFornecedorRazao(String nome) {
        String sql = DAOUtil.getQuery("fornecedor.nome");
        Fornecedor fornecedor = new Fornecedor();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornecedor.setId(rs.getInt("CODIGO"));
                fornecedor.setRazao(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setEndereco(rs.getString("ENDERECO"));
                fornecedor.setFone(rs.getString("FONE"));
                fornecedor.setFax(rs.getString("FAX"));
                fornecedor.setRepresentante(rs.getString("REPRESENTANTE"));
            }

            rs.close();
            return fornecedor;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar fornecedor pelo nome");
        }
    }
}