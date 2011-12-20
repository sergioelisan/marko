/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.despesa;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public class RNDespesa implements IDespesa {

    @Override
    public void inserirDespesa(Despesa despesa) throws Exception {
        if (!despesa.getDescricao().equals("")) {
            if (!despesa.getCredor().equals("")) {
                if (despesa.getValor() >= 0) {
                    if (despesa.getLancamento() != null) {

                        if (despesa.getVencimento() != null) {
                            DAODespesa dao = new DAODespesa();
                            dao.inserirDespesa(despesa);
                        } else {
                            throw new Exception("A data de vencimento informada é inválida.");
                        }
                    } else {
                        throw new Exception("A data de lançamento informada é inválida.");
                    }
                } else {
                    throw new Exception("O valor informado é inválido.");
                }
            } else {
                throw new Exception("O credor não pode ser vazio.");
            }
        } else {
            throw new Exception("A descrição não pode ser vazia.");
        }
    }

    @Override
    public void removerDespesa(int id) {
        DAODespesa dao = new DAODespesa();
        dao.removerDespesa(id);
    }

    @Override
    public void atualizarDespesa(Despesa despesa) throws Exception {
        if (!despesa.getDescricao().equals("")) {
            if (!despesa.getCredor().equals("")) {
                if (despesa.getLancamento() != null) {

                    if (despesa.getVencimento() != null) {
                        DAODespesa dao = new DAODespesa();
                        dao.atualizarDespesa(despesa);
                    } else {
                        throw new Exception("A data de vencimento informada é inválida.");
                    }
                } else {
                    throw new Exception("A data de lançamento informada é inválida.");
                }
            } else {
                throw new Exception("O credor não pode ser vazio.");
            }
        } else {
            throw new Exception("A descrição não pode ser vazia.");
        }
    }

    @Override
    public ArrayList<Despesa> listarDespesas() {
        DAODespesa dao = new DAODespesa();
        return dao.listarDespesas();
    }

    @Override
    public Despesa buscarDespesa(int id) {
        DAODespesa dao = new DAODespesa();
        return dao.buscarDespesa(id);
    }
}
