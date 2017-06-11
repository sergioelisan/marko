package com.marko.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Serginho
 */
public class Venda {

    private int id;
    private Date horario;
    private Cliente cliente;
    private ArrayList<Item> itens;
    private Funcionario funcionario;

    public Venda() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

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
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return Objects.equals(this.funcionario, other.funcionario);
    }

    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.horario);
        hash = 47 * hash + Objects.hashCode(this.cliente);
        hash = 47 * hash + Objects.hashCode(this.itens);
        hash = 47 * hash + Objects.hashCode(this.funcionario);
        return hash;
    }
}