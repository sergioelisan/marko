/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.util;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Tupla<T, K> implements Serializable {

    public Tupla(T primeiro, K segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public T getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(T primeiro) {
        this.primeiro = primeiro;
    }

    public K getSegundo() {
        return segundo;
    }

    public void setSegundo(K segundo) {
        this.segundo = segundo;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tupla<T, K> other = (Tupla<T, K>) obj;
        if (!Objects.equals(this.primeiro, other.primeiro)) {
            return false;
        }
        if (!Objects.equals(this.segundo, other.segundo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.primeiro);
        hash = 47 * hash + Objects.hashCode(this.segundo);
        return hash;
    }
    
    private T primeiro;
    private K segundo;
}
