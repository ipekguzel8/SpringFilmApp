package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    void add(User user);
    void delete(User user);
    void update(User user);
    User getById(long id);
    List<User> getByObj(User user);
}
