package tierraMedia;

import java.util.ArrayList;
import java.util.List;

public class PromocionAxB extends Promocion {
	private int cantidadAtraccionesPagas;
	private int cantidadAtraccionesGratis;
	private List<Atraccion> atraccionesPagas;
	private List<Atraccion> atraccionesGratuitas;

	public PromocionAxB(String nombrePromocion, int cantidadAtraccionesPagas, List<Atraccion> atraccionesPagas, int cantidadAtraccionesGratis,
			List<Atraccion> atraccionesGratuitas) {
		super(nombrePromocion, atraccionesPagas);
		this.cantidadAtraccionesPagas = cantidadAtraccionesPagas;
		this.cantidadAtraccionesGratis = cantidadAtraccionesGratis;
		this.atraccionesGratuitas = new ArrayList<Atraccion>();
	}

	@Override
	public String getNombrePromo() {
		return nombrePromocion;
	}

	@Override
	public double getDescuento() {
		double valor = 0.0;
		/*
		for(Atraccion cadaAtraccion : atraccionesPagas) {
			valor += cadaAtraccion.getPrecioOriginal();
		}
		*/			
		return valor;
	}
}
	
	
	/*
	private List<String> nombresAtraccionesGratuitas;
	private Set<Atraccion> promociones2;

	public PromocionAxB(String nombrePromocion, List<Atraccion> promociones, double montoPromo) {
		super(nombrePromocion, promociones, montoPromo);
		nombresAtraccionesGratuitas =  new ArrayList<>();
		promociones2 =	new HashSet<>();
	}
	
	public List<String> agregarAtraccionesGratuita() {
		nombresAtraccionesGratuitas.add("Erebor");
		nombresAtraccionesGratuitas.add("Bosque Negro");
		nombresAtraccionesGratuitas.add("Abismo de Helm");
		nombresAtraccionesGratuitas.add("Minas Tirith");

		return nombresAtraccionesGratuitas;
	}
	
		
	@Override
	public double getDescuento() {
		double costoAtraccionesSinGratuitas = super.getCosto();
		

		for(Atraccion cadaAtraccion : promociones) {			
			for(String cadaNombre : agregarAtraccionesGratuita()) {
				
				if(cadaNombre.equals(cadaAtraccion.getNombre())) {
					promociones2.add(cadaAtraccion);
				}
			}
		}		
		
		for(Atraccion cadaAtraccion : promociones2 ) {
			costoAtraccionesSinGratuitas -= cadaAtraccion.getCosto();
		}
		
		return costoAtraccionesSinGratuitas;
	}

*/
	

	
	
