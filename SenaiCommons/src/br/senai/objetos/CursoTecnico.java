package br.senai.objetos;

import java.util.List;

/**
 *
 * @author Serginho
 */
public class CursoTecnico extends Curso {

    public CursoTecnico(Boolean pago, String nome, Integer duracao, String nucleo, List<Disciplina> disciplinas) {
        super(nome, duracao, nucleo, disciplinas);
        this.pago = pago;
    }

    public CursoTecnico(Boolean pago, String nome, Integer duracao, String nucleo, List<Disciplina> disciplinas, List<Turma> turmas) {
        super(nome, duracao, nucleo, disciplinas, turmas);
        this.pago = pago;
    }

    public CursoTecnico(Boolean pago) {
        this.pago = pago;
    }

    public CursoTecnico() {
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CursoTecnico other = (CursoTecnico) obj;
        if (this.pago != other.pago && (this.pago == null || !this.pago.equals(other.pago))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.pago != null ? this.pago.hashCode() : 0);
        return hash;
    }

    private Boolean pago;    
}
