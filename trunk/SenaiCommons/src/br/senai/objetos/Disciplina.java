package br.senai.objetos;

import java.io.Serializable;

/**
 *
 * @author Serginho
 */
public class Disciplina implements Comparable<Disciplina>, Serializable {

    public Disciplina(String nome, Integer carga, String ementa, Integer modulo, Laboratorio lab) {
        this.nome = nome;
        this.carga = carga;
        this.ementa = ementa;
        this.modulo = modulo;
        this.lab = lab;
    }

    public Disciplina() {
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Laboratorio getLab() {
        return lab;
    }

    public void setLab(Laboratorio lab) {
        this.lab = lab;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.carga != other.carga && (this.carga == null || !this.carga.equals(other.carga))) {
            return false;
        }
        if ((this.ementa == null) ? (other.ementa != null) : !this.ementa.equals(other.ementa)) {
            return false;
        }
        if (this.modulo != other.modulo && (this.modulo == null || !this.modulo.equals(other.modulo))) {
            return false;
        }
        if (this.lab != other.lab && (this.lab == null || !this.lab.equals(other.lab))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.carga != null ? this.carga.hashCode() : 0);
        hash = 29 * hash + (this.ementa != null ? this.ementa.hashCode() : 0);
        hash = 29 * hash + (this.modulo != null ? this.modulo.hashCode() : 0);
        hash = 29 * hash + (this.lab != null ? this.lab.hashCode() : 0);
        return hash;
    }

    private Long id;
    private String nome;
    private Integer carga;
    private String ementa;
    private Integer modulo;
    private Laboratorio lab;

    @Override
    public int compareTo(Disciplina o) {
        return carga < o.carga ? -1 : carga == o.carga ? 0 : 1;
    }
}
