package br.senai.objetos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Turma implements Serializable {

    public Turma() {
    }

    public Turma(String nome, Date entrada, Date saida, Horario horario, Turno turno) {
        this.nome = nome;
        this.entrada = entrada;
        this.saida = saida;
        this.horario = horario;
        this.turno = turno;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.entrada, other.entrada)) {
            return false;
        }
        if (!Objects.equals(this.saida, other.saida)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.entrada);
        hash = 43 * hash + Objects.hashCode(this.saida);
        hash = 43 * hash + Objects.hashCode(this.horario);
        hash = 43 * hash + Objects.hashCode(this.turno);
        return hash;
    }

    private Long id;
    private String nome;
    private Date entrada;
    private Date saida;
    private Horario horario;
    private Turno turno;    
}
