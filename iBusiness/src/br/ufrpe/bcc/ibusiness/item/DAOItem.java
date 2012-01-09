package br.ufrpe.bcc.ibusiness.item;
import br.ufrpe.bcc.ibusiness.database.Conexao;
import br.ufrpe.bcc.ibusiness.database.DAOUtil;
import br.ufrpe.bcc.ibusiness.produto.Produto;
import java.util.*;
import java.sql.*;


/**
 *
 * @author Wolf
 */
public class DAOItem implements IItem{

    private Connection conexao;

    public DAOItem() {
        this.conexao = new Conexao().conectar();
    }
    /**
     * Lista todos os itens da base
     * @return uma lista com todos os funcionarios
     */
    public ArrayList<Item> listarItens() {
        ArrayList<Item> itens = new ArrayList<>();
        String sql = DAOUtil.getQuery("item.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setQuantidade(rs.getInt("QUANTIDADE"));
                
                Produto produto = new Produto();
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstocado(rs.getInt("QUANTIDADE"));
                produto.setCompra(rs.getDate("DATA_DE_COMPRA"));
                produto.setVencimento(rs.getDate("VENCIMENTO"));
                produto.setPrecoCompra(rs.getInt("VALOR_UNITARIO"));
                produto.setPrecoVenda(rs.getInt("PRECO_DE_VENDA"));   
                produto.setId(rs.getInt("CODIGO"));
                
                item.setProduto(produto);
                itens.add(item);
            }

            rs.close();
            return itens;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao listar os funcionarios");
        }
    }

    @Override
    public void inserirItem(Item item) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}