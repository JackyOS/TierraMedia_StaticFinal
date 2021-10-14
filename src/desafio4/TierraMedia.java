package desafio4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TierraMedia {

	private List<Usuario> listaUsuarios;
	private static List<Atraccion> listaAtracciones;
	private List<Promocion> listaPromociones;

	private static String respuesta = "a";

	public TierraMedia() {
		listaUsuarios = new LinkedList<>();
		listaAtracciones = new LinkedList<>();
		listaPromociones = new LinkedList<>();
	}

	public boolean agregarListaPersonas(String rutaArchivo) {
		return listaUsuarios.addAll(LectorUsuarios.cargarUsuarios(rutaArchivo));
	}

	public boolean agregarListaAtracciones(String rutaArchivo) {
		return listaAtracciones.addAll(LectorAtracciones.cargarAtracciones(rutaArchivo));
	}

	public boolean agregarListaPromociones(String rutaArchivo) {
		return listaPromociones.addAll(LectorPromociones.cargarPromociones(rutaArchivo, listaAtracciones));
	}

	public List<Usuario> getPersonas() {
		return listaUsuarios;
	}

	public List<Atraccion> getAtracciones() {
		Collections.sort(listaAtracciones); // ordeno por el costo -> ver clase atraccion en el compareTo
		return listaAtracciones;
	}

	public List<Promocion> getPromociones() {
		Collections.sort(listaPromociones); // ordeno por el costo -> ver clase promocion en el compareTo
		return listaPromociones;
	}

	public Atraccion buscar(int posicion) {
		return listaAtracciones.get(posicion);
	}

	public void hacerSugerencia() {
		System.out.println("-------------------------------------------------------");
		for (Usuario cadaPersona : listaUsuarios) {
			System.out.println("Nombre del visitante: " + cadaPersona.getNombre());
			System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y " + 
								cadaPersona.getHorasDisponibles() + " horas disponibles" + "\n");
			System.out.println("Sugerencias:");

			for (Promocion cadaPromocion : getPromociones()) {
				if (cadaPersona.getDinero() >= cadaPromocion.getCosto()
						&& cadaPersona.getHorasDisponibles() >= cadaPromocion.getDuracion()) {
					System.out.println(String.format("%s", cadaPromocion.consolaPromocion())); //

					while (!respuesta.equalsIgnoreCase("S")) {
						if (respuesta.equalsIgnoreCase("N")) {
							break;
						}

						System.out.println("¿Desea comprar la promoción? S o N ");
						usarScanner(); // permite escribir por consola (ver el metodo de abajo)

					}
				}
			}

			for (Atraccion cadaAtraccion : getAtracciones()) {

				if (cadaPersona.getDinero() >= cadaAtraccion.getCosto()
						&& cadaPersona.getHorasDisponibles() >= cadaAtraccion.getDuracion()
						&& cadaAtraccion.getCupo() > 0) {

					System.out.println(String.format("%s", cadaAtraccion.consolaAtraccion())); //
					// escribe en consola la atraccion, su precio y la duracion

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
						cadaPersona.comprar(cadaAtraccion);
					}
					System.out.println("Usted tiene: $" + cadaPersona.getDinero() + " y "
							+ cadaPersona.getHorasDisponibles() + " horas disponibles");
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
