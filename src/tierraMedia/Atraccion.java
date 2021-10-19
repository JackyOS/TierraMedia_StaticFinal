package tierraMedia;

import java.util.List;

public class Atraccion implements Ofertable {
	private String nombreAtraccion;
	private double costoAtraccion;
	private double duracionAtraccion;
	private int cupoAtraccion;

	public Atraccion(String nombre, double costo, double duracion, int cupo) {
		this.nombreAtraccion = nombre;
		this.costoAtraccion = costo;
		this.duracionAtraccion = duracion;
		this.cupoAtraccion = cupo;
	}

	@Override
	public String getNombre() {
		return nombreAtraccion;
	}

	@Override
	public double getPrecioOriginal() {
		return costoAtraccion;
	}

	@Override
	public double getDuracion() {
		return duracionAtraccion;
	}

	@Override
	public boolean hayCupo() {
		boolean verCupo = true;
		if (cupoAtraccion == 0) {
			verCupo = false;
		}
		return verCupo;
	}

	public int getCupo() {
		return cupoAtraccion;
	}

	public synchronized void setCupo() {
		this.cupoAtraccion--;
	}

	@Override
	public boolean soyPromocion() {
		return false;
	}

	@Override
	public boolean estaIncluidaLaAtraccion() {
		return false;
	}

	@Override
	public double getDescuento() {
		return 0;
	}

	public String formatoConsola() {
		return String.format(" -Atracción: [ %s ] \n -Duración: %s horas \n -Precio: $%s \n", 
				nombreAtraccion, duracionAtraccion, costoAtraccion);
	}

	@Override
	public String toString() {
		return formatoConsola() + "\n";
	}
}
