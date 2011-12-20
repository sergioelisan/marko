/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.produto;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
class DAOProduto implements IProduto{

    @Override
    public ArrayList<Produto> listarProdutos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void inserirProduto(Produto produto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removerProduto(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizarProduto(Produto produto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscarProdutoID(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscarProdutoNome(String nome){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
