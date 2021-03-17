/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.services;

import com.gregaria.proyectobarrio.entities.Comment;
import com.gregaria.proyectobarrio.entities.User;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.repositories.CommentRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nahue
 */
@Service
public class CommentService {
  
  @Autowired
  private CommentRepository commentRepository;
  
  @Autowired
  private UserService userService;
  
  public Comment save(String idUsuario, String content) throws WebException {
    Comment comment = new Comment();
    comment.setUser(userService.finById(idUsuario));
    comment.setContent(content);
    comment.setActive(true);
    comment.setCreated(new Date());
    validate(comment.getContent());
    
    return commentRepository.save(comment);
  }
  
  public Comment update(String idComment, String content) throws WebException {
    Comment comment = commentRepository.getOne(idComment);
    comment.setContent(content);
    comment.setActive(true);
    comment.setCreated(new Date());
    validate(comment.getContent());
    
    return commentRepository.save(comment);
  }
  
  public Comment report(String id) {
    Comment comment = commentRepository.getOne(id);
    comment.setReported(true);
    return commentRepository.save(comment);
  }
  
  public Comment activate(String id) throws WebException {
    Comment comment = commentRepository.getOne(id);
    if (!comment.isActive()) {
      comment.setActive(true);
      commentRepository.save(comment);
    } else {
      throw new WebException("The comment you want to activate is already activated");
    }
    return null;
  }
  
  public Comment deactivate(String id) throws WebException{
    Comment comment = commentRepository.getOne(id);
    if (comment.isActive()) {
      comment.setActive(false);
      commentRepository.save(comment);
    } else {
      throw new WebException("The comment you want to deactivate is already deactivate");
    }
    return null;
  }
  
  public Comment activeToggle(String id) {
    Comment comment = commentRepository.getOne(id);
    comment.setActive(!comment.isActive());
    return commentRepository.save(comment);
  }
  
  public void delete(String id) {
    Comment comment = commentRepository.getOne(id);
    commentRepository.delete(comment);
  }
  
  public Comment findById(String id) {
    Optional<Comment> response = commentRepository.findById(id);
    Comment comment = response.get();
    return comment;
  }
  
  public List<Comment> findByUser(User user) {
    return commentRepository.findByUser(user.getId());
  }
  
  public List<Comment> findByUserId(String id) {
    return commentRepository.findByUser(id);
  }
  
  
  private void validate(String content) throws WebException {
    if (content == null || content.isEmpty()) {
      throw new WebException("An attempt was made to save a comment that did not have an content  ");
    }
  }
}
