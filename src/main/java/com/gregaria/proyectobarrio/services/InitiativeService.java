/**
 * 
 */
package com.gregaria.proyectobarrio.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregaria.proyectobarrio.entities.Initiative;
import com.gregaria.proyectobarrio.repositories.InitiativeRepository;


@Service
public class InitiativeService {
	
	@Autowired
	InitiativeRepository initiativeRepository;
	
	@Transactional
	public Initiative save(Initiative initiative) {
		return initiativeRepository.save(initiative);
	}
	
	@Transactional
	public Initiative update(Initiative initiative) {
		return initiativeRepository.save(initiative);
	}
	
	@Transactional
	public List<Initiative> listAll() {
		return initiativeRepository.findAllActive();
	}
	
	public Initiative findById(String id) {
		Optional<Initiative> response = initiativeRepository.findById(id);
		
		Initiative initiative = null;
		if (response.isPresent()) {
			 initiative = response.get();
		} 
		return initiative;
	}
	
	

}
