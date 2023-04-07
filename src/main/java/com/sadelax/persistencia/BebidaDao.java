package com.sadelax.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sadelax.modelo.Bebida;

public interface BebidaDao extends JpaRepository<Bebida, Integer> {

	@Query("SELECT b FROM Bebida b WHERE b.tags LIKE %:tag%")
	List<Bebida> findByTag(@Param("tag") String tag);
	
	@Query("SELECT b FROM Bebida b WHERE b.popular = 1")
	List<Bebida> findByPopularity();
}
