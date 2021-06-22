package com.ozguryaz.filmproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "media")
    private String media;

    public Film() {
    }

    public Film(Integer year) {
        this.year = year;
    }

    public Film(String name) {
        this.name = name;
    }

    public Film(Long id) {
        this.id = id;
    }

    public Film(Long id, String name, int year, String type, String description, String media) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.type = type;
        this.description = description;
        this.media = media;
    }

    public Film(String name, int year, String type, String description, String media) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.description = description;
        this.media = media;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Long getId() {
        return id;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}
