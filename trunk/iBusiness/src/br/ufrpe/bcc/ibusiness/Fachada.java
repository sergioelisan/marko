/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness;

import br.ufrpe.bcc.ibusiness.cliente.*;
import br.ufrpe.bcc.ibusiness.despesa.*;
import br.ufrpe.bcc.ibusiness.fornecedor.*;
import br.ufrpe.bcc.ibusiness.funcionario.*;
import br.ufrpe.bcc.ibusiness.item.*;
import br.ufrpe.bcc.ibusiness.produto.*;
import br.ufrpe.bcc.ibusiness.venda.*;
import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public class Fachada implements ICliente, IDespesa, IFornecedor, IFuncionario, IItem, IProduto, IVenda {
    
    @Override
    public ArrayList<Cliente> listarClientes() {
        RNCliente rn = new RNCliente();
        return rn.listarClientes();
    }
    
    @Override
    public void inserirCliente(Cliente cliente) throws Exception {
        RNCliente rn = new RNCliente();
        rn.inserirCliente(cliente);
    }
    
    @Override
    public void removerCliente(int id) {
        RNCliente rn = new RNCliente();
        rn.removerCliente(id);
    }
    
    @Override
    public void atualizarCliente(Cliente cliente) throws Exception {
        RNCliente rn = new RNCliente();
        rn.atualizarCliente(cliente);
    }
    
    @Override
    public Cliente buscarClienteCPF(String cpf) {
        RNCliente rn = new RNCliente();
        return rn.buscarClienteCPF(cpf);
    }
    
    @Override
    public Cliente buscarClienteNome(String nome) {
        RNCliente rn = new RNCliente();
        return rn.buscarClienteNome(nome);
    }
    
    @Override
    public void inserirDespesa(Despesa despesa) throws Exception {
        RNDespesa rn = new RNDespesa();
        rn.inserirDespesa(despesa);
    }
    
    @Override
    public void removerDespesa(int id) {
        RNDespesa rn = new RNDespesa();
        rn.removerDespesa(id);
    }
    
    @Override
    public void atualizarDespesa(Despesa despesa) throws Exception {
        RNDespesa rn = new RNDespesa();
        rn.atualizarDespesa(despesa);
    }
    
    @Override
    public ArrayList<Despesa> listarDespesas() {
        RNDespesa rn = new RNDespesa();
        return rn.listarDespesas();
    }
    
    @Override
    public Despesa buscarDespesa(int id) {
        RNDespesa rn = new RNDespesa();
        return rn.buscarDespesa(id);
    }
    
    @Override
    public ArrayList<Fornecedor> listarFornecedores() {
        RNFornecedor rn = new RNFornecedor();
        return rn.listarFornecedores();
    }
    
    @Override
    public void inserirFornecedor(Fornecedor fornecedor) throws Exception {
        RNFornecedor rn = new RNFornecedor();
        rn.inserirFornecedor(fornecedor);
    }
    
    @Override
    public void removerFornecedor(int id) {
        RNFornecedor rn = new RNFornecedor();
        rn.removerFornecedor(id);
    }
    
    @Override
    public void atualizarFornecedor(Fornecedor fornecedor) throws Exception {
        RNFornecedor rn = new RNFornecedor();
        rn.atualizarFornecedor(fornecedor);
    }
    
    @Override
    public Fornecedor buscarFornecedorCNPJ(String cnpj) {
        RNFornecedor rn = new RNFornecedor();
        return rn.buscarFornecedorCNPJ(cnpj);
    }
    
    @Override
    public Fornecedor buscarFornecedorRazao(String razao) {
        RNFornecedor rn = new RNFornecedor();
        return rn.buscarFornecedorRazao(razao);
    }
    
    @Override
    public ArrayList<Funcionario> listarFuncionarios() {
        RNFuncionario rn = new RNFuncionario();
        return rn.listarFuncionarios();
    }
    
    @Override
    public void inserirFuncionario(Funcionario funcionario) throws Exception {
        RNFuncionario rn = new RNFuncionario();
        rn.inserirFuncionario(funcionario);
    }
    
    @Override
    public void removerFuncionario(int id) {
        RNFuncionario rn = new RNFuncionario();
        rn.removerFuncionario(id);
    }
    
    @Override
    public void atualizarFuncionario(Funcionario funcionario) throws Exception {
        RNFuncionario rn = new RNFuncionario();
        rn.atualizarFuncionario(funcionario);
    }
    
    @Override
    public ArrayList<Item> listarItens() {
        RNItem rn = new RNItem();
        return rn.listarItens();
    }
    
    @Override
    public void inserirItem(Item item) throws Exception {
        RNItem rn = new RNItem();
        rn.inserirItem(item);
    }
    
    @Override
    public ArrayList<Produto> listarProdutos() {
        RNProduto rn = new RNProduto();
        return rn.listarProdutos();
    }
    
    @Override
    public void inserirProduto(Produto produto) throws Exception {
        RNProduto rn = new RNProduto();
        rn.inserirProduto(produto);
    }
    
    @Override
    public void removerProduto(int id) {
        RNProduto rn = new RNProduto();
        rn.removerProduto(id);
    }
    
    @Override
    public void atualizarProduto(Produto produto) throws Exception {
        RNProduto rn = new RNProduto();
        rn.atualizarProduto(produto);
    }
    
    @Override
    public Produto buscarProdutoID(int id) {
        RNProduto rn = new RNProduto();
        return rn.buscarProdutoID(id);
    }
    
    @Override
    public Produto buscarProdutoNome(String nome) {
        RNProduto rn = new RNProduto();
        return rn.buscarProdutoNome(nome);
    }
    
    @Override
    public void inserirVenda(Venda venda) throws Exception {
        RNVenda rn = new RNVenda();
        rn.inserirVenda(venda);
    }
    
    @Override
    public ArrayList<Venda> listarVendas() {
        RNVenda rn = new RNVenda();
        return rn.listarVendas();
    }
    
    @Override
    public Venda buscarVendaId(int id) {
        RNVenda rn = new RNVenda();
        return rn.buscarVendaId(id);
    }
    
    @Override
    public Venda buscarVendaCliente(int id) {
        RNVenda rn = new RNVenda();
        return rn.buscarVendaId(id);
    }
    
    @Override
    public Venda buscarVendaFuncionario(int id) {
        RNVenda rn = new RNVenda();
        return rn.buscarVendaFuncionario(id);
    }

    @Override
    public Funcionario buscarFuncionarioNome(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
