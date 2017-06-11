/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.business;

import com.marko.dao.DAOVenda;
import com.marko.interfaces.IVenda;
import com.marko.model.Venda;

import java.util.ArrayList;

/**
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
    public ArrayList<Venda> buscarVendaCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Venda> buscarVendaFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
