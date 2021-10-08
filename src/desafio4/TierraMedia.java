package desafio4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TierraMedia {

	private List<Persona> personas;
	private List<Atraccion> atracciones;

	private static String respuesta = "a";

	
	public TierraMedia() {
		personas = new LinkedList<>();
		atracciones = new LinkedList<>();
	}
	
	
	public boolean agregarListaPersonas(String rutaArchivo) {
		return personas.addAll(LectorPersonas.cargarPersonas(rutaArchivo));
	}
	
	public boolean agregarListaAtracciones(String rutaArchivo) {
		return atracciones.addAll(LectorAtracciones.cargarAtracciones(rutaArchivo));
	}
	
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public List<Atraccion> getAtracciones() {
		Collections.sort(atracciones); // ordeno por el costo -> ver clase atraccion en el compareTo
		return atracciones;
	}


	
		
		public void hacerSugerencia() {
			
			System.out.println("-------------------------------------------------------------------");
			
			for (Persona cadaPersona : personas) {	
							
				System.out.println("Sugerencias: \n ");
				System.out.println("Nombre del visitante: " + cadaPersona.getNombre() + "\n");
				System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y " + cadaPersona.getHorasDisponibles() + " horas disponibles" + "\n");
				
				
				for (Atraccion cadaAtraccion :  atracciones) {

					if (cadaPersona.getDinero() >= cadaAtraccion.getCosto()
							&& cadaPersona.getHorasDisponibles() >= cadaAtraccion.getDuracion()
							&& cadaAtraccion.getCupo() > 0) {		
						
						
						
						System.out.println(String.format("%s", cadaAtraccion.formatoConsola()));				
					
						
					while(!respuesta.equalsIgnoreCase("S")) {
						if(respuesta.equalsIgnoreCase("N")) {
							break;
						}
						
						System.out.println("¿Desea comprar la atraccion? S o N ");
						usarScanner();
						
						
					} 
						
						
						if(respuesta.equalsIgnoreCase("S")) {
						cadaPersona.comprar(cadaAtraccion);	
						}
						System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y " + cadaPersona.getHorasDisponibles() + " horas disponibles");
						System.out.println("\n-------------------------------------------------------------------");
					
						respuesta = "a";
					}
					
				}		
				
				
			}		 
		}
				
		
		public static void usarScanner() {
			Scanner s = new Scanner(System.in); //para poder escribir por consola
			respuesta = s.next().toUpperCase();
		}


		
		
		
		
		
		
		
}


/*
 * 	public void buscarAtraccionesPosibles() {

		for (Persona cadaPersona : personas) {			
			for (Atraccion cadaAtraccion :  atracciones) {

				if (cadaPersona.getDinero() > cadaAtraccion.getCosto()
						&& cadaPersona.getHorasDisponibles() > cadaAtraccion.getDuracion()
						&& cadaAtraccion.getCupo() > 0) {		
					
					cadaPersona.setAtraccionesPosibles(cadaAtraccion);
				}
			}
		}	
	}


	

	public void listarAtracciones() {
		
		System.out.println("-------------------------------------------------------------------");
		
		
		for(int i  = 0; i < personas.size(); i++) {
						
			System.out.println("Sugerencias: \n ");
			System.out.println("Nombre del visitante: " + personas.get(i).getNombre() + "\n");
			System.out.println("Usted tiene: $" + personas.get(i).getDinero() + " y " + personas.get(i).getHorasDisponibles() + " horas disponibles" + "\n");
			
			
			//personas.get(i).getatraccionesPosibles().forEach(atraccion-> System.out.println(String.format("%s", atraccion.formatoConsola()))	);
			
			for(Atraccion atraccionesA :  personas.get(i).getatraccionesPosibles()) {
	
				
				System.out.println(String.format("%s", atraccionesA.formatoConsola()));
				
				System.out.println("¿Desea comprar la atraccion? S o N  \n");
				
				usarScanner();
				
				while(!respuesta.equalsIgnoreCase("S")) {
					System.out.println("¿Desea comprar la atraccion? S o N  \n");
					usarScanner();
				} 
				
					personas.get(i).comprar(atraccionesA);	
					System.out.println("Usted tiene: $" + personas.get(i).getDinero() + " y " + personas.get(i).getHorasDisponibles() + " horas disponibles");
					//buscarAtraccionesPosibles();
					
				
				
				
				System.out.println("\n-------------------------------------------------------------------");

			}
						
			
		}
	}

 * 
 * 
 * 	public void generarSugerencia(Persona p, Atraccion a, Promocion promo) {

		Random randomizer = new Random();
		Atraccion atraccionRandom = atracciones.get(randomizer.nextInt(atracciones.size()));

		// Promocion promocionRandom = promociones.get()

		for (Persona persona : personas) {
			persona.comprar(atraccionRandom, 1.0);
			System.out.println(persona);
		}
	}
 * 
 * 
 * */
