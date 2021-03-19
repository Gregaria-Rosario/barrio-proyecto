
package com.gregaria.proyectobarrio.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gregaria.proyectobarrio.Enums.State;
import com.gregaria.proyectobarrio.entities.Initiative;
import com.gregaria.proyectobarrio.services.InitiativeService;

/**
 * @author Gisele Galaburri
 *
 */

@Controller
@RequestMapping("/initiatives")
public class InitiativeController {

	@Autowired
	InitiativeService initiativeService;

	// consultar el caso de "Iterable<Initiative>
	// lo uso? Y en ese caso, como?
	@GetMapping("/")
	public String getAll(Model model) {
		List<Initiative> all = initiativeService.listActives();
		model.addAttribute("initiatives", all);
		return "/initiatives/index.html";
	}

	@PostMapping("/publish")
	public String newInitiative(@RequestParam String title, @RequestParam String creatorId,
			@RequestParam Integer budget, @RequestParam String description, @RequestParam String idTags,
			Model model) {

		// confirmar como llegan las etiquetas
		// podria ser un string de ID's de etiquetas separados por coma
		// como envia desde el front la localizacion? No lo agregué
		State state = State.PUBLISHED;

		Initiative initiative = initiativeService.save(title, creatorId, budget, description, idTags, null, state);

		model.addAttribute("initiative", initiative);

		return "/initiatives/index.html";
	}

	@PostMapping("/save-draft")
	public String saveDraft(@RequestParam String title, @RequestParam String creatorId, @RequestParam Integer budget,
			@RequestParam String description, @RequestParam String idTags, Model model) {

		// confirmar como llegan las etiquetas
		// podria ser un string de ID's de etiquetas separados por coma
		// como envia desde el front la localizacion? No lo agregué
		State state = State.DRAFT;

		Initiative initiative = initiativeService.save(title, creatorId, budget, description, idTags, null, state);
		model.addAttribute("initiative", initiative);

		return "/initiatives/index.html";
	}
	
	@GetMapping("/own")
	public String showOwnInitiatives(HttpSession session, @RequestParam(required = false) String creatorId,
			Model model) {
		
		List<Initiative> ownInitiatives = initiativeService.listByCreator(creatorId);
		
		model.addAttribute("ownInitiatives", ownInitiatives);
		
		return "/initiatives/index.html"; 
	}

}
