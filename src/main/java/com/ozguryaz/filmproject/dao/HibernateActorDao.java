package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.Film;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateActorDao implements IActorDao{
    @Autowired
    private EntityManager entityManager;

    public HibernateActorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Actor> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Actor> actors = session.createQuery("from Actor ").getResultList();
        return actors;
    }

    @Override
    public void add(Actor actor) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(actor);
    }

    @Override
    public void delete(Actor actor) {
        Session session = entityManager.unwrap(Session.class);
        Actor actorToDelete = session.get(Actor.class, actor.getId());
        session.delete(actorToDelete);
    }

    @Override
    public void update(Actor actor) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(actor);
    }

    @Override
    public Actor getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Actor actor = session.get(Actor.class, id);
        return actor;
    }

    @Override
    public List<Actor> gelByObj(Actor actor) {
        return null;
    }
}
