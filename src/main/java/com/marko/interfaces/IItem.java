/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marko.interfaces;

import com.marko.model.Item;

import java.util.ArrayList;

/**
 * @author Wolf
 */
public interface IItem {

    ArrayList<Item> listarItens();

    void inserirItem(Item item) throws Exception;
}
