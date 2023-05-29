package com.pickycocktail.usuarios.application.service;

import java.util.Set;

import com.pickycocktail.usuarios.dominio.model.Usuario;

public interface UsuarioService {

    public Usuario crearUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public boolean eliminarUsuario(int usuarioId);
    public Usuario obtenerUsuarioPorId(Long usuarioId);
	public void solicitudAmistad(Usuario amigo, String mensaje);
	public Set<Usuario> amigosDe(Usuario usuario);
}
