/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.interfaces;

import com.marko.model.Funcionario;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface IFuncionario {

    ArrayList<Funcionario> listarFuncionarios();

    void inserirFuncionario(Funcionario funcionario) throws Exception;

    void removerFuncionario(int id);

    void atualizarFuncionario(Funcionario funcionario) throws Exception;

    Funcionario buscarFuncionarioNome(String nome) throws Exception;
}
