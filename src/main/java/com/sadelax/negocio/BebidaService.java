package com.sadelax.negocio;

import java.util.List;

import com.sadelax.modelo.Bebida;

public interface BebidaService {
	
	// para la primera pantalla
	public List<Bebida> buscarBebidasPorTags(List<String> tags);
	
	// para la segunda pantalla
	public List<Bebida> ingredientesQueOdias(List<String> valores);
	
	// para la tercera pantalla. recomendación final
	public Bebida bebidaEstrella();
	
	// para la cuarta pantalla
	public List<Bebida> otrasBebidas();

}
