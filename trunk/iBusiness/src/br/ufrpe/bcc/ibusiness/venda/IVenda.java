package br.ufrpe.bcc.ibusiness.venda;

import java.util.List;

/**
 *
 * @author Wolf
 */
public interface IVenda {
     
    void submeterVenda(Venda venda) throws Exception;
     
     List<Venda> listarVendas(); 
     
     Venda buscarVenda(int id);
     
     List<Venda> buscarVendaFuncionario(int id);
     
     List<Venda> buscarVendaCliente(int id);
}
