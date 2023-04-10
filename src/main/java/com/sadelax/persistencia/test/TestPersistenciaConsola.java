package com.sadelax.persistencia.test;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadelax.modelo.Bebida;
import com.sadelax.persistencia.BebidaDao;

@Component
public class TestPersistenciaConsola {
	
	@Autowired
	private BebidaDao dao;

	@PostConstruct
	public void mostrarMenu() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int contador = 0;
		int opcion;
		do {
			System.out.println("********** MENU PICKYCOCKTAIL **********");
			System.out.println("1. Mostrar todas las bebidas");
			System.out.println("2. Buscar bebida por id");
			System.out.println("3. Mostrar las bebidas más populares");
			System.out.println("4. Filtrar por tag");
			System.out.println("5. Filtrar por ingrediente");
			System.out.println("6. Filtrar por valor");
			System.out.println("7. Mostrar todos los tags de la bbdd");
			System.out.println("8. Salir");
			System.out.println("****************************************");

			System.out.print("Ingresa numero: ");
			
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("********** LISTADO DE BEBIDAS **********");
				List<Bebida> todas = dao.findAll();
				for (Bebida bebida : todas) {
					System.out.println(bebida.toString());
					contador++;
				}
				System.out.println("****************************************");
				System.out.println("TOTAL ENCONTRADO: " + contador);
				System.out.println("****************************************");
				break;
			case 2:
				System.out.print("Introduce el id de la bebida a buscar: ");
				Integer id = scanner.nextInt();
				Bebida bebida = dao.findById(id).orElse(null);
				if (bebida != null) {
					System.out.println("********** BEBIDA ENCONTRADA **********");
					System.out.println(bebida.toString());
					System.out.println("****************************************");
				} else {
					System.out.println("No se encontró ninguna bebida con el id especificado.");
				}
				break;
			case 3:
				System.out.println("********** LISTADO DE BEBIDAS **********");
				List<Bebida> populares = dao.findPopularDrinks();
				for (Bebida popular : populares) {
					System.out.println(popular.toString());
					contador++;
				}
				System.out.println("****************************************");
				System.out.println("TOTAL ENCONTRADO: " + contador);
				System.out.println("****************************************");
				break;
			case 4:
				System.out.print("Escribe un tag: ");
				String tag = scanner.next();
				List<Bebida> bebidaTag = dao.findByTag(tag);
				if(bebidaTag != null) {
					System.out.println("********** BEBIDA ENCONTRADA **********");
					for (Bebida byTag : bebidaTag) {
						System.out.println(byTag.toString());
						contador++;
					}
					System.out.println("****************************************");
					System.out.println("TOTAL ENCONTRADO: " + contador);
					System.out.println("****************************************");
				} else {
					System.out.println("No se encontró ninguna bebida con el tag especificado.");
				}
				break;
			case 5:
				System.out.print("Escribe un ingrediente: ");
				String ingrediente = scanner.next();
				List<Bebida> ingredientes = dao.findByIngredient(ingrediente);
				if(ingredientes != null) {
					System.out.println("********** BEBIDA ENCONTRADA **********");
					for (Bebida byIngrediente : ingredientes) {
						System.out.println(byIngrediente.toString());
						contador++;
					}
					System.out.println("****************************************");
					System.out.println("TOTAL ENCONTRADO: " + contador);
					System.out.println("****************************************");
				} else {
					System.out.println("No se encontró ninguna bebida con el ingrediente especificado.");
				}
				break;
			case 6:
				System.out.println("Buscar: ");
				String buscar = scanner.next();
				Set<Bebida> encontradas = dao.findByValue(buscar);
				if(encontradas != null) {
					System.out.println("********** BEBIDA ENCONTRADA **********");
					for (Bebida byValue : encontradas) {
						System.out.println(byValue.toString());
						contador++;
					}
					System.out.println("****************************************");
					System.out.println("TOTAL ENCONTRADO: " + contador);
					System.out.println("****************************************");
				} else {
					System.out.println("No se encontró ninguna bebida con el ingrediente especificado.");
				}
				break;
			case 7:
//				System.out.println(dao.obtenerTags());
				break;
			case 8:
				System.out.println("Saliendo del menú.");
				break;
			default:
				System.out.println("Opcion no valida. Intentalo de nuevo.");
				break;
			}
		} while (opcion != 7);
	}
	
	public static void main(String[] args) {
    TestPersistenciaConsola testCarga = new TestPersistenciaConsola();
    testCarga.mostrarMenu();
}
	
}
