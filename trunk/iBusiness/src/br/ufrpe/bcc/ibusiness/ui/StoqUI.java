/*
 * StoqUI.java
 *
 * Created on 17/12/2011, 15:45:11
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.ibusiness.Fachada;
import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import br.ufrpe.bcc.ibusiness.ui.components.ShowData;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author serginho
 */
public class StoqUI extends javax.swing.JPanel {

    private Home home;
    
    public StoqUI(Home home) {
        this.home = home;
        initComponents();
    }

    /**
     * Carrega os eventos
     */
    private void loadButtonEvents() {
        List<JLabel> botoes = new ArrayList<>();
        botoes.add(btAdd);
        botoes.add(btClean);
        botoes.add(btRemove);
        botoes.add(btUpdate);

        for (final JLabel lb : botoes) {
            lb.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e) {
                    lb.setBackground(Color.white);
                    lb.setForeground(new Color(61, 61, 61));
                }

                public void mouseExited(MouseEvent e) {
                    lb.setBackground(new Color(61, 128, 128));
                    lb.setForeground(Color.white);
                }
            });
        }
    }
    
    /**
     * Salva um produto no banco
     */
    private void save() {
        Cliente c = new Cliente();

        String nome = txtnomeproduto.getText();
        String cpf = txtcpf.getText();
        String endereco = txtendereco.getText();
        String fone = txtfone.getText();
        String celular = txtcelular.getText();
        String email = txtemail.getText();

        c.setNome(nome);
        c.setCpf(cpf);
        c.setEndereco(endereco);
        c.setTelefone(fone);
        c.setCelular(celular);
        c.setEmail(email);

        Fachada face = new Fachada();

        if (lbID.getText().equals("codigo")) {
            try {
                face.inserirCliente(c);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problemas ao adicionar o Cliente:\n" + ex);
            }
        } else {
            int id = Integer.parseInt(lbID.getText());
            c.setId(id);
            try {
                face.atualizarCliente(c);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problemas ao alterar o Cliente:\n" + ex);
            }
        }

        update();
    }
    
    
    /**
     * Remove
     */
    private void remove() {
        int id = Integer.parseInt(lbID.getText());

        Fachada face = new Fachada();
        face.removerCliente(id);

        update();
    }
    
    /**
     * Atualiza os dados a serem exibidos
     */
    private void update() {
        clientsPane.removeAll();

        List<Cliente> clientes = new Fachada().listarClientes();
        Collections.sort(clientes);

        for (Cliente c : clientes) {
            String nome = c.getNome();
            String cpf = c.getId() + " - " + c.getCpf();
            String fone = c.getCelular() == null ? c.getTelefone() : c.getCelular();
            final ShowData<Cliente> sd = new ShowData<>(c, nome, cpf, fone);

            sd.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    setDataOnFields(sd.getObjeto());
                }
            });

            clientsPane.add(sd);
        }

        clientsPane.updateUI();
    }
    
    private void populate(Cliente c) {
        clientsPane.removeAll();

        String n = c.getNome();
        String cpf = c.getId() + " - " + c.getCpf();
        String fone = c.getCelular() == null ? c.getTelefone() : c.getCelular();
        final ShowData<Cliente> sd = new ShowData<>(c, n, cpf, fone);

        sd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setDataOnFields(sd.getObjeto());
            }
        });

        clientsPane.add(sd);
        clientsPane.updateUI();
    }

    private void clear() {
        lbID.setText("codigo");
        txtnomeproduto.setText(null);
        txtcpf.setText(null);
        txtendereco.setText(null);
        txtfone.setText(null);
        txtcelular.setText(null);
        txtemail.setText(null);
        txtpesquisa.setText(null);
    }

    private void setDataOnFields(Cliente c) {
        lbID.setText(c.getId() + "");
        txtnomeproduto.setText(c.getNome());
        txtcpf.setText(c.getCpf());
        txtendereco.setText(c.getEndereco());
        txtfone.setText(c.getTelefone());
        txtcelular.setText(c.getCelular());
        txtemail.setText(c.getEmail());
    }

    private void pesquisaNome() {
        String nome = txtpesquisa.getText();
        Fachada face = new Fachada();
        Cliente c = face.buscarClienteNome(nome);
        populate(c);        
    }

    private void pesquisaCPF() {
        String cpf = txtpesquisa.getText();
        Fachada face = new Fachada();
        Cliente c = face.buscarClienteCPF(cpf);
        populate(c);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(64, 128, 128));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1024, 620));
        setPreferredSize(new java.awt.Dimension(1024, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
