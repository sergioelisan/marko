/*
 * MarkoUI.java
 *
 * Created on 07/12/2011, 02:11:24
 */
package com.marko.desktop.ui;

import com.marko.desktop.ui.components.*;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Serginho
 */
public class MarkoUI extends javax.swing.JFrame {

    private List<JPanel> uis;
    private List<Tile> modulos;

    public MarkoUI() {
        initComponents();
        loadModules();
        setContentPane(new PresentationUI(this));
        setLocationRelativeTo(null);
    }

    /**
     * seleciona a home
     */
    public void SwitchToHome() {
        setContentPane(new Home(this));
        ((JComponent) getContentPane()).updateUI();
    }

    private void loadModules() {
        modulos = new LinkedList<>();
        modulos.add(new CostumerTile());
        modulos.add(new SocialTile());
        modulos.add(new PartnesTile());
        modulos.add(new StoqTile());
        modulos.add(new RhTile());
        modulos.add(new SalesTile());
        modulos.add(new ReportsTile());
        modulos.add(new ConfigTile());
        modulos.add(new HelpTile());
        setExtendedState(MAXIMIZED_BOTH);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("bcc ibusiness beta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<Tile> getModulos() {
        return modulos;
    }
}
