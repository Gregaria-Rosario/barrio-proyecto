package com.gregaria.proyectobarrio.controllers;

import com.gregaria.proyectobarrio.entities.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class GulpController {

    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", List.of(new Todo("Install Tailwind CSS"),
                new Todo("Make awesome UI")));
        return "pruebaInstalacionGulp";
    }
}
