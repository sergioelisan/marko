package br.ufrpe.bcc.ibusiness.venda;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public interface IVenda {

    public void inserirVenda(Venda venda) throws Exception;

    public ArrayList<Venda> listarVendas();

    public Venda buscarVendaId(int id);

    public ArrayList<Venda> buscarVendaCliente(int id);

    public ArrayList<Venda> buscarVendaFuncionario(int id);
}
