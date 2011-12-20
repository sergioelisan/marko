package br.ufrpe.bcc.ibusiness.despesa;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Despesa {

    private int id;
    private String descricao;
    private String credor;
    private Double valor;
    private Date lancamento;

    public Despesa() {
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Despesa other = (Despesa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.credor, other.credor)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.lancamento, other.lancamento)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.credor);
        hash = 29 * hash + Objects.hashCode(this.valor);
        hash = 29 * hash + Objects.hashCode(this.lancamento);
        return hash;
    }
}
