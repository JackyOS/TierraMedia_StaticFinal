package desafio4;

public class Atraccion extends Ofertable implements Comparable<Atraccion> {
	/*
	 * Cada atracci�n cuenta con su costo de visita, el promedio de tiempo necesario
	 * para realizarla y el cupo de personas que pueden visitarlo a diario.
	 */

	public Atraccion(String nombre, double costo, double duracion, int cupo) {
		super(nombre, costo, duracion, cupo);
	}

	public String consolaAtraccion() {
		return String.format(" -Atracci�n: [ %s ] \n -Duraci�n: %s horas \n -Precio: $%s \n", 
				nombre, duracion, costo); 
	}

	
	/*
	@Override
	public String toString() {
		return ("-Atracci�n: [ " + nombre + " ]" +
				"\n" + "-Duracion: " + duracion + " horas" + "\n" + 
				"-Precio: $" + costo + "\n");
	}
	*/
	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(Atraccion o) {
		return -costo.compareTo(o.costo); // ordeno de forma natural, segun el costo de cada atraccion.
	}


}
