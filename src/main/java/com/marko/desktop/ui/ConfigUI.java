/*
 * ConfigUI.java
 *
 * Created on 21/12/2011, 12:03:21
 */
package com.marko.desktop.ui;

/**
 * @author Sergio lisan e vitor rolim
 */
public class ConfigUI extends javax.swing.JPanel {

    private Home home;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btHelp;
    private javax.swing.JLabel btHome;
    private javax.swing.JLabel lbPanel;

    public ConfigUI(Home home) {
        this.home = home;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btHelp = new javax.swing.JLabel();
        lbPanel = new javax.swing.JLabel();
        btHome = new javax.swing.JLabel();

        setBackground(new java.awt.Color(64, 128, 128));

        btHelp.setBackground(new java.awt.Color(255, 255, 255));
        btHelp.setFont(new java.awt.Font("Roboto", 1, 24));
        btHelp.setForeground(new java.awt.Color(64, 128, 128));
        btHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btHelp.setText("?");
        btHelp.setMaximumSize(new java.awt.Dimension(38, 38));
        btHelp.setMinimumSize(new java.awt.Dimension(38, 38));
        btHelp.setOpaque(true);
        btHelp.setPreferredSize(new java.awt.Dimension(38, 38));
        btHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHelpMouseClicked(evt);
            }
        });

        lbPanel.setFont(new java.awt.Font("Lucida Sans", 0, 36));
        lbPanel.setForeground(new java.awt.Color(255, 255, 255));
        lbPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanel.setText("Configurações");

        btHome.setBackground(new java.awt.Color(153, 0, 153));
        btHome.setFont(new java.awt.Font("Roboto", 1, 24));
        btHome.setForeground(new java.awt.Color(255, 255, 255));
        btHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/casinha.png"))); // NOI18N
        btHome.setMaximumSize(new java.awt.Dimension(38, 38));
        btHome.setMinimumSize(new java.awt.Dimension(38, 38));
        btHome.setOpaque(true);
        btHome.setPreferredSize(new java.awt.Dimension(38, 38));
        btHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbPanel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 669, Short.MAX_VALUE)
                                .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbPanel)
                                        .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(566, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHelpMouseClicked

        home.Switch(Home.HELP);
    }//GEN-LAST:event_btHelpMouseClicked

    private void btHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHomeMouseClicked

        home.Return();
    }//GEN-LAST:event_btHomeMouseClicked
    // End of variables declaration//GEN-END:variables
}
