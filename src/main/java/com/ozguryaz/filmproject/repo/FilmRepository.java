package com.ozguryaz.filmproject.repo;

import com.ozguryaz.filmproject.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
