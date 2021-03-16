package com.gregaria.proyectobarrio.restcontrollers;

import com.gregaria.proyectobarrio.entities.Inspiration;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.services.InspirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inspiration")
public class InspirationRestController {

    @Autowired
    private InspirationService InspirationService;

    @PostMapping("/save")
    public ResponseEntity<Inspiration> save(@RequestParam String title,
        @RequestParam String description, @RequestParam String links,
        @RequestParam String images) throws WebException {
        Inspiration response = InspirationService.save(title, description, links, images);
        return new ResponseEntity<Inspiration>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Inspiration> update(@RequestParam String idInspiration,
        @RequestParam String title, @RequestParam String description,
        @RequestParam String links, @RequestParam String images,
        @RequestParam String tags) throws WebException {
        Inspiration response = InspirationService.update(idInspiration, title, description, links, images, tags);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/deactivate")
    public ResponseEntity<Inspiration>
    deactivate(@RequestParam String idInspiration) throws WebException {
        Inspiration response = InspirationService.deactivate(idInspiration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/activetoggle")
    public ResponseEntity<Inspiration>
    activeToggle(@RequestParam String idInspiration) throws WebException {
        Inspiration response = InspirationService.activeToggle(idInspiration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/activate")
    public ResponseEntity<Inspiration>
    activate(@RequestParam String idInspiration) throws WebException {
        Inspiration response = InspirationService.activate(idInspiration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/findbyid")
    public ResponseEntity<Inspiration>
    findById(@RequestParam String idInspiration) throws WebException {
        Inspiration response = InspirationService.findById(idInspiration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
