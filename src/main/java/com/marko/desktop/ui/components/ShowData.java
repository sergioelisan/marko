/*
 * ShowData.java
 *
 * Created on 21/12/2011, 10:19:05
 */
package com.marko.desktop.ui.components;

/**
 * Componentezinho que mostra os dados de um objeto
 *
 * @author Sergio Lisan e Vitor Rolim
 */
public class ShowData<T> extends javax.swing.JPanel {

    private T objeto;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIdentificador;
    private javax.swing.JLabel lbInfo1;
    private javax.swing.JLabel lbInfo2;

    public ShowData() {
        initComponents();
    }

    public ShowData(T objeto, String nome, String info1, String info2) {
        this();
        this.objeto = objeto;
        setNome(nome);
        setInfo1(info1);
        setInfo2(info2);
    }

    public T getObjeto() {
        return objeto;
    }

    public void setNome(String nome) {
        lbIdentificador.setText(nome);
    }

    public void setInfo1(String info) {
        lbInfo1.setText(info);
    }

    public void setInfo2(String info) {
        lbInfo2.setText(info);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIdentificador = new javax.swing.JLabel();
        lbInfo2 = new javax.swing.JLabel();
        lbInfo1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        lbIdentificador.setFont(new java.awt.Font("Tahoma", 0, 18));
        lbIdentificador.setForeground(new java.awt.Color(255, 255, 255));
        lbIdentificador.setText("Identificador");

        lbInfo2.setForeground(new java.awt.Color(255, 255, 255));
        lbInfo2.setText("info2");

        lbInfo1.setForeground(new java.awt.Color(255, 255, 255));
        lbInfo1.setText("info1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbIdentificador)
                                        .addComponent(lbInfo2)
                                        .addComponent(lbInfo1))
                                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbIdentificador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbInfo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbInfo2)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(getBackground().brighter());
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(getBackground().darker());
    }//GEN-LAST:event_formMouseExited
    // End of variables declaration//GEN-END:variables
}
