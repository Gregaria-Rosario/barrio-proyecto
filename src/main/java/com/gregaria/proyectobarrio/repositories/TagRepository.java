/**
 * Author gisele Galaburri
 */
package com.gregaria.proyectobarrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gregaria.proyectobarrio.entities.Tag;


/*
 * @author gisele
 *
 */

@Repository
public interface TagRepository extends JpaRepository<Tag, String>  {

}
