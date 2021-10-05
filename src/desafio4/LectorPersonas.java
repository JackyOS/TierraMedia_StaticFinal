package desafio4;

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
			fr = new FileReader(path); 
			br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while(linea!=null) { //mientras linea sea distinta a null, seguimos leyendo

				String[] datos = linea.split(","); //separamos los datos en las comas
								
				String nombre = datos[0];
				Integer dinero = Integer.parseInt(datos[1]); 				
				Integer horasDisponibles = Integer.parseInt(datos[2]); 	

				personas.add(new Persona(nombre, dinero, horasDisponibles));
								
				linea = br.readLine(); 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(fr != null) { 
				try {
					fr.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return personas;
	}
	
	
	
	

}
