package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precioConDescuento;

	public PromocionAbsoluta(String nombrePromocion, int precioConDescuento, List<Atraccion> promociones) {
		super(nombrePromocion, promociones);
		this.precioConDescuento = precioConDescuento;
	}

	@Override
	public String getNombrePromo() {
		return nombrePromocion;
	}

	@Override
	public double getDescuento() {
		return precioConDescuento;
	}
}
