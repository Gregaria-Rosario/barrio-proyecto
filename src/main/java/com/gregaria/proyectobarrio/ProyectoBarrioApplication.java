package com.gregaria.proyectobarrio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gregaria.proyectobarrio.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ProyectoBarrioApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBarrioApplication.class, args);
	}

	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 
	           registry.addResourceHandler("swagger-ui.html")
	                    .addResourceLocations("classpath:/META-INF/resources/");
	 
	    }
	
}
