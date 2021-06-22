package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dto.FilmDto;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.repo.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmDtoService implements IFilmDtoService{
    private final FilmRepository filmRepository;
    @Override
    public FilmDto save(FilmDto filmDto) {
        Film film= new Film();
        film.setId(filmDto.getId());
        film.setName(filmDto.getName());
        film.setType(filmDto.getType());
        final Film filmDb= filmRepository.save(film);
        return null;
    }

    @Override
    public List<FilmDto> getAllDto() {
        List<Film> all =filmRepository.findAll();
        List<FilmDto> filmDtos= new ArrayList<>();
        for(Film film: all){
            FilmDto filmDto=new FilmDto();
            filmDto.setId(film.getId());
            filmDto.setName(film.getName());
            filmDto.setType(film.getType());
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }

    @Override
    public Page<FilmDto> getAllDto(Pageable pageable) {
        return null;
    }

}
