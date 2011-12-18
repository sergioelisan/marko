package br.ufrpe.bcc.ibusiness;

import br.ufrpe.bcc.ibusiness.ui.IBusinessUI;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Sergio
 */
public class IBusiness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater( new Runnable() {

            @Override
            public void run() {
                JFrame ui = new IBusinessUI();
                ui.setVisible(true);
            }
        });
    }
}
