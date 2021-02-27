/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Nahue
 */
@Data
@Entity
public class Inspiration implements Serializable {

  @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
  
  private String title;

  private String description;

  @ElementCollection
  private List<String> links;

  @ElementCollection
  private List<String> images;

  @ManyToMany
  private List<Tag> tags;

  private boolean active;
  
  private boolean reported;
  
  @Temporal(TemporalType.DATE)
  private Date created;
}
