package br.senai.objetos;

import java.io.Serializable;

/**
 *
 * @author Serginho
 */
public class Formacao implements Serializable {

    public Formacao() {
    }

    public Formacao(Integer indice, String descricao) {
        this.indice = indice;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formacao other = (Formacao) obj;
        if (this.indice != other.indice && (this.indice == null || !this.indice.equals(other.indice))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.indice != null ? this.indice.hashCode() : 0);
        hash = 89 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        return hash;
    }
    
    private Integer indice;
    private String descricao;
}
