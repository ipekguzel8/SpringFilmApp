package com.ozguryaz.filmproject.rest;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/actors")
public class ActorRest {
    private IActorService iActorService;
    @Autowired
    public ActorRest(IActorService iActorService) {
        this.iActorService = iActorService;
    }
    @GetMapping()
    public List<Actor> listActor(){
        List<Actor> all = iActorService.getAll();
        return all;
    }
}
