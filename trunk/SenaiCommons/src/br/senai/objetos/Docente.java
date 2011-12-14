package br.senai.objetos;

import java.util.Date;

/**
 *
 * @author Serginho
 */
public class Docente {

    public Docente() {
    }

    public Docente(Long matricula, String nome, String nucleo, Formacao formacao, Date contratacao, Turno primeiroTurno, Turno segundoTurno) {
        this.matricula = matricula;
        this.nome = nome;
        this.nucleo = nucleo;
        this.formacao = formacao;
        this.contratacao = contratacao;
        this.primeiroTurno = primeiroTurno;
        this.segundoTurno = segundoTurno;
    }

    public Date getContratacao() {
        return contratacao;
    }

    public void setContratacao(Date contratacao) {
        this.contratacao = contratacao;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public Turno getPrimeiroTurno() {
        return primeiroTurno;
    }

    public void setPrimeiroTurno(Turno primeiroTurno) {
        this.primeiroTurno = primeiroTurno;
    }

    public Turno getSegundoTurno() {
        return segundoTurno;
    }

    public void setSegundoTurno(Turno segundoTurno) {
        this.segundoTurno = segundoTurno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Docente other = (Docente) obj;
        if (this.matricula != other.matricula && (this.matricula == null || !this.matricula.equals(other.matricula))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.nucleo == null) ? (other.nucleo != null) : !this.nucleo.equals(other.nucleo)) {
            return false;
        }
        if (this.formacao != other.formacao && (this.formacao == null || !this.formacao.equals(other.formacao))) {
            return false;
        }
        if (this.contratacao != other.contratacao && (this.contratacao == null || !this.contratacao.equals(other.contratacao))) {
            return false;
        }
        if (this.primeiroTurno != other.primeiroTurno && (this.primeiroTurno == null || !this.primeiroTurno.equals(other.primeiroTurno))) {
            return false;
        }
        if (this.segundoTurno != other.segundoTurno && (this.segundoTurno == null || !this.segundoTurno.equals(other.segundoTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 67 * hash + (this.nucleo != null ? this.nucleo.hashCode() : 0);
        hash = 67 * hash + (this.formacao != null ? this.formacao.hashCode() : 0);
        hash = 67 * hash + (this.contratacao != null ? this.contratacao.hashCode() : 0);
        hash = 67 * hash + (this.primeiroTurno != null ? this.primeiroTurno.hashCode() : 0);
        hash = 67 * hash + (this.segundoTurno != null ? this.segundoTurno.hashCode() : 0);
        return hash;
    }
    
    
    
    private Long matricula;
    private String nome;
    private String nucleo;
    private Formacao formacao;
    private Date contratacao;
    private Turno primeiroTurno;
    private Turno segundoTurno;
}
