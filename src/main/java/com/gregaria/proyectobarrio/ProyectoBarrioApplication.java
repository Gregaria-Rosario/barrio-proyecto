package com.gregaria.proyectobarrio;

import com.gregaria.proyectobarrio.config.SwaggerConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ProyectoBarrioApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBarrioApplication.class, args);
	}
}
