package br.ufrpe.bcc.ibusiness.venda;

import br.ufrpe.bcc.ibusiness.cliente.*;
import br.ufrpe.bcc.ibusiness.funcionario.*;
import br.ufrpe.bcc.ibusiness.database.Conexao;
import br.ufrpe.bcc.ibusiness.database.DAOUtil;
import br.ufrpe.bcc.ibusiness.item.Item;
import br.ufrpe.bcc.ibusiness.produto.Produto;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Douglas Hnrique e Francisco Fernandes
 */
public class DAOVenda implements IVenda {

    /**
     * Atributo de conexao
     */
    private Connection conexao;

    public DAOVenda() {
            this.conexao = new Conexao().conectar();

        
    }

    /**
     * Insere uma venda no banco
     * @param venda 
     */
    public void inserirVenda(Venda venda) {
        String sql = DAOUtil.getQuery("venda.insert");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, venda.getCliente().getId());
            stmt.setInt(2, venda.getFuncionario().getId());

            java.util.Date utilDate = venda.getHorario();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(3, sqlDate);

            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao adicionar venda ao banco");
        }
    }

    /**
     * Lista as vendas do banco
     * @param  
     */
    public ArrayList<Venda> listarVendas() {
        ArrayList<Venda> Vendas = new ArrayList<>();
        String sql = DAOUtil.getQuery("venda.select");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();
                cliente.setId(rs.getInt("CLIENTE"));
                funcionario.setId(rs.getInt("VENDEDOR"));

                java.util.Date utilDate = rs.getDate("HORARIO");
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                ArrayList<Item> itens = this.listarItens(rs.getInt("CODIGO_VENDA"));

                venda.setItens(itens);
                venda.setCliente(cliente);
                venda.setFuncionario(funcionario);
                venda.setHorario(utilDate);
                venda.setId(rs.getInt("CODIGO_VENDA"));
                Vendas.add(venda);
            }
            rs.close();
            return Vendas;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Problemas ao Listar Vendas");
        }

    }

    /**
     * busca uma venda no banco pelo codigo
     * @param codigo 
     */
    public Venda buscarVendaId(int codigo) {
        String sql = DAOUtil.getQuery("venda.codigo");

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            Venda venda = new Venda();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();
                cliente.setId(rs.getInt("CLIENTE"));
                funcionario.setId(rs.getInt("VENDEDOR"));

                java.util.Date utilDate = rs.getDate("HORARIO");
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                ArrayList<Item> itens = this.listarItens(rs.getInt("CODIGO_VENDA"));

                venda.setItens(itens);
                venda.setCliente(cliente);
                venda.setFuncionario(funcionario);
                venda.setHorario(utilDate);
                venda.setId(rs.getInt("CODIGO_VENDA"));
            }
            rs.close();
            return venda;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao buscar Venda pelo codigo");
        }
    }

    /**
     * busca uma venda pelo id do funcionario
     * @param id 
     */
    public ArrayList<Venda> buscarVendaFuncionario(int id) {
        String sql = DAOUtil.getQuery("venda.usuario");
        ArrayList<Venda> Vendas = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();
                cliente.setId(rs.getInt("CLIENTE"));
                funcionario.setId(rs.getInt("VENDEDOR"));

                java.util.Date utilDate = rs.getDate("HORARIO");
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                ArrayList<Item> itens = this.listarItens(rs.getInt("CODIGO_VENDA"));

                venda.setItens(itens);
                venda.setCliente(cliente);
                venda.setFuncionario(funcionario);
                venda.setHorario(utilDate);
                venda.setId(rs.getInt("CODIGO_VENDA"));
                Vendas.add(venda);
            }
            rs.close();
            return Vendas;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao buscar Vendas pelo codigo do funcionario");
        }
    }

    /**
     * busca uma venda pelo id do cliente
     * @param id 
     */
    public ArrayList<Venda> buscarVendaCliente(int id) {
        String sql = DAOUtil.getQuery("venda.cliente");
        ArrayList<Venda> Vendas = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();
                cliente.setId(rs.getInt("CLIENTE"));
                funcionario.setId(rs.getInt("VENDEDOR"));

                java.util.Date utilDate = rs.getDate("HORARIO");
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                ArrayList<Item> itens = this.listarItens(rs.getInt("CODIGO_VENDA"));

                venda.setItens(itens);
                venda.setCliente(cliente);
                venda.setFuncionario(funcionario);
                venda.setHorario(utilDate);
                venda.setId(rs.getInt("CODIGO_VENDA"));
                Vendas.add(venda);
            }
            rs.close();
            return Vendas;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao buscar Vendas pelo codigo do Cliente");
        }
    }

    /**
     * retorna todos os itens de uma venda
     * @param id 
     */
    public ArrayList<Item> listarItens(int id) {

        String sql = DAOUtil.getQuery("venda.listarItens");
        ArrayList<Item> Itens = new ArrayList<Item>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Item item = new Item();

                String sql2 = DAOUtil.getQuery("venda.criaProdutos");
                PreparedStatement stmt2 = conexao.prepareStatement(sql);
                stmt2.setInt(1, rs.getInt("CODIGO_PRODUTO"));
                ResultSet rs2 = stmt.executeQuery();

                while (rs2.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs2.getInt("CODIGO"));
                    produto.setNome(rs2.getString("NOME"));
                    produto.setDescricao(rs2.getString("DESCRICAO"));
                    produto.setEstocado(rs2.getInt("QUANTIDADE"));
                    java.sql.Date dataSql = rs2.getDate("DATA_DE_COMPRA");
                    java.util.Date utilData = new Date(dataSql.getTime());
                    produto.setCompra(utilData);
                    java.sql.Date dataSql2 = rs2.getDate("VENCIMENTO");
                    java.util.Date utilData2 = new Date(dataSql2.getTime());
                    produto.setVencimento(utilData);
                    produto.setPrecoCompra(rs2.getDouble("CUSTO"));
                    produto.setPrecoCompra(rs2.getDouble("PRECO_DE_VENDA"));

                    item.setProduto(produto);
                }
                stmt2.close();
                rs2.close();
                item.setQuantidade(rs.getInt("QUANTIDADE"));
                Itens.add(item);
            }

            rs.close();
            return Itens;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao Listar os Itens pelo metodo listar itens");
        }
    }
    
    /**
     * neste metodo inserimos todos intens de uma venda no banco
     * @param venda 
     */
    public void inserirItens(Venda venda) {
        String sql = DAOUtil.getQuery("venda.insereItens");

        for (int i = 0; venda.getItens().size() < i; i++) {
            PreparedStatement stmt;
            try {
                stmt = conexao.prepareStatement(sql);

                stmt.setInt(1, venda.getId());
                stmt.setInt(2, venda.getItens().get(i).getProduto().getId());
                stmt.setString(3, venda.getItens().get(i).getProduto().getDescricao());
                stmt.setInt(4, venda.getItens().get(i).getProduto().getEstocado());
                stmt.setDouble(2, venda.getItens().get(i).getProduto().getPrecoVenda());
                stmt.setDouble(2, venda.getItens().get(i).getProduto().getPrecoVenda() * venda.getItens().get(i).getProduto().getEstocado());
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw DAOUtil.exception(e, "Erro ao inserir itens na tabela itens_pedido");
            }
        }

    }

    public void atualizaEstoque(Venda venda){
        String sql = DAOUtil.getQuery("venda.atualizaEstq");
        String sql2 = DAOUtil.getQuery("produto.codigo");

        for (int i = 0; venda.getItens().size() < i; i++) {
            PreparedStatement stmt;
            PreparedStatement stmt2;
            try {
                stmt = conexao.prepareStatement(sql);
                stmt2 = conexao.prepareStatement(sql2);
                stmt2.setInt(1, venda.getItens().get(i).getProduto().getId());
                ResultSet rs = stmt2.executeQuery();
                while (rs.next()){
                int total_atual=rs.getInt("QUANTIDADE")-venda.getItens().get(i).getQuantidade();
                stmt.setInt(1, total_atual);
                }
                stmt.execute();
                stmt.close();
                rs.close();
                stmt2.close();
            } catch (SQLException e) {
                throw DAOUtil.exception(e, "Erro ao inserir itens na tabela itens_pedido");
            }
        }
    }

}