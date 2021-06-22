package com.ozguryaz.filmproject.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actor")
public class Actor extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", length = 50)
    private String name;

    public Actor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Actor() {

    }

    public Actor(String name) {
        this.name = name;
    }

    public Actor(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }
}