package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.entities.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> getAll();
    void add(Actor actor);
    void delete(Actor actor);
    void update(Actor actor);
    Actor getById(Long id);
    List<Actor> gelByObj(Actor actor);
}
