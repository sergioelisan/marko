/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.funcionario;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public interface IFuncionario {

    public ArrayList<Funcionario> listarFuncionarios();

    public void inserirFuncionario(Funcionario funcionario) throws Exception;

    public void removerFuncionario(int id);

    public void atualizarFuncionario(Funcionario funcionario) throws Exception;

    public Funcionario buscarFuncionarioNome(String nome) throws Exception;
}
