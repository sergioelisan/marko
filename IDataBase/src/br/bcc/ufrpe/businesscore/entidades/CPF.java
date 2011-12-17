package br.bcc.ufrpe.businesscore.entidades;

import java.util.Objects;

/**
 *
 * Encapsula um CPF e a logica de validacao numa mesma classe
 * 
 * @author sergiolisan
 */
public class CPF {

    public CPF() {
    }

    /**
     * Dentro do construtor ja existe uma validacao do cpf
     * @param cpf 
     */
    public CPF(String cpf) {
        if(CPF.validate(cpf))
            this.cpf = cpf;
        else
            throw new IllegalArgumentException("CPF Inválido");
    }
    
    /**
     * Sobrecarga do método validate que recebe uma String, para aumentar a flexibilidade
     * @param cpf
     * @return 
     */
    public static boolean validate(CPF cpf) {
        return CPF.validate(cpf.getCpf() );
    }
    
    /**
     * Valida um cpf e retorna true se confirmar e false se for invalido
     * @param cpf
     * @return 
     */
    public static boolean validate(String cpf) {
        // TO DO implementar o algoritomo de validacao de cpf
        return true;
    }
    
    /*
     * 
     * GETTERS AND SETTERS
     * 
     */

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CPF other = (CPF) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    public String toString() {
        return "CPF - " + cpf;
    }
    
    private String cpf;    
}
