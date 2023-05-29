package com.pickycocktail.usuarios.infraestructura.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class LoginAction implements Action {

	@Override
	public String get(String path, HttpServletRequest req, HttpServletResponse resp) {
		return path;
	}

	@Override
	public String post(String path, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
