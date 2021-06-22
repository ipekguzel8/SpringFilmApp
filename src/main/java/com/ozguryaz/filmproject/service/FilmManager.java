package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dao.IFilmDao;
import com.ozguryaz.filmproject.dto.FilmDto;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.repo.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
@Service

public class FilmManager implements IFilmService{
    private IFilmDao iFilmDao;

    @Autowired
    public FilmManager(IFilmDao iFilmDao) {
        this.iFilmDao = iFilmDao;
    }


    @Override
    @Transactional
    public List<Film> getAll() {
        return this.iFilmDao.getAll();
    }

    @Override
    @Transactional
    public void add(Film film) {
        this.iFilmDao.add(film);
    }

    @Override
    @Transactional
    public void delete(Film film) {
        this.iFilmDao.delete(film);
    }

    @Override
    @Transactional
    public void update(Film film) {
        this.iFilmDao.update(film);
    }

    @Override
    @Transactional
    public Film getById(Long id) {
        return this.iFilmDao.getById(id);
    }
}
