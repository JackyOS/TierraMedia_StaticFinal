package desafio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


//---------------------------HAY QUE HACERLO BIEN!!!-----------------------------------------------

public class LectorPromociones {
	
	public static ArrayList<Promocion> cargarPromocions(String path) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();//preparamos la lista de Promocions
				
		try {
			
			fr = new FileReader(path); //va dentro de un try catch
			br = new BufferedReader(fr);
			
			//leer linea por linea de la lista de Promocions
			String linea = br.readLine();
			Atraccion atraccion;
			
			while(linea!=null) { //mientras linea sea distinta a null, seguimos leyendo
				//LEO LA FILA
				
				//DIVIDO LOS DATOS
				String[] datos = linea.split(","); //separamos la linea por comas
								
				//Preparo los datos
				String nombre = datos[0];
				
				// = (datos[1], datos[2],datos[3], datos[4]);
				
				double costo = Double.parseDouble(datos[2]); 				

				
				//AGREGO LOS DATOS A LA LISTA Promocions, CREO UNa NUEVa promocion cada vez que lee una linea
				//promociones.add(new Promocion(nombre,,costo)));
								
				
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
	
		return promociones;
	}
	
	
	
	

}
