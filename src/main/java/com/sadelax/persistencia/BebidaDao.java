package com.sadelax.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadelax.modelo.Bebida;

public interface BebidaDao extends JpaRepository<Bebida, Integer> {

}
