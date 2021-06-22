package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dao.IActorDao;
import com.ozguryaz.filmproject.dao.IFilmActorDao;
import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.FilmActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmActorManager implements IFilmActorService{
    private IFilmActorDao iFilmActorDao;
    @Autowired
    public FilmActorManager(IFilmActorDao iFilmActorDao) {
        this.iFilmActorDao = iFilmActorDao;
    }

    @Override
    @Transactional
    public void addFilmActor(FilmActor filmActor) {
        this.iFilmActorDao.addFilmActor(filmActor);
    }

    @Override
    @Transactional
    public List<Actor> actorList() {
        return this.iFilmActorDao.actorList();
    }

    @Override
    @Transactional
    public List<Film> filmList() {
        return this.iFilmActorDao.filmList();
    }

    @Override
    @Transactional
    public Actor getById(Long id) {
        return this.iFilmActorDao.getById(id);
    }

    @Override
    @Transactional
    public Film getByIdFilm(Long id) {
        return this.iFilmActorDao.getByIdFilm(id);
    }

    @Override
    @Transactional
    public List<FilmActor> getByFilmActor(Long id) {
        return this.iFilmActorDao.getByFilmActor(id);
    }

    @Override
    @Transactional
    public void deleteActor(Long id) {
        this.iFilmActorDao.deleteActor(id);
    }

    @Override
    @Transactional
    public void updateActor(Actor actor) {
        this.iFilmActorDao.updateActor(actor);
    }

    @Override
    @Transactional
    public void updateFA(FilmActor filmActor) {
        this.iFilmActorDao.updateFA(filmActor);
    }

    @Override
    @Transactional
    public FilmActor getByIdFA(Long id) {
        return iFilmActorDao.getByIdFA(id);
    }

    @Override
    @Transactional
    public List<FilmActor> getAll() {
        return iFilmActorDao.getAll();
    }

}
