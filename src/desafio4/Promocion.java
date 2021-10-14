package desafio4;

import java.util.List;

public class Promocion extends Ofertable implements Comparable<Promocion> {
	/*
	 * En la generación de las sugerencias deben contemplarse las promociones
	 * vigentes. Cada promoción incluye una o varias atracciones y beneficia al
	 * usuario con una reducción del costo total. Se espera que el sistema permita
	 * la definición de promociones de tres tipos: Promociones porcentuales (X % de
	 * descuento en el costo total) Promociones absolutas ($ X por todo el paquete)
	 * Promociones A x B (si el usuario compra A, B, C entonces tiene gratis D).
	 */

	protected List<Atraccion> promociones;
	protected double porcentajePromocion;
	protected int totalPromocionAbsoluta;
	protected Atraccion atraccionGratuita;
	// private Object costoPromocion;
	protected double duracion;

	public Promocion(String nombre, List<Atraccion> promociones, double porcentajePromocion, int totalPromocionAbsoluta,
			Atraccion atraccionGratuita) {
		super(nombre, totalPromocionAbsoluta, porcentajePromocion, totalPromocionAbsoluta);
		this.promociones = promociones;
		this.porcentajePromocion = porcentajePromocion;
		this.totalPromocionAbsoluta = totalPromocionAbsoluta;
		this.atraccionGratuita = atraccionGratuita;
	}

	public String consolaPromocion() {
		return String.format(
				" -Promocion %s \n -Atracciones incluídas: %s \n -Duración: %s horas \n " + "-Precio: $%s \n ", nombre,
				promociones, duracion, PromocionPorcentual.precioFinal);
	}

	/*
	 * @Override public String toString() { return "-Promocion: " + nombre + "\n" +
	 * promociones + " \n" + "-PorcentajePromocion: " + porcentajePromocion + "\n" +
	 * "-TotalPromocionAbsoluta: " + totalPromocionAbsoluta + "\n" +
	 * "-AtraccionGratuita: " + atraccionGratuita + "\n" + "\n"; }
	 */

	public double duracionPromo() {
		this.duracion = 0;
		for (Atraccion atracciones : this.promociones) {
			this.duracion += atracciones.getDuracion();
		}
		return this.duracion;
	}

	@Override
	public int compareTo(Promocion o) {
		return -this.costo.compareTo(o.costo);
	}
}
