/*
 * CostumerUI.java
 *
 * Created on 17/12/2011, 15:45:01
 */
package br.ufrpe.bcc.ibusiness.ui;

import br.ufrpe.bcc.ibusiness.Fachada;
import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import br.ufrpe.bcc.ibusiness.produto.Produto;
import br.ufrpe.bcc.ibusiness.ui.components.ShowData;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sergio lisan e vitor rolim
 */
public class StoqUI extends javax.swing.JPanel {

    private Home home;

    public StoqUI() {
        initComponents();
        loadButtonEvents();
        update();
    }

    public StoqUI(Home aThis) {
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
        Produto p = new Produto();

        String nome = txtnome.getText();
        String desc = txtdescricao.getText();
        String estocado = txtestocado.getText();
        String compra = txtcompra.getText();
        String vencimento = txtvencimento.getText();
        String precocompra = txtprecocompra.getText();
        String precovenda = txtprecovenda.getText();

        p.setNome(nome);
        p.setDescricao(desc);
        p.setEstocado(Integer.parseInt(estocado));
    
        Double pc = Double.parseDouble(precocompra.replace(',', '.').replace("R$", ""));
        Double pv = Double.parseDouble(precovenda.replace(',', '.').replace("R$", ""));
        p.setPrecoCompra(pc);
        p.setPrecoVenda(pv);

        DateFormat fmt = DateFormat.getDateInstance();
        try {
            p.setCompra(fmt.parse(compra));
            p.setVencimento(fmt.parse(vencimento));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data incorreta!");
        }

        Fachada face = new Fachada();

        if (lbID.getText().equals("codigo")) {
            try {
                face.inserirProduto(p);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problemas ao adicionar o Produto:\n" + ex);
            }
        } else {
            int id = Integer.parseInt(lbID.getText());
            p.setId(id);
            try {
                face.atualizarProduto(p);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problemas ao alterar o Produto:\n" + ex);
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
        face.removerProduto(id);

        update();
    }

    /**
     * Atualiza os dados a serem exibidos
     */
    private void update() {
        produtoPane.removeAll();

        List<Produto> produtos = new Fachada().listarProdutos();
        Collections.sort(produtos);

        for (Produto p : produtos) {
            String nome = p.getNome();
            String id = p.getId() + "";
            String descricao = p.getDescricao();
            final ShowData<Produto> sd = new ShowData<>(p, nome, id, descricao);

            sd.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    setDataOnFields(sd.getObjeto());
                }
            });

            produtoPane.add(sd);
        }

        produtoPane.updateUI();
    }

    private void populate(Produto p) {
        produtoPane.removeAll();

        String nome = p.getNome();
        String id = p.getId() + "";
        String descricao = p.getDescricao();
        final ShowData<Produto> sd = new ShowData<>(p, nome, id, descricao);

        sd.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                setDataOnFields(sd.getObjeto());
            }
        });

        produtoPane.add(sd);
        produtoPane.updateUI();
    }

    private void clear() {
        lbID.setText("codigo");
        txtnome.setText(null);
        txtdescricao.setText(null);
        txtestocado.setText(null);
        txtcompra.setText(null);
        txtvencimento.setText(null);
        txtprecocompra.setText(null);
        txtprecovenda.setText(null);
        txtpesquisa.setText(null);
    }

    private void setDataOnFields(Produto p) {
        lbID.setText(p.getId() + "");
        txtnome.setText(p.getNome());
        txtdescricao.setText(p.getDescricao());
        txtestocado.setText(String.valueOf(p.getEstocado()));

        DateFormat fmt = DateFormat.getDateInstance();
        txtcompra.setText(fmt.format(p.getCompra()));
        txtvencimento.setText(fmt.format(p.getVencimento()));

        NumberFormat fm = NumberFormat.getCurrencyInstance();
        txtprecocompra.setText(fm.format(p.getPrecoCompra()));
        txtprecovenda.setText(fm.format(p.getPrecoVenda()));
    }

    private void pesquisaNome() {
        String nome = txtpesquisa.getText();
        Fachada face = new Fachada();
        Produto c = face.buscarProdutoNome(nome);
        populate(c);
    }

    private void pesquisaCodigo() {
        String codigo = txtpesquisa.getText();
        Fachada face = new Fachada();
        Produto prod = face.buscarProdutoID(Integer.parseInt(codigo));
        populate(prod);
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
        txtvencimento = new javax.swing.JTextField();
        txtprecocompra = new javax.swing.JTextField();
        txtestocado = new javax.swing.JTextField();
        txtcompra = new javax.swing.JTextField();
        txtdescricao = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        txtprecovenda = new javax.swing.JTextField();
        produtoPane = new javax.swing.JPanel();
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
        lbPanel.setText("Estoque");

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

        txtvencimento.setFont(new java.awt.Font("Roboto", 0, 18));
        txtvencimento.setText("Vencimento");
        txtvencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtvencimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtvencimentoFocusLost(evt);
            }
        });

        txtprecocompra.setFont(new java.awt.Font("Roboto", 0, 18));
        txtprecocompra.setText("R$ Compra");
        txtprecocompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtprecocompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecocompraFocusLost(evt);
            }
        });

        txtestocado.setFont(new java.awt.Font("Roboto", 0, 18));
        txtestocado.setText("Estocado");
        txtestocado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtestocadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtestocadoFocusLost(evt);
            }
        });

        txtcompra.setFont(new java.awt.Font("Roboto", 0, 18));
        txtcompra.setText("Compra");
        txtcompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcompraFocusLost(evt);
            }
        });

        txtdescricao.setFont(new java.awt.Font("Roboto", 0, 18));
        txtdescricao.setText("Descrição");
        txtdescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdescricaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdescricaoFocusLost(evt);
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

        txtprecovenda.setFont(new java.awt.Font("Roboto", 0, 18));
        txtprecovenda.setText("R$ Venda");
        txtprecovenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtprecovendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecovendaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtestocado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtvencimento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtprecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecocompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtdescricao, txtestocado, txtnome});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbID)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtprecocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtestocado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        produtoPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        produtoPane.setOpaque(false);
        produtoPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 15));

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
                    .addComponent(produtoPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
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
                        .addComponent(btOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(produtoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

    private void txtcompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcompraFocusGained
        if (txtcompra.getText().equals("Compra")) {
            txtcompra.setText(null);
        }
    }//GEN-LAST:event_txtcompraFocusGained

    private void txtdescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescricaoFocusGained
        if (txtdescricao.getText().equals("Descrição")) {
            txtdescricao.setText(null);
        }
    }//GEN-LAST:event_txtdescricaoFocusGained

    private void txtvencimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvencimentoFocusGained
        if (txtvencimento.getText().equals("Vencimento")) {
            txtvencimento.setText(null);
        }
    }//GEN-LAST:event_txtvencimentoFocusGained

    private void txtestocadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtestocadoFocusGained
        if (txtestocado.getText().equals("Estocado")) {
            txtestocado.setText(null);
        }
    }//GEN-LAST:event_txtestocadoFocusGained

    private void txtprecocompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecocompraFocusGained
        if (txtprecocompra.getText().equals("R$ Compra")) {
            txtprecocompra.setText(null);
        }
    }//GEN-LAST:event_txtprecocompraFocusGained

    private void txtnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnomeFocusLost
        if (txtnome.getText().equals("")) {
            txtnome.setText("Nome");
        }
    }//GEN-LAST:event_txtnomeFocusLost

    private void txtdescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescricaoFocusLost
        if (txtdescricao.getText().equals("")) {
            txtdescricao.setText("Descrição");
        }
    }//GEN-LAST:event_txtdescricaoFocusLost

    private void txtestocadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtestocadoFocusLost
        if (txtestocado.getText().equals("")) {
            txtestocado.setText("Estocado");
        }
    }//GEN-LAST:event_txtestocadoFocusLost

    private void txtcompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcompraFocusLost
        if (txtcompra.getText().equals("")) {
            txtcompra.setText("Compra");
        }
    }//GEN-LAST:event_txtcompraFocusLost

    private void txtvencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvencimentoFocusLost
        if (txtvencimento.getText().equals("")) {
            txtvencimento.setText("Vencimento");
        }
    }//GEN-LAST:event_txtvencimentoFocusLost

    private void txtprecocompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecocompraFocusLost
        if (txtprecocompra.getText().equals("")) {
            txtprecocompra.setText("R$ Compra");
        }
    }//GEN-LAST:event_txtprecocompraFocusLost

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
            if (txtpesquisa.getText().trim().matches("\\d")) {
                pesquisaCodigo();
            } else {
                pesquisaNome();
            }
        }
    }//GEN-LAST:event_txtpesquisaKeyReleased

    private void txtprecovendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecovendaFocusGained
        if (txtprecovenda.getText().equals("R$ Venda")) {
            txtprecovenda.setText("");
        }
    }//GEN-LAST:event_txtprecovendaFocusGained

    private void txtprecovendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecovendaFocusLost
       if (txtprecovenda.getText().equals("")) {
            txtprecovenda.setText("R$ Venda");
        }
    }//GEN-LAST:event_txtprecovendaFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btAdd;
    private javax.swing.JLabel btClean;
    private javax.swing.JLabel btHelp;
    private javax.swing.JLabel btHome;
    private javax.swing.JLabel btOptions;
    private javax.swing.JLabel btRemove;
    private javax.swing.JLabel btUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbPanel;
    private javax.swing.JPanel produtoPane;
    private javax.swing.JTextField txtcompra;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtestocado;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtprecocompra;
    private javax.swing.JTextField txtprecovenda;
    private javax.swing.JTextField txtvencimento;
    // End of variables declaration//GEN-END:variables
}
