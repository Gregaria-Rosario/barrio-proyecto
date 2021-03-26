package com.gregaria.proyectobarrio.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gregaria.proyectobarrio.Enums.State;
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

	@PostMapping("/publish")
	public @ResponseBody Initiative newInitiative(
			@RequestParam String title,
			@RequestParam String  creatorId,
			@RequestParam Integer budget,
			@RequestParam String description,
			@RequestParam String idTags
			){
		
		// confirmar como llegan las etiquetas
		// podria ser un string de ID's de etiquetas separados por coma
		// como envia desde el front la localizacion? No lo agregué
		State state = State.PUBLISHED;
		
		Initiative initiative = initiativeService.save(title, creatorId, budget, description, idTags, null, state);
		return initiative;
	}
	
	@PostMapping("/save-draft")
	public @ResponseBody Initiative saveDraft(
			@RequestParam String title,
			@RequestParam String  creatorId,
			@RequestParam Integer budget,
			@RequestParam String description,
			@RequestParam String idTags
			){
		
		// confirmar como llegan las etiquetas
		// podria ser un string de ID's de etiquetas separados por coma
		// como envia desde el front la localizacion? No lo agregué
		State state = State.DRAFT;
		
		Initiative initiative = initiativeService.save(title, creatorId, budget, description, idTags, null, state);
		return initiative;
	}
	
	@GetMapping("/own")
	public @ResponseBody Iterable<Initiative> showOwnInitiatives(@RequestParam(required = false) String creatorId) {
		
		return initiativeService.listByCreator(creatorId);
	}
	
}
