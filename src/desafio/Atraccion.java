package desafio;

import java.util.List;

public class Atraccion extends Ofertable implements Comparable<Atraccion> {
	
	private String nombreAtraccion;
	private Double costoAtraccion;
	private double duracionAtraccion;
	private int cupoAtraccion;
	private static List<Atraccion> listaA; //modificar
	
	
	public Atraccion(String nombre, double costo, double duracion, int cupo) {
		super(nombre, listaA, duracion);
		this.nombreAtraccion = nombre;
		this.costoAtraccion = costo;
		this.duracionAtraccion = duracion;
		this.cupoAtraccion = cupo;
	}

	public String getNombre() {
		return nombreAtraccion;
	}

	public double getCosto() {
		return costoAtraccion;
	}

	public double getDuracion() {
		return duracionAtraccion;
	}

	public int getCupo() {
		return cupoAtraccion;
	}

	
	public synchronized void setCupo() {
		this.cupoAtraccion--;
	}
	
	
	@Override
	public String toString() {
		return "Nombre = " + nombreAtraccion + " costoAtraccion=" + costoAtraccion
				+ " duracionAtraccion=" + duracionAtraccion + " cupoAtraccion=" + cupoAtraccion + "\n";
	}
	
/*
	@Override
	public String formatoConsola() {
		return String.format(" -Atracciones incluidas: [%s] \n -Duracion: %s horas \n -Precio original: $%s \n",
				this.nombreAtraccion, this.duracionAtraccion, this.costoAtraccion);

	}
	
*/
	
	public String formatoConsola() {
		return String.format(" -Atracción: [ %s ] \n -Duración: %s horas \n -Precio: $%s \n", 
				nombre, duracionAtraccion, costoAtraccion); 
	}


	@Override
	public int compareTo(Atraccion o) {
		return -this.costoAtraccion.compareTo(o.costoAtraccion); // ordeno de forma natural, segun el costo de cada atraccion.
	}
	

}
