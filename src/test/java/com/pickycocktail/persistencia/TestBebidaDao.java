package com.pickycocktail.persistencia;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pickycocktail.bebidas.dominio.model.Bebida;
import com.pickycocktail.bebidas.infraestructura.persistence.BebidaDao;

@Component
public class TestBebidaDao {

	@Autowired
	BebidaDao bd;
		
	@PostConstruct
	public void test() {
		System.out.println("----------------");
		List<Bebida> bebida = bd.findAll();
		System.out.println(bebida);
		System.out.println("----------------");
		
	}
}
