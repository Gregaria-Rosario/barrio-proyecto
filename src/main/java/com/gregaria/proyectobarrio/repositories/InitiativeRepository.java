/**
 * 
 */
package com.gregaria.proyectobarrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.gregaria.proyectobarrio.entities.Initiative;

@Repository
public interface InitiativeRepository  extends JpaRepository<Initiative, String> {

}
