package br.senai.objetos;

import java.io.Serializable;

/**
 * 
 * @author Sergio Lisan
 */
public class Aula implements Serializable {

    public Aula() {
    }

    public Aula(Docente docente, Disciplina disciplina, Laboratorio lab) {
        this.docente = docente;
        this.disciplina = disciplina;
        this.lab = lab;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Laboratorio getLab() {
        return lab;
    }

    public void setLab(Laboratorio lab) {
        this.lab = lab;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aula other = (Aula) obj;
        if (this.docente != other.docente && (this.docente == null || !this.docente.equals(other.docente))) {
            return false;
        }
        if (this.disciplina != other.disciplina && (this.disciplina == null || !this.disciplina.equals(other.disciplina))) {
            return false;
        }
        if (this.lab != other.lab && (this.lab == null || !this.lab.equals(other.lab))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.docente != null ? this.docente.hashCode() : 0);
        hash = 61 * hash + (this.disciplina != null ? this.disciplina.hashCode() : 0);
        hash = 61 * hash + (this.lab != null ? this.lab.hashCode() : 0);
        return hash;
    }
    
    private Docente docente;
    private Disciplina disciplina;
    private Laboratorio lab;   
    
}
