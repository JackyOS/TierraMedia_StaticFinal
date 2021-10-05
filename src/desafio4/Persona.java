package desafio4;

public class Persona {
	
	Atraccion atraccion;
	
	private String nombre;
	private int dinero;
	private int horasDisponibles;
	//itinerario
	
	
	public Persona(String nombre, int dinero, int horasDisponibles) {
		this.nombre = nombre;
		this.dinero = dinero;
		this.horasDisponibles = horasDisponibles;
	}

	public int getDinero() {
		return dinero;
	}


	public void setDinero(int dinero) {
		this.dinero = dinero;
	}


	public int getHorasDisponibles() {
		return horasDisponibles;
	}


	public void setHorasDisponibles(int horasDisponibles) {
		this.horasDisponibles = horasDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	
	
	
	

	@Override
	public String toString() {
		return "Nombre= " + nombre + ", Dinero= " + dinero + ", Horas Disponibles= " + horasDisponibles + "\n";
	}
	
	
	
	

}
