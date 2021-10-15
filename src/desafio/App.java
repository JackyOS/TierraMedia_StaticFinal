package desafio;

public class App {
	
	
	public static void main(String[] args) {
				
		TierraMedia p = new TierraMedia();
		
		p.agregarListaPersonas("datos/Usuario");
		p.agregarListaAtracciones("datos/Atraccion");
		p.agregarListaPromociones("datos/Promocion");
	
		System.out.println("\t Bienvenidos a Tierra Media");
		
		
		//System.out.println(p.getAtracciones());
		System.out.println(p.getPromociones());
		//p.hacerSugerencia();
		
		;
	}

}
