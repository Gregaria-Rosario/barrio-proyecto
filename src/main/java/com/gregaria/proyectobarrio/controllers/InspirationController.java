package com.gregaria.proyectobarrio.controllers;

import com.gregaria.proyectobarrio.entities.Inspiration;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.services.InspirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inspiration")
public class InspirationController {
    
    @Autowired
    private InspirationService inspirationService;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("inspirations", inspirationService.findAll());
        return "/inspiration/index";
    }

    @GetMapping("/show")
    public String getOne(Model model, @RequestParam String id) {
        try {
            model.addAttribute("inspiration", inspirationService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "no se ha encontrado la inspiración solicitada");
        }
        return "/inspiration/show";
    }

    @GetMapping("/save")
    public String save(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("inspiration", id != null ? inspirationService.findById(id) : new Inspiration());
        return "/inspiration/edit";
    }

    @PostMapping("/save")
    public String saveData(Model model, @ModelAttribute("inspiration") Inspiration entidad,
                           @RequestParam String links,  @RequestParam String images,
                           @RequestParam(required = false) String tags) throws WebException {
        try {
            model.addAttribute("inspiration", (inspirationService.save(entidad, links, images, tags)));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",  "Hubo un error al guardar la inspiración");
        }
        return "/inspiration/index";
    }
}
