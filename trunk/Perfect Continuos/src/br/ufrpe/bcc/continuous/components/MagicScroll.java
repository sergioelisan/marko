package br.ufrpe.bcc.continuous.components;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Esconde as barras de rolagem e deixa isso por
 * conta de gestos do mouse, deixando a interface simples e elegante.
 * 
 * @author Sergio Lisan
 */
@SuppressWarnings("serial")
public class MagicScroll extends JScrollPane {

    private int sensibility = 70;
    
    public MagicScroll() {           
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
    }
    
    public MagicScroll(Boolean activeMouseGesture) {
        this();
        if (activeMouseGesture) {
            this.addMouseMotionListener(new MouseGesture());
            this.addMouseWheelListener(new MouseWhellGesture());
        }
    }

    public MagicScroll(Component comp, Integer sensibility, Boolean activeMouseGesture) {
        this(activeMouseGesture);
        this.setViewportView(comp);
        this.sensibility = sensibility;
    }

    /**
     * Detecta a posição do mouse relativa a este componente
     * 
     * @param pos
     */
    public void detectMotion(int x, int y) {
        int previousHorizontalLocation = (int) (this.getSize().width * 0.08);
        int nextHorizontalLocation = (int) (this.getSize().width * 0.92);

        int previousVerticalLocation = (int) (this.getSize().height * 0.08);
        int nextVerticalLocation = (int) (this.getSize().height * 0.92);

        if (x <= previousHorizontalLocation) {
            previousHorizontal();
        } else if (x >= nextHorizontalLocation) {
            nextHorizontal();
        }

        if (y <= previousVerticalLocation) {
            previousVertical();
        } else if (y >= nextVerticalLocation) {
            nextVertical();
        }
    }

    /**
     * Detecta a direção do movimento da rodinha do mouse
     * @param pos 
     */
    public void detectWheel(int pos) {
        if (pos < 0) {
            previousVertical();
        } else if (pos > 0) {
            nextVertical();
        }
    }

    /**
     * Promove a rolagem para trás quando solicitado
     */
    public void previousVertical() {
        JScrollBar barra = this.getVerticalScrollBar();
        barra.setValue(barra.getValue() - sensibility);
    }

    /**
     * Promove a rolagem para frente quando solicitado
     */
    public void nextVertical() {
        JScrollBar barra = this.getVerticalScrollBar();
        barra.setValue(barra.getValue() + sensibility);
    }

    /**
     * Promove a rolagem para trás quando solicitado
     */
    public void previousHorizontal() {
        JScrollBar barra = this.getHorizontalScrollBar();
        barra.setValue(barra.getValue() - sensibility);
    }

    /**
     * Promove a rolagem para frente quando solicitado
     */
    public void nextHorizontal() {
        JScrollBar barra = this.getHorizontalScrollBar();
        barra.setValue(barra.getValue() + sensibility);
    }

    /**
     * @return the sensibility
     */
    public int getSensibility() {
        return sensibility;
    }

    /**
     * @param sensibility the sensibility to set
     */
    public void setSensibility(int sensibility) {
        this.sensibility = sensibility;
    }

    /**
     * Handler responsável por tratar os eventos de movimento do mouse (Mouse
     * Motion), capturar a posição onde eles foram gerados e chamar o método 
     * devido.
     */
    public class MouseGesture extends MouseAdapter {

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
            detectMotion(e.getX(), e.getY());
        }
    }

    /**
     * Handler responsável por tratar os eventos da rodinha do mouse (Whell
     * Motion), capturar a direção e chamar o método devido
     */
    public class MouseWhellGesture extends MouseAdapter {

        public void mouseWheelMoved(MouseWheelEvent e) {
            detectWheel(e.getWheelRotation());
        }
    }
}
