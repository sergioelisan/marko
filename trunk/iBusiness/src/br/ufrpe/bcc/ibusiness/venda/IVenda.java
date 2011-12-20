package br.ufrpe.bcc.ibusiness.venda;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public interface IVenda {

    public void inserirVenda(Venda venda) throws Exception;

    public ArrayList<Venda> listarVendas();

    public ArrayList<Venda> buscarVendaId(int id);

    public ArrayList<Venda> buscarVendaUsuario(int id);

    public ArrayList<Venda> buscarVendaFuncionario(int id);
}
