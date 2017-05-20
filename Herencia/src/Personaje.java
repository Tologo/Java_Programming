
public class Personaje {
	//Definición de las propiedades
	private int vida=100;
	private int nivel=1;
	private String armaActual="";
	
	//Constructor
	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	//Establecemos un método para quitar vidas
	public void quitarVida(){
		this.vida = this.vida-1;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getArmaActual() {
		return armaActual;
	}

	public void setArmaActual(String armaActual) {
		this.armaActual = armaActual;
	}

}
