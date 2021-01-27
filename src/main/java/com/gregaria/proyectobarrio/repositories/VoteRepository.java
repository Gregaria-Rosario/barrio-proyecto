/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gregaria.proyectobarrio.entities.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Nahue
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
  
  @Query("")
  public List<Vote> findByUser();
  
  @Query("")
  public List<Vote> findByIniciative();
}
