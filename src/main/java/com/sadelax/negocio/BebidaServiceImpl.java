//package com.sadelax.negocio;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sadelax.modelo.Bebida;
//import com.sadelax.negocio.test.TestCarga;
//import com.sadelax.persistencia.BebidaDao;
//import com.sadelax.persistencia.BebidaDaoCustom;
//
//@Service("bebidaService")
//public class BebidaServiceImpl implements BebidaService {
//	
//	@Autowired
//	private BebidaDao dao;
//	@Autowired
//	private BebidaDaoCustom daoCustom;
//
//	@Override
//	public List<Bebida> buscarBebidasPorTags(List<String> tags) {
//		List<Bebida> bebidas = new LinkedList<>();
////		for (String tag : tags) {
////			bebidas = dao.findByTag(tag);
////		}
////		return bebidas;
//		
//		int contador = 0;
//        List<Bebida> bebidasFiltradas = new ArrayList<>();
//        for (Bebida bebida : bebidas) {
//            List<String> bebidaTags = daoCustom.obtenerTags(bebida);
//            if (bebidaTags != null && bebidaTags.stream().anyMatch(tags::contains)) {
//                bebidasFiltradas.add(bebida);
//                contador++;
//            }
//        }
//        System.out.println(contador + " rows returned");
//        return bebidasFiltradas;
//	}
//
//	@Override
//	public List<Bebida> ingredientesQueOdias(List<String> valores) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Bebida bebidaEstrella() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Bebida> otrasBebidas() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//}
