/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.business;

import com.marko.dao.DAOProduto;
import com.marko.interfaces.IProduto;
import com.marko.model.Produto;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public class RNProduto implements IProduto {

    @Override
    public ArrayList<Produto> listarProdutos() {
        DAOProduto dao = new DAOProduto();
        return dao.listarProdutos();
    }

    @Override
    public void inserirProduto(Produto produto) throws Exception {
        if (!produto.getNome().trim().equals("")) {
            if (!produto.getDescricao().equals("")) {
                if (produto.getEstocado() >= 0) {
                    if (produto.getCompra() != null) {
                        if (produto.getVencimento() != null) {
                            if (produto.getPrecoCompra() >= 0) {
                                if (produto.getPrecoVenda() >= 0) {
                                    DAOProduto dao = new DAOProduto();
                                    dao.inserirProduto(produto);
                                } else {
                                    throw new Exception("O preço de venda informado é inválido.");
                                }
                            } else {
                                throw new Exception("O preço de compra informado é inválido.");
                            }
                        } else {
                            throw new Exception("A data de vencimento informada é inválida.");
                        }
                    } else {
                        throw new Exception("A data de compra informada é inválida.");
                    }
                } else {
                    throw new Exception("A quantidade estocada é inválida.");
                }
            } else {
                throw new Exception("A descrição informada é inválida.");
            }
        } else {
            throw new Exception("O nome informado é inválido.");
        }
    }

    @Override
    public void removerProduto(int id) {
        DAOProduto dao = new DAOProduto();
        dao.removerProduto(id);
    }

    @Override
    public void atualizarProduto(Produto produto) throws Exception {
        if (!produto.getNome().trim().equals("")) {
            if (!produto.getDescricao().equals("")) {
                if (produto.getEstocado() >= 0) {
                    if (produto.getCompra() != null) {
                        if (produto.getVencimento() != null) {
                            if (produto.getPrecoCompra() >= 0) {
                                if (produto.getPrecoVenda() >= 0) {
                                    DAOProduto dao = new DAOProduto();
                                    dao.atualizarProduto(produto);
                                } else {
                                    throw new Exception("O preço de venda informado é inválido.");
                                }
                            } else {
                                throw new Exception("O preço de compra informado é inválido.");
                            }
                        } else {
                            throw new Exception("A data de vencimento informada é inválida.");
                        }
                    } else {
                        throw new Exception("A data de compra informada é inválida.");
                    }
                } else {
                    throw new Exception("A quantidade estocada é inválida.");
                }
            } else {
                throw new Exception("A descrição informada é inválida.");
            }
        } else {
            throw new Exception("O nome informado é inválido.");
        }
    }

    @Override
    public Produto buscarProdutoID(int id) {
        DAOProduto dao = new DAOProduto();
        return dao.buscarProdutoID(id);
    }

    @Override
    public Produto buscarProdutoNome(String nome) {
        DAOProduto dao = new DAOProduto();
        return dao.buscarProdutoNome(nome);
    }
}
