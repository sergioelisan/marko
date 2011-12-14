package br.senai.objetos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Laboratorio implements Serializable {

    public Laboratorio() {
    }

    public Laboratorio(String nome, String definicao) {
        this.nome = nome;
        this.definicao = definicao;
    }

    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laboratorio other = (Laboratorio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.definicao, other.definicao)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.definicao);
        return hash;
    }
    
    private Long id;
    private String nome;
    private String definicao;
}
