
public class Jugador extends Personaje{ //Establecemos que Jugador mantiene las propiedad de Personaje adem�s de las propias que podamos incorporar

	private int puntos=0;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	//Creamos un nuevo m�todo para ganar puntor
	public void addPuntos(){
		this.puntos = this.puntos+1;
	}
}
