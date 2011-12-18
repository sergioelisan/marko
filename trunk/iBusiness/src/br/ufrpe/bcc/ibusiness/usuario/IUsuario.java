/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.usuario;

import br.ufrpe.bcc.ibusiness.usuario.exception.FuncionarioInvalidoException;
import br.ufrpe.bcc.ibusiness.usuario.exception.LoginInvalidoException;
import br.ufrpe.bcc.ibusiness.usuario.exception.PasswdInvalidoException;
import java.util.List;

/**
 *
 * @author Wolf
 */
public interface IUsuario {

    public List<Usuario> listarUsuarios();

    public void addUsuario(Usuario usuario) throws LoginInvalidoException, PasswdInvalidoException, FuncionarioInvalidoException;

    public void rmUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario) throws LoginInvalidoException, PasswdInvalidoException, FuncionarioInvalidoException;

    public Usuario buscaUsuario(String login);
}
