/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.funcionario;

import br.ufrpe.bcc.ibusiness.funcionario.exception.EnderecoInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.MatriculaInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.CNTPSInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.NomeInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.SalarioInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.EmailInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.FoneInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.CelInvalidoException;
import br.ufrpe.bcc.ibusiness.funcionario.exception.CPFInvalidoException;
import br.ufrpe.bcc.ibusiness.util.CPF;
import java.util.List;

/**
 *
 * @author Wolf
 */
public interface IFuncionario {

    List<Funcionario> listarFuncionarios();

    void addFuncionario(Funcionario funcionario) throws NomeInvalidoException, CPFInvalidoException, MatriculaInvalidoException,
            EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, CNTPSInvalidoException,
            SalarioInvalidoException, EmailInvalidoException;

    void rmFuncionario(Funcionario funcionario);

    void updateFuncionario(Funcionario funcionario) throws NomeInvalidoException, CPFInvalidoException, MatriculaInvalidoException,
            EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, CNTPSInvalidoException,
            SalarioInvalidoException, EmailInvalidoException;

    Funcionario buscaFuncionario(CPF cpf) throws CPFInvalidoException;

    Funcionario buscaFuncionario(String nome) throws NomeInvalidoException;
}
