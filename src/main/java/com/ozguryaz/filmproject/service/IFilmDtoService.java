package com.ozguryaz.filmproject.service;

import com.ozguryaz.filmproject.dto.FilmDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IFilmDtoService {
    FilmDto save(FilmDto filmDto);
    List<FilmDto> getAllDto();
    Page<FilmDto> getAllDto(Pageable pageable);
}
