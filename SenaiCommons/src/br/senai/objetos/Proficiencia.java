package br.senai.objetos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Proficiencia implements Serializable {

    public Proficiencia() {
    }

    public Proficiencia(Integer indice, Disciplina disciplina, Integer vezesLecionada) {
        this.indice = indice;
        this.disciplina = disciplina;
        this.vezesLecionada = vezesLecionada;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public Integer getVezesLecionada() {
        return vezesLecionada;
    }

    public void setVezesLecionada(Integer vezesLecionada) {
        this.vezesLecionada = vezesLecionada;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proficiencia other = (Proficiencia) obj;
        if (!Objects.equals(this.indice, other.indice)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.vezesLecionada, other.vezesLecionada)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.indice);
        hash = 67 * hash + Objects.hashCode(this.disciplina);
        hash = 67 * hash + Objects.hashCode(this.vezesLecionada);
        return hash;
    }

    private Integer indice;
    private Disciplina disciplina;
    private Integer vezesLecionada;
}
