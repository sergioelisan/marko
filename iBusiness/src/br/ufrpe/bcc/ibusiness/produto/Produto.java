package br.ufrpe.bcc.ibusiness.produto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Produto implements Comparable<Produto> {

    private int id;
    private String nome;
    private String descricao;
    private int estocado;
    private Date compra;
    private Date vencimento;
    private double precoCompra;
    private double precoVenda;

    public Produto() {
    }

    public Date getCompra() {
        return compra;
    }

    public void setCompra(Date compra) {
        this.compra = compra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstocado() {
        return estocado;
    }

    public void setEstocado(int estocado) {
        this.estocado = estocado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.estocado != other.estocado) {
            return false;
        }
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoCompra) != Double.doubleToLongBits(other.precoCompra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoVenda) != Double.doubleToLongBits(other.precoVenda)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + this.estocado;
        hash = 59 * hash + Objects.hashCode(this.compra);
        hash = 59 * hash + Objects.hashCode(this.vencimento);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.precoCompra) ^ (Double.doubleToLongBits(this.precoCompra) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.precoVenda) ^ (Double.doubleToLongBits(this.precoVenda) >>> 32));
        return hash;
    }

    @Override
    public int compareTo(Produto o) {
        return nome.compareTo(o.nome);
    }
}
