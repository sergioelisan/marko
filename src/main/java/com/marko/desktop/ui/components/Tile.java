package com.marko.desktop.ui.components;

import com.marko.desktop.ui.PerfectContinuousConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author sergio lisan, douglas henrique, lucas de holanda, vitor rolim, francisco fernandes e alan batista
 */
public class Tile extends JPanel implements PerfectContinuousConstants {

    public static final int Tile_Width = 300;
    public static final int Tile_Height = 150;
    private Color entered;
    private Color exited;

    public Tile() {
        setPreferredSize(new Dimension(300, 150));
        setMinimumSize(new Dimension(300, 150));
        setMaximumSize(new Dimension(300, 150));
        setBackground(PerfectContinuousConstants.bright_bcc);
        addMouseListener(new TileHandler());
    }

    /**
     * inicia as cores da Tile
     */
    public void instantiateColors() {
        exited = getBackground();
        if (!exited.equals(Color.white)) {
            entered = exited.brighter();
        } else {
            entered = exited.darker();
        }
    }

    public void over() {
        setBackground(entered);
    }

    public void exit() {
        setBackground(exited);
    }

    public Color getEntered() {
        return entered;
    }

    public void setEntered(Color entered) {
        this.entered = entered;
    }

    public Color getExited() {
        return exited;
    }

    public void setExited(Color exited) {
        this.exited = exited;
    }

    /**
     * classe interna para tratamento de eventos baseados no mouse
     */
    private class TileHandler extends MouseAdapter {

        public void mouseExited(MouseEvent e) {
            exit();
        }

        public void mouseEntered(MouseEvent e) {
            over();
        }
    }
}
