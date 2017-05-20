
public class Monstruo extends Personaje{ //Establecemos que Jugador mantiene las propiedad de Personaje además de las propias que podamos incorporar
	
	private String tipoAtaque="";
	
	public Monstruo() {
		// TODO Auto-generated constructor stub
	}

	public String getTipoAtaque() {
		return tipoAtaque;
	}

	public void setTipoAtaque(String tipoAtaque) {
		this.tipoAtaque = tipoAtaque;
	}

}
