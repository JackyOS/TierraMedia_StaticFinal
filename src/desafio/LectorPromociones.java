package desafio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//---------------------------HAY QUE HACERLO BIEN!!!-----------------------------------------------

public class LectorPromociones {

	public static ArrayList<Promocion> cargarPromociones(String path, List<Atraccion> atracciones) {

		FileReader fr = null;
		BufferedReader br = null;

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();// preparamos la lista de Promocions

		try {

			fr = new FileReader(path); // va dentro de un try catch
			br = new BufferedReader(fr);

			// leer linea por linea de la lista de Promocions
			String linea = br.readLine();
			// Atraccion atraccion;

			while (linea != null) { // mientras linea sea distinta a null, seguimos leyendo
				// LEO LA FILA

				// DIVIDO LOS DATOS
				String[] datos = linea.split(","); // separamos la linea por comas

				// Preparo los datos
				String nombre = datos[0];
				
				//TipoPromocion tipo = TipoPromocion.valueOf(datos[1].toUpperCase());

				String[] stringListaAtracciones = datos[1].split("-");
				List<Atraccion> atraccionesDePromocion = new ArrayList<Atraccion>();

				for (int i = 0; i < stringListaAtracciones.length; i++) {
					atraccionesDePromocion.add(buscarAtraccion(stringListaAtracciones[i], atracciones));
				}

				double monto = Double.parseDouble(datos[2]);
			
				promociones.add(new Promocion(nombre, atraccionesDePromocion, monto));

				linea = br.readLine(); // leemos cada linea
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (fr != null) { // si abrí fr, lo debo cerrar!
				try {
					fr.close(); // cierro el archivo (tambien necesita de un try/catch)
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
 
		}

		return promociones;
	}

	private static Atraccion buscarAtraccion(String cadena, List<Atraccion> listaAtracciones) {
		
		Atraccion a = null;
		for (Atraccion cadaAtraccion : listaAtracciones) {
			if (cadaAtraccion.getNombre().equals(cadena)) {
				 a= cadaAtraccion;
			}
		}
		
		return a;
	}

}
