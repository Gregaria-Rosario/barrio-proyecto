/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.services;

import com.gregaria.proyectobarrio.entities.Initiative;
import com.gregaria.proyectobarrio.entities.Vote;
import com.gregaria.proyectobarrio.entities.User;
import com.gregaria.proyectobarrio.errors.WebException;
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
  
  public Vote save(Vote vote) throws WebException {
    validate(vote);
    return voteRepository.save(vote);
  }
  
  public Vote update(Vote vote) throws WebException {
    validate(vote);
    return voteRepository.save(vote);
  }
  
  public Vote activate(Vote vote) throws WebException {
    if (!vote.isActive()) {
      vote.setActive(true);
      voteRepository.save(vote);
    } else {
      throw new WebException("The vote you want to activate is already activated");
    }
    return null;
  }
  
  public Vote deactivate(Vote vote) throws WebException{
    if (vote.isActive()) {
      vote.setActive(false);
      voteRepository.save(vote);
    } else {
      throw new WebException("The vote you want to deactivate is already deactivate ");
    }
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
  
  public List<Vote> findByUser(User user) {
    return voteRepository.findByUser(user.getId());
  }
  
  public List<Vote> findByUserId(String id) {
    return voteRepository.findByUser(id);
  }
  
  public List<Vote> findByIniciative(Initiative initiative) {
    return voteRepository.findByInitiative(initiative.getId());
  }
  
  public List<Vote> findByIniciativeId(String id) {
    return voteRepository.findByInitiative(id);
  }
  
  private Vote validate(Vote vote) throws WebException {
    if (vote.getInitiative() == null) {
      throw new WebException("An attempt was made to save a vote that did not have an initiative assigned");
    }
    
    if (vote.getUser() == null) {
      throw new WebException("An attempt was made to save a vote that did not have an user assigned");
    }
    
    return vote;
  }
}
