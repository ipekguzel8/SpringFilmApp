package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.FilmActor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HibernateFilmActorDao implements IFilmActorDao{

    private EntityManager entityManager;
    @Autowired
    public HibernateFilmActorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addFilmActor(FilmActor filmActor) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(filmActor);
    }

    @Override
    @Transactional
    public List<Actor> actorList() {
        Session session = entityManager.unwrap(Session.class);
        List<Actor> actors = session.createQuery("from Actor ").getResultList();
        return actors;
    }

    @Override
    public List<Film> filmList() {
        Session session = entityManager.unwrap(Session.class);
        List<Film> films = session.createQuery("from Film ").getResultList();
        return films;
    }

    @Override
    public Actor getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Actor actor = session.get(Actor.class, id);
        return actor;
    }

    @Override
    public Film getByIdFilm(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Film film = session.get(Film.class, id);
        return film;
    }

    @Override
    public List<FilmActor> getByFilmActor(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = entityManager.createQuery("SELECT filmActor FROM FilmActor filmActor WHERE filmActor.film.id = :id ");
        query.setParameter("id",id);
        List resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<FilmActor> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<FilmActor> filmActor = session.createQuery("from FilmActor ").getResultList();
        return filmActor;
    }

    @Override
    public void deleteActor(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = entityManager.createQuery("DELETE FROM FilmActor filmActor WHERE filmActor.actor.id = :id ");
        query.setParameter("id",id);
        int i = query.executeUpdate();
    }

    @Override
    public void updateActor(Actor actor) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(actor);
    }

    @Override
    public void updateFA(FilmActor filmActor) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(filmActor);
    }

    @Override
    public FilmActor getByIdFA(Long id) {
        Session session = entityManager.unwrap(Session.class);
        FilmActor filmActor = session.get(FilmActor.class, id);
        return filmActor;
    }

}
