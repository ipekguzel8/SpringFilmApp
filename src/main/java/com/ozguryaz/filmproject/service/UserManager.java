package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dao.IUserDao;
import com.ozguryaz.filmproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManager implements IUserService{
    @Autowired
    public UserManager(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    IUserDao iUserDao;

    @Override
    @Transactional
    public List<User> getAll() {
        return this.iUserDao.getAll();
    }

    @Override
    @Transactional
    public void add(User user) {
        this.iUserDao.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.iUserDao.delete(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        this.iUserDao.update(user);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return this.iUserDao.getById(id);

    }

    @Override
    public List<User> getByObj(User user) {
        return this.iUserDao.gelByObj(user);
    }
}
