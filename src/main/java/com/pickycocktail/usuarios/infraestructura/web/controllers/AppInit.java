package com.pickycocktail.usuarios.infraestructura.web.controllers;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pickycocktail.usuarios.infraestructura.config.Config;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
        // Configuración de las clases de configuración principales de la aplicación (capa de infraestructura)
        return new Class<?>[] { Config.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
        // Configuración específica del servlet de Spring MVC (capa de infraestructura)
        return new Class<?>[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
        // Mapeo del DispatcherServlet (por ejemplo, "/")
        return new String[] { "/" };
	}

}
