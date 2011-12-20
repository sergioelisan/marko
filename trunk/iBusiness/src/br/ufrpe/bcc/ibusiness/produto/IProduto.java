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

    public void inserirProduto(Produto produto) throws Exception;

    public void removerProduto(int id);

    public void atualizarProduto(Produto produto) throws Exception;

    public Produto buscarProdutoID(int id);

    public Produto buscarProdutoNome(String nome);
}
