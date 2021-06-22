package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dao.IActorDao;
import com.ozguryaz.filmproject.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorManager implements IActorService{
    private IActorDao iActorDao;

    @Autowired
    public ActorManager(IActorDao iActorDao) {
        this.iActorDao = iActorDao;
    }

    @Override
    @Transactional
    public List<Actor> getAll() {
        return this.iActorDao.getAll();
    }

    @Override
    @Transactional
    public void add(Actor actor) {
        this.iActorDao.add(actor);
    }

    @Override
    @Transactional
    public void delete(Actor actor) {
        this.iActorDao.delete(actor);
    }

    @Override
    @Transactional
    public void update(Actor actor) {
        this.iActorDao.update(actor);
    }

    @Override
    @Transactional
    public Actor getById(Long id) {
        return this.iActorDao.getById(id);
    }

    @Override
    @Transactional
    public List<Actor> gelByObj(Actor actor) {
        return this.iActorDao.gelByObj(actor);
    }
}
