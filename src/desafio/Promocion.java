package desafio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Promocion extends Ofertable  {

	double duracionAtraccionesTotal = 0;
	int cupoMinimoTotal = 0;
		
	protected String nombrePromocion;
	protected List<Atraccion> promociones;
	protected double montoPromo;
	
	public Promocion(String nombrePromocion, List<Atraccion> promociones, double montoPromo) {
		super(nombrePromocion, promociones, montoPromo);
		this.nombrePromocion = nombrePromocion;
		this.promociones = promociones;
		this.montoPromo = montoPromo;
	}
	
	
	@Override 
	public String getNombre() {
		//ArrayList<String> nombresPromo = new ArrayList<>();
		
		String nombresPromos = "";
		
		for(Atraccion cadaAtraccion : promociones ) {
			//nombresPromo.add(cadaAtraccion.getNombre());
			nombresPromos += cadaAtraccion.getNombre() ;
		}
		
		return nombresPromos ;
	}
	

	@Override 
	public double getCosto() {
		double valor = 0;
		for(Atraccion cadaAtraccion : getPromociones()) {
			valor += cadaAtraccion.getCosto();
		}		
		return valor;
	}
	
	
	
	@Override 
	public double getDuracion() {
		double duracionTotal = 0;
		for(Atraccion cadaAtraccion : getPromociones()) {
			duracionTotal += cadaAtraccion.getDuracion();
		}		
		return duracionTotal;
	}
	
	
	@Override 
	public int getCupo() {
		ArrayList<Integer> cuposPromo = new ArrayList<>();
		
		for(Atraccion cadaAtraccion : promociones ) {
			//duracionAtraccionesTotal += cadaAtraccion.getDuracion();
			cuposPromo.add(cadaAtraccion.getCupo());
		}
		
		cupoMinimoTotal = Collections.min(cuposPromo);
		
		return cupoMinimoTotal;
	}
	
	public double getCostoAtracciones() {
		double costoAtraccionesTotal = 0;
		
		for(Atraccion cadaAtraccion : promociones ) {
			costoAtraccionesTotal += cadaAtraccion.getCosto();
		}
		
		return costoAtraccionesTotal;
	}
	

	public double getDescuento() {
		return montoPromo;
	}

	
	
	public synchronized void setCupo() {
	
		for(Atraccion cadaAtraccion : promociones ) {
			cadaAtraccion.setCupo();
		}
	}
	




	@Override
	public String formatoConsola() {
		return String.format(" -Atracciones incluidas: [ %s ] \n -Duracion: %s horas \n -Precio original: $%s \n -Precio Con descuento: $%s \n", 
			getNombre(), getDuracion(), getCosto(), getDescuento());

	}


	
	
}
