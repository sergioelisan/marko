/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.interfaces;

import com.marko.model.Produto;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface IProduto {

    ArrayList<Produto> listarProdutos();

    void inserirProduto(Produto produto) throws Exception;

    void removerProduto(int id);

    void atualizarProduto(Produto produto) throws Exception;

    Produto buscarProdutoID(int id);

    Produto buscarProdutoNome(String nome);
}
