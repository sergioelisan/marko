package br.ufrpe.bcc.ibusiness.venda;

import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import br.ufrpe.bcc.ibusiness.usuario.Usuario;
import br.ufrpe.bcc.ibusiness.venda.exception.ClienteInvalidoException;
import br.ufrpe.bcc.ibusiness.venda.exception.HorarioInvalidoException;
import br.ufrpe.bcc.ibusiness.venda.exception.ItemInvalidoException;
import br.ufrpe.bcc.ibusiness.venda.exception.UsuarioInvalidoException;
import java.util.List;

/**
 *
 * @author Wolf
 */
public interface IVenda {
     
    void submeterVenda(Venda venda) throws HorarioInvalidoException, ClienteInvalidoException, UsuarioInvalidoException, ItemInvalidoException;
     
     List<Venda> listarVendas(); 
     
     Venda buscarVenda(Integer codigo);
     
     List<Venda> buscarVenda(Usuario usuario);
     
     List<Venda> buscarVenda(Cliente cliente);
}
