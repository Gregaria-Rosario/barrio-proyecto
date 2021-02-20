/**
 * 
 */
package com.gregaria.proyectobarrio.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gregaria.proyectobarrio.Enums.State;
import com.gregaria.proyectobarrio.entities.Initiative;
import com.gregaria.proyectobarrio.entities.Location;
import com.gregaria.proyectobarrio.entities.Tag;
import com.gregaria.proyectobarrio.repositories.InitiativeRepository;


@Service
public class InitiativeService {
	
	@Autowired
	InitiativeRepository initiativeRepository;
	
//	@Autowired
//	UserRepository userRepositiry;
	
	@Autowired
	TagService tagService;
	
	@Transactional
	public Initiative save(String title,
			 String  creatorId,
			 Integer budget,
			 String description,
			 String idTags, 
			 Location location,
			 State state) {
		
		Initiative initiative = new Initiative();
		
//		User creator = userRepository.findyById(creatorId);
//		initiative.setCreator(creator);
		
		initiative.setTitle(title);
		initiative.setBudget(budget);
		initiative.setDescription(description);
		
		List<Tag> tags = tagService.idsToList(idTags);
				
		initiative.setTags(tags);
		initiative.setLocation(location);
		initiative.setState(state);
		initiative.setCreatedAt(new Date());
		initiative.setActive(true);
		
		return initiativeRepository.save(initiative);
	}
	
	@Transactional
	public Initiative update(String id, String title,
			 Integer budget,
			 String description,
			 String idTags, 
			 Location location,
			 State state) throws Exception {
		
		Initiative initiative = findById(id);
			
		initiative.setTitle(title);
		initiative.setBudget(budget);
		initiative.setDescription(description);
		
		List<Tag> tags = tagService.idsToList(idTags);
				
		initiative.setTags(tags);
		initiative.setLocation(location);
		initiative.setState(state);
		initiative.setUpdatedAt(new Date());
		
		
		return initiativeRepository.save(initiative);
	}
	
	@Transactional
	public List<Initiative> listActives() {
		return initiativeRepository.findByActiveTrue();
	}
	
	public Initiative findById(String id) throws Exception {
		Optional<Initiative> response = initiativeRepository.findById(id);
		
		Initiative initiative = null;
		if (response.isPresent()) {
			 initiative = response.get();
		} else {
			throw new Exception("No se encontró la iniciativa");
		}
		return initiative;
	}
	
	

}
