package Principal;

import Ventanas.Registro;
import Ventanas.Juego;

public class Principal {

	// La entrada a nuestro programa (main)
	
	public static void main(String[] args) {
		
		//Ventanas a emplear por la aplicación
		
		Juego vJuego = new Juego();
		
		Registro vRegistro= new Registro(vJuego);
		
		//Al añadir aquí el parámetro vJuego (la ventana de juego), indicamos que desde vRegistro
		//(ventana de Registro)tenemos una referencia a la ventana de Juego (vJuego),
		// para que vRegistro pueda lanzar la vJuego
		
		vRegistro.setVisible(true);

	}

	//Constructor
	
		public Principal() {	
	}
	
	// Final de la clase principal
}