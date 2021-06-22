package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.entities.Film;

import java.util.List;

public interface IFilmDao {
    List<Film> getAll();
    void add(Film film);
    void delete(Film film);
    void update(Film film);
    Film getById(Long id);
}
