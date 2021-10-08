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
				
				
				for (Atraccion cadaAtraccion :  getAtracciones()) {

					if (cadaPersona.getDinero() >= cadaAtraccion.getCosto()
							&& cadaPersona.getHorasDisponibles() >= cadaAtraccion.getDuracion()
							&& cadaAtraccion.getCupo() > 0) {		
						
						
						
						System.out.println(String.format("%s", cadaAtraccion.formatoConsola()));	//escribe en consola la atraccion, su precio y la duracion			
					
						
					while(!respuesta.equalsIgnoreCase("S")) { //entro al while, mientras la respuesta (lo que se escribe por consola) no sea igual a "s", pregunta si desea comprar la atraccion
						if(respuesta.equalsIgnoreCase("N")) {
							break;
						}
						
						System.out.println("¿Desea comprar la atraccion? S o N ");
						usarScanner(); //permite escribir por consola (ver el metodo de abajo)
						
						
					} 
						
						
						if(respuesta.equalsIgnoreCase("S")) { //si responde "s", compra la atraccion
						cadaPersona.comprar(cadaAtraccion);	
						}
						System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y " + cadaPersona.getHorasDisponibles() + " horas disponibles");
						System.out.println("\n-------------------------------------------------------------------");
					
						respuesta = "a"; //cambio la respuesta a cualquier cosa que no sea S ni N, así, en la proxima iteracion, entra al while.
					}	
				}			
			}		 
		}
				
		
		public static void usarScanner() {
			Scanner s = new Scanner(System.in); //para poder escribir por consola
			respuesta = s.next().toUpperCase(); //en respuesta se guarda lo que uno escribe en consola
		}

	
		
		
}
