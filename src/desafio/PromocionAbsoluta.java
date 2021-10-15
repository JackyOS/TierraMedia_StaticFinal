package desafio;

import java.util.List;

public class PromocionAbsoluta extends Promocion{
	
	//Promociones absolutas ($ X por todo el paquete)
	private int precioFinal;
	public PromocionAbsoluta(String nombrePromocion, List<Atraccion> promociones, double porcentajePromocion,
			int totalPromocionAbsoluta, Atraccion atraccionGratuita) {
		super(nombrePromocion, promociones, porcentajePromocion, totalPromocionAbsoluta, atraccionGratuita);
		this.precioFinal=this.totalPromocionAbsoluta;
	}

}
