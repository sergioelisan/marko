package br.bcc.ufrpe.businesscore.entidades;

/**
 *
 * @author Serginho
 */
public class Funcionario {

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String matricula, String endereco, String fone, String celular, String cntps, double salario, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.endereco = endereco;
        this.fone = fone;
        this.celular = celular;
        this.cntps = cntps;
        this.salario = salario;
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCntps() {
        return cntps;
    }

    public void setCntps(String cntps) {
        this.cntps = cntps;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if ((this.fone == null) ? (other.fone != null) : !this.fone.equals(other.fone)) {
            return false;
        }
        if ((this.celular == null) ? (other.celular != null) : !this.celular.equals(other.celular)) {
            return false;
        }
        if ((this.cntps == null) ? (other.cntps != null) : !this.cntps.equals(other.cntps)) {
            return false;
        }
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
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
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 67 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 67 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 67 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 67 * hash + (this.fone != null ? this.fone.hashCode() : 0);
        hash = 67 * hash + (this.celular != null ? this.celular.hashCode() : 0);
        hash = 67 * hash + (this.cntps != null ? this.cntps.hashCode() : 0);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 67 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }
    
    private long id;
    private String nome;
    private String cpf;
    private String matricula;
    private String endereco;
    private String fone;
    private String celular;
    private String cntps;
    private double salario;
    private String email;    
}
