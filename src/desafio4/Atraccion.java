package desafio4;

public class Atraccion implements Comparable<Atraccion> {
	
	private String nombre;
	private Integer costo;
	private double duracion;
	private int cupo;
	
	
	public Atraccion(String nombre, int costo, double duracion, int cupo) {
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
	

	public void setCupo(int cupo) {
		this.cupo -= cupo;
	}
	
	
	
	@Override
	public String toString() {
		return "nombre= " + nombre + ", costo= " + costo + ", duracion= " + duracion + ", cupo= " + cupo + "\n";
	}


	@Override
	public int compareTo(Atraccion o) {
		return this.costo.compareTo(o.costo); //ordeno de forma natural, segun el costo de cada atraccion.
	}
	
	
	
	
	
}
