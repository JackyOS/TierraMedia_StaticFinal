package tierraMedia;

import java.util.List;

public interface Ofertable {
	public String getNombre();
	
	public double getDescuento();
	
	public boolean soyPromocion();
	
	public boolean estaIncluidaLaAtraccion();
	
	public double getPrecioOriginal();
	
	public double getDuracion();
	
	public String formatoConsola();
	
	public boolean hayCupo();
	
	public void setCupo();
}
