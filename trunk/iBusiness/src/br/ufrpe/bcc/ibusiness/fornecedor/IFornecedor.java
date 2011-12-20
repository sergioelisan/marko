/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.fornecedor;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public interface IFornecedor {

    public ArrayList<Fornecedor> listarFornecedores();

    public void inserirFornecedor(Fornecedor fornecedor) throws Exception;

    public void removerFornecedor(int id);

    public void atualizarFornecedor(Fornecedor fornecedor) throws Exception;

    public Fornecedor buscarFornecedorCNPJ(String cnpj) throws Exception;

    public Fornecedor buscarFornecedorRazao(String razao) throws Exception;
}
