package desafio;

import java.util.List;

//Promociones absolutas ($ X por todo el paquete)
public class PromocionAbsoluta extends Promocion{

	public PromocionAbsoluta(String nombrePromocion, List<Atraccion> promociones, double montoPromo) {
		super(nombrePromocion, promociones, montoPromo);

	}
	
	
	@Override
	public double getDescuento() {
		return montoPromo;
	}
	
	
	/*
	@Override
	public double getDescuento() {
		return montoPromo;
	}

*/

}
