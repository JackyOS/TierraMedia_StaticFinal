package desafio;

import java.util.List;

public class Promocion  {
	/*
	 * En la generación de las sugerencias deben contemplarse las promociones
	 * vigentes. Cada promoción incluye una o varias atracciones y beneficia al
	 * usuario con una reducción del costo total. Se espera que el sistema permita
	 * la definición de promociones de tres tipos: Promociones porcentuales (X % de
	 * descuento en el costo total) Promociones absolutas ($ X por todo el paquete)
	 * Promociones A x B (si el usuario compra A, B, C entonces tiene gratis D).
	 */

	
	protected String nombrePromocion;
	protected List<Atraccion> promociones;
	protected double porcentajePromocion;
	protected int totalPromocionAbsoluta;
	protected Atraccion atraccionGratuita;

	public Promocion(String nombrePromocion, List<Atraccion> promociones, double porcentajePromocion,
			int totalPromocionAbsoluta, Atraccion atraccionGratuita) {
		this.nombrePromocion = nombrePromocion;
		this.promociones = promociones;
		this.porcentajePromocion = porcentajePromocion;
		this.totalPromocionAbsoluta = totalPromocionAbsoluta;
		this.atraccionGratuita = atraccionGratuita;
	}

	@Override
	public String toString() {
		return "\n NombrePromocion=" + nombrePromocion + "\n Lista de Atracciones = " + promociones
				+ " \n PorcentajePromocion=" + porcentajePromocion + "\n TotalPromocionAbsoluta=" + totalPromocionAbsoluta
				+ "\n AtraccionGratuita=" + atraccionGratuita + "]";
	}
	
	
}
