package desafio4;

import java.util.ArrayList;
import java.util.Collections;


public class TierraMedia {
	

	private ArrayList<Persona> personas = LectorPersonas.cargarPersonas("datos/personas.txt");
	private ArrayList<Atraccion> atracciones = LectorAtracciones.cargarAtracciones("datos/atracciones.txt");
	
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	
	public ArrayList<Atraccion> getAtracciones(){
		Collections.sort(atracciones); //ordeno por el costo -> ver clase atraccion en el compareTo
		return atracciones;
	}
	
	

	
	
	

		
	
	
	
	
	
}
