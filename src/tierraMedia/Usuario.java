package tierraMedia;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombreUsuario;
	private double presupuesto;
	private double horasDisponibles;
	private double gastoTotal;
	private double horasConsumidas;
	private List<String> atraccionesNombres;
	private List<Ofertable> itinerario;

	public Usuario(String nombre, double presupuesto, int horasDisponibles) {
		this.nombreUsuario = nombre;
		this.presupuesto = presupuesto;
		this.horasDisponibles = horasDisponibles;
		itinerario = new ArrayList<>();
		atraccionesNombres = new ArrayList<>();
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getHorasDisponibles() {
		return horasDisponibles;
	}

	public void setHorasDisponibles(int horasDisponibles) {
		this.horasDisponibles = horasDisponibles;
	}

	public String getNombre() {
		return nombreUsuario;
	}

	public void setItinerario(Ofertable cadaOferta) {
		itinerario.add(cadaOferta);
	}

	public List<String> getNombreAtraccionesCompradas() {
		return atraccionesNombres;
	}

	public void comprar(Ofertable cadaOferta) {
		atraccionesNombres.add(cadaOferta.getNombre());
		gastoTotal += (cadaOferta.soyPromocion()) ? cadaOferta.getDescuento() : cadaOferta.getPrecioOriginal();
		this.presupuesto -= (cadaOferta.soyPromocion()) ? cadaOferta.getDescuento() : cadaOferta.getPrecioOriginal();
		horasConsumidas += cadaOferta.getDuracion();
		this.horasDisponibles -= cadaOferta.getDuracion();
		cadaOferta.setCupo();
	}

	public String formatoItinerario() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.format(" -Atracciones compradas: %s \n -Duración Total: %s horas \n ==========>> TOTAL: $%s \n ",
				atraccionesNombres, horasConsumidas, df.format(gastoTotal));
	}

	@Override
	public String toString() {
		return "Nombre= " + nombreUsuario + ", Dinero= " + presupuesto + ", Horas Disponibles= " + horasDisponibles
				+ "\n";
	}
}
