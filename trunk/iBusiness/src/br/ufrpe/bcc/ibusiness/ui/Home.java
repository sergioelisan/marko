/*
 * Home.java
 *
 * Created on 17/12/2011, 14:12:43
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.continuous.components.MagicScroll;
import br.ufrpe.bcc.continuous.components.Tile;
import br.ufrpe.bcc.continuous.util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author vitor rolim e sergio lisan
 */
public class Home extends javax.swing.JPanel {

    public Home(IBusinessUI main) {
        this.mainFrame = main;
        initComponents();
        rotinas();
        
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 7, 7));
        mainPanel.setOpaque(false);
        mainPanel.setBackground(Color.red);
        mainPanel.setPreferredSize(new Dimension(this.getSize().width - 30, 1080));
        initTiles();

        scroll = new MagicScroll(mainPanel, 50, false);
        scroll.setPreferredSize(new Dimension(mainPanel.getSize().width, mainPanel.getSize().height));
        containerPanel.add(scroll, BorderLayout.CENTER);

        btUp.addMouseListener(scroll.new MouseGesture());
        btDown.addMouseListener(scroll.new MouseGesture());
        
    }

    /**
     * retorna para a pagina inicial
     */
    public void Return() {
        mainFrame.setContentPane(this);
        ((JComponent) mainFrame.getContentPane()).updateUI();
    }

    /**
     * Inicia as rotinas do sistema
     */
    private void rotinas() {
        // Atualiza o relógio e o calendário
        Timer clock = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DateFormat fmt = DateFormat.getDateInstance(DateFormat.LONG);
                lbData.setText(fmt.format(new Date()));
                
                fmt = DateFormat.getTimeInstance(DateFormat.MEDIUM);
                lbHora.setText(fmt.format(new Date() ) );
            }
        });

        clock.start();
    }

    /**
     * troca o painel
     * @param panel 
     */
    public void Switch(String panel) {
        switch (panel) {
            case Home.CLIENT:
                mainFrame.setContentPane(costumer);
                break;
            case Home.RH:
                mainFrame.setContentPane(rh);
                break;
            case Home.STOQ:
                mainFrame.setContentPane(stoq);
                break;
            case Home.SALES:
                mainFrame.setContentPane(sale);
                break;
            case Home.SOCIAL:
                mainFrame.setContentPane(social);
                break;
            case Home.PARTNERS:
                mainFrame.setContentPane(partner);
                break;
            case Home.REPORT:
                mainFrame.setContentPane(report);
                break;
            case Home.CONFIG:
                mainFrame.setContentPane(config);
                break;
            case Home.HELP:
                mainFrame.setContentPane(help);
                break;
        }

        ((JComponent) mainFrame.getContentPane()).updateUI();
    }

    /**
     * Cria as tiles do sistema
     */
    private void initTiles() {
        String[] actions = {CLIENT, SOCIAL, PARTNERS, 
                            STOQ, RH, SALES, REPORT, 
                            CONFIG, HELP};

        for (int i = 0; i < actions.length; i++) {
            final Tile tile = mainFrame.getModulos().get(i);
            final String action = actions[i];
            mainPanel.add(tile);
            tile.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    Switch(action);
                    tile.exit();
                }
            });
        }

        mainPanel.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btUp = new javax.swing.JLabel();
        btDown = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();

        setBackground(new java.awt.Color(64, 135, 135));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(990, 680));
        setPreferredSize(new java.awt.Dimension(990, 680));

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

        containerPanel.setOpaque(false);
        containerPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("home");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setText("data");

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        lbHora.setText("hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                            .addComponent(btUp, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                            .addComponent(btDown, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbData))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbHora)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUp)
                .addGap(18, 18, 18)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lbHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbData)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpMouseClicked
    scroll.previousVertical();
}//GEN-LAST:event_btUpMouseClicked

private void btUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpMouseEntered
    btUp.setIcon(new ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_acima_active.png")));
}//GEN-LAST:event_btUpMouseEntered

private void btUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpMouseExited
    btUp.setIcon(new ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_acima_inactive.png")));
}//GEN-LAST:event_btUpMouseExited

private void btDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDownMouseClicked
    scroll.nextVertical();
}//GEN-LAST:event_btDownMouseClicked

private void btDownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDownMouseEntered
    btDown.setIcon(new ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_baixo_active.png")));
}//GEN-LAST:event_btDownMouseEntered

private void btDownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDownMouseExited
    btDown.setIcon(new ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/seta_baixo_inactive.png")));
}//GEN-LAST:event_btDownMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btDown;
    private javax.swing.JLabel btUp;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Referencia ao frame principal
     */
    private IBusinessUI mainFrame;
    
    /**
     * Containeres
     */
    private JPanel mainPanel;
    private MagicScroll scroll;
    
    /**
     * UI dos modulos
     */
    private JPanel costumer = new CostumerUI(this);
    private JPanel social = new SocialUI(this);
    private JPanel rh = new RhUI(this);
    private JPanel partner = new PartnerUI(this);
    private JPanel stoq = new StoqUI(this);
    private JPanel sale = new SaleUI(this);
    private JPanel report = new ReportUI(this);
    private JPanel config = new ConfigUI(this);
    private JPanel help = new HelpUI(this);
    
    /**
     * Nome dos modulos
     */
    public static final String CLIENT = "client";
    public static final String SOCIAL = "social";
    public static final String PARTNERS = "partners";
    public static final String STOQ = "stoq";
    public static final String RH = "rh";
    public static final String SALES = "sales";
    public static final String REPORT = "report";
    public static final String CONFIG = "config";
    public static final String HELP = "help";
    
    
}
