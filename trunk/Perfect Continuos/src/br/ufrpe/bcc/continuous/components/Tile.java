package br.ufrpe.bcc.continuous.components;

import br.ufrpe.bcc.continuous.PerfectContinuousConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author sergio lisan, douglas henrique, lucas de holanda, vitor rolim, francisco fernandes e alan batista
 */
public class Tile extends JPanel implements PerfectContinuousConstants {
    
    public Tile() {
        setPreferredSize(new Dimension(300, 150));
        setMinimumSize(new Dimension(300, 150));
        setMaximumSize(new Dimension(300, 150));
        setBackground(PerfectContinuousConstants.bright_bcc);        
        addMouseListener(new TileHandler() );
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

    private Color entered;
    private Color exited;
    
    public static final int Tile_Width = 300;
    public static final int Tile_Height = 150;
}
