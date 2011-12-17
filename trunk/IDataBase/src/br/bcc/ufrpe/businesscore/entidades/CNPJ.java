package br.bcc.ufrpe.businesscore.entidades;

import java.util.Objects;

/**
 *
 * @author sergio lisan
 */
public class CNPJ {
    public CNPJ() {
    }

    /**
     * Dentro do construtor ja existe uma validacao do cnpj
     * @param cnpj 
     */
    public CNPJ(String cnpj) {
        if(CPF.validate(cnpj))
            this.cnpj = cnpj;
        else
            throw new IllegalArgumentException("CNPJ Inválido");
    }
    
    /**
     * Sobrecarga do método validate que recebe uma String, para aumentar a flexibilidade
     * @param cnpj
     * @return 
     */
    public static boolean validate(CNPJ cnpj) {
        return CNPJ.validate(cnpj.getCNPJ() );
    }
    
    /**
     * Valida um cnpj e retorna true se confirmar e false se for invalido
     * @param cnpj
     * @return 
     */
    public static boolean validate(String cnpj) {
        // TO DO implementar o algoritomo de validacao de cnpj
        return true;
    }
    
    /*
     * 
     * GETTERS AND SETTERS
     * 
     */

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CNPJ other = (CNPJ) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cnpj);
        return hash;
    }

    public String toString() {
        return "CNPJ - " + cnpj;
    }
    
    private String cnpj;  
}
