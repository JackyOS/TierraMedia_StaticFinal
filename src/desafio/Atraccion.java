package desafio;

public class Atraccion extends Oferta implements Comparable<Atraccion> {
	/*
	 * Cada atracción cuenta con su costo de visita, el promedio de tiempo necesario
	 * para realizarla y el cupo de personas que pueden visitarlo a diario.
	 */
	private String nombreAtraccion;
	private Integer costoAtraccion;
	private double duracionAtraccion;
	private int cupoAtraccion;

	public Atraccion(String nombre, int costo, double duracion, int cupo) {
		this.nombreAtraccion = nombre;
		this.costoAtraccion = costo;
		this.duracionAtraccion = duracion;
		this.cupoAtraccion = cupo;
	}

	public String getNombre() {
		return nombreAtraccion;
	}

	public int getCosto() {
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
		return "-Atracciones incluidas: " + "[ " + nombreAtraccion + " ]" + "\n" + "-Duracion: " + duracionAtraccion
				+ "\n" + "-Precio original: " + costoAtraccion + "\n";
	}

	/*public String formatoConsola() {
		return String.format(" -Atracciones incluidas: [%s] \n -Duracion: %s horas \n -Precio original: $%s \n",
				this.nombreAtraccion, this.duracionAtraccion, this.costoAtraccion);

	}*/

	@Override
	public int compareTo(Atraccion o) {
		return -this.costoAtraccion.compareTo(o.costoAtraccion); // ordeno de forma natural, segun el costo de cada atraccion.
	}
	
	@Override
	public void AgregarOfertas() {
		ofertas.add(new Atraccion(this.nombreAtraccion, this.cupoAtraccion, this.duracionAtraccion, this.cupoAtraccion));	
	}

	
}
