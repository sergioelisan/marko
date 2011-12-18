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
public class RNFuncionario implements IFuncionario {

    @Override
    public List<Funcionario> listarFuncionarios() {
        DAOFuncionario dao = new DAOFuncionario();
        return dao.listarFuncionarios();
    }

    @Override
    public void addFuncionario(Funcionario funcionario) throws NomeInvalidoException, CPFInvalidoException, MatriculaInvalidoException, EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, CNTPSInvalidoException, SalarioInvalidoException, EmailInvalidoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rmFuncionario(Funcionario id) {
        DAOFuncionario dao = new DAOFuncionario();
        dao.rmFuncionario(id);
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) throws NomeInvalidoException, CPFInvalidoException, MatriculaInvalidoException, EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, CNTPSInvalidoException, SalarioInvalidoException, EmailInvalidoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Funcionario buscaFuncionario(CPF cpf) throws CPFInvalidoException {
        if (validarCPF(cpf.getCpf())) {
            DAOFuncionario dao = new DAOFuncionario();
            return dao.buscaFuncionario(cpf);
        } else {
            throw new CPFInvalidoException("O CPF informado é inválido.");
        }
    }

    @Override
    public Funcionario buscaFuncionario(String nome) throws NomeInvalidoException {
        if (!nome.trim().equals("")) {
            DAOFuncionario dao = new DAOFuncionario();
            return dao.buscaFuncionario(nome);
        } else {
            throw new NomeInvalidoException("O nome informado é inválido.");
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
}
