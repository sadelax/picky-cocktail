package com.pickycocktail.usuarios.infraestructura.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickycocktail.usuarios.dominio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Integer, Usuario> {

//	TODO
}
