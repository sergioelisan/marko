/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.cliente;

import br.ufrpe.bcc.ibusiness.cliente.exception.NomeInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.EmailInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.FoneInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.CelInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.EnderecoInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.CPFInvalidoException;
import br.ufrpe.bcc.ibusiness.util.CPF;
import java.util.List;

/**
 *
 * @author Wolf
 */
public interface ICliente {

    public List<Cliente> listarClientes();

    public void addCliente(Cliente cliente)throws NomeInvalidoException, CPFInvalidoException, EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, EmailInvalidoException;

    public void rmCliente(Cliente cliente);

    public void updateCliente(Cliente cliente) throws NomeInvalidoException, CPFInvalidoException, EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, EmailInvalidoException;

    public Cliente buscaCliente(CPF cpf) throws CPFInvalidoException;

    public Cliente buscaCliente(String nome) throws NomeInvalidoException;
}
