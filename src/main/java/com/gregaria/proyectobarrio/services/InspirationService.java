/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.services;

import com.gregaria.proyectobarrio.entities.Inspiration;
import com.gregaria.proyectobarrio.errors.WebException;
import com.gregaria.proyectobarrio.repositories.InspirationRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nahue
 */
@Service
public class InspirationService {
  
  @Autowired
  private InspirationRepository inspirationRepository;
  
//  @Autowired
//  private TagService tagService;
  
  public Inspiration save(String title, String description, String links,
          String images,
          List<String> tag) throws WebException {
    Inspiration inspiration = new Inspiration();
    inspiration.setTitle(title);
    inspiration.setDescription(description);
    inspiration.setLinks(Arrays.asList(links.split(",")));
    inspiration.setImages(Arrays.asList(images.split(",")));
//    inspiration.setTags(tagService.saveListTag());
    inspiration.setActive(true);
    inspiration.setCreated(new Date());
    validate(inspiration);
    
    return inspirationRepository.save(inspiration);
  }
  
  public Inspiration Update(String id, String title, String description,
          String links,
          String images,
          List<String> tag) throws WebException {
    Inspiration inspiration = inspirationRepository.getOne(id);
    inspiration.setTitle(title);
    inspiration.setDescription(description);
    inspiration.setLinks(Arrays.asList(links.split(",")));
    inspiration.setImages(Arrays.asList(images.split(",")));
//    inspiration.setTags(tagService.saveListTag());
    inspiration.setActive(true);
    inspiration.setCreated(new Date());
    validate(inspiration);
    
    return inspirationRepository.save(inspiration);
  }
  
  public Inspiration report(String id) {
    Inspiration inspiration = inspirationRepository.getOne(id);
    inspiration.setReported(true);
    return inspirationRepository.save(inspiration);
  }
  
  public Inspiration activate(String id) throws WebException {
    Inspiration inspiration = inspirationRepository.getOne(id);
    if (!inspiration.isActive()) {
      inspiration.setActive(true);
      inspirationRepository.save(inspiration);
    } else {
      throw new WebException("The inspiration you want to activate is already activated");
    }
    return null;
  }
  
  public Inspiration deactivate(String id) throws WebException{
    Inspiration inspiration = inspirationRepository.getOne(id);
    if (inspiration.isActive()) {
      inspiration.setActive(false);
      inspirationRepository.save(inspiration);
    } else {
      throw new WebException("The inspiration you want to deactivate is already deactivate");
    }
    return null;
  }
  
  public Inspiration activeToggle(String id) {
    Inspiration inspiration = inspirationRepository.getOne(id);
    inspiration.setActive(!inspiration.isActive());
    return inspirationRepository.save(inspiration);
  }
  
  public void delete(String id) {
    Inspiration inspiration = inspirationRepository.getOne(id);
    inspirationRepository.delete(inspiration);
  }
  
  public Inspiration findById(String id) {
    Optional<Inspiration> response = inspirationRepository.findById(id);
    Inspiration inspiration = response.get();
    return inspiration;
  }
  
  private Inspiration validate(Inspiration inspiration) throws WebException {
    
    if (inspiration.getTitle() == null || inspiration.getTitle().trim().isEmpty()) {
      throw new WebException("An attempt was made to save a inspiration that did not have an title assigned");
    }
    if (inspiration.getDescription() == null || inspiration.getDescription().trim().isEmpty()) {
      throw new WebException("An attempt was made to save a inspiration that did not have an description assigned");
    }
    if (inspiration.getLinks() == null || inspiration.getLinks().get(0).trim().isEmpty() || inspiration.getLinks().get(0).contains(",") ) {
      throw new WebException("An attempt was made to save a inspiration that did not have links assigned");
    }
    if (inspiration.getImages() == null || inspiration.getImages().get(0).trim().isEmpty() || inspiration.getImages().get(0).contains(",")) {
      throw new WebException("An attempt was made to save a inspiration that did not have images assigned");
    }
    if (inspiration.getTags() == null) {
      throw new WebException("An attempt was made to save a inspiration that did not have tags assigned");
    }
    
    return inspiration;
  }
  
}
