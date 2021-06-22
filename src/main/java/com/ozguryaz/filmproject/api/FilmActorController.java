package com.ozguryaz.filmproject.api;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.entities.FilmActor;
import com.ozguryaz.filmproject.service.IFilmActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filmActor")
public class FilmActorController{
    public FilmActorController(IFilmActorService iFilmActorService) {
        this.iFilmActorService = iFilmActorService;
    }

    @Autowired
    private IFilmActorService iFilmActorService;


    @GetMapping("/addActor/{id}")
    public String addActor(@PathVariable long id, Model model){
        List<Actor> actors = iFilmActorService.actorList();
        Film byIdFilm = iFilmActorService.getByIdFilm(id);
        model.addAttribute("addFilmActor",new FilmActor());
        model.addAttribute("actorList",actors);
        model.addAttribute("byIdFilm",byIdFilm);
        return "AddFilmActor";
    }
    @PostMapping("/addActor")
    public String addActorP(@ModelAttribute("addFilmActor") FilmActor filmActor, BindingResult bindingResult, Model model){
        Actor byId = iFilmActorService.getById(filmActor.getActor().getId());
        Film byIdFilm = iFilmActorService.getByIdFilm(filmActor.getFilm().getId());
        filmActor.setFilm(byIdFilm);
        filmActor.setActor(byId);
        iFilmActorService.addFilmActor(filmActor);
        return "redirect:/api/films";
    }
    @GetMapping("/listActor/{id}")
    public String listActor(@PathVariable long id, Model model){
        List<FilmActor> actors = iFilmActorService.getByFilmActor(id);
        model.addAttribute("actorList",actors);
        return "ListFilmInActor";
    }
    @PostMapping("/listActor")
    public String listActorP(@ModelAttribute("addFilmActor") FilmActor filmActor, BindingResult bindingResult, Model model){
        iFilmActorService.addFilmActor(filmActor);
        return "redirect:/api/films";
    }
    @GetMapping("/deleteActor/{id}")
    public String deleteFilm(@PathVariable long id){
        iFilmActorService.deleteActor(id);
        return "redirect:/api/films";
    }

    @GetMapping("/editActor/{id}")
    public String updateFilm(@PathVariable long id,Model model){
        FilmActor byIdFA = iFilmActorService.getByIdFA(id);
        model.addAttribute("UpdateFA", byIdFA);
        model.addAttribute("actor", byIdFA.actorName());
        return "UpdateFilmActor";
    }
    @PostMapping("/updateActor/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute FilmActor filmActor,
                             BindingResult result, Model model) {
        iFilmActorService.updateFA(filmActor);
        return "redirect:/api/films";
    }
}
