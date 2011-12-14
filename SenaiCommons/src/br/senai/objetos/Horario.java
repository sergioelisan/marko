package br.senai.objetos;

import br.senai.util.Tupla;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Serginho
 */
public class Horario implements Serializable {

    public Horario() {
    }

    public Horario(Map<Date, Tupla<Aula, Aula>> aulas) {
        this.aulas = aulas;
    }

    /**
     * Inicia um horario com os dias uteis, mas vago para alocação de aulas
     * @param diasUteis 
     */
    public Horario(List<Date> diasUteis) {
        aulas = new HashMap<>();
        // preenche o horario com dias uteis vazios
        for (Date dia : diasUteis) {
            aulas.put(dia, null);
        }
    }

    /**
     * Insere duas aulas em um dia. É chamado quando a opcao de horas por dia eh 4.
     * Dai insere no dia, mas se o dia estiver ocupado, retorna false.
     * @param dia
     * @param aulas
     * @return se o dia foi alocado ou nao
     */
    public boolean addAula(Tupla<Aula, Aula> aulas) {
        // Procura em todos os dias por um dia vago
        for (Date dia : this.aulas.keySet()) {
            if (this.aulas.get(dia) == null) {
                this.aulas.put(dia, aulas);
                return true;
            }
        }
        // Se nao encontrar entao retorna false
        return false;
    }

    /**
     * Adiciona uma aula na primeira vaga de um dia especifico. Senao retorna falso.
     * Esse metodo é usado quando o horario é segmentado em duas disciplinas por dia
     * @param dia
     * @param aula
     * @return verdadeiro se alocou e falso se nao alocou
     */
    public boolean addAula(Aula aula) {
        // Procura por uma dia vago
        for (Date dia : this.aulas.keySet()) {
            // se nada foi alocado no dia ainda
            if (aulas.get(dia) == null) {
                aulas.put(dia, new Tupla<Aula, Aula>(aula, null));
                return true;
            } // se o segundo horario estiver vago e a primeira aula nao for da mesma disciplina
            else if (aulas.get(dia).getSegundo() == null && !aulas.get(dia).getPrimeiro().equals(aula)) {
                aulas.get(dia).setSegundo(aula);
                return true;
            }
        }
        // Se nao achar nenhum dia vago
        return false;
    }

    /**
     * Adiciona as aulas de uma turma em um determinado dia
     * @param dia quando as aulas serao lecionadas
     * @param aulas que serao lecionadas
     */
    public void setDiaAula(Date dia, Tupla<Aula, Aula> aulas) {
        this.aulas.put(dia, aulas);
    }

    /**
     * Retorna um dicionario com as aulas do dia
     * @param dia
     * @return 
     */
    public Tupla<Aula, Aula> getDiaDeAula(Date dia) {
        return aulas.get(dia);
    }

    /**
     * 
     * @return o dicionario de aulas
     */
    public Map<Date, Tupla<Aula, Aula>> getAulas() {
        return aulas;
    }
    private Map<Date, Tupla<Aula, Aula>> aulas;
}
