package br.ufrpe.bcc.continuous.util;

import javax.swing.ImageIcon;

/**
 *
 * @author Serginho
 */
public class GuiUtil {

    /**
     * Retorna uma imagem
     * @param endereco
     * @return 
     */
    public ImageIcon getImage(String endereco) {
        return new ImageIcon(getClass().getResource(endereco));
    }
}
