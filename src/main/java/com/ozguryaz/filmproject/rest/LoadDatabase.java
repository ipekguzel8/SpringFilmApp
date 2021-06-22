package com.ozguryaz.filmproject.rest;

import com.ozguryaz.filmproject.entities.Film;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
           // log.info("Preloading " + repository.save(new Film()));
           // log.info("Preloading " + repository.save(new Film()));
        };
    }
}
