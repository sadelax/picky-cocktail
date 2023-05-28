package com.pickycocktail.usuarios.infraestructura.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pickycocktail.usuarios.dominio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Integer, Usuario> {

	@Query("SELECT u FROM Usuario u WHERE u.nombre like %?1% or u.apellido like %?1% or u.usuario like %?1%")
	List<Usuario> findByValue(String valor);

	@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.misBebidas WHERE u.id = :id")
	Usuario findByIdEager(@Param("id") Integer id);
}
