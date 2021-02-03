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
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Nahue
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
  
  @Query("SELECT a FROM Vote a WHERE a.user = :id")
  public List<Vote> findByUser(@Param("id") String id);
  
  @Query("SELECT a FROM Vote a WHERE a.initiative = :id")
  public List<Vote> findByInitiative(@Param("id") String id);
}
