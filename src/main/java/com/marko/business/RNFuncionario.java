/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.business;

import com.marko.dao.DAOFuncionario;
import com.marko.interfaces.IFuncionario;
import com.marko.model.Funcionario;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public class RNFuncionario implements IFuncionario {

    @Override
    public ArrayList<Funcionario> listarFuncionarios() {
        DAOFuncionario dao = new DAOFuncionario();
        return dao.listarFuncionarios();
    }

    @Override
    public void inserirFuncionario(Funcionario funcionario) throws Exception {
        if (!funcionario.getLogin().equals("")) {
            if (!funcionario.getSenha().equals("")) {
                DAOFuncionario dao = new DAOFuncionario();
                dao.inserirFuncionario(funcionario);
            } else {
                throw new Exception("A senha não pode se vazia.");
            }
        } else {
            throw new Exception("O login não pode ser vazio.");
        }
    }

    @Override
    public void removerFuncionario(int id) {
        DAOFuncionario dao = new DAOFuncionario();
        dao.removerFuncionario(id);
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) throws Exception {
        if (!funcionario.getSenha().equals("")) {
            DAOFuncionario dao = new DAOFuncionario();
            dao.inserirFuncionario(funcionario);
        } else {
            throw new Exception("O login não pode ser vazio.");
        }
    }

    public boolean validarCPF(String cpfNum) {
        int[] cpf = new int[cpfNum.length()]; //Define o valor com o tamanho da string  
        int resultP = 0;
        int resultS = 0;

        //Converte a string para um array de integer  
        for (int i = 0; i < cpf.length; i++) {
            cpf[i] = Integer.parseInt(cpfNum.substring(i, i + 1));
        }

        //Calcula o primeiro número(DIV) do cpf  
        for (int i = 0; i < 9; i++) {
            resultP += cpf[i] * (i + 1);
        }
        int divP = resultP % 11;

        //Se o resultado for diferente ao 10º digito do cpf retorna falso  
        if (divP != cpf[9]) {
            return false;
        } else {
            //Calcula o segundo número(DIV) do cpf  
            for (int i = 0; i < 10; i++) {
                resultS += cpf[i] * (i);
            }
            int divS = resultS % 11;

            //Se o resultado for diferente ao 11º digito do cpf retorna falso  
            if (divS != cpf[10]) {
                return false;
            }
        }

        //Se tudo estiver ok retorna verdadeiro  
        return true;
    }

    @Override
    public Funcionario buscarFuncionarioNome(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
