package br.ufrpe.bcc.ibusiness.produto;

import br.ufrpe.bcc.ibusiness.database.Conexao;
import br.ufrpe.bcc.ibusiness.database.DAOUtil;
import java.util.*;
import java.sql.*;

/**
 * Objeto de acesso aos dados de Produto
 * 
 * @author Douglas Henrique e Francisco Fernandes
 */
class DAOProduto implements IProduto{

    private Connection conexao;

    public DAOProduto() {
        try {
            this.conexao = new Conexao().conectar();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * lista os produtos do banco
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
                produto.setCompra(rs.getDate("DATA_DE_COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getDouble("PRECO_DE_VENDA"));
                produto.setPrecoVenda(rs.getDouble("PRECO_DE_COMPRA"));
                                
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
     * @param produto
     */
    public void inserirProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(4, produto.getEstocado());
            
            java.util.Date utilDataCompra = produto.getCompra();
            java.sql.Date sqlDataCompra = new java.sql.Date(utilDataCompra.getTime());
            stmt.setDate(5, sqlDataCompra);
            
            java.util.Date utilDataVencimento = produto.getVencimento();
            java.sql.Date sqlDataVencimento = new java.sql.Date(utilDataVencimento.getTime());
            stmt.setDate(6, sqlDataVencimento);
            
            stmt.setDouble(7, produto.getPrecoCompra());
            stmt.setDouble(8, produto.getPrecoVenda());
            
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
     * Atualiza Produto do banco
     * @param produto 
     */
    public void atualizarProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(4, produto.getEstocado());
            java.util.Date utilDataCompra = produto.getCompra();
            java.sql.Date sqlDataCompra = new java.sql.Date(utilDataCompra.getTime());
            stmt.setDate(5, sqlDataCompra);
            
            java.util.Date utilDataVencimento = produto.getVencimento();
            java.sql.Date sqlDataVencimento = new java.sql.Date(utilDataVencimento.getTime());
            stmt.setDate(6, sqlDataVencimento);
            
            stmt.setDouble(7, produto.getPrecoCompra());
            stmt.setDouble(8, produto.getPrecoVenda());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao alterar um produto no banco");
        }
    }

    /**
     * Buscar produto pelo Id
     * @param id
     */
    public Produto buscarProdutoID(int id) {
        String sql = DAOUtil.getQuery("produto.codigo");
        Produto produto = new Produto();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("CODIGO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstocado(rs.getInt("QUANTIDADE"));
                produto.setCompra(rs.getDate("DATA_DE_COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getDouble("PRECO_DE_VENDA"));
                produto.setPrecoVenda(rs.getDouble("PRECO_DE_COMPRA"));
            }
            
            rs.close();
            return produto;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar produto pelo id");
        }
    }
   
    /**
     * Buscar produto pelo string
     * @param nome
     */
    
    public Produto buscarProdutoNome(String nome) {
        String sql = DAOUtil.getQuery("produto.nome");
        Produto produto = new Produto();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("CODIGO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstocado(rs.getInt("ESTOCADO"));
                produto.setCompra(rs.getDate("COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getDouble("PRECO_VENDA"));
                produto.setPrecoVenda(rs.getDouble("PRECO_COMPRA"));
            }
            
            rs.close();
            return produto;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar produto pelo nome");
        }
    }
}