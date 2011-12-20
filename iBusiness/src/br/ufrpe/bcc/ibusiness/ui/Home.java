/*
 * Home.java
 *
 * Created on 17/12/2011, 14:12:43
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.continuous.components.Tile;
import br.ufrpe.bcc.ibusiness.ui.components.CostumerTile;
import br.ufrpe.bcc.ibusiness.ui.components.PartnesTile;
import br.ufrpe.bcc.ibusiness.ui.components.ReportsTile;
import br.ufrpe.bcc.ibusiness.ui.components.RhTile;
import br.ufrpe.bcc.ibusiness.ui.components.SalesTile;
import br.ufrpe.bcc.ibusiness.ui.components.SocialTile;
import br.ufrpe.bcc.ibusiness.ui.components.StoqTile;

/**
 *
 * @author serginho
 */
public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();        
        initTiles();
    }
    
    private void initTiles() {
        costumers = new CostumerTile();
        mainPanel.add(costumers);
        
        social = new SocialTile();
        mainPanel.add(social);
        
        partners = new PartnesTile();
        mainPanel.add(partners);
        
        stoq = new StoqTile();
        mainPanel.add(stoq);
        
        rh = new RhTile();
        mainPanel.add(rh);
        
        sales = new SalesTile();
        mainPanel.add(sales);
        
        reports = new ReportsTile();       
        mainPanel.add(reports);
        
        mainPanel.updateUI();                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogo = new javax.swing.JLabel();
        btHelp = new javax.swing.JLabel();
        btOptions = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        btUp = new javax.swing.JLabel();
        btDown = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(64, 128, 128));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1024, 620));
        setPreferredSize(new java.awt.Dimension(1024, 620));

        lbLogo.setFont(new java.awt.Font("Roboto", 2, 36));
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/ibusinesslogo.png"))); // NOI18N

        btHelp.setBackground(new java.awt.Color(255, 255, 255));
        btHelp.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btHelp.setForeground(new java.awt.Color(64, 128, 128));
        btHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btHelp.setText("?");
        btHelp.setMaximumSize(new java.awt.Dimension(38, 38));
        btHelp.setMinimumSize(new java.awt.Dimension(38, 38));
        btHelp.setOpaque(true);
        btHelp.setPreferredSize(new java.awt.Dimension(38, 38));

        btOptions.setBackground(new java.awt.Color(255, 204, 0));
        btOptions.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btOptions.setForeground(new java.awt.Color(255, 255, 255));
        btOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/engrenagem.png"))); // NOI18N
        btOptions.setMaximumSize(new java.awt.Dimension(38, 38));
        btOptions.setMinimumSize(new java.awt.Dimension(38, 38));
        btOptions.setOpaque(true);
        btOptions.setPreferredSize(new java.awt.Dimension(38, 38));

        mainPanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        mainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 376));
        mainPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 25));

        btUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_acima_inactive.png"))); // NOI18N

        btDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_baixo_inactive.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data e Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 628, Short.MAX_VALUE)
                        .addComponent(btOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btUp, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(btDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 910, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogo)
                    .addComponent(btOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btUp)
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btHelp, btOptions});

    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btDown;
    private javax.swing.JLabel btHelp;
    private javax.swing.JLabel btOptions;
    private javax.swing.JLabel btUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    private Tile costumers;
    private Tile social;
    private Tile partners;
    private Tile stoq;
    private Tile rh;
    private Tile sales;
    private Tile reports;
}
