package com.sadelax.persistencia;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sadelax.modelo.Bebida;

public interface BebidaDao extends JpaRepository<Bebida, Integer> {

	@Query("SELECT b FROM Bebida b WHERE b.tags LIKE %:tag%")
	List<Bebida> findByTag(@Param("tag") String tag);
	
	@Query("SELECT b FROM Bebida b WHERE b.popular = 1")
	List<Bebida> findByPopularity();
	
    @Query("SELECT b FROM Bebida b "
    		+ "JOIN CantidadPorBebida cpb ON b.idBebida = cpb.bebida.idBebida "
    		+ "JOIN Ingrediente i ON cpb.ingrediente.idIngrediente = i.idIngrediente "
    		+ "WHERE i.nombre LIKE %?1%")
	List<Bebida> findByIngredient(String valor);
    
    @Query("SELECT b FROM Bebida b "
    		+ "JOIN CantidadPorBebida cpb ON b.idBebida = cpb.bebida.idBebida "
    		+ "JOIN Ingrediente i ON cpb.ingrediente.idIngrediente = i.idIngrediente "
    		+ "JOIN Vaso v ON b.vaso.idVaso = v.idVaso "
    		+ "JOIN Preparacion p ON b.preparacion.idPreparacion = p.idPreparacion "
    		+ "WHERE b.nombre LIKE %?1% "
    		+ "OR i.nombre LIKE %?1% "
    		+ "OR v.nombre LIKE %?1% "
    		+ "or p.descripcion LIKE %?1% ")
    Set<Bebida> findByValue(String valor);
	
}
