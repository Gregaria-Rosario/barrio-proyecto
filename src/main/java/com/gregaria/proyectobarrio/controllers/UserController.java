package com.gregaria.proyectobarrio.controllers;

import com.gregaria.proyectobarrio.entities.Comment;
import com.gregaria.proyectobarrio.entities.User;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/user/index";
    }

    @GetMapping("/show")
    public String getOne(Model model, @RequestParam String id) {
        try {
            model.addAttribute("user", userService.finById(id));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "no se ha encontrado el usuario solicitado");
        }
        return "/user/show";
    }

    @GetMapping("/save")
    public String save(Model model, @RequestParam (required = false) String id) {
        model.addAttribute("user", id != null ? userService.finById(id) : new User());
        return "/user/edit";
    }

    @PostMapping("/save")
    public String saveData(Model model,  @ModelAttribute("user") User entidad) throws WebException {
        try {
            model.addAttribute("user", entidad.getId() != null ? userService.save(entidad): userService.finById(userService.save().getId()));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",  "Hubo un error al guardar el usuario");
        }
        return "/user/index";
    }
}
