/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.restcontrollers;

import com.gregaria.proyectobarrio.services.VoteService;
import com.gregaria.proyectobarrio.entities.Vote;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nahue
 */
@RestController
@RequestMapping("/vote")
public class VoteRestController {
  
  @Autowired
  private VoteService voteService;
  
  @GetMapping("/all")
  public List<Vote> getall() {
    return voteService.all();
  }
  
  public ResponseEntity<Vote> save(@RequestBody Vote vote) {
    Vote response = voteService.save(vote);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
