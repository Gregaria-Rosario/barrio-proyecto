/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.services;

import com.gregaria.proyectobarrio.entities.Vote;
import com.gregaria.proyectobarrio.repositories.VoteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nahue
 */
@Service
public class VoteService {
  
  @Autowired
  private VoteRepository voteRepository;
  
  public Vote save(Vote vote) {
    return null;
  }
  
  public Vote update() {
    return null;
  }
  
  public Vote active() {
    return null;
  }
  
  public Vote notActive() {
    return null;
  }
  
  public void delete(Vote vote) {
    voteRepository.delete(vote);
  }
  
  public List<Vote> all() {
    return voteRepository.findAll();
  }
  
  public Vote findById(String id) {
    Optional<Vote> response = voteRepository.findById(id);
    Vote vote = response.get();
    return vote;
  }
  
//  public List<Vote> findByUser(User user) {
//    return voteRepository.findByUser(user);
//  }
  
//  public List<Vote> findByIniciative(Iniciative iniciative) {
//    return voteRepository.findByIniciative(iniciative);
//  }
  
  
}
