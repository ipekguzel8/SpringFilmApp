package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.User;

import java.util.List;

public interface IActorDao {
    List<Actor> getAll();
    void add(Actor actor);
    void delete(Actor actor);
    void update(Actor actor);
    Actor getById(Long id);
    List<Actor> gelByObj(Actor actor);
}
