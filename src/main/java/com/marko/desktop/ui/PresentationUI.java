/*
 * PresentationUI.java
 *
 * Created on 21/12/2011, 08:29:55
 */
package com.marko.desktop.ui;

import com.marko.Fachada;
import com.marko.model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Serginho
 */
public class PresentationUI extends javax.swing.JPanel {

    private MarkoUI main;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbHora1;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JPasswordField txtsenha;

    public PresentationUI(MarkoUI main) {
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

                int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                int minuto = Calendar.getInstance().get(Calendar.MINUTE);
                String h = hora < 10 ? "0" + hora : "" + hora;
                String m = minuto < 10 ? "0" + minuto : "" + minuto;
                lbHora.setText(h + ":" + m);
            }
        });

        clock.start();
    }

    private boolean logged() {
        String nome = txtlogin.getText().trim();
        String senha = new String(txtsenha.getPassword());

        Fachada face = new Fachada();
        Funcionario f = null;
        try {
            f = face.buscarFuncionarioNome(nome);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao buscar usuario:\n" + e);
        }

        return senha.equals(f.getSenha());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHora = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbHora1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtlogin = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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
        lbHora.setText("Carregando...");

        lbData.setBackground(new java.awt.Color(255, 255, 255));
        lbData.setFont(new java.awt.Font("Tahoma", 0, 14));
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setText("loading...");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo 124.jpg"))); // NOI18N

        lbHora1.setBackground(new java.awt.Color(102, 0, 102));
        lbHora1.setFont(new java.awt.Font("Tahoma", 0, 12));
        lbHora1.setForeground(new java.awt.Color(61, 61, 61));
        lbHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/casinha.png"))); // NOI18N
        lbHora1.setOpaque(true);
        lbHora1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHora1MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Autenticação");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Senha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtlogin)
                                                        .addComponent(txtsenha, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                                .addContainerGap(181, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, jLabel3, jLabel4);

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 574, Short.MAX_VALUE)
                                                .addComponent(lbHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
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
        if (logged())
            main.SwitchToHome();
        else
            JOptionPane.showMessageDialog(null, "FAIL! Voce nao esta autorizado!");
    }//GEN-LAST:event_lbHora1MouseClicked
    // End of variables declaration//GEN-END:variables
}
