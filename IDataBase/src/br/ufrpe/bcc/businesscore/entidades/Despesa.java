package br.ufrpe.bcc.businesscore.entidades;

import java.util.Date;

/**
 *
 * @author Serginho
 */
public class Despesa {

    public Despesa() {
    }

    public Despesa(String descricao, String credor, double valor, Date lancamento) {
        this.descricao = descricao;
        this.credor = credor;
        this.valor = valor;
        this.lancamento = lancamento;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
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
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if ((this.credor == null) ? (other.credor != null) : !this.credor.equals(other.credor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.lancamento != other.lancamento && (this.lancamento == null || !this.lancamento.equals(other.lancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 97 * hash + (this.credor != null ? this.credor.hashCode() : 0);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 97 * hash + (this.lancamento != null ? this.lancamento.hashCode() : 0);
        return hash;
    }
    
    private long id;
    private String descricao;
    private String credor;
    private double valor;
    private Date lancamento;    
}
