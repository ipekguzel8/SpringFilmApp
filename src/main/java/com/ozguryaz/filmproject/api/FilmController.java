package com.ozguryaz.filmproject.api;

import com.ozguryaz.filmproject.entities.Film;
import com.ozguryaz.filmproject.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class FilmController {
    @Autowired
    public FilmController(IFilmService iFilmService) {
        this.iFilmService = iFilmService;
    }

    private IFilmService iFilmService;

    @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "Hello World!";
    }
    @GetMapping("/films")
    public String FilmLists(Model model) {
        model.addAttribute("filmList", iFilmService.getAll());
        return "FilmList";
    }
    @GetMapping("/add")
    public String addFilm(Model model){
        model.addAttribute("filmAdd", new Film());
        return "FilmAdd";
    }
    @PostMapping ("/add")
    public String add(@ModelAttribute Film film){
        iFilmService.add(film);
        return "redirect:/api/films";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable long id){
        Film byId = iFilmService.getById(id);
        iFilmService.delete(byId);
        return "redirect:/api/films";
    }

    @GetMapping("/edit/{id}")
    public String updateFilm(@PathVariable long id,Model model){
        model.addAttribute("filmUpdate", iFilmService.getById(id));
        return "UpdateFilm";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute Film film,
                             BindingResult result, Model model) {
        iFilmService.update(film);
        return "redirect:/api/films";
    }
}
