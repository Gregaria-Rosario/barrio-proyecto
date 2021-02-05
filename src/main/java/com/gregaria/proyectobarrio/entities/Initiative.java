package com.gregaria.proyectobarrio.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import com.gregaria.proyectobarrio.Enums.State;

import lombok.Data;

@Data
@Entity
public class Initiative implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String nombre;
	// private List<User> volunteers;
	// private User creator;
	private Integer budget; // presupuesto
	private String description;
	private State state;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	private Boolean active;

	@ManyToMany
	private List<Tag> tags;

	@OneToMany
	private List<Comment> comments;
	private String idModification;

	@OneToMany
	private List<Vote> editedVotes;

	@ElementCollection
	private List<String> pictures;

	@ManyToMany
	private List<Inspiration> inspirations;
}
