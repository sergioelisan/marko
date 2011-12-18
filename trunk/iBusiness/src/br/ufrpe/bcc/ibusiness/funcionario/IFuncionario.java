/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.funcionario;

import br.ufrpe.bcc.ibusiness.util.CPF;
import java.util.List;

/**
 *
 * @author Wolf
 */
public interface IFuncionario {

    List<Funcionario> listarFuncionarios();

    void addFuncionario(Funcionario funcionario) throws Exception;

    void rmFuncionario(Funcionario funcionario);

    void updateFuncionario(Funcionario funcionario) throws Exception;

    Funcionario buscaFuncionario(CPF cpf) throws Exception;

    Funcionario buscaFuncionario(String nome) throws Exception;
}
