
public class Principal {

	public static void main(String[] args) {
	
// Generamos un nuevo jugador
		Jugador player1=new Jugador();
		
		player1.setPuntos(10);
		player1.setArmaActual("Espada");
	
// Generamos un nuevo Monstruo
		Monstruo ogro=new Monstruo();
		
		ogro.setTipoAtaque("Hachazo");
		ogro.setVida(5);
	
//Definimos un personaje de forma general
		Personaje personaje=new Personaje();
		personaje.setNivel(3);
		personaje.setVida(100);

//Creamos una ventana
		Ventana1 v1=new Ventana1();
		v1.setVisible(true);
	
	}
}
