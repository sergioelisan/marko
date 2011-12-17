package br.bcc.ufrpe.businesscore.entidades;

/**
 *
 * @author Serginho
 */
public class Cliente {

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String endereco, String fone, String cel, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.fone = fone;
        this.cel = cel;
        this.email = email;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if ((this.fone == null) ? (other.fone != null) : !this.fone.equals(other.fone)) {
            return false;
        }
        if ((this.cel == null) ? (other.cel != null) : !this.cel.equals(other.cel)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 17 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 17 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 17 * hash + (this.fone != null ? this.fone.hashCode() : 0);
        hash = 17 * hash + (this.cel != null ? this.cel.hashCode() : 0);
        hash = 17 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String fone;
    private String cel;
    private String email;    
}
