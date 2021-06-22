package com.ozguryaz.filmproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "Authorization")
    @Enumerated(EnumType.STRING)
    private Authorization authorization;

    public User() {

    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
    public User(Long id, String username, String password, Authorization authorization) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorization = authorization;
    }

    public User(String username, String password, Authorization authorization) {
        this.username = username;
        this.password = password;
        this.authorization = authorization;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

