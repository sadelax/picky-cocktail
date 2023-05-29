package com.pickycocktail.usuarios.application.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickycocktail.usuarios.dominio.model.Usuario;
import com.pickycocktail.usuarios.infraestructura.persistence.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository userRep;

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		usuario = null;
		try {
			usuario = userRep.save(usuario);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarUsuario(int usuarioId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void solicitudAmistad(Usuario amigo, String mensaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Usuario> amigosDe(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
