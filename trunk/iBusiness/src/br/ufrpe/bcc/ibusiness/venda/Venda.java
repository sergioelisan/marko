package br.ufrpe.bcc.ibusiness.venda;

import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import br.ufrpe.bcc.ibusiness.funcionario.Funcionario;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Serginho
 */
public class Venda {

    public Venda() {
    }

    public Venda(Date horario, Funcionario funcionario, Cliente cliente, Set<Item> item) {
        this.horario = horario;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.item = item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Item> getItem() {
        return item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }
    
    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.horario != other.horario && (this.horario == null || !this.horario.equals(other.horario))) {
            return false;
        }
        if (this.cliente != other.cliente && (this.cliente == null || !this.cliente.equals(other.cliente))) {
            return false;
        }
        if (this.item != other.item && (this.item == null || !this.item.equals(other.item))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.horario != null ? this.horario.hashCode() : 0);
        hash = 97 * hash + (this.cliente != null ? this.cliente.hashCode() : 0);
        hash = 97 * hash + (this.item != null ? this.item.hashCode() : 0);
        return hash;
    }
    private long id;
    private Date horario;
    private Cliente cliente;
    private Funcionario funcionario;
    private Set<Item> item;

    
}
