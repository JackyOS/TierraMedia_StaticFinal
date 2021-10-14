package desafio4;

import java.util.List;

public abstract class Ofertable{
	public List<Object> ofertas;

	protected String nombre;
	protected Double costo;
	protected double duracion;
	protected int cupo;
	
	public Ofertable(String nombre, double costo, double duracion, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}
	
	public int getCupo() {
		return cupo;
	}
	
	public synchronized void setCupo() {
		cupo--;
	}

	
	

}
