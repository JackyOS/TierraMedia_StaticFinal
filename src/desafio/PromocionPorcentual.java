package desafio;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	public PromocionPorcentual(String nombrePromocion, List<Atraccion> promociones, double montoPromo) {
		super(nombrePromocion, promociones, montoPromo);
	}
		
	@Override
	public double getDescuento() {
		return montoPromo * super.getCosto() ;
	}

	@Override
	public String toString() {
		return "PromocionPorcentual [getDescuento()=" + getDescuento() + "]";
	}

	
	
	
	
	
}


