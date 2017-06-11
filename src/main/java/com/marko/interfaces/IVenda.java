package com.marko.interfaces;

import com.marko.model.Venda;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface IVenda {

    void inserirVenda(Venda venda) throws Exception;

    ArrayList<Venda> listarVendas();

    Venda buscarVendaId(int id);

    ArrayList<Venda> buscarVendaCliente(int id);

    ArrayList<Venda> buscarVendaFuncionario(int id);
}
