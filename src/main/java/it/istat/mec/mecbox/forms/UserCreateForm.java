package it.istat.mec.mecbox.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class UserCreateForm {

    private Long userid;

    @NotNull
    @Email
    @Size(min = 2, max = 100)
    private String email;

    @NotNull
    @Size(min = 2, max = 50)
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    private String nome;

    @NotNull
    @Size(min = 2, max = 30)
    private String cognome;

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @NotNull
    @Size(min = 2, max = 30)
    private String role;

    ;

	public String toString() {
        return "Person(Email: " + this.email + ", Nome: " + this.nome + ", Cognome: " + this.cognome + ")";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

}
