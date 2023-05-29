package com.pickycocktail.usuarios.infraestructura.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
	"com.pickycocktail.usuarios.infraestructura.web.controllers",
	"com.pickycocktail.usuarios.application.service",
	"com.pickycocktail.usuarios.infraestructura.persistence" })
@PropertySource("classpath:pickycocktail.properties")
@Import({ JPAConfig.class, ProduccionConfig.class, DesarrolloConfig.class })
public class Config {

}
