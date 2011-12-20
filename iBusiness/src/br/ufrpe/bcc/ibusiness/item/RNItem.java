/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.bcc.ibusiness.item;

import java.util.ArrayList;

/**
 *
 * @author Wolf
 */
public class RNItem implements IItem {

    @Override
    public ArrayList<Item> listarItens() {
        DAOItem dao = new DAOItem();
        return dao.listarItens();
    }

    @Override
    public void inserirItem(Item item) throws Exception {
        if (item.getQuantidade() >= 0) {
            if (item.getProduto() != null) {
                DAOItem dao = new DAOItem();
                dao.inserirItem(item);
            } else {
                throw new Exception("O produto informado é inválido.");
            }
        } else {
            throw new Exception("A quantidade informada é inválida.");
        }
    }
}