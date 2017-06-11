/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.interfaces;

import com.marko.model.Cliente;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface ICliente {

    ArrayList<Cliente> listarClientes();

    void inserirCliente(Cliente cliente) throws Exception;

    void removerCliente(int id);

    void atualizarCliente(Cliente cliente) throws Exception;

    Cliente buscarClienteCPF(String cpf);

    Cliente buscarClienteNome(String nome);
}
