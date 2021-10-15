package desafio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LectorPersonas {
	
	public static ArrayList<Persona> cargarPersonas(String path) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		ArrayList<Persona> personas = new ArrayList<Persona>();//preparamos la lista de Personas
				
		try {
			
			fr = new FileReader(path); //va dentro de un try catch
			br = new BufferedReader(fr);
			
			//leer linea por linea de la lista de Personas
			String linea = br.readLine();
			
			while(linea!=null) { //mientras linea sea distinta a null, seguimos leyendo
				//LEO LA FILA
				
				//DIVIDO LOS DATOS
				String[] datos = linea.split(","); //separamos la linea por comas
								
				//Preparo los datos
				String nombre = datos[0];
				Integer dinero = Integer.parseInt(datos[1]); 				
				Integer horasDisponibles = Integer.parseInt(datos[2]); 	

				
				//AGREGO LOS DATOS A LA LISTA Personas, CREO UNa NUEVa persona cada vez que lee una linea
				personas.add(new Persona(nombre, dinero, horasDisponibles));
								
				
				linea = br.readLine(); //leemos cada linea
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(fr != null) { //si abrí fr, lo debo cerrar!
				try {
					fr.close(); //cierro el archivo (tambien necesita de un try/catch)
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	
		return personas;
	}
	
	
	
	

}
