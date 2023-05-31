package com.pickycocktail.usuarios.infraestructura.web.actions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionsFactory {

	private Map<String, Action> actions;
	private Set<String> urlPublica;
	
	public final String VISTA_PRE = "/WEB-INF/vistas/";
	public final String VISTA_POST = ".jsp";
	
	@Autowired
	private LoginAction login;
	@Autowired
	private RegistroAction registro;
	
	public Action getAction(HttpServletRequest req) {
		String pathInfo = req.getServletPath().substring(5);
		String clave = req.getMethod() + pathInfo;
		/////////////// ^GET o POST //////^menu_principal
		String clave2 = "GET-POST" + pathInfo;

		Action respuesta;

		if (urlPublica.contains(pathInfo.substring(1)) || isSessionActive(req)) {
			if (actions.containsKey(clave)) {
				respuesta = actions.get(clave);				
			}
			else if (actions.containsKey(clave2)) {
				respuesta = actions.get(clave2);				
			}
			else {
				respuesta = actions.get("URL_INCORRECTA");				
			}
		} else {
			respuesta = actions.get("URL_INCORRECTA");			
		}
		return respuesta;
	}
	
	@PostConstruct
	private void creaActions() {
		actions = new HashMap<>();
		actions.put("GET-POST/login", login);
		actions.put("GET-POST/registro", registro);

		urlPublica = new HashSet<>();
		urlPublica.add("login");
		urlPublica.add("registro");
		urlPublica.add("registro_ok");
	}

	private boolean isSessionActive(HttpServletRequest req) {
		return req.getSession().getAttribute("usuario") != null;
	}

	
}
