/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.entities;

import com.gregaria.proyectobarrio.Enums.Role;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
public class User implements Serializable {
  
  @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
  
  private String idFirebase;
  
  private Role role;
  
  @ManyToMany
  private List<Initiative> initiatives;
  
  @OneToMany
  private List<Inspiration> favorites;
  
  @ManyToMany
  private List<Vote> votes;
  
  @OneToMany
  private List<Tag> interests;
  
  private boolean active;
  
  @Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
  
  @Temporal(TemporalType.DATE)
  private Date createdAt;
  
}
