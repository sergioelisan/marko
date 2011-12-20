/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.despesa;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public interface IDespesa {

    public void inserirDespesa(Despesa despesa) throws Exception;

    public void removerDespesa(int id);

    public void atualizarDespesa(Despesa despesa) throws Exception;

    public ArrayList<Despesa> listarDespesas();

    public Despesa buscarDespesa(int id);
}
