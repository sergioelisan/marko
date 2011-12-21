/*
 * PresentationUI.java
 *
 * Created on 21/12/2011, 08:29:55
 */
package br.ufrpe.bcc.ibusiness.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Serginho
 */
public class PresentationUI extends javax.swing.JPanel {

    private IBusinessUI main;
    
    public PresentationUI(IBusinessUI main) {
        this.main = main;
        initComponents();
        rotinas();
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
                
                int hora = Calendar.getInstance().get(Calendar.HOUR);
                int minuto = Calendar.getInstance().get(Calendar.MINUTE);
                String h = hora < 10 ? "0" + hora : "" + hora;
                String m = minuto < 10 ? "0" + minuto : "" + minuto;
                lbHora.setText(h + ":" + m);
            }
        });

        clock.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHora = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbHora1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(64, 128, 128));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(990, 680));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbHora.setBackground(new java.awt.Color(255, 255, 255));
        lbHora.setFont(new java.awt.Font("Tahoma", 0, 48));
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        lbHora.setText("hora");

        lbData.setBackground(new java.awt.Color(255, 255, 255));
        lbData.setFont(new java.awt.Font("Tahoma", 0, 14));
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setText("data");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/logo 124.jpg"))); // NOI18N

        lbHora1.setBackground(new java.awt.Color(102, 0, 102));
        lbHora1.setFont(new java.awt.Font("Tahoma", 0, 12));
        lbHora1.setForeground(new java.awt.Color(61, 61, 61));
        lbHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/casinha.png"))); // NOI18N
        lbHora1.setOpaque(true);
        lbHora1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHora1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbData)
                            .addComponent(lbHora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 769, Short.MAX_VALUE)
                        .addComponent(lbHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbData)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void lbHora1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHora1MouseClicked
        main.SwitchToHome();        
    }//GEN-LAST:event_lbHora1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbHora1;
    // End of variables declaration//GEN-END:variables
}
