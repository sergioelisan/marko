package br.ufrpe.bcc.continuous.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sergio lisan e carlos melo
 */
public class PerfectSwitch extends JPanel {

    /**
     * Construtor padrao
     */
    public PerfectSwitch() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        overbackground = new Color(153, 204, 255);
        overforeground = Color.white;
        inactivebackground = Color.white;
        inactiveforeground = Color.black;

        opt1 = new JLabel("ON");
        opt1.setHorizontalAlignment(JLabel.CENTER);
        opt1.setVerticalAlignment(JLabel.CENTER);
        opt1.addMouseListener(new SwitchHandler());
        opt1.setOpaque(true);

        opt2 = new JLabel("OFF");
        opt2.setHorizontalAlignment(JLabel.CENTER);
        opt2.setVerticalAlignment(JLabel.CENTER);
        opt2.addMouseListener(new SwitchHandler());
        opt2.setBackground(inactivebackground);
        opt2.setForeground(inactiveforeground);
        opt2.setOpaque(true);

        setPreferredSize(new Dimension(90, 20));
        opt1.setPreferredSize(new Dimension(45, 20));
        opt2.setPreferredSize(new Dimension(45, 20));

        add(opt1);
        add(opt2);
        setOpaque(false);

        opt1.setBackground(overbackground);
        opt1.setForeground(overforeground);
        activated = opt1;
    }

    /**
     * Construtor que recebe os textos
     *
     * @param opt1
     * @param opt2
     */
    public PerfectSwitch(String opt1, String opt2) {
        this();
        this.opt1.setText(opt1);
        this.opt2.setText(opt2);
    }

    /**
     * Construtor que recebe varios para metros, como textos e cores
     *
     * @param o1
     * @param o2
     * @param ovback
     * @param ovfront
     * @param inback
     * @param infront
     */
    public PerfectSwitch(String o1, String o2, Color ovback, Color ovfront, Color inback, Color infront) {
        this(o1, o2);
        this.overbackground = ovback;
        this.overforeground = ovfront;
        this.inactivebackground = inback;
        this.inactiveforeground = infront;
    }

    /**
     * Retorna a opcao selecionada
     *
     * @return
     */
    public int getSelected() {
        return activated.equals(opt1) ? 0 : 1;
    }

    public void setSelected(int opcao) {
        if (opcao == 0) {
            setActivated(opt1);
        } else {
            setActivated(opt2);
        }
    }

    public void setFirstText(String text) {
        opt1.setText(text);
    }

    public void setSecondText(String text) {
        opt2.setText(text);
    }

    public String getFirstText() {
        return opt1.getText();
    }

    public String getSecondText() {
        return opt2.getText();
    }

    public Color getInactivebackground() {
        return inactivebackground;
    }

    public void setInactivebackground(Color inactivebackground) {
        if (activated.equals(opt1)) {
            opt2.setBackground(inactivebackground);
        } else {
            opt1.setBackground(inactivebackground);
        }

        this.inactivebackground = inactivebackground;
    }

    public Color getInactiveforeground() {
        return inactiveforeground;
    }

    public void setInactiveforeground(Color inactiveforeground) {
        if (activated.equals(opt1)) {
            opt2.setForeground(inactiveforeground);
        } else {
            opt1.setForeground(inactiveforeground);
        }

        this.inactiveforeground = inactiveforeground;
    }

    public Color getOverbackground() {
        return overbackground;
    }

    public void setOverbackground(Color overbackground) {
        if (activated.equals(opt1)) {
            opt1.setForeground(overbackground);
        } else {
            opt2.setForeground(overbackground);
        }

        this.overbackground = overbackground;
    }

    public Color getOverforeground() {
        return overforeground;
    }

    public void setOverforeground(Color overforeground) {
        if (activated.equals(opt1)) {
            opt1.setForeground(overforeground);
        } else {
            opt2.setForeground(overforeground);
        }

        this.overforeground = overforeground;
    }

    private void setActivated(JLabel lb) {
        lb.setBackground(overbackground);
        lb.setForeground(overforeground);

        activated.setBackground(inactivebackground);
        activated.setForeground(inactiveforeground);
        activated = lb;
    }

    /**
     * Classe que trata os eventos do switch
     */
    private class SwitchHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel lb = (JLabel) e.getSource();
            setActivated(lb);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel lb = (JLabel) e.getSource();
            lb.setBackground(overbackground);
            lb.setForeground(overforeground);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel lb = (JLabel) e.getSource();
            if (!lb.equals(activated)) {
                lb.setBackground(inactivebackground);
                lb.setForeground(inactiveforeground);
            }
        }
    }
    /**
     * Referencia em qual das opcoes esta selecionada
     */
    private JLabel activated;
    /**
     * Label que representa a primeira opcao
     */
    private JLabel opt1;
    /**
     * Label que representa a segunda opcao
     */
    private JLabel opt2;
    /**
     * Cor de fundo quando o mouse esta em cima do elemento ou esta selecionado
     */
    private Color overbackground;
    /**
     * Cor da fonte quando o mouse esta em cima do elemento ou esta selecionado
     */
    private Color overforeground;
    /**
     * Cor de fundo quando o mouse nao esta por cima e nao esta selecionado
     */
    private Color inactivebackground;
    /**
     * Cor da fonte quando o elemento nao estiver por cima e nao estiver
     * selecionado
     */
    private Color inactiveforeground;
}
