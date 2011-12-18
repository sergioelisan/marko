/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.produto;

import br.ufrpe.bcc.ibusiness.produto.exception.VencimentoInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.CategoriaInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.DisponivelInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.NomeInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.EstocadoInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.PrecoVendaInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.FornecedorInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.CompraInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.PrecoCompraInvalidoException;
import br.ufrpe.bcc.ibusiness.produto.exception.DescricaoInvalidoException;
import br.ufrpe.bcc.ibusiness.categoria.Categoria;
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
    public void addProduto(Produto produto) throws NomeInvalidoException, DescricaoInvalidoException, CategoriaInvalidoException,
            FornecedorInvalidoException, EstocadoInvalidoException, DisponivelInvalidoException, CompraInvalidoException,
            VencimentoInvalidoException, PrecoCompraInvalidoException, PrecoVendaInvalidoException {
        if (!produto.getNome().trim().equals("")) {
            if (!produto.getDescricao().equals("")) {
                if (produto.getCategoria() != null) {
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
                                                throw new PrecoVendaInvalidoException("O preço de venda informado é inválido.");
                                            }
                                        }else{
                                            throw new PrecoCompraInvalidoException("O preço de compra informado é inválido.");
                                        }
                                    }else{
                                        throw new VencimentoInvalidoException("A data de vencimento informada é inválida.");
                                    }
                                }else{
                                    throw new CompraInvalidoException("A data de compra informada é inválida.");
                                }
                            }else{
                                throw new DisponivelInvalidoException("A quantidade disponível é inválida.");
                            }
                        }else{
                            throw new EstocadoInvalidoException("A quantidade estocada é inválida.");
                        }
                    }else{
                        throw new FornecedorInvalidoException("O fornecedor informado é inválido.");
                    }
                }else{
                    throw new CategoriaInvalidoException("A categoria informada é inválida.");
                }
            }else{
                throw new DescricaoInvalidoException("A descrição informada é inválida.");
            }
        }else{
            throw new NomeInvalidoException("O nome informado é inválido.");
        }
    }

    @Override
    public void rmProduto(int id) {
        DAOProduto dao = new DAOProduto();
        dao.rmProduto(id);
    }

    @Override
    public void updateProduto(Produto produto) throws NomeInvalidoException, DescricaoInvalidoException, CategoriaInvalidoException,
            FornecedorInvalidoException, EstocadoInvalidoException, DisponivelInvalidoException, CompraInvalidoException,
            VencimentoInvalidoException, PrecoCompraInvalidoException, PrecoVendaInvalidoException {
        if (!produto.getNome().trim().equals("")) {
            if (!produto.getDescricao().equals("")) {
                if (produto.getCategoria() != null) {
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
                                                throw new PrecoVendaInvalidoException("O preço de venda informado é inválido.");
                                            }
                                        }else{
                                            throw new PrecoCompraInvalidoException("O preço de compra informado é inválido.");
                                        }
                                    }else{
                                        throw new VencimentoInvalidoException("A data de vencimento informada é inválida.");
                                    }
                                }else{
                                    throw new CompraInvalidoException("A data de compra informada é inválida.");
                                }
                            }else{
                                throw new DisponivelInvalidoException("A quantidade disponível é inválida.");
                            }
                        }else{
                            throw new EstocadoInvalidoException("A quantidade estocada é inválida.");
                        }
                    }else{
                        throw new FornecedorInvalidoException("O fornecedor informado é inválido.");
                    }
                }else{
                    throw new CategoriaInvalidoException("A categoria informada é inválida.");
                }
            }else{
                throw new DescricaoInvalidoException("A descrição informada é inválida.");
            }
        }else{
            throw new NomeInvalidoException("O nome informado é inválido.");
        }
    }

    @Override
    public Produto buscaProduto(int codigo) {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProduto(codigo);
    }

    @Override
    public Produto buscaProduto(String nome) throws NomeInvalidoException {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProduto(nome);
    }

    @Override
    public ArrayList<Produto> buscaProdutos(Categoria categoria) {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProdutos(categoria);
    }

    @Override
    public ArrayList<Produto> buscaProdutos(Date validade) {
        DAOProduto dao = new DAOProduto();
        return dao.buscaProdutos(validade);
    }
}
