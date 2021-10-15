package desafio;

import java.util.List;

public abstract class Ofertable {

	protected String nombre;
	protected List<Atraccion> promociones;
	protected double duracion;
	protected double montoPromo;
	protected int cupo;
	
	
	public Ofertable(String nombre, List<Atraccion> promociones, double montoPromo) {
		this.nombre = nombre;
		this.promociones = promociones;
		this.montoPromo = montoPromo;
	}


	public String getNombre() {
		return nombre;
	}


	public List<Atraccion> getPromociones() {
		return promociones;
	}

	public double getDuracion() {
		return duracion;
	}


	public double getCosto() {		
		return montoPromo;
	}


	public int getCupo() {
		return cupo;
	}

	
	public synchronized void setCupo() {
		cupo--;
	}

	

	@Override
	public String toString() {
		return "Ofertable [nombre=" + nombre + ", promociones=" + promociones + ", duracion=" + duracion + ", costo="
				+ montoPromo + ", cupo=" + cupo + "]";
	}

	
	
	public String formatoConsola() {
		return String.format(" -Atracciones incluidas: [%s] \n -Duracion: %s horas \n -Precio original: $%s \n", 
			getNombre(), getDuracion(), getCosto());

	}


	
	
	//public abstract void AgregarOfertas();
	
	
	
	
	
	
}
