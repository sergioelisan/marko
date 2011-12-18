/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.cliente;

import br.ufrpe.bcc.ibusiness.util.CPF;
import java.util.List;

/**
 *
 * @author Wolf
 */
public interface ICliente {

    public List<Cliente> listarClientes();

    public void addCliente(Cliente cliente)throws Exception;

    public void rmCliente(Cliente cliente);

    public void updateCliente(Cliente cliente) throws Exception;

    public Cliente buscaCliente(CPF cpf) throws Exception;

    public Cliente buscaCliente(String nome) throws Exception;
}
