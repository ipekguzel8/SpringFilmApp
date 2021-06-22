package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.entities.Film;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateFilmDao implements IFilmDao{

    @Autowired
    private EntityManager entityManager;

    public HibernateFilmDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Film> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Film> films = session.createQuery("from Film").getResultList();
        return films;
    }

    @Override
    public void add(Film film) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(film);
    }

    @Override
    public void delete(Film film) {
        Session session = entityManager.unwrap(Session.class);
        Film filmToDelete = session.get(Film.class, film.getId());
        session.delete(filmToDelete);
    }

    @Override
    public void update(Film film) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(film);
    }

    @Override
    public Film getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Film film = session.get(Film.class, id);
        return film;
    }
}
