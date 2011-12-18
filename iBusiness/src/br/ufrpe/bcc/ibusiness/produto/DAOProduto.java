/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.produto;

import java.util.ArrayList;
import java.util.Date;

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
    public void addProduto(Produto produto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rmProduto(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateProduto(Produto produto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscaProduto(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscaProduto(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Produto> buscaProdutos(Date validade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
