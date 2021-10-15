package desafio;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	// Promociones porcentuales (X % de descuento en el costo total)
	/*
	 * String nombrePromocion List<Atraccion> promociones double porcentajePromocion
	 * int totalPromocionAbsoluta Atraccion atraccionGratuita;
	 */
	private double precioFinal;

	public PromocionPorcentual(String nombrePromocion, List<Atraccion> promociones, double porcentajePromocion,
			int totalPromocionAbsoluta, Atraccion atraccionGratuita) {
		super(nombrePromocion, promociones, porcentajePromocion, totalPromocionAbsoluta, atraccionGratuita);
		precioFinal = precioFinal();
	}

	public double precioFinal() {
		double precioFinal = 0.0;
		for (Atraccion a : this.promociones) {
			precioFinal += a.getCosto();
		}
		return precioFinal * (1 - this.porcentajePromocion);
	}

}
