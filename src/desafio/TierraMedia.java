package desafio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TierraMedia {

	private List<Usuario> listaUsuarios;
	private List<Atraccion> listaAtracciones;
	private List<Promocion> listaPromociones;
	
	private List<Ofertable> listaOfertas;
	
	
	private static String respuesta = "a";

	public TierraMedia() {
		listaUsuarios = new ArrayList<>();
		listaAtracciones = new ArrayList<>();
		listaPromociones = new ArrayList<>();
		listaOfertas = new ArrayList<>();
	}

	public boolean agregarListaPersonas(String rutaArchivo) {
		return listaUsuarios.addAll(LectorUsuario.cargarUsuario(rutaArchivo));
	}

	public boolean agregarListaAtracciones(String rutaArchivo) {
		return listaAtracciones.addAll(LectorAtracciones.cargarAtracciones(rutaArchivo));
	}
	
	public boolean agregarListaPromociones(String rutaArchivo) {
		return listaPromociones.addAll(LectorPromociones.cargarPromociones(rutaArchivo,listaAtracciones));
	}

	public List<Usuario> getPersonas() {
		return listaUsuarios;
	}


	public List<Atraccion> getAtracciones() {
		Collections.sort(listaAtracciones); // ordeno por el costo -> ver clase atraccion en el compareTo
		return listaAtracciones;
	}
	
	public List<Promocion> getPromociones() {
		//Collections.sort(listaPromociones); // ordeno por el costo -> ver clase promocion en el compareTo
		return listaPromociones;
	}
	
	
	public List<Ofertable> creandoOfertas(){
		
		for(Promocion cadaPromo : getPromociones() ) {
			listaOfertas.add(cadaPromo);
		}
		
		for(Atraccion cadaAtraccion : getAtracciones()) {
			listaOfertas.add(cadaAtraccion);
		}
		
		return listaOfertas;
	}
	
	

	public  Atraccion buscar(int posicion) {
		return listaAtracciones.get(posicion);
	}

	public void hacerSugerencia() {

		System.out.println("-------------------------------------------------------------------");

		for (Usuario cadaPersona : listaUsuarios) {
			
			System.out.println("Sugerencias: \n ");
			System.out.println("Nombre del visitante: " + cadaPersona.getNombre() + "\n");
			System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y " + cadaPersona.getHorasDisponibles()
					+ " horas disponibles" + "\n");	
		
			for(Ofertable cadaOferta : creandoOfertas()) {
				
				if (cadaPersona.getDinero() >= cadaOferta.getCosto()
						&& cadaPersona.getHorasDisponibles() >= cadaOferta.getDuracion()
						&& cadaOferta.getCupo() > 0) {
					
				
			System.out.println(String.format("%s", cadaOferta.formatoConsola())); // escribe en consola la atraccion, su precio y la duracion

					//System.out.println(cadaOferta.getNombre());
					
					
					
					while (!respuesta.equalsIgnoreCase("S")) { // entro al while, mientras la respuesta (lo que se
																// escribe por consola) no sea igual a "s", pregunta si
																// desea comprar la atraccion
						if (respuesta.equalsIgnoreCase("N")) {
							break;
						}

						System.out.println("¿Desea comprar la atraccion? S o N ");
						usarScanner(); // permite escribir por consola (ver el metodo de abajo)

					}

					if (respuesta.equalsIgnoreCase("S")) { // si responde "s", compra la atraccion
						cadaPersona.comprar(cadaOferta);
						System.out.println("¡Aceptada! \n");
					}
					
					System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y "
							+ cadaPersona.getHorasDisponibles() + " horas disponibles");
					
					
					//borrar!!!! System.out.println("\n" + cadaOferta.getCupo());
					
					System.out.println("\n-------------------------------------------------------------------");

					respuesta = "a"; // cambio la respuesta a cualquier cosa que no sea S ni N, así, en la proxima
										// iteracion, entra al while.
				}
			}
		}
	}

	public static void usarScanner() {
		Scanner s = new Scanner(System.in); // para poder escribir por consola
		respuesta = s.next().toUpperCase(); // en respuesta se guarda lo que uno escribe en consola
	}
}



