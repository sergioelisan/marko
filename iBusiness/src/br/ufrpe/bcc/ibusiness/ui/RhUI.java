/*
 * CostumerUI.java
 *
 * Created on 17/12/2011, 15:45:01
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.ibusiness.Fachada;
import br.ufrpe.bcc.ibusiness.funcionario.Funcionario;
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
 * @author sergio lisan e vitor rolim
 */
public class RhUI extends javax.swing.JPanel {

    private Home home;

    public RhUI() {
        initComponents();
        loadButtonEvents();
        update();
    }

    public RhUI(Home aThis) {
        this();
        this.home = aThis;
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

    private void save() {
        Funcionario f = new Funcionario();

        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        f.setLogin(login);
        f.setSenha(senha);

        Fachada face = new Fachada();

        if (lbID.getText().equals("codigo")) {
            try {
                face.inserirFuncionario(f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problemas ao adicionar o Funcionario:\n" + ex);
            }
        } else {
            int id = Integer.parseInt(lbID.getText());
            f.setId(id);
            try {
                face.atualizarFuncionario(f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problemas ao alterar o Funcionario:\n" + ex);
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
        face.removerFuncionario(id);

        update();
    }

    /**
     * Atualiza os dados a serem exibidos
     */
    private void update() {
        usersPane.removeAll();

        List<Funcionario> funcionario = new Fachada().listarFuncionarios();
        Collections.sort(funcionario);

        for (Funcionario f : funcionario) {
            String login = f.getLogin();
            String id = String.valueOf(f.getId());
            String nulo = "";
            final ShowData<Funcionario> sd = new ShowData<>(f, login, id, nulo);

            sd.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    setDataOnFields(sd.getObjeto());
                }
            });

            usersPane.add(sd);
        }

        usersPane.updateUI();
    }

    private void populate(Funcionario f) {
        usersPane.removeAll();

        String login = f.getLogin();
        String id = String.valueOf(f.getId());
        String nulo = "";
        final ShowData<Funcionario> sd = new ShowData<>(f, login, id, nulo);

        sd.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                setDataOnFields(sd.getObjeto());
            }
        });

        usersPane.add(sd);
        usersPane.updateUI();
    }

    private void clear() {
        lbID.setText("codigo");
        txtLogin.setText(null);
        txtSenha.setText(null);
        txtpesquisa.setText(null);
    }

    private void setDataOnFields(Funcionario f) {
        lbID.setText(f.getId() + "");
        txtLogin.setText(f.getLogin());
        txtSenha.setText(f.getSenha());
    }

    private void pesquisaLogin() {
        String nome = txtpesquisa.getText();
        Fachada face = new Fachada();
        Funcionario f = null;
        try {
            f = face.buscarFuncionarioNome(nome);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao procurar pelo Funcionario:\n" + ex);
        }
        populate(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btHelp = new javax.swing.JLabel();
        btOptions = new javax.swing.JLabel();
        lbPanel = new javax.swing.JLabel();
        btHome = new javax.swing.JLabel();
        btAdd = new javax.swing.JLabel();
        btRemove = new javax.swing.JLabel();
        btUpdate = new javax.swing.JLabel();
        btClean = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSenha = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usersPane = new javax.swing.JPanel();
        txtpesquisa = new javax.swing.JTextField();

        setBackground(new java.awt.Color(64, 128, 128));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1024, 620));
        setPreferredSize(new java.awt.Dimension(1024, 620));

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

        lbPanel.setFont(new java.awt.Font("Lucida Sans", 0, 36));
        lbPanel.setForeground(new java.awt.Color(255, 255, 255));
        lbPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanel.setText("Funcionários");

        btHome.setBackground(new java.awt.Color(153, 0, 153));
        btHome.setFont(new java.awt.Font("Roboto", 1, 24));
        btHome.setForeground(new java.awt.Color(255, 255, 255));
        btHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe/bcc/ibusiness/ui/img/casinha.png"))); // NOI18N
        btHome.setMaximumSize(new java.awt.Dimension(38, 38));
        btHome.setMinimumSize(new java.awt.Dimension(38, 38));
        btHome.setOpaque(true);
        btHome.setPreferredSize(new java.awt.Dimension(38, 38));
        btHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHomeMouseClicked(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(64, 128, 128));
        btAdd.setFont(new java.awt.Font("Arial", 0, 14));
        btAdd.setForeground(new java.awt.Color(255, 255, 255));
        btAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btAdd.setText("Salvar");
        btAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        btAdd.setIconTextGap(15);
        btAdd.setOpaque(true);
        btAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddMouseClicked(evt);
            }
        });

        btRemove.setBackground(new java.awt.Color(64, 128, 128));
        btRemove.setFont(new java.awt.Font("Arial", 0, 14));
        btRemove.setForeground(new java.awt.Color(255, 255, 255));
        btRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btRemove.setText("Remover");
        btRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        btRemove.setIconTextGap(15);
        btRemove.setOpaque(true);
        btRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btRemoveMouseClicked(evt);
            }
        });

        btUpdate.setBackground(new java.awt.Color(64, 128, 128));
        btUpdate.setFont(new java.awt.Font("Arial", 0, 14));
        btUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUpdate.setText("Atualizar");
        btUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        btUpdate.setIconTextGap(15);
        btUpdate.setOpaque(true);
        btUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdateMouseClicked(evt);
            }
        });

        btClean.setBackground(new java.awt.Color(64, 128, 128));
        btClean.setFont(new java.awt.Font("Arial", 0, 14));
        btClean.setForeground(new java.awt.Color(255, 255, 255));
        btClean.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btClean.setText("Limpar");
        btClean.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        btClean.setIconTextGap(15);
        btClean.setOpaque(true);
        btClean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCleanMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setOpaque(false);

        txtSenha.setFont(new java.awt.Font("Roboto", 0, 18));
        txtSenha.setText("Senha");
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });

        txtLogin.setFont(new java.awt.Font("Roboto", 0, 18));
        txtLogin.setText("Login");
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
        });

        lbID.setForeground(new java.awt.Color(255, 255, 255));
        lbID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbID.setText("codigo");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14));
        jLabel1.setForeground(new java.awt.Color(61, 61, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Foto");
        jLabel1.setIconTextGap(15);
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(lbID, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addGap(255, 255, 255))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtLogin, txtSenha});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        usersPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        usersPane.setOpaque(false);
        usersPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 15));

        txtpesquisa.setFont(new java.awt.Font("Roboto", 2, 14));
        txtpesquisa.setText("Pesquisa");
        txtpesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpesquisaFocusLost(evt);
            }
        });
        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usersPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 646, Short.MAX_VALUE)
                        .addComponent(btOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btHelp, btHome, btOptions});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPanel, 0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(btOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(usersPane, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btHelp, btHome, btOptions});

    }// </editor-fold>//GEN-END:initComponents

private void btHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHomeMouseClicked
    home.Return();
}//GEN-LAST:event_btHomeMouseClicked

    private void btOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOptionsMouseClicked
        home.Switch(Home.CONFIG);
    }//GEN-LAST:event_btOptionsMouseClicked

    private void btHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHelpMouseClicked
        home.Switch(Home.HELP);
    }//GEN-LAST:event_btHelpMouseClicked

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusGained
        if (txtLogin.getText().equals("Login")) {
            txtLogin.setText(null);
        }
    }//GEN-LAST:event_txtLoginFocusGained

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        if (txtSenha.getText().equals("Senha")) {
            txtSenha.setText(null);
        }
    }//GEN-LAST:event_txtSenhaFocusGained

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusLost
        if (txtLogin.getText().equals("")) {
            txtLogin.setText("Login");
        }
    }//GEN-LAST:event_txtLoginFocusLost

    private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusLost
        if (txtSenha.getText().equals("")) {
            txtSenha.setText("Senha");
        }
    }//GEN-LAST:event_txtSenhaFocusLost

    private void txtpesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpesquisaFocusGained
        if (txtpesquisa.getText().equals("Pesquisa")) {
            txtpesquisa.setText(null);
        }
    }//GEN-LAST:event_txtpesquisaFocusGained

    private void txtpesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpesquisaFocusLost
        if (txtpesquisa.getText().equals("")) {
            txtpesquisa.setText("Pesquisa");
        }
    }//GEN-LAST:event_txtpesquisaFocusLost

    private void btAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseClicked
        save();
    }//GEN-LAST:event_btAddMouseClicked

    private void btRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRemoveMouseClicked
        remove();
    }//GEN-LAST:event_btRemoveMouseClicked

    private void btCleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCleanMouseClicked
        clear();
    }//GEN-LAST:event_btCleanMouseClicked

    private void btUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateMouseClicked
        update();
    }//GEN-LAST:event_btUpdateMouseClicked

    private void txtpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisaLogin();
        }
    }//GEN-LAST:event_txtpesquisaKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btAdd;
    private javax.swing.JLabel btClean;
    private javax.swing.JLabel btHelp;
    private javax.swing.JLabel btHome;
    private javax.swing.JLabel btOptions;
    private javax.swing.JLabel btRemove;
    private javax.swing.JLabel btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbPanel;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JPanel usersPane;
    // End of variables declaration//GEN-END:variables
}
