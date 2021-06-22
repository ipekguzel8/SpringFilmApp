package com.ozguryaz.filmproject.rest;

import com.ozguryaz.filmproject.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Film, Long> {
}
