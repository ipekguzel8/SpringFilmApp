package com.ozguryaz.filmproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FilmActor")
public class FilmActor extends BaseEntity{
    public FilmActor(Film film) {
        this.setFilm(film);
        System.out.println(film.getId());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_Film",foreignKey = @ForeignKey(name = "FK_Film_Actor_Film"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Film film;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ID_Actor", foreignKey = @ForeignKey(name = "FK_Film_Actor_Actor"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Actor actor;

    @Column(name = "Role", length = 100)
    private String role;

    @Column(name = "Role_Description")
    private String roleDescription;

    public String actorName() {
        return actor.getName();
    }

    public FilmActor() {

    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "id=" + id +
                ", film=" + film.toString() +
                ", actor=" + actor.toString() +
                ", role='" + role + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    public FilmActor(Long id, Film film, Actor actor, String role, String roleDescription) {
        this.id = id;
        this.film = film;
        this.actor = actor;
        this.role = role;
        this.roleDescription = roleDescription;
    }

    public FilmActor(Film film, Actor actor, String role, String roleDescription) {
        this.film = film;
        this.actor = actor;
        this.role = role;
        this.roleDescription = roleDescription;
    }

    public FilmActor(Actor actor) {
        this.actor = actor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public Long getId() {
        return id;
    }
}