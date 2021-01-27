/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Comment implements Serializable {
  
  @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
  
  private String content;
  
//  @ManyToOne
//  private User user;
  
  private boolean reported;
  
  private boolean active;
  
  @Temporal(TemporalType.DATE)
  private Date created;
}
