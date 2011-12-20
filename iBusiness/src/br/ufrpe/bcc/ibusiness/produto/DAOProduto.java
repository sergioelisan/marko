/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.produto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Wolf
 */
class DAOProduto implements IProduto{

    private Connection conexao;

    public DAOFornecedor() throws ClassNotFoundException {
        this.conexao = new Conexao().conectar();
    }

    /**
     * lista os fornecedores do banco
     * @return 
     */
    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = DAOUtil.getQuery("produto.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setFornecedor(new Fornecedor(rs.getInt("FORNECEDOR")) );
                produto.setEstocado(rs.getInt("ESTOCADO"));
                produto.setCompra(rs.getDate("DATA_DE_COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getDouble("CUSTO"));
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
     * @param fornecedor 
     */
    public void inserirProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getFornecedor().getId());
            stmt.setInt(4, produto.getEstocado());
            stmt.setDate(5, produto.getCompra());
            stmt.setDate(6, produto.getVencimento());
            stmt.setDouble(7, produto.getPrecoCompra());
            stmt.setDouble(8, produto.getPrecoVenda());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao adicionar produto ao banco");
        }
    }

    public void removerProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.delete");
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao remover um produto no banco");
        }
    }

    /**
     * Altera os fornecedores do banco
     * @param fornecedor 
     */
    public void updateProduto(Produto produto) {
        String sql = DAOUtil.getQuery("produto.update");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getFornecedor().getId());
            stmt.setInt(4, produto.getEstocado());
            stmt.setDate(5, produto.getCompra());
            stmt.setDate(6, produto.getVencimento());
            stmt.setDouble(7, produto.getPrecoCompra());
            stmt.setDouble(8, produto.getPrecoVenda());
            stmt.setlONG(9, produto.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao alterar um produto no banco");
        }
    }



    public Produto buscaProduto(Int id) {
        String sql = DAOUtil.getQuery("produto.codigo");
        Produto produto = new Produto();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("RAZAO_SOCIAL"));
                produto.setFornecedor(new Fornecedor(rs.getInt("FORNECEDOR")) );
                produto.setEstocado(rs.getInt("ESTOCADO"));
                produto.setCompra(rs.getDate("DATA_DE_COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getDouble("CUSTO"));
                produto.setPrecoVenda(rs.getDouble("PRECO_DE_VENDA"));               
            }
            
            rs.close();
            return produto;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar produto pelo id");
        }
    }

    @Override
    public ArrayList<Produto> buscaProdutosNome(String nome) {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = DAOUtil.getQuery("produto.NOME");
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("RAZAO_SOCIAL"));
                produto.setFornecedor(new Fornecedor(rs.getInt("FORNECEDOR")) );
                produto.setEstocado(rs.getInt("ESTOCADO"));
                produto.setDisponivel(rs.getInt("DISPONIVEL"));
                produto.setCompra(rs.getDate("COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getInt("PRECO_VENDA"));
                produto.setPrecoVenda(rs.getInt("PRECO_COMPRA"));  
                
                produtos.add(produto);
            }
            
            rs.close();
            return produtos;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao buscar produto pelo nome");
        }
    }
    
}
