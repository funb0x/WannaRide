package com.wannaride.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    @Column(name = "id_user")
    private Integer idUser;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @Size(min = 3, max = 24, message = "Login must be between 3 and 24 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Login must be alphanumeric with no spaces")
    @Column(name = "login", unique = true)
    private String login;

    @Size(min = 6, max = 20, message = "Password must be between 3 and 12 characters long.")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})", message="Invalid emailaddress.")
    @Column(name = "email", unique = true)
    private String email;

    @Pattern(regexp="+380[0-9]{2} [0-9]{3}-[0-9]{2}-[0-9]{2}", message="Wrong cellphone number. Input like +380XX XXX-XX-XX")
    @Column(name = "cell")
    private String cell;

    public User() {}

    public User(Role role, String login, String password, String email, String cell) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.cell = cell;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", cell='" + cell + '\'' +
                '}';
    }
}
