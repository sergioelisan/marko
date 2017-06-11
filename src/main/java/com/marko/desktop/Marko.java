package com.marko.desktop;

import com.marko.desktop.ui.MarkoUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Sergio
 */
public class Marko {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ui = new MarkoUI();
            ui.setVisible(true);
        });
    }
}
