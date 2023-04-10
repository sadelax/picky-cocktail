//package com.sadelax.negocio.test;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.sadelax.modelo.Bebida;
//import com.sadelax.negocio.BebidaService;
//
//@Component
//public class TestCarga {
//
//	@Autowired
//	private BebidaService service;
//    
//	@PostConstruct
//	public void mostrarMenu() {
//		
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(System.in);
//		int contador = 0;
//		int opcion;
//		do {
//			System.out.println("********** MENU PICKYCOCKTAIL **********");
//			System.out.println("1. buscarBebidasPorTags");
//			System.out.println("2. ingredientesQueOdias");
//			System.out.println("3. bebidaEstrella");
//			System.out.println("4. otrasBebidas");
//			System.out.println("5. Salir");
//			System.out.println("****************************************");
//
//			System.out.print("Ingresa numero: ");
//			
//			opcion = scanner.nextInt();
//
//			switch (opcion) {
//			case 1:
//				System.out.println("********** LISTADO DE BEBIDAS **********");
//				System.out.print("Escribe los tags separada por comas: ");
//				String input = scanner.next();
//				List<String> tags = Arrays.asList(input.split(","));
//				System.out.println("Lista separada: " + tags);
//				List<Bebida> todas = service.buscarBebidasPorTags(tags);
//				for (Bebida bebida : todas) {
//					System.out.println(bebida.toString());
//					contador++;
//				}
//				System.out.println("****************************************");
//				System.out.println("TOTAL ENCONTRADO: " + contador);
//				System.out.println("****************************************");
//				break;
//			case 5:
//				System.out.println("Saliendo del menú.");
//				break;
//			default:
//				System.out.println("Opcion no valida. Intentalo de nuevo.");
//				break;
//			}
//		} while (opcion != 7);
//	}
//	
//	public static void main(String[] args) {
//	    TestCarga testCarga = new TestCarga();
//	    testCarga.mostrarMenu();
//	}
//
//}
