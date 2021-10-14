package desafio4;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	// Promociones absolutas ($ X por todo el paquete)
	protected int precioFinal;

	public PromocionAbsoluta(String nombre, List<Atraccion> promociones, double porcentajePromocion,
			int totalPromocionAbsoluta, Atraccion atraccionGratuita) {
		super(nombre, promociones, porcentajePromocion, totalPromocionAbsoluta, atraccionGratuita);
		this.precioFinal = totalPromocionAbsoluta;
	}

}
