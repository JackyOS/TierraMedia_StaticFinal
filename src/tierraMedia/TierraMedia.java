package tierraMedia;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
		return listaUsuarios.addAll(LectorUsuarios.cargarUsuario(rutaArchivo));
	}

	public boolean agregarListaAtracciones(String rutaArchivo) {
		return listaAtracciones.addAll(LectorAtracciones.cargarAtracciones(rutaArchivo));
	}

	public boolean agregarListaPromociones(String rutaArchivo) {
		return listaPromociones.addAll(LectorPromociones.cargarPromociones(rutaArchivo, listaAtracciones));
	}

	public List<Atraccion> getAtracciones() {
		return listaAtracciones;
	}

	public List<Promocion> getPromociones() {
		return listaPromociones;
	}

	public List<Ofertable> creandoOfertas() {
		for (Promocion cadaPromo : getPromociones()) {
			listaOfertas.add(cadaPromo);
		}
		for (Atraccion cadaAtraccion : getAtracciones()) {
			listaOfertas.add(cadaAtraccion);
		}
		return listaOfertas;
	}

	/*
	 * VEEEER - NO ME TOMA LA LISTA DE OFERTAS - IMPRIME [] public List<Ofertable>
	 * getOfertas(){ return listaOfertas; }
	 */

	public Atraccion buscar(int posicion) {
		return listaAtracciones.get(posicion);
	}

	public void hacerSugerencia() {
		System.out.println("\t - BIENVENIDOS A TIERRA MEDIA -");
		System.out.println("---------------------------------------------------");
		
		for (Usuario cadaPersona : listaUsuarios) {
			System.out.println("Nombre del visitante: " + cadaPersona.getNombre());
			System.out.println("Usted tiene: $" + cadaPersona.getPresupuesto() + " y "
					+ cadaPersona.getHorasDisponibles() + " horas disponibles" + "\n");
			
			System.out.println("Sugerencias: ");
			for (Ofertable cadaOferta : creandoOfertas()) {
				if (cadaPersona.getPresupuesto() >= cadaOferta.getPrecio() && 
						cadaPersona.getHorasDisponibles() >= cadaOferta.getDuracion() && cadaOferta.hayCupo()) {
					System.out.println(String.format("%s", cadaOferta.formatoConsola()));
					while (!respuesta.equals("S")) {
						if (respuesta.equals("N")) {
							break;
						}
						System.out.println("¿Desea comprar la atraccion? S o N ");
						usarScanner(); // permite escribir por consola (ver el metodo de abajo)
					}

					if (respuesta.equals("S")) { // si responde "s", compra la atraccion
						cadaPersona.comprar(cadaOferta);
						cadaPersona.setItinerario(cadaOferta);
						System.out.println("¡Aceptada! \n");
					}

					DecimalFormat df = new DecimalFormat("0.00"); // rendondeo decimales.
					System.out.println("Usted tiene: $" + df.format(cadaPersona.getPresupuesto()) + " y "
							+ cadaPersona.getHorasDisponibles() + " horas disponibles");
					respuesta = "a";
				}
			}
			System.out.println("\n\n------------------ ITINERARIO ---------------------");
			System.out.println(cadaPersona.formatoItinerario());
			System.out.println("\n===================================================");
			getSalida(cadaPersona);
		}
	}

	public static void usarScanner() {
		Scanner s = new Scanner(System.in);
		respuesta = s.next().toUpperCase();
	}

	public void getSalida(Usuario cadaUsuario) {
		try {
			String fileName = "salida/" + cadaUsuario.getNombre() + ".txt";
			List<String> lines = Arrays.asList(cadaUsuario.formatoItinerario());
			Path file = Paths.get(fileName);
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Ocurrió un error");
			e.printStackTrace();
		}
	}
}
