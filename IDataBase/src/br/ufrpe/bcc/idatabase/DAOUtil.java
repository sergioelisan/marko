package br.ufrpe.bcc.idatabase;

import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author serginho
 */
public class DAOUtil {
    
    /**
     * Retorna uma query a partir de uma chave
     * @param key
     * @return 
     */
    public static String getQuery(String key) {
        ResourceBundle rb = ResourceBundle.getBundle(queryURL);
        return rb.getString(key);
    }
    
    /**
     * Quando ha uma excessao, esse metodo eh chamado para detalhar o erro
     * @param e
     * @param mensagem
     * @return 
     */
    public static RuntimeException exception(SQLException e, String mensagem) {
        String erro = mensagem + "\n"
                    + "Mensagem:  " + e.getMessage()
                    + "SQL Error: " + e.getSQLState();
        return new RuntimeException(erro);
    }
    
    /**
     * Endereco do arquivo que contem as queries
     */
    public static final String queryURL = "br/bcc/ufrpe/idatabase/queries/queries";

    
    
}
