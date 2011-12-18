package br.ufrpe.bcc.ibusiness.produto;

import br.ufrpe.bcc.ibusiness.categoria.Categoria;
import br.ufrpe.bcc.ibusiness.fornecedor.Fornecedor;
import java.util.Date;

/**
 *
 * @author Serginho
 */
public class Produto {

    public Produto() {
    }

    public Produto(String nome, String descricao, Categoria categoria, Fornecedor fornecedor, int estocado, int disponivel, Date compra, Date vencimento, double precoCompra, double precoVenda) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.estocado = estocado;
        this.disponivel = disponivel;
        this.compra = compra;
        this.vencimento = vencimento;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    public int getEstocado() {
        return estocado;
    }

    public void setEstocado(int estocado) {
        this.estocado = estocado;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
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
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.categoria != other.categoria && (this.categoria == null || !this.categoria.equals(other.categoria))) {
            return false;
        }
        if (this.fornecedor != other.fornecedor && (this.fornecedor == null || !this.fornecedor.equals(other.fornecedor))) {
            return false;
        }
        if (this.estocado != other.estocado) {
            return false;
        }
        if (this.disponivel != other.disponivel) {
            return false;
        }
        if (this.compra != other.compra && (this.compra == null || !this.compra.equals(other.compra))) {
            return false;
        }
        if (this.vencimento != other.vencimento && (this.vencimento == null || !this.vencimento.equals(other.vencimento))) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 97 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 97 * hash + (this.categoria != null ? this.categoria.hashCode() : 0);
        hash = 97 * hash + (this.fornecedor != null ? this.fornecedor.hashCode() : 0);
        hash = 97 * hash + this.estocado;
        hash = 97 * hash + this.disponivel;
        hash = 97 * hash + (this.compra != null ? this.compra.hashCode() : 0);
        hash = 97 * hash + (this.vencimento != null ? this.vencimento.hashCode() : 0);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precoCompra) ^ (Double.doubleToLongBits(this.precoCompra) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precoVenda) ^ (Double.doubleToLongBits(this.precoVenda) >>> 32));
        return hash;
    }
    
    private long id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private int estocado;
    private int disponivel;
    private Date compra;
    private Date vencimento;
    private double precoCompra;
    private double precoVenda;
}
