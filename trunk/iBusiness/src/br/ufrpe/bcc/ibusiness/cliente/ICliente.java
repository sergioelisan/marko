/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.cliente;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public interface ICliente {

    public ArrayList<Cliente> listarClientes();

    public void inserirCliente(Cliente cliente) throws Exception;

    public void removerCliente(Cliente cliente);

    public void atualizarCliente(Cliente cliente) throws Exception;

    public Cliente buscarClienteCPF(String cpf) throws Exception;

    public Cliente buscarClienteNome(String nome) throws Exception;
}
