package bcc.ibusiness.dominio;

/**
 *
 * @author Serginho
 */
public class Usuario {

    public Usuario() {
    }

    public Usuario(String login, String passwd, Funcionario funcionario) {
        this.login = login;
        this.passwd = passwd;
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.passwd == null) ? (other.passwd != null) : !this.passwd.equals(other.passwd)) {
            return false;
        }
        if (this.funcionario != other.funcionario && (this.funcionario == null || !this.funcionario.equals(other.funcionario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 23 * hash + (this.passwd != null ? this.passwd.hashCode() : 0);
        hash = 23 * hash + (this.funcionario != null ? this.funcionario.hashCode() : 0);
        return hash;
    }
    
    private long id;
    private String login;
    private String passwd;
    private Funcionario funcionario;
    
}
