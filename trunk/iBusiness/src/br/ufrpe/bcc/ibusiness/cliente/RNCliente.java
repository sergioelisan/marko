/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.cliente;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public class RNCliente implements ICliente {

    @Override
    public ArrayList<Cliente> listarClientes() {
        DAOCliente dao = new DAOCliente();
        return dao.listarClientes();
    }

    @Override
    public void inserirCliente(Cliente cliente) throws Exception {
        //Verifica se o nome do cliente não está vazio
        if ((!cliente.getNome().trim().equals("")
                && !cliente.getNome().matches("[a-zA-Z\\s]*"))) {
            //Verifica se o CPF é válido
            if (validarCPF(cliente.getCpf())) {
                //Verificar se o endereço não está vazio
                if (!cliente.getEndereco().trim().equals("")) {
                    //Verifica se o telefone é válido: (00)0000-0000
                    if (cliente.getTelefone().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                        //Verifica se o celular é válido: (00)0000-0000
                        if (cliente.getCelular().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                            //Verfica se o e-mail é válido: x@x.x
                            if (cliente.getEmail().matches("\\w+@\\w+.\\w+")) {
                                DAOCliente dao = new DAOCliente();
                                dao.inserirCliente(cliente);
                            } else {
                                throw new Exception("O e-mail informado é inválido.");
                            }
                        } else {
                            throw new Exception("O celular informado é inválido.");
                        }
                    } else {
                        throw new Exception("O telefone informado é inválido.");
                    }
                } else {
                    throw new Exception("O endereço informado é inválido.");
                }
            } else {
                throw new Exception("O CPF informado é inválido.");
            }
        } else {
            throw new Exception("O nome informado é inválido.");
        }
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws Exception {
        //Verifica se o nome do cliente não está vazio
        if ((!cliente.getNome().trim().equals("")
                && !cliente.getNome().matches("[a-zA-Z\\s]*"))) {
            //Verifica se o CPF é válido
            if (validarCPF(cliente.getCpf())) {
                //Verificar se o endereço não está vazio
                if (!cliente.getEndereco().trim().equals("")) {
                    //Verifica se o telefone é válido: (00)0000-0000
                    if (cliente.getTelefone().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                        //Verifica se o celular é válido: (00)0000-0000
                        if (cliente.getCelular().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                            //Verfica se o e-mail é válido: x@x.x
                            if (cliente.getEmail().matches("\\w+@\\w+.\\w+")) {
                                DAOCliente dao = new DAOCliente();
                                dao.inserirCliente(cliente);
                            } else {
                                throw new Exception("O e-mail informado é inválido.");
                            }
                        } else {
                            throw new Exception("O celular informado é inválido.");
                        }
                    } else {
                        throw new Exception("O telefone informado é inválido.");
                    }
                } else {
                    throw new Exception("O endereço informado é inválido.");
                }
            } else {
                throw new Exception("O CPF informado é inválido.");
            }
        } else {
            throw new Exception("O nome informado é inválido.");
        }
    }

    @Override
    public Cliente buscarClienteCPF(String cpf) {
        DAOCliente dao = new DAOCliente();
        return dao.buscarClienteCPF(cpf);
    }

    @Override
    public Cliente buscarClienteNome(String nome) {
        DAOCliente dao = new DAOCliente();
        return dao.buscarClienteNome(nome);

    }

    @Override
    public void removerCliente(int id) {
        DAOCliente dao = new DAOCliente();
        dao.removerCliente(id);
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
