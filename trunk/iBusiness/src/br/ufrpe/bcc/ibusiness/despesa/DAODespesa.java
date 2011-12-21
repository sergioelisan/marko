package br.ufrpe.bcc.ibusiness.despesa;

import java.sql.*;
import br.ufrpe.bcc.ibusiness.database.Conexao;
import br.ufrpe.bcc.ibusiness.database.DAOUtil;
import java.util.*;

/**
 *
 * @author Douglas Henrique e Francisco Fernandes
 */
public class DAODespesa implements IDespesa {

    /**
     * Atributo de conexão
     */
    private Connection conexao7;

    public DAODespesa() {
        try {
            this.conexao7 = new Conexao().conectar();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Adiciona uma Despesa
     * @param despesa
     */
    public void inserirDespesa(Despesa despesa) {
        String sql = DAOUtil.getQuery("despesa.insert");
        try (PreparedStatement stmt = conexao7.prepareStatement(sql)) {
            stmt.setInt(1, despesa.getId());
            stmt.setString(2, despesa.getDescricao());
            stmt.setString(3, despesa.getCredor());
            stmt.setDouble(4, despesa.getValor());

            java.util.Date utilDate = despesa.getLancamento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(5, sqlDate);

            java.util.Date utilDate2 = despesa.getVencimento();
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate.getTime());
            stmt.setDate(6, sqlDate2);

            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao adicionar uma despesa no banco");
        }
    }


    /**
     * Remover uma Despesa
     * @param id
     */
    public void removerDespesa(int id) {
        String sql = DAOUtil.getQuery("despesa.delete");
        try (PreparedStatement stmt = conexao7.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao remover uma despesa no banco");
        }
    }

    /**
     * Altera uma Despesa
     * @param despesa
     */
    public void atualizarDespesa(Despesa despesa) {
        String sql = DAOUtil.getQuery("despesa.update");
        try (PreparedStatement stmt = conexao7.prepareStatement(sql)) {
            stmt.setInt(1, despesa.getId());
            stmt.setString(2, despesa.getDescricao());
            stmt.setString(3, despesa.getCredor());
            stmt.setDouble(4, despesa.getValor());

            java.util.Date utilDate = despesa.getLancamento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(5, sqlDate);

            java.util.Date utilDate2 = despesa.getVencimento();
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate.getTime());
            stmt.setDate(6, sqlDate2);

            stmt.setInt(7, despesa.getId());


            stmt.execute();
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao atualizar despesa");
        }
    }

    /**
     * Lista as Despesas
     * @param 
     */
    public ArrayList<Despesa> listarDespesas() {
        ArrayList<Despesa> despesas = new ArrayList<>();
        String sql = DAOUtil.getQuery("despesa.select");

        try (PreparedStatement stmt = conexao7.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("CODIGO_CONTA"));
                despesa.setDescricao(rs.getString("DESCRICAO"));
                despesa.setCredor(rs.getString("CREDOR"));
                despesa.setValor(rs.getDouble("VALOR"));

                java.sql.Date sqlDate = rs.getDate("LANCAMENTO");
                java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                despesa.setLancamento(utilDate);

                java.sql.Date sqlDate2 = rs.getDate("VENCIMENTO");
                java.util.Date utilDate2 = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                despesa.setLancamento(utilDate2);

                despesas.add(despesa);
            }
            rs.close();

            return despesas;
        } catch (SQLException e) {
            throw DAOUtil.exception(e, "problemas ao listar despesa");
        }
    }

     /**
     * busca uma Despesa
     * @param id 
     */
    public Despesa buscarDespesa(int id) {
        String sql = DAOUtil.getQuery("despesa.buscar");

        try (PreparedStatement stmt = conexao7.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Despesa despesa = new Despesa();

            while (rs.next()) {
                despesa.setId(rs.getInt("CODIGO_CONTA"));
                despesa.setDescricao(rs.getString("DESCRICAO"));
                despesa.setCredor(rs.getString("CREDOR"));
                despesa.setValor(rs.getDouble("VALOR"));

                java.sql.Date sqlDate = rs.getDate("LANCAMENTO");
                java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                despesa.setLancamento(utilDate);

                java.sql.Date sqlDate2 = rs.getDate("VENCIMENTO");
                java.util.Date utilDate2 = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDate());
                despesa.setLancamento(utilDate2);
            }
            rs.close();
            return despesa;

        } catch (SQLException e) {
            throw DAOUtil.exception(e, "Erro ao buscar despesa");
        }
    }
}
