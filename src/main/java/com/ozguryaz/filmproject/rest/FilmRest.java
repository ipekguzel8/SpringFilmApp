package com.ozguryaz.filmproject.rest;

import com.ozguryaz.filmproject.dto.FilmDto;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.service.IFilmDtoService;
import com.ozguryaz.filmproject.service.IFilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/films")
@RequiredArgsConstructor
public class FilmRest {
    private final IFilmDtoService iFilmService;

    @GetMapping()
    public ResponseEntity<List<FilmDto>> tumunuListele() {
        return ResponseEntity.ok(iFilmService.getAllDto());
    }
}
