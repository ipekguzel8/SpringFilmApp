package com.ozguryaz.filmproject.api;

import com.ozguryaz.filmproject.entities.Actor;
import com.ozguryaz.filmproject.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private IActorService iActorService;
    @Autowired
    public ActorController(IActorService iActorService) {
        this.iActorService = iActorService;
    }
    @GetMapping("/actors")
    public String UserLists(Model model) {
        model.addAttribute("actorList", iActorService.getAll());
        return "ActorList";
    }
    @GetMapping("/add")
    public String addActor(Model model){
        model.addAttribute("actorAdd", new Actor());
        return "ActorAdd";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Actor actor){
        iActorService.add(actor);
        return "redirect:/actor/actors";
    }
    @GetMapping("/delete/{id}")
    public String deleteActor(@PathVariable long id){
        Actor byId = iActorService.getById(id);
        iActorService.delete(byId);
        return "redirect:/api/films";
    }

    @GetMapping("/edit/{id}")
    public String updateActor(@PathVariable long id,Model model){
        model.addAttribute("actorUpdate", iActorService.getById(id));
        return "UpdateActor";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute Actor actor,
                             BindingResult result, Model model) {
        iActorService.update(actor);
        return "redirect:/actor/actors";
    }

}
