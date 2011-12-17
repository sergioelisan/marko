package br.bcc.ufrpe.businesscore.entidades;

import java.util.Set;

/**
 *
 * @author Serginho
 */
public class Fornecedor {

    public Fornecedor() {
    }

    public Fornecedor(String razao, String cnpj, String endereco, String fone, String fax, String representante, Set<Produto> produtos) {
        this.razao = razao;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.fone = fone;
        this.fax = fax;
        this.representante = representante;
        this.produtos = produtos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.razao == null) ? (other.razao != null) : !this.razao.equals(other.razao)) {
            return false;
        }
        if ((this.cnpj == null) ? (other.cnpj != null) : !this.cnpj.equals(other.cnpj)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if ((this.fone == null) ? (other.fone != null) : !this.fone.equals(other.fone)) {
            return false;
        }
        if ((this.fax == null) ? (other.fax != null) : !this.fax.equals(other.fax)) {
            return false;
        }
        if ((this.representante == null) ? (other.representante != null) : !this.representante.equals(other.representante)) {
            return false;
        }
        if (this.produtos != other.produtos && (this.produtos == null || !this.produtos.equals(other.produtos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + (this.razao != null ? this.razao.hashCode() : 0);
        hash = 53 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        hash = 53 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 53 * hash + (this.fone != null ? this.fone.hashCode() : 0);
        hash = 53 * hash + (this.fax != null ? this.fax.hashCode() : 0);
        hash = 53 * hash + (this.representante != null ? this.representante.hashCode() : 0);
        hash = 53 * hash + (this.produtos != null ? this.produtos.hashCode() : 0);
        return hash;
    }
    
    private long id;
    private String razao;
    private String cnpj;
    private String endereco;
    private String fone;
    private String fax;
    private String representante;
    private Set<Produto> produtos;
    
}
