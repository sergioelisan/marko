package br.senai.objetos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Serginho
 */
abstract public class Curso implements Serializable {

    public Curso() {
    }

    public Curso(String nome, Integer duracao, String nucleo, List<Disciplina> disciplinas, List<Turma> turmas) {
        this.nome = nome;
        this.duracao = duracao;
        this.nucleo = nucleo;
        this.disciplinas = disciplinas;
        this.turmas = turmas;
    }

    public Curso(String nome, Integer duracao, String nucleo, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.duracao = duracao;
        this.nucleo = nucleo;
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
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

    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.duracao != other.duracao && (this.duracao == null || !this.duracao.equals(other.duracao))) {
            return false;
        }
        if ((this.nucleo == null) ? (other.nucleo != null) : !this.nucleo.equals(other.nucleo)) {
            return false;
        }
        if (this.disciplinas != other.disciplinas && (this.disciplinas == null || !this.disciplinas.equals(other.disciplinas))) {
            return false;
        }
        if (this.turmas != other.turmas && (this.turmas == null || !this.turmas.equals(other.turmas))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 23 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 23 * hash + (this.duracao != null ? this.duracao.hashCode() : 0);
        hash = 23 * hash + (this.nucleo != null ? this.nucleo.hashCode() : 0);
        hash = 23 * hash + (this.disciplinas != null ? this.disciplinas.hashCode() : 0);
        hash = 23 * hash + (this.turmas != null ? this.turmas.hashCode() : 0);
        return hash;
    }

    private Long id;
    private String nome;
    private Integer duracao;
    private String nucleo;    
    private List<Disciplina> disciplinas;
    private List<Turma> turmas;
}
