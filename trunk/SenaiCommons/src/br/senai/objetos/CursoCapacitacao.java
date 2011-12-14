package br.senai.objetos;

import java.util.List;

/**
 *
 * @author Serginho
 */
public class CursoCapacitacao extends Curso {

    public CursoCapacitacao(String nome, Integer duracao, String nucleo, List<Disciplina> disciplinas) {
        super(nome, duracao, nucleo, disciplinas);
    }

    public CursoCapacitacao(String nome, Integer duracao, String nucleo, List<Disciplina> disciplinas, List<Turma> turmas) {
        super(nome, duracao, nucleo, disciplinas, turmas);
    }

    public CursoCapacitacao() {
    }
    
    
    
}
