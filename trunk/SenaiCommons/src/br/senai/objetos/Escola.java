package br.senai.objetos;

import java.util.List;

/**
 *
 * @author Serginho
 */
public class Escola {

    public Escola() {
    }

    public Escola(String nome, String endereco, String diretor, List<Docente> docentes, List<Curso> cursos, List<Laboratorio> labs) {
        this.nome = nome;
        this.endereco = endereco;
        this.diretor = diretor;
        this.docentes = docentes;
        this.cursos = cursos;
        this.labs = labs;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Laboratorio> getLabs() {
        return labs;
    }

    public void setLabs(List<Laboratorio> labs) {
        this.labs = labs;
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
        final Escola other = (Escola) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if ((this.diretor == null) ? (other.diretor != null) : !this.diretor.equals(other.diretor)) {
            return false;
        }
        if (this.docentes != other.docentes && (this.docentes == null || !this.docentes.equals(other.docentes))) {
            return false;
        }
        if (this.cursos != other.cursos && (this.cursos == null || !this.cursos.equals(other.cursos))) {
            return false;
        }
        if (this.labs != other.labs && (this.labs == null || !this.labs.equals(other.labs))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 73 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 73 * hash + (this.diretor != null ? this.diretor.hashCode() : 0);
        hash = 73 * hash + (this.docentes != null ? this.docentes.hashCode() : 0);
        hash = 73 * hash + (this.cursos != null ? this.cursos.hashCode() : 0);
        hash = 73 * hash + (this.labs != null ? this.labs.hashCode() : 0);
        return hash;
    }
    
    private String nome;
    private String endereco;
    private String diretor;
    private List<Docente> docentes;
    private List<Curso> cursos;
    private List<Laboratorio> labs;    
}
