package com.ozguryaz.filmproject.rest;

import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.FilmActor;
import com.ozguryaz.filmproject.service.IFilmActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/filmactor")
public class FilmActorRest {
    @Autowired
    private IFilmActorService iFilmActorService;

    public FilmActorRest(IFilmActorService iFilmActorService) {
        this.iFilmActorService = iFilmActorService;
    }
    @GetMapping()
    public List<FilmActor> listFilm(){
        List<FilmActor> all = iFilmActorService.getAll();
        return all;
    }
}
