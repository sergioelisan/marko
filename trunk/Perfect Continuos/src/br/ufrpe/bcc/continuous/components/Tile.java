package br.ufrpe.bcc.continuous.components;

import br.ufrpe.bcc.continuous.PerfectContinuousConstants;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author serginho
 */
public class Tile extends JPanel implements PerfectContinuousConstants {
    
    public Tile() {
        setPreferredSize(new Dimension(300, 150));
        setMinimumSize(new Dimension(300, 150));
        setMaximumSize(new Dimension(300, 150));
        setBackground(PerfectContinuousConstants.bright_bcc);        
    }
 
    
    public static final int Tile_Width = 300;
    public static final int Tile_Height = 150;
}
