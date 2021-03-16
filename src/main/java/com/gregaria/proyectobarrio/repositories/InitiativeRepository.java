/**
 * 
 */
package com.gregaria.proyectobarrio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.gregaria.proyectobarrio.entities.Initiative;

@Repository
public interface InitiativeRepository extends JpaRepository<Initiative, String> {

	
	public List<Initiative> findByActiveTrue();
}
