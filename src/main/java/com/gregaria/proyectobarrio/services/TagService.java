package com.gregaria.proyectobarrio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregaria.proyectobarrio.entities.Tag;
import com.gregaria.proyectobarrio.repositories.TagRepository;

/*
* @author gisele
*
*/

@Service
public class TagService {

	@Autowired
	TagRepository tagRepository;
	
	public Tag findById(String id) {
		return tagRepository.getOne(id);
	}
	
	public List<Tag> idsToList(String ids) {
		
		String[] idsArray = ids.split(",");
		List<Tag> tags = new ArrayList<>();
		
		for(String id : idsArray) {
			Tag tag = findById(id);
			tags.add(tag);
		}
		
		return tags;
	}
}
