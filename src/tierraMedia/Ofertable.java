package tierraMedia;

public interface Ofertable {
	public String getNombre();
	
	public double getDescuento();
	
	public boolean soyPromocion();
	
	public boolean estaIncluidaLaAtraccion();
	
	public double getPrecio();
	
	public double getDuracion();
	
	public String formatoConsola();
	
	public boolean hayCupo();
	
	public void restarCupo();
}
