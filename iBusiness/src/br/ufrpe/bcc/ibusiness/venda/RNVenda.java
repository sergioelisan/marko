/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.venda;

import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import java.util.List;

/**
 *
 * @author Wolf
 */
public class RNVenda implements IVenda {

    @Override
    public void submeterVenda(Venda venda) throws Exception {
        if (venda.getHorario() != null) {
            if (venda.getCliente() != null) {
                if (venda.getItem() != null) {
                    DAOVenda dao = new DAOVenda();
                    dao.submeterVenda(venda);
                } else {
                    throw new Exception("O item informado é inválido.");
                }
            } else {
                throw new Exception("O cliente informado é inválido.");
            }
        } else {
            throw new Exception("O horário informado é inválido.");
        }
    }

    @Override
    public List<Venda> listarVendas() {
        DAOVenda dao = new DAOVenda();
        return dao.listarVendas();
    }

    @Override
    public Venda buscarVenda(int id) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVenda(id);
    }

    @Override
    public List<Venda> buscarVendaFuncionario(int id) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVendaFuncionario(id);
    }

    @Override
    public List<Venda> buscarVendaCliente(int id) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVendaCliente(id);
    }
}
