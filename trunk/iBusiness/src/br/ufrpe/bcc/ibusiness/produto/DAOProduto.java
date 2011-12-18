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
class DAOProduto implements IProduto{

    @Override
    public ArrayList<Produto> listarProdutos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addProduto(Produto produto) throws NomeInvalidoException, DescricaoInvalidoException, CategoriaInvalidoException, FornecedorInvalidoException, EstocadoInvalidoException, DisponivelInvalidoException, CompraInvalidoException, VencimentoInvalidoException, PrecoCompraInvalidoException, PrecoVendaInvalidoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rmProduto(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateProduto(Produto produto) throws NomeInvalidoException, DescricaoInvalidoException, CategoriaInvalidoException, FornecedorInvalidoException, EstocadoInvalidoException, DisponivelInvalidoException, CompraInvalidoException, VencimentoInvalidoException, PrecoCompraInvalidoException, PrecoVendaInvalidoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscaProduto(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscaProduto(String nome) throws NomeInvalidoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Produto> buscaProdutos(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Produto> buscaProdutos(Date validade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
