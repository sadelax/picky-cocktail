package com.pickycocktail.usuarios.application.service;

import com.pickycocktail.usuarios.dominio.model.Usuario;

public interface UsuarioAuthService {

	public Usuario autenticarUsuario(String nombreUsuario, String password);
    public boolean verificarCredenciales(String nombreUsuario, String password);
    public Usuario obtenerUsuarioAutenticado();
}
