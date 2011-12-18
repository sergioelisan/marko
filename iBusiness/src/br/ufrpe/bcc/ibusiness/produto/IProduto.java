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
public interface IProduto {

    public ArrayList<Produto> listarProdutos();

    public void addProduto(Produto produto) throws NomeInvalidoException, DescricaoInvalidoException, 
            CategoriaInvalidoException, FornecedorInvalidoException, EstocadoInvalidoException, 
            DisponivelInvalidoException, CompraInvalidoException, VencimentoInvalidoException, 
            PrecoCompraInvalidoException, PrecoVendaInvalidoException;

    public void rmProduto(int id);

    public void updateProduto(Produto produto) throws NomeInvalidoException, DescricaoInvalidoException, 
            CategoriaInvalidoException, FornecedorInvalidoException, EstocadoInvalidoException, 
            DisponivelInvalidoException, CompraInvalidoException, VencimentoInvalidoException, 
            PrecoCompraInvalidoException, PrecoVendaInvalidoException;

    public Produto buscaProduto(int codigo);

    public Produto buscaProduto(String nome) throws NomeInvalidoException;

    public ArrayList<Produto> buscaProdutos(Categoria categoria);

    public ArrayList<Produto> buscaProdutos(Date validade);
}
