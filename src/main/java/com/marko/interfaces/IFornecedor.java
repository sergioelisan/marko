/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.interfaces;

import com.marko.model.Fornecedor;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface IFornecedor {

    ArrayList<Fornecedor> listarFornecedores();

    void inserirFornecedor(Fornecedor fornecedor) throws Exception;

    void removerFornecedor(int id);

    void atualizarFornecedor(Fornecedor fornecedor) throws Exception;

    Fornecedor buscarFornecedorCNPJ(String cnpj);

    Fornecedor buscarFornecedorRazao(String razao);
}
