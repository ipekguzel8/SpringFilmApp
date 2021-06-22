package com.ozguryaz.filmproject.rest;

import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.User;
import com.ozguryaz.filmproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserRest {
    @Autowired
    public UserRest(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    private IUserService iUserService;
    @GetMapping()
    public List<User> listFilm(){
        List<User> all = iUserService.getAll();
        return all;
    }
}
