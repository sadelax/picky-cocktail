package com.sadelax.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sadelax.modelo.Bebida;

//@Repository
public class BebidaDaoImpl implements BebidaDaoCustom {
	
//	@PersistenceContext
	private EntityManager em;
	
//	@Autowired
	private BebidaDao dao;

	public List<String> obtenerTags() {
	    List<String> tags = new ArrayList<>();
	    List<Bebida> bebidas = dao.findAll();
	    for (Bebida bebida : bebidas) {
	        String[] tagsArray = bebida.getTags().split(",");
	        tags.addAll(Arrays.asList(tagsArray));
	    }
	    return tags;
	}
}
