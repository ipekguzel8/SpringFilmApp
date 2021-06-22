package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.FilmActor;

import java.util.List;

public interface IFilmActorService {
    void addFilmActor(FilmActor filmActor);
    List<Actor> actorList();
    List<Film> filmList();
    Actor getById(Long id);
    Film getByIdFilm(Long id);
    List<FilmActor> getByFilmActor(Long id);
    void deleteActor(Long id);
    void updateActor(Actor actor);
    void updateFA(FilmActor filmActor);
    FilmActor getByIdFA(Long id);
    List<FilmActor> getAll();
}
