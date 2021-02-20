package com.gregaria.proyectobarrio.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gregaria.proyectobarrio.entities.Initiative;
import com.gregaria.proyectobarrio.services.InitiativeService;



@RestController
@RequestMapping("/initiative")
public class InitiativeRestController {
	@Autowired
	InitiativeService initiativeService;
	
	@GetMapping("/")
	public @ResponseBody Iterable<Initiative> getAll(){
		return initiativeService.listActives();
	}
	
	@PostMapping("/save")
	public @ResponseBody Initiative newInitiative(@RequestParam String title){
		Initiative response = initiativeService.save(initiative);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
