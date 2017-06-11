/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.interfaces;

import com.marko.model.Despesa;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface IDespesa {

    void inserirDespesa(Despesa despesa) throws Exception;

    void removerDespesa(int id);

    void atualizarDespesa(Despesa despesa) throws Exception;

    ArrayList<Despesa> listarDespesas();

    Despesa buscarDespesa(int id);
}
