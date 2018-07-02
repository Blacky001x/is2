package com.miroslav.is2.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "email", unique = true, nullable = true)
    @Email(message = "* Please, provide valid email.")
    @NotEmpty(message = "* Please, provide an email.")
    private String email;

    @Column(name = "password", unique = false, nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Lob
    private String password;

    @Column(name = "name", unique = false, nullable = false)
    @NotEmpty(message = "* Please, provide your name")
    private String name;

    @Column(name = "last_name", unique = false, nullable = false)
    @NotEmpty(message = "* Please, provide your last name")
    private String lastName;

    @Column(name = "active", unique = false, nullable = false)
    private int active;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id", unique = false) },
            inverseJoinColumns = { @JoinColumn(name = "role_id", unique = false) }
            )
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
