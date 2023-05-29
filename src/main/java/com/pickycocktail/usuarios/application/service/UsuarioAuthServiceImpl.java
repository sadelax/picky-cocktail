package com.pickycocktail.usuarios.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickycocktail.usuarios.dominio.model.Usuario;
import com.pickycocktail.usuarios.infraestructura.persistence.UsuarioRepository;

@Service
public class UsuarioAuthServiceImpl implements UsuarioAuthService {
	
	@Autowired
	private UsuarioRepository usuarioRep;

	@Override
	public Usuario autenticarUsuario(String nombreUsuario, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarCredenciales(String nombreUsuario, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario obtenerUsuarioAutenticado() {
		// TODO Auto-generated method stub
		return null;
	}

}
