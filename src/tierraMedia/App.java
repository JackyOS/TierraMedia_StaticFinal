package tierraMedia;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		TierraMedia p = new TierraMedia();

		p.agregarListaPersonas("datos/Usuario");
		p.agregarListaAtracciones("datos/Atraccion");
		p.agregarListaPromociones("datos/Promocion");
		ArrayList<String> gratuitas = new ArrayList<String>();
		gratuitas.add("Erebor");
		
		

		// System.out.println(p.getAtracciones());

		// System.out.println(p.getPromociones());

		p.hacerSugerencia();

	}

}
