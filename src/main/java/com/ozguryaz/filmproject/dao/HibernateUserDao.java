package com.ozguryaz.filmproject.dao;

import com.ozguryaz.filmproject.FilmProjectApplication;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class HibernateUserDao implements IUserDao{
    public HibernateUserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<User> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<User> users = session.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public void add(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        Session session = entityManager.unwrap(Session.class);
        User userToDelete = session.get(User.class, user.getId());
        session.delete(userToDelete);
    }

    @Override
    public void update(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);
        return user;

    }

    @Override
    public List<User> gelByObj(User user) {
        Session session = entityManager.unwrap(Session.class);
        Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.username = :username and user.password = :password");
        query.setParameter("username",user.getUsername());
        query.setParameter( "password",user.getPassword());
        List resultList = query.getResultList();
        return resultList;
    }
}
