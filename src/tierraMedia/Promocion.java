package tierraMedia;

import java.text.DecimalFormat;
import java.util.List;

public abstract class Promocion implements Ofertable {
	protected String nombrePromocion;
	protected List<Atraccion> listaAtracciones;

	public Promocion(String nombrePromocion, List<Atraccion> listaAtracciones) {
		this.listaAtracciones = listaAtracciones;
		this.nombrePromocion = nombrePromocion;
	}

	public String getNombrePromo() { // nombre de la promo
		return nombrePromocion;
	}

	@Override
	public String getNombre() { // nombre de cada atraccion
		String nombresPromos = "";
		for (Atraccion cadaAtraccion : listaAtracciones) {
			nombresPromos += cadaAtraccion.getNombre() + ", "; // separa los nombres con ", "
		}
		nombresPromos = nombresPromos.substring(0, nombresPromos.length() - 2); // elimina el ", " que queda en el final
		return nombresPromos;
	}

	@Override
	public double getPrecio() { // precio SIN DESCUENTO
		double valor = 0;
		for (Atraccion cadaAtraccion : listaAtracciones) {
			valor += cadaAtraccion.getPrecio();
		}
		return valor;
	}

	@Override
	public double getDuracion() { // DURACION TOTAL
		double duracionTotal = 0;
		for (Atraccion cadaAtraccion : listaAtracciones) {
			duracionTotal += cadaAtraccion.getDuracion();
		}
		return duracionTotal;
	}

	@Override
	public boolean hayCupo() {
		boolean verCupo = false;

		/*
		 * int i = 0; while (verCupo && i < listaAtracciones.size()) {
		 * if(!listaAtracciones.get(i).hayCupo()) { verCupo = false; } }
		 */

		for (Atraccion cadaAtraccion : listaAtracciones) {
			if (cadaAtraccion.hayCupo()) {
				verCupo = true;
			}
		}
		return verCupo;
	}

	public synchronized void setCupo() { // resta cupo
		for (Atraccion cadaAtraccion : listaAtracciones) {
			cadaAtraccion.setCupo();
		}
	}

	@Override
	public boolean soyPromocion() {
		return true;
	}

	@Override
	public double getDescuento() {
		return 0;
	}

	@Override
	public boolean estaIncluidaLaAtraccion() {
		return false;
	}

	@Override
	public String formatoConsola() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.format(
				"-Promocion: [ %s ] \n -Atracciones incluidas: [ %s ] \n -Duracion: %s horas \n -Precio original: $%s \n -Precio Con descuento: $%s \n",
				getNombrePromo(), getNombre(), getDuracion(), getPrecio(), df.format(getDescuento()));
	}

	@Override
	public String toString() {
		return formatoConsola() + "\n";
	}
}
