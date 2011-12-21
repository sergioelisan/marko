/*
 * Home.java
 *
 * Created on 17/12/2011, 14:12:43
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.continuous.components.Tile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author vitor rolim e sergio lisan
 */
public class Home extends javax.swing.JPanel {

    public Home(IBusinessUI main) {
        this.mainFrame = main;
        initComponents();
        initTiles();
        scroll.getViewport().setOpaque(false);
    }

    public void Return() {
        mainFrame.setContentPane(this);
        ((JComponent) mainFrame.getContentPane()).updateUI();
    }

    /**
     * troca o painel
     * @param panel 
     */
    public void Switch(String panel) {
        switch (panel) {
            case "client":
                mainFrame.setContentPane(costumer);
                break;
            case "rh":
                mainFrame.setContentPane(rh);
                break;
            case "stoq":
                mainFrame.setContentPane(stoq);
                break;
            case "sales":
                mainFrame.setContentPane(sale);
                break;
            case "social":
                mainFrame.setContentPane(social);
                break;
            case "partners":
                mainFrame.setContentPane(partner);
                break;
            case "report":
                mainFrame.setContentPane(report);
                break;
            case "config":
                mainFrame.setContentPane(config);
                break;
            case "help":
                mainFrame.setContentPane(help);
                break;

        }

        ((JComponent) mainFrame.getContentPane()).updateUI();
    }

    /**
     * Cria as tiles do sistema
     */
    private void initTiles() {
        String[] actions = {"client", "social", "partners", "stoq", "rh", "sales", "report", "config", "help"};

        for (int i = 0; i < actions.length; i++) {
            Tile tile = mainFrame.getModulos().get(i);
            final String action = actions[i];
            mainPanel.add(tile);
            tile.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    Switch(action);
                }
            });
        }

        mainPanel.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogo = new javax.swing.JLabel();
        btUp = new javax.swing.JLabel();
        btDown = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(64, 128, 128));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1024, 620));
        setPreferredSize(new java.awt.Dimension(1024, 620));

        lbLogo.setFont(new java.awt.Font("Roboto", 2, 36));
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/logo 124.jpg"))); // NOI18N

        btUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_acima_inactive.png"))); // NOI18N
        btUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUpMouseExited(evt);
            }
        });

        btDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_baixo_inactive.png"))); // NOI18N
        btDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDownMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDownMouseExited(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data e Hora");

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scroll.setMaximumSize(new java.awt.Dimension(1920, 1080));
        scroll.setOpaque(false);

        mainPanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        mainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 376));
        mainPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 7));
        scroll.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogo)
                    .addComponent(btUp, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 910, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(btDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo)
                .addGap(18, 18, 18)
                .addComponent(btUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDown)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpMouseClicked
    JScrollBar barra = scroll.getVerticalScrollBar();
    barra.setValue(barra.getValue() - sensibility);
}//GEN-LAST:event_btUpMouseClicked

private void btUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpMouseEntered
    btUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_acima_active.png")));
}//GEN-LAST:event_btUpMouseEntered

private void btUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpMouseExited
    btUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_acima_inactive.png")));
}//GEN-LAST:event_btUpMouseExited

private void btDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDownMouseClicked
    JScrollBar barra = scroll.getVerticalScrollBar();
    barra.setValue(barra.getValue() + sensibility);
}//GEN-LAST:event_btDownMouseClicked

private void btDownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDownMouseEntered
    btDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_baixo_active.png")));
}//GEN-LAST:event_btDownMouseEntered

private void btDownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDownMouseExited
    btDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_baixo_inactive.png")));
}//GEN-LAST:event_btDownMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btDown;
    private javax.swing.JLabel btUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
    private IBusinessUI mainFrame;
    public static final int sensibility = 20;
    private JPanel costumer = new CostumerUI(this);
    private JPanel social = new SocialUI(this);
    private JPanel rh = new RhUI(this);
    private JPanel partner = new PartnerUI(this);
    private JPanel stoq = new StoqUI(this);
    private JPanel sale = new SaleUI(this);
    private JPanel report = new ReportUI(this);
    private JPanel config = new ConfigUI(this);
    private JPanel help = new HelpUI(this);
}
