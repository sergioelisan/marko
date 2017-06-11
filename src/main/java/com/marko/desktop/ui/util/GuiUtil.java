package com.marko.desktop.ui.util;

import javax.swing.*;

/**
 * @author Serginho
 */
public class GuiUtil {

    /**
     * Retorna uma imagem
     *
     * @param endereco
     * @return
     */
    public ImageIcon getImage(String endereco) {
        return new ImageIcon(getClass().getResource(endereco));
    }
}
