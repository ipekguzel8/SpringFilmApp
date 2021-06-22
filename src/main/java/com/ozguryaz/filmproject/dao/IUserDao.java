package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.User;

import java.util.List;

public interface IUserDao {
    List<User> getAll();
    void add(User user);
    void delete(User user);
    void update(User user);
    User getById(Long id);
    List<User> gelByObj(User user);
}
