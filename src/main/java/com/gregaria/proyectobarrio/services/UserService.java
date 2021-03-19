/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.services;

import com.gregaria.proyectobarrio.entities.User;
import com.gregaria.proyectobarrio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Nahue
 */
@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;
  
  public User save() {
    return null;
  }
  
  public User update() {
    return  null;
  }
  
  public User finById(String id) {
    User user = userRepository.getOne(id);
    return user;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }
  
}
