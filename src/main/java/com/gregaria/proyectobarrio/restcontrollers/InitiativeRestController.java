package com.gregaria.proyectobarrio.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregaria.proyectobarrio.entities.Initiative;
import com.gregaria.proyectobarrio.services.InitiativeService;



@RestController
@RequestMapping("/initiative")
public class InitiativeRestController {
	@Autowired
	InitiativeService initiativeService;
	
	@GetMapping("/all")
	public List <Initiative> getAll(){
		return initiativeService.listAll();
	}
	
	public ResponseEntity<Initiative> save(@RequestBody Initiative initiative){
		Initiative response = initiativeService.save(initiative);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
