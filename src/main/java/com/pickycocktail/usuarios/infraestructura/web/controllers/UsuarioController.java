package com.pickycocktail.usuarios.infraestructura.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/registro", method = {RequestMethod.GET, RequestMethod.POST})
	public String registro() {
		// Lógica de manejo de la solicitud GET y POST aquí
		return "registro";
	}

}
