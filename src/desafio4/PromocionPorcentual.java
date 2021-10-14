package desafio4;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	// Promociones porcentuales (X % de descuento en el costo total)
	/*
	 * String nombrePromocion List<Atraccion> promociones double porcentajePromocion
	 * int totalPromocionAbsoluta Atraccion atraccionGratuita;
	 */
	protected static double precioFinal;

	public PromocionPorcentual(String nombre, List<Atraccion> promociones, double porcentajePromocion,
			int totalPromocionAbsoluta, Atraccion atraccionGratuita) {
		super(nombre, promociones, porcentajePromocion, totalPromocionAbsoluta, atraccionGratuita);
		precioFinal = precioFinal();
	}

	public double precioFinal() {
		double precioFinal = 0;
		for (Atraccion atracciones : this.promociones) {
			precioFinal += atracciones.getCosto();
		}
		return precioFinal * (1 - porcentajePromocion);
	}

}
