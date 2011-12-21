/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HelpUI.java
 *
 * Created on 17/12/2011, 15:46:15
 */
package br.ufrpe.bcc.ibusiness.ui;

/**
 *
 * @author serginho
 */
public class HelpUI extends javax.swing.JPanel {

    private Home home;
    
    public HelpUI(Home aThis) {
        this.home = aThis;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btOptions = new javax.swing.JLabel();
        btOptions1 = new javax.swing.JLabel();
        lbPanel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(64, 128, 128));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1024, 620));

        btOptions.setBackground(new java.awt.Color(255, 204, 0));
        btOptions.setFont(new java.awt.Font("Roboto", 1, 24));
        btOptions.setForeground(new java.awt.Color(255, 255, 255));
        btOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/engrenagem.png"))); // NOI18N
        btOptions.setMaximumSize(new java.awt.Dimension(38, 38));
        btOptions.setMinimumSize(new java.awt.Dimension(38, 38));
        btOptions.setOpaque(true);
        btOptions.setPreferredSize(new java.awt.Dimension(38, 38));
        btOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOptionsMouseClicked(evt);
            }
        });

        btOptions1.setBackground(new java.awt.Color(153, 0, 153));
        btOptions1.setFont(new java.awt.Font("Roboto", 1, 24));
        btOptions1.setForeground(new java.awt.Color(255, 255, 255));
        btOptions1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btOptions1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/casinha.png"))); // NOI18N
        btOptions1.setMaximumSize(new java.awt.Dimension(38, 38));
        btOptions1.setMinimumSize(new java.awt.Dimension(38, 38));
        btOptions1.setOpaque(true);
        btOptions1.setPreferredSize(new java.awt.Dimension(38, 38));
        btOptions1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOptions1MouseClicked(evt);
            }
        });

        lbPanel.setFont(new java.awt.Font("Lucida Sans", 2, 36));
        lbPanel.setForeground(new java.awt.Color(255, 255, 255));
        lbPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanel.setText("Ajuda");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(61, 61, 61));
        jLabel1.setText("Documentação do sistema");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(new java.awt.Color(61, 61, 61));
        jLabel2.setText("Desenvolvedores");

        jLabel3.setText("<html>O sistema está hospedado em: http://code.google.com/p/bcc-ibusiness <br> Toda a documentação se encontra em http://code.google.com/p/bcc-ibusiness/wiki</html>");

        jLabel4.setText("Sergio Lisan - sergiolisan@gmail.com");

        jLabel5.setText("Douglas Silva - douglas_hss@hotmail.com");

        jLabel6.setText("Francisco Fernandes - netoffdf@gmail.com");

        jLabel7.setText("Alan Batista - alan.provisorio@gmail.com");

        jLabel8.setText("Vitor Rolim - victor.b.rolim@gmail.com");

        jLabel9.setText("Lucas de Holanda - lucasr__13@hotmail.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addContainerGap(669, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btOptions1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 900, Short.MAX_VALUE)
                        .addComponent(btOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPanel, 0, 0, Short.MAX_VALUE)
                    .addComponent(btOptions1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btOptions1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOptions1MouseClicked
        home.Return();
    }//GEN-LAST:event_btOptions1MouseClicked

    private void btOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOptionsMouseClicked
        home.Switch(Home.CONFIG);
    }//GEN-LAST:event_btOptionsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btOptions;
    private javax.swing.JLabel btOptions1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPanel;
    // End of variables declaration//GEN-END:variables
}
