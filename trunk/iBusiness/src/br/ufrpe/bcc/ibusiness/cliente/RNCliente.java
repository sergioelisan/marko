/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.cliente;

import br.ufrpe.bcc.ibusiness.cliente.exception.NomeInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.EmailInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.FoneInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.CelInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.EnderecoInvalidoException;
import br.ufrpe.bcc.ibusiness.cliente.exception.CPFInvalidoException;
import br.ufrpe.bcc.ibusiness.util.CPF;
import java.util.List;

/**
 *
 * @author Wolf
 */
public class RNCliente implements ICliente {

    @Override
    public List<Cliente> listarClientes() {
        DAOCliente dao = new DAOCliente();
        return dao.listarClientes();
    }

    @Override
    public void addCliente(Cliente cliente) throws NomeInvalidoException, CPFInvalidoException, EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, EmailInvalidoException {
        //Verifica se o nome do cliente não está vazio
        if (!cliente.getNome().trim().equals("")) {
            //Verifica se o CPF é válido
            if (validarCPF(cliente.getCpf().getCpf())) {
                //Verificar se o endereço não está vazio
                if (!cliente.getEndereco().trim().equals("")) {
                    //Verifica se o telefone é válido: (00)0000-0000
                    if (cliente.getFone().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                        //Verifica se o celular é válido: (00)0000-0000
                        if (cliente.getCel().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                            //Verfica se o e-mail é válido: x@x.x
                            if (cliente.getEmail().matches("\\w+@\\w+.\\w+")) {
                                DAOCliente dao = new DAOCliente();
                                dao.addCliente(cliente);
                            } else {
                                throw new EmailInvalidoException("O e-mail informado é inválido.");
                            }
                        } else {
                            throw new CelInvalidoException("O celular informado é inválido.");
                        }
                    } else {
                        throw new FoneInvalidoException("O telefone informado é inválido.");
                    }
                } else {
                    throw new EnderecoInvalidoException("O endereço informado é inválido.");
                }
            } else {
                throw new CPFInvalidoException("O CPF informado é inválido.");
            }
        } else {
            throw new NomeInvalidoException("O nome informado é inválido.");
        }
    }

    @Override
    public void rmCliente(Cliente c) {
        DAOCliente dao = new DAOCliente();
        dao.rmCliente(c);
    }

    @Override
    public void updateCliente(Cliente cliente) throws NomeInvalidoException, CPFInvalidoException, EnderecoInvalidoException, FoneInvalidoException, CelInvalidoException, EmailInvalidoException {
        //Verifica se o nome do cliente não está vazio
        if (!cliente.getNome().trim().equals("")) {
            //Verifica se o CPF é válido
            if (validarCPF(cliente.getCpf().getCpf())) {
                //Verificar se o endereço não está vazio
                if (!cliente.getEndereco().trim().equals("")) {
                    //Verifica se o telefone é válido: (00)0000-0000
                    if (cliente.getFone().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                        //Verifica se o celular é válido: (00)0000-0000
                        if (cliente.getCel().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                            //Verfica se o e-mail é válido: x@x.x
                            if (cliente.getEmail().matches("\\w+@\\w+.\\w+")) {
                                DAOCliente dao = new DAOCliente();
                                dao.updateCliente(cliente);
                            } else {
                                throw new EmailInvalidoException("O e-mail informado é inválido.");
                            }
                        } else {
                            throw new CelInvalidoException("O celular informado é inválido.");
                        }
                    } else {
                        throw new FoneInvalidoException("O telefone informado é inválido.");
                    }
                } else {
                    throw new EnderecoInvalidoException("O endereço informado é inválido.");
                }
            } else {
                throw new CPFInvalidoException("O CPF informado é inválido.");
            }
        } else {
            throw new NomeInvalidoException("O nome informado é inválido.");
        }
    }

    @Override
    public Cliente buscaCliente(CPF cpf) throws CPFInvalidoException {
        if (validarCPF(cpf.getCpf())) {
            DAOCliente dao = new DAOCliente();
            return dao.buscaCliente(cpf);
        } else {
            throw new CPFInvalidoException("O CPF informado é inválido.");
        }
    }

    @Override
    public Cliente buscaCliente(String nome) throws NomeInvalidoException {
        if (!nome.trim().equals("")) {
            DAOCliente dao = new DAOCliente();
            return dao.buscaCliente(nome);
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
