package desafio4;

public class Atraccion implements Comparable<Atraccion> {
	
	private String nombre;
	private Integer costo;
	private double duracion;
	private int cupo;
	
	
	public Atraccion(String nombre, int costo, double duracion, int cupo) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
	}

	
	public String getNombre() {
		return nombre;
	}

	public int getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getCupo() {
		return cupo;
	}
	

	public void setCupo() {
		this.cupo--;
	}


	@Override
	public String toString() {
		return "-Atracciones incluidas: " + "[ " + nombre + " ]" + "\n" +
				"-Duracion: " + duracion + "\n" +
				"-Precio original: " + costo + "\n";
	}
	
	public String formatoConsola() {
		return String.format(" -Atracciones incluidas: [%s] \n -Duracion: %s horas \n -Precio original: $%s \n", 
				this.nombre, this.duracion, this.costo); 
			
	}
	
	@Override
	public int compareTo(Atraccion o) {
		return this.costo.compareTo(o.costo); //ordeno de forma natural, segun el costo de cada atraccion.
	}
	
	
	
}
