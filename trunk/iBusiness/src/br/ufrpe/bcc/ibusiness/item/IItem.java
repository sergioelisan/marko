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
public interface IItem {

    public ArrayList<Item> listarItens();

    public void inserirItem(Item item) throws Exception;
}
