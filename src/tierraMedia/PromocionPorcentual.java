package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private double descuentoPorcentaje;
	
	public PromocionPorcentual(String nombrePromocion, double descuentoPorcentaje, List<Atraccion> promociones) {
		super(nombrePromocion,promociones);
		this.descuentoPorcentaje = descuentoPorcentaje;
	}
	
	@Override
	public String getNombrePromo() {
		return nombrePromocion;
	}

	public double getDescuento() {
		return descuentoPorcentaje * super.getPrecioOriginal();
	}	
}


