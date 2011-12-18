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
public class RNUsuario implements IUsuario {

    @Override
    public List<Usuario> listarUsuarios() {
        DAOUsuario dao = new DAOUsuario();
        return dao.listarUsuarios();
    }

    @Override
    public void addUsuario(Usuario usuario) throws LoginInvalidoException, PasswdInvalidoException, FuncionarioInvalidoException {
        if (!usuario.getLogin().trim().equals("")) {
            if (!usuario.getPasswd().trim().equals("")) {
                DAOUsuario dao = new DAOUsuario();
                dao.addUsuario(usuario);
            } else {
                throw new PasswdInvalidoException("A senha informada é inválida.");
            }
        } else {
            throw new LoginInvalidoException("O login informado é inválido.");
        }
    }

    @Override
    public void rmUsuario(Usuario user) {
        DAOUsuario dao = new DAOUsuario();
        dao.rmUsuario(user);
    }

    @Override
    public void updateUsuario(Usuario usuario) throws LoginInvalidoException, PasswdInvalidoException, FuncionarioInvalidoException {
        if (!usuario.getLogin().trim().equals("")) {
            if (!usuario.getPasswd().trim().equals("")) {
                DAOUsuario dao = new DAOUsuario();
                dao.updateUsuario(usuario);
            } else {
                throw new PasswdInvalidoException("A senha informada é inválida.");
            }
        } else {
            throw new LoginInvalidoException("O login informado é inválido.");
        }
    }

    @Override
    public Usuario buscaUsuario(String login) {
        DAOUsuario dao = new DAOUsuario();
        return dao.buscaUsuario(login);
    }
}