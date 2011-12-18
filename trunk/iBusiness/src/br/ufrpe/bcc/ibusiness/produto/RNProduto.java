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
public class RNProduto implements IProduto {

    @Override
    public ArrayList<Produto> listarProdutos() {
        DAOProduto dao = new DAOProduto();
        return dao.listarProdutos();
    }

    @Override
    public void addProduto(Produto produto) throws Exception {
        if (!produto.getNome().trim().equals("")) {
            if (!produto.getDescricao().equals("")) {
                if (produto.getFornecedor() != null) {
                    if (produto.getEstocado() >= 0) {
                        if (produto.getDisponivel() >= 0) {
                            if (produto.getCompra() != null) {
                                if (produto.getVencimento() != null) {
                                    if (produto.getPrecoCompra() >= 0) {
                                        if (produto.getPrecoVenda() >= 0) {
                                            DAOProduto dao = new DAOProduto();
                                            dao.addProduto(produto);
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
                            throw new Exception("A quantidade disponível é inválida.");
                        }
                    } else {
                        throw new Exception("A quantidade estocada é inválida.");
                    }
                } else {
                    throw new Exception("O fornecedor informado é inválido.");
                }
            } else {
                throw new Exception("A descrição informada é inválida.");
            }
        } else {
            throw new Exception("O nome informado é inválido.");
        }
    }

    @Override
    public void rmProduto(int id) {
        DAOProduto dao = new DAOProduto();
        dao.rmProduto(id);
    }

    @Override
    public void updateProduto(Produto produto) throws Exception {
        if (!produto.getNome().trim().equals("")) {
            if (!produto.getDescricao().equals("")) {
                if (produto.getFornecedor() != null) {
                    if (produto.getEstocado() >= 0) {
                        if (produto.getDisponivel() >= 0) {
                            if (produto.getCompra() != null) {
                                if (produto.getVencimento() != null) {
                                    if (produto.getPrecoCompra() >= 0) {
                                        if (produto.getPrecoVenda() >= 0) {
                                            DAOProduto dao = new DAOProduto();
                                            dao.updateProduto(produto);
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
                            throw new Exception("A quantidade disponível é inválida.");
                        }
                    } else {
                        throw new Exception("A quantidade estocada é inválida.");
                    }
                } else {
                    throw new Exception("O fornecedor informado é inválido.");
                }
            } else {
                throw new Exception("A descrição informada é inválida.");
            }
        } else {
            throw new Exception("O nome informado é inválido.");
        }
    }

    @Override
    public Produto buscaProduto(int codigo) {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProduto(codigo);
    }

    @Override
    public Produto buscaProduto(String nome) throws Exception {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProduto(nome);
    }

    @Override
    public ArrayList<Produto> buscaProdutos(Date validade) {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProdutos(validade);
    }
}
