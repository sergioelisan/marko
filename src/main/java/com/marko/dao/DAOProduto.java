package com.marko.dao;

import com.marko.interfaces.IProduto;
import com.marko.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Objeto de acesso aos dados de Produto
 *
 * @author Douglas Henrique e Francisco Fernandes
 */
public class DAOProduto implements IProduto {

    /**
     * atributo de conexao
     */
    private Connection conexao;

    public DAOProduto() {
        this.conexao = new Conexao().conectar();
    }

    /**
     * lista os Produtos do banco
     *
     * @return
     */
    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = DAOUtil.getQuery("produto.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("CODIGO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstocado(rs.getInt("QUANTIDADE"));

                java.sql.Date dataSql = rs.getDate("DATA_DE_COMPRA");
                java.util.Date utilData = new Date(dataSql.getTime());
                produto.setCompra(utilData);

                java.sql.Date dataSql2 = rs.getDate("VENCIMENTO");
                java.util.Date utilData2 = new Date(dataSql2.getTime());
                produto.setVencimento(utilData2);

                produto.setPrecoVenda(rs.getDouble("CUSTO"));
                produto.setPrecoCompra(rs.getDouble("PRECO_DE_VENDA"));

                produtos.add(produto);
            }
            rs.close();

            return produtos;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao listas produtos do banco");
        }
    }

    /**
     * Adiciona um produto ao banco
     *
     * @param produto
     */
    public void inserirProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getEstocado());

            java.util.Date utilDate = produto.getCompra();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(4, sqlDate);

            java.util.Date utilDate2 = produto.getVencimento();
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
            stmt.setDate(5, sqlDate2);
            stmt.setDouble(6, produto.getPrecoCompra());
            stmt.setDouble(7, produto.getPrecoVenda());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao adicionar produto ao banco");
        }
    }

    public void removerProduto(int id) {
        String sql = DAOUtil.getQuery("produto.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao remover um produto no banco");
        }
    }

    /**
     * Altera os produtos do banco
     *
     * @param produto
     */
    public void atualizarProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getEstocado());

            java.util.Date utilDate = produto.getCompra();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(4, sqlDate);

            java.util.Date utilDate2 = produto.getVencimento();
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
            stmt.setDate(5, sqlDate2);
            stmt.setDouble(6, produto.getPrecoCompra());
            stmt.setDouble(7, produto.getPrecoVenda());
            stmt.setInt(8, produto.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao alterar um produto no banco");
        }
    }

    public Produto buscarProdutoID(int id) {
        String sql = DAOUtil.getQuery("produto.codigo");
        Produto produto = new Produto();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("Codigo"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstocado(rs.getInt("QUANTIDADE"));

                java.sql.Date dataSql = rs.getDate("DATA_DE_COMPRA");
                java.util.Date utilData = new Date(dataSql.getTime());
                produto.setCompra(utilData);

                java.sql.Date dataSql2 = rs.getDate("VENCIMENTO");
                java.util.Date utilData2 = new Date(dataSql2.getTime());
                produto.setVencimento(utilData2);
                produto.setPrecoCompra(rs.getDouble("PRECO_DE_VENDA"));
                produto.setPrecoVenda(rs.getDouble("CUSTO"));
            }

            rs.close();
            return produto;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar produto pelo id");
        }
    }

    public Produto buscarProdutoNome(String nome) {
        String sql = DAOUtil.getQuery("produto.nome");
        Produto produto = new Produto();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("Codigo"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstocado(rs.getInt("QUANTIDADE"));

                java.sql.Date dataSql = rs.getDate("DATA_DE_COMPRA");
                java.util.Date utilData = new Date(dataSql.getTime());
                produto.setCompra(utilData);

                java.sql.Date dataSql2 = rs.getDate("VENCIMENTO");
                java.util.Date utilData2 = new Date(dataSql2.getTime());
                produto.setVencimento(utilData2);
                produto.setPrecoCompra(rs.getDouble("PRECO_DE_VENDA"));
                produto.setPrecoVenda(rs.getDouble("CUSTO"));
            }

            rs.close();
            return produto;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar produto pelo nome");
        }
    }
}
