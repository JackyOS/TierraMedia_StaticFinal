package desafio4;

public class App {
	
	
	public static void main(String[] args) {
				
		TierraMedia p = new TierraMedia();
		
		p.agregarListaPersonas("datos/personas.txt");
		p.agregarListaAtracciones("datos/atracciones.txt");
	
		System.out.println("\t Bienvenidos a Tierra Media");
		
		
		//System.out.println(p.getAtracciones());
		
		p.hacerSugerencia();
		
		
	
	}

}
