package br.senai.objetos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Turno implements Serializable {

    public Turno() {
    }

    public Turno(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turno other = (Turno) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.codigo);
        return hash;
    }
    
    
    
    private Integer codigo;
    
}
