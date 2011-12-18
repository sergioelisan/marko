/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.venda;

import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import br.ufrpe.bcc.ibusiness.usuario.Usuario;
import br.ufrpe.bcc.ibusiness.venda.exception.HorarioInvalidoException;
import br.ufrpe.bcc.ibusiness.venda.exception.ClienteInvalidoException;
import br.ufrpe.bcc.ibusiness.venda.exception.ItemInvalidoException;
import br.ufrpe.bcc.ibusiness.venda.exception.UsuarioInvalidoException;
import java.util.List;

/**
 *
 * @author Wolf
 */
public class RNVenda implements IVenda {

    @Override
    public void submeterVenda(Venda venda) throws HorarioInvalidoException, ClienteInvalidoException, UsuarioInvalidoException, ItemInvalidoException {
        if (venda.getHorario() != null) {
            if (venda.getCliente() != null) {
                if (venda.getUsuario() != null) {
                    if (venda.getItem() != null) {
                        DAOVenda dao = new DAOVenda();
                        dao.submeterVenda(venda);
                    } else {
                        throw new ItemInvalidoException("O item informado é inválido.");
                    }
                } else {
                    throw new UsuarioInvalidoException("O usuario informado é inválido.");
                }
            } else {
                throw new ClienteInvalidoException("O cliente informado é inválido.");
            }
        } else {
            throw new HorarioInvalidoException("O horário informado é inválido.");
        }
    }

    @Override
    public List<Venda> listarVendas() {
        DAOVenda dao = new DAOVenda();
        return dao.listarVendas();
    }

    @Override
    public Venda buscarVenda(Integer codigo) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVenda(codigo);
    }

    @Override
    public List<Venda> buscarVenda(Usuario usuario) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVenda(usuario);
    }

    @Override
    public List<Venda> buscarVenda(Cliente cliente) {
        DAOVenda dao = new DAOVenda();
        return dao.buscarVenda(cliente);
    }
}
