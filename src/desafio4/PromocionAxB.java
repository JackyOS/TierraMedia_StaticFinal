package desafio4;

import java.util.List;

public class PromocionAxB extends Promocion {

	protected int precioFinal;
	protected Atraccion atraccionGratuita;

	public PromocionAxB(String nombrePromocion, List<Atraccion> promociones, double porcentajePromocion,
			int totalPromocionAbsoluta, Atraccion atraccionGratuita) {
		super(nombrePromocion, promociones, porcentajePromocion, totalPromocionAbsoluta, atraccionGratuita);
		this.precioFinal = precioFinal();
		this.atraccionGratuita = atraccionGratuita;
	}

	private int precioFinal() {
		int precioFinal = 0;
		for (Atraccion atraccion : promociones) {
			precioFinal += atraccion.getCosto();
		}
		return precioFinal;
	}

}
