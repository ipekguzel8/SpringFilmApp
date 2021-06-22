package com.ozguryaz.filmproject.api;

import com.ozguryaz.filmproject.entities.User;
import com.ozguryaz.filmproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    private IUserService iUserService;

    @GetMapping("/users")
    public String UserLists(Model model) {
        model.addAttribute("userList", iUserService.getAll());
        return "UserList";
    }
    @GetMapping("/add")
    public String addFilm(Model model){
        model.addAttribute("userAdd", new User());
        return "UserAdd";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute User user){
        iUserService.add(user);
        return "redirect:/api/films";
    }
    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable long id, Model model){
        model.addAttribute("userUpdate", iUserService.getById(id));
        return "UpdateUser";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute User user,
                             BindingResult result, Model model) {
        iUserService.update(user);
        return "redirect:/actor/actors";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User byId = iUserService.getById(id);
        iUserService.delete(byId);
        return "redirect:/actor/actors";
    }
}
