/*
 * IBusinessUI.java
 *
 * Created on 07/12/2011, 02:11:24
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.continuous.components.Tile;
import br.ufrpe.bcc.ibusiness.ui.components.ConfigTile;
import br.ufrpe.bcc.ibusiness.ui.components.CostumerTile;
import br.ufrpe.bcc.ibusiness.ui.components.HelpTile;
import br.ufrpe.bcc.ibusiness.ui.components.PartnesTile;
import br.ufrpe.bcc.ibusiness.ui.components.ReportsTile;
import br.ufrpe.bcc.ibusiness.ui.components.RhTile;
import br.ufrpe.bcc.ibusiness.ui.components.SalesTile;
import br.ufrpe.bcc.ibusiness.ui.components.SocialTile;
import br.ufrpe.bcc.ibusiness.ui.components.StoqTile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Serginho
 */
public class IBusinessUI extends javax.swing.JFrame {

    public IBusinessUI() {
        initComponents();
        loadModules();
        setContentPane(new Home(this) );
        setLocationRelativeTo(null);
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
    }

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private List<JPanel> uis;
    private List<Tile> modulos;
}
