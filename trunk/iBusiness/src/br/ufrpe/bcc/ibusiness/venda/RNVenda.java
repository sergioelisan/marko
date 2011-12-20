/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.venda;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public class RNVenda implements IVenda {

    @Override
    public void inserirVenda(Venda venda) throws Exception {
        if (venda.getHorario() != null) {
            if (venda.getCliente() != null) {
                if (venda.getItens().size() > 0) {
                    if (venda.getFuncionario() != null) {
                        DAOVenda dao = new DAOVenda();
                        dao.inserirVenda(venda);
                    } else {
                        throw new Exception("O funcionário informado é inválido.");
                    }
                } else {
                    throw new Exception("A lista de vendas não pode estar vazia.");
                }
            } else {
                throw new Exception("O cliente informado é inválido.");
            }
        } else {
            throw new Exception("O horário informado é inválido.");
        }
    }

    @Override
    public ArrayList<Venda> listarVendas() {
        DAOVenda dao = new DAOVenda();
        return dao.listarVendas();
    }

    @Override
    public Venda buscarVendaId(int id) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVendaId(id);
    }

    @Override
    public Venda buscarVendaFuncionario(int id) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVendaFuncionario(id);
    }

    @Override
    public Venda buscarVendaCliente(int id) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVendaCliente(id);
    }
}
