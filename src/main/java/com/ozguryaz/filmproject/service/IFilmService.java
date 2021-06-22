package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dto.FilmDto;
import com.ozguryaz.filmproject.entities.Film;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IFilmService {

    List<Film> getAll();
    void add(Film film);
    void delete(Film film);
    void update(Film film);
    Film getById(Long id);
}
