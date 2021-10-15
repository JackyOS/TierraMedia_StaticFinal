package desafio;

import java.util.List;

public class Usuario {
	/*
	 * para cada usuario el sistema conoce su presupuesto y el tiempo disponible
	 * para la visita.
	 */

	private String nombreUsuario;
	private int presupuestoUsuario;
	private double horasDisponibles;

	List<Atraccion> itinerario;

	public Usuario(String nombre, int dinero, int horasDisponibles) {
		this.nombreUsuario = nombre;
		this.presupuestoUsuario = dinero;
		this.horasDisponibles = horasDisponibles;
	}

	public int getDinero() {
		return presupuestoUsuario;
	}

	public void setDinero(int dinero) {
		this.presupuestoUsuario = dinero;
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

	public void comprar(Atraccion a) {
		this.presupuestoUsuario -= a.getCosto();
		this.horasDisponibles -= a.getDuracion();
		a.setCupo();
	}

	@Override
	public String toString() {
		return "Nombre= " + nombreUsuario + ", Dinero= " + presupuestoUsuario + ", Horas Disponibles= "
				+ horasDisponibles + "\n";
	}
}
