package com.gregaria.proyectobarrio.controllers;

import com.gregaria.proyectobarrio.entities.Comment;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.services.CommentService;
import com.gregaria.proyectobarrio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAll(Model model) {
        try {
            model.addAttribute("comments", commentService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error");
        }
        return "/comment/index";
    }

    @GetMapping("/comment/user")
    public String getCommentUser(Model model, @RequestParam String idUser) {
        try {
            model.addAttribute("comments", commentService.findByUser(userService.finById(idUser)));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Puede ser que falte el id del usuario para ver los comentarios");
        }
        return "/comment/index";
    }

    @GetMapping("/show")
    public String getOne(Model model, @RequestParam String id) {
        try {
            model.addAttribute("comment", commentService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "no se ha encontrado el usuario solicitado");
        }
        return "/comment/show";
    }

    @GetMapping("/save")
    public String save(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("comment", id != null ? commentService.findById(id) : new Comment());
        return "/comment/edit";
    }

    @PostMapping("/save")
    public String saveData(Model model, @ModelAttribute("comment") Comment entidad) throws WebException {
        try {
            model.addAttribute("comment", (commentService.save(entidad)));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",  "Hubo un error al guardar el comentario");
        }
        return "/comment/index";
    }
}
