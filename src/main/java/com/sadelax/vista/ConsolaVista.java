package com.sadelax.vista;

import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadelax.modelo.Bebida;
import com.sadelax.persistencia.BebidaDao;

@Component
public class ConsolaVista {
	
	@Autowired
	private BebidaDao bebidaDao;

	@PostConstruct
	public void mostrarMenu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("********** MENU PICKYCOCKTAIL **********");
			System.out.println("1. Mostrar todas las bebidas");
			System.out.println("2. Buscar bebida por id");
			System.out.println("3. Salir");
			System.out.println("****************************************");

			System.out.print("Ingresa numero: ");
			
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("********** LISTADO DE BEBIDAS **********");
				List<Bebida> bebidas = bebidaDao.findAll();
				for (Bebida bebida : bebidas) {
					System.out.println(bebida.toString());
				}
				System.out.println("****************************************");
				break;
			case 2:
				System.out.println("Introduce el id de la bebida a buscar:");
				Integer id = scanner.nextInt();
				Bebida bebida = bebidaDao.findById(id).orElse(null);
				if (bebida != null) {
					System.out.println("********** BEBIDA ENCONTRADA **********");
					System.out.println(bebida.toString());
					System.out.println("****************************************");
				} else {
					System.out.println("No se encontró ninguna bebida con el id especificado.");
				}
				break;
			case 3:
				System.out.println("Saliendo del menú.");
				break;
			default:
				System.out.println("Opcion no valida. Intentalo de nuevo.");
				break;
			}
		} while (opcion != 3);
	}
}
