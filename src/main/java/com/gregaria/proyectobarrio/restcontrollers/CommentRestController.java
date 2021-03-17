/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.restcontrollers;

import com.gregaria.proyectobarrio.entities.Comment;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nahue
 */
@RestController
@RequestMapping("/comment")
public class CommentRestController {
  
  @Autowired
  private CommentService commentService;
  
  @PostMapping("/save")
  public ResponseEntity<Comment> save(@RequestParam String idUser,
          @RequestParam String content) throws WebException {
    Comment response = commentService.save(idUser, content);
    return new ResponseEntity<Comment>(response, HttpStatus.OK);
  }

  @PostMapping("/update")
  public ResponseEntity<Comment> update(@RequestParam String idComment,
              @RequestParam String content) throws WebException {
    Comment response = commentService.update(idComment, content);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/deactivate")
  public ResponseEntity<Comment> deactivate(@RequestParam String idComment) throws WebException {
    Comment response = commentService.deactivate(idComment);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/activetoggle")
  public ResponseEntity<Comment> activeToggle(@RequestParam String idComment) throws WebException {
    Comment response = commentService.activeToggle(idComment);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/activate")
  public ResponseEntity<Comment> activate(@RequestParam String idComment) throws WebException {
    Comment response = commentService.activate(idComment);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/findbyid")
  public ResponseEntity<Comment> findById(@RequestParam String idComment) throws WebException {
    Comment response = commentService.findById(idComment);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
  
}
