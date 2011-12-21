/*
 * CostumerUI.java
 *
 * Created on 17/12/2011, 15:45:01
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
 * @author sergio lisan e vitor rolim
 */
public class CostumerUI extends javax.swing.JPanel {

    private Home home;

    public CostumerUI() {
        initComponents();
        loadButtonEvents();
        update();
    }

    public CostumerUI(Home aThis) {
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
        botoes.add(btFace);
        botoes.add(btRemove);
        botoes.add(btTwitter);
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
        Cliente c = new Cliente();

        String nome = txtnome.getText();
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
        txtnome.setText(null);
        txtcpf.setText(null);
        txtendereco.setText(null);
        txtfone.setText(null);
        txtcelular.setText(null);
        txtemail.setText(null);
        txtpesquisa.setText(null);
    }

    private void face() {
        home.Switch(Home.SOCIAL);
    }

    private void tweet() {
        home.Switch(Home.SOCIAL);
    }

    private void setDataOnFields(Cliente c) {
        lbID.setText(c.getId() + "");
        txtnome.setText(c.getNome());
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

        btHelp = new javax.swing.JLabel();
        btOptions = new javax.swing.JLabel();
        lbPanel = new javax.swing.JLabel();
        btHome = new javax.swing.JLabel();
        btFace = new javax.swing.JLabel();
        btTwitter = new javax.swing.JLabel();
        btAdd = new javax.swing.JLabel();
        btRemove = new javax.swing.JLabel();
        btUpdate = new javax.swing.JLabel();
        btClean = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtcelular = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtendereco = new javax.swing.JTextField();
        txtfone = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clientsPane = new javax.swing.JPanel();
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
        lbPanel.setText("Clientes");

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

        btFace.setBackground(new java.awt.Color(64, 128, 128));
        btFace.setFont(new java.awt.Font("Arial", 0, 14));
        btFace.setForeground(new java.awt.Color(255, 255, 255));
        btFace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btFace.setText("Contactar via Facebook");
        btFace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        btFace.setIconTextGap(15);
        btFace.setOpaque(true);
        btFace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btFaceMouseClicked(evt);
            }
        });

        btTwitter.setBackground(new java.awt.Color(64, 128, 128));
        btTwitter.setFont(new java.awt.Font("Arial", 0, 14));
        btTwitter.setForeground(new java.awt.Color(255, 255, 255));
        btTwitter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btTwitter.setText("Contactar via Twitter");
        btTwitter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        btTwitter.setIconTextGap(15);
        btTwitter.setOpaque(true);
        btTwitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTwitterMouseClicked(evt);
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

        txtcelular.setFont(new java.awt.Font("Roboto", 0, 18));
        txtcelular.setText("Celular");
        txtcelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcelularFocusLost(evt);
            }
        });

        txtemail.setFont(new java.awt.Font("Roboto", 0, 18));
        txtemail.setText("E-mail");
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailFocusLost(evt);
            }
        });

        txtendereco.setFont(new java.awt.Font("Roboto", 0, 18));
        txtendereco.setText("Endereço");
        txtendereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtenderecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtenderecoFocusLost(evt);
            }
        });

        txtfone.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtfone.setText("Fone");
        txtfone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfoneFocusLost(evt);
            }
        });

        txtcpf.setFont(new java.awt.Font("Roboto", 0, 18));
        txtcpf.setText("CPF");
        txtcpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcpfFocusLost(evt);
            }
        });

        txtnome.setFont(new java.awt.Font("Roboto", 0, 18));
        txtnome.setText("Nome");
        txtnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnomeFocusLost(evt);
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
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtcelular, txtcpf, txtemail, txtendereco, txtfone, txtnome});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clientsPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        clientsPane.setOpaque(false);
        clientsPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

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
                    .addComponent(clientsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 728, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btFace, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btTwitter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(clientsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btFace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void txtnomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnomeFocusGained
        if (txtnome.getText().equals("Nome")) {
            txtnome.setText(null);
        }
    }//GEN-LAST:event_txtnomeFocusGained

    private void txtfoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfoneFocusGained
        if (txtfone.getText().equals("Fone")) {
            txtfone.setText(null);
        }
    }//GEN-LAST:event_txtfoneFocusGained

    private void txtcpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcpfFocusGained
        if (txtcpf.getText().equals("CPF")) {
            txtcpf.setText(null);
        }
    }//GEN-LAST:event_txtcpfFocusGained

    private void txtcelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcelularFocusGained
        if (txtcelular.getText().equals("Celular")) {
            txtcelular.setText(null);
        }
    }//GEN-LAST:event_txtcelularFocusGained

    private void txtenderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtenderecoFocusGained
        if (txtendereco.getText().equals("Endereço")) {
            txtendereco.setText(null);
        }
    }//GEN-LAST:event_txtenderecoFocusGained

    private void txtemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusGained
        if (txtemail.getText().equals("E-mail")) {
            txtemail.setText(null);
        }
    }//GEN-LAST:event_txtemailFocusGained

    private void txtnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnomeFocusLost
        if (txtnome.getText().equals("")) {
            txtnome.setText("Nome");
        }
    }//GEN-LAST:event_txtnomeFocusLost

    private void txtcpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcpfFocusLost
        if (txtcpf.getText().equals("")) {
            txtcpf.setText("CPF");
        }
    }//GEN-LAST:event_txtcpfFocusLost

    private void txtenderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtenderecoFocusLost
        if (txtendereco.getText().equals("")) {
            txtendereco.setText("Endereço");
        }
    }//GEN-LAST:event_txtenderecoFocusLost

    private void txtfoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfoneFocusLost
        if (txtfone.getText().equals("")) {
            txtfone.setText("Fone");
        }
    }//GEN-LAST:event_txtfoneFocusLost

    private void txtcelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcelularFocusLost
        if (txtcelular.getText().equals("")) {
            txtcelular.setText("Celular");
        }
    }//GEN-LAST:event_txtcelularFocusLost

    private void txtemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusLost
        if (txtemail.getText().equals("")) {
            txtemail.setText("E-mail");
        }
    }//GEN-LAST:event_txtemailFocusLost

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

    private void btFaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFaceMouseClicked
        face();
    }//GEN-LAST:event_btFaceMouseClicked

    private void btTwitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTwitterMouseClicked
        tweet();
    }//GEN-LAST:event_btTwitterMouseClicked

    private void txtpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(txtpesquisa.getText().trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") )
                pesquisaCPF();
            else
                pesquisaNome();
        }
    }//GEN-LAST:event_txtpesquisaKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btAdd;
    private javax.swing.JLabel btClean;
    private javax.swing.JLabel btFace;
    private javax.swing.JLabel btHelp;
    private javax.swing.JLabel btHome;
    private javax.swing.JLabel btOptions;
    private javax.swing.JLabel btRemove;
    private javax.swing.JLabel btTwitter;
    private javax.swing.JLabel btUpdate;
    private javax.swing.JPanel clientsPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbPanel;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtfone;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables
}
