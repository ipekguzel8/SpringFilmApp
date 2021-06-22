package com.ozguryaz.filmproject.api;

import com.ozguryaz.filmproject.entities.User;
import com.ozguryaz.filmproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@ComponentScan
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    IUserService iUserService;

    public LoginController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("login", new User());
        return "Login";
    }
    @PostMapping("/login")
    public String loginP(@ModelAttribute User user, Model model){
        List<User> byObj = iUserService.getByObj(user);
        boolean empty = byObj.isEmpty();
        if(empty == true) {
            return "redirect:/";
        }
        return "Layout";
    }
}
