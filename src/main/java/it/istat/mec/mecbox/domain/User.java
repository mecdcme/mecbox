package it.istat.mec.mecbox.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Istat MecBox Team
 */
@Entity
@Table(name = "mb_users")
@DynamicUpdate
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userid;

    @Column(name = "password", length = 100)
    private String password;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @OneToOne(mappedBy = "user", orphanRemoval = true)
    @JsonManagedReference
    private UserRole role;

    public User() {

    }

    public User(String email, String fullname) {
        this.email = email;

    }

    public User(Long userid, String email, String fullname) {
        this.userid = userid;
        this.email = email;

    }

    public User(User user) {
        this.userid = user.userid;
        this.name = user.name;
        this.surname = user.surname;
        this.email = user.email;
        this.password = user.password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + userid + ", email='" + email + '\'' + ", passwordHash='" + password + '\'' + '}';
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
