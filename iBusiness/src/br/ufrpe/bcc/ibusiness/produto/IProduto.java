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
public interface IProduto {

    public ArrayList<Produto> listarProdutos();

    public void addProduto(Produto produto) throws Exception;

    public void rmProduto(int id);

    public void updateProduto(Produto produto) throws Exception;

    public Produto buscaProduto(int codigo);

    public Produto buscaProduto(String nome) throws Exception;

    public ArrayList<Produto> buscaProdutos(Date validade);
}
