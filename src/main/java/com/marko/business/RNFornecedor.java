/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.business;

import com.marko.dao.DAOFornecedor;
import com.marko.interfaces.IFornecedor;
import com.marko.model.Fornecedor;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public class RNFornecedor implements IFornecedor {

    @Override
    public ArrayList<Fornecedor> listarFornecedores() {
        DAOFornecedor dao = null;
        try {
            dao = new DAOFornecedor();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return dao.listarFornecedores();
    }

    @Override
    public void inserirFornecedor(Fornecedor fornecedor) throws Exception {
        if (!fornecedor.getRazao().trim().equals("")) {
            if (ValidarCNPJ(fornecedor.getCnpj())) {
                if (!fornecedor.getEndereco().trim().equals("")) {
                    if (fornecedor.getFone().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                        if (fornecedor.getFax().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                            if (fornecedor.getRepresentante().trim().equals("")) {
                                DAOFornecedor dao = new DAOFornecedor();
                                dao.inserirFornecedor(fornecedor);
                            } else {
                                throw new Exception("O representante informado é inválido.");
                            }
                        } else {
                            throw new Exception("O fax informado é inválido.");
                        }
                    } else {
                        throw new Exception("O telefone informado é inválido.");
                    }
                } else {
                    throw new Exception("O endereço informado é inválido.");
                }
            } else {
                throw new Exception("O CNPJ informado é inválido.");
            }
        } else {
            throw new Exception("A razão informada é inválida.");
        }
    }

    @Override
    public void removerFornecedor(int id) {
        DAOFornecedor dao = null;
        try {
            dao = new DAOFornecedor();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        dao.removerFornecedor(id);
    }

    @Override
    public void atualizarFornecedor(Fornecedor fornecedor) throws Exception {
        if (!fornecedor.getRazao().trim().equals("")) {
            if (ValidarCNPJ(fornecedor.getCnpj())) {
                if (!fornecedor.getEndereco().trim().equals("")) {
                    if (fornecedor.getFone().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                        if (fornecedor.getFax().matches("(\\d\\d)\\d\\d\\d\\d\\-\\d\\d\\d\\d")) {
                            if (fornecedor.getRepresentante().trim().equals("")) {
                                DAOFornecedor dao = new DAOFornecedor();
                                dao.atualizarFornecedor(fornecedor);
                            } else {
                                throw new Exception("O representante informado é inválido.");
                            }
                        } else {
                            throw new Exception("O fax informado é inválido.");
                        }
                    } else {
                        throw new Exception("O telefone informado é inválido.");
                    }
                } else {
                    throw new Exception("O endereço informado é inválido.");
                }
            } else {
                throw new Exception("O CNPJ informado é inválido.");
            }
        } else {
            throw new Exception("A razão informada é inválida.");
        }
    }

    @Override
    public Fornecedor buscarFornecedorCNPJ(String cnpj) {
        DAOFornecedor dao = null;
        try {
            dao = new DAOFornecedor();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return dao.buscarFornecedorCNPJ(cnpj);
    }

    @Override
    public Fornecedor buscarFornecedorRazao(String razao) {
        DAOFornecedor dao = null;
        try {
            dao = new DAOFornecedor();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return dao.buscarFornecedorRazao(razao);
    }

    public boolean ValidarCNPJ(String str_cnpj) {
        int soma = 0, aux, dig;
        String cnpj_calc = str_cnpj.substring(0, 12);

        if (str_cnpj.length() != 14) {
            return false;
        }

        char[] chr_cnpj = str_cnpj.toCharArray();

        /* Primeira parte */
        for (int i = 0; i < 4; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);

        cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);

        /* Segunda parte */
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);

        return str_cnpj.equals(cnpj_calc);
    }
}
