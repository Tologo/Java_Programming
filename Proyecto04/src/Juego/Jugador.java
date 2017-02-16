package Juego;

public class Jugador {
	
	//Propiedades
		private String nombre; //Definir� el nombre del jugador 
		private String apellidos; //Definir� los apellidos del jugador
		private String nick; //Definir� el nick empleado por el jugador
		private int edad; //Definir� la edad del jugador [1-99]
		private int nivel; //Definir� el nivel alcanzado por el jugador
		private int puntuacion; //Definir� la puntuaci�n acumulada del jugador
		private int tiempo; //Indicar� el tiempo de juego acumulado.
		private int id; //Definir� el indentificador del jugador
	
	//M�todos
		
		public String getNombre(){
			return nombre;
		}
		public void setNombre(String nombre){
			this.nombre=nombre;
		}
		public String getApellidos(){
			return apellidos;
		}
		public void setApellidos(String apellidos){
			this.apellidos=apellidos;
		}
		public String getNick(){
			return nick;
		}
		public void setNick(String nick){
			this.nick=nick;
		}
		public int getEdad(){
			return edad;
		}
		public void setEdad(int edadJugador){ //Condicionamos la edad entre 1 y 99.
			if(edad<1){
				edad=0; //Si la edad es menor que 1 mostrar� 1
			}else if(edad>99){
				edad=99; //Si la edad es mayor a 99 mostrar� 99
			}
			edad=edadJugador; //En el resto de casos mostrar� la edad introducida.
		}
		public int getNivel() {
			return nivel;
		}
		public void setNivel(int nivelJugador) {
			nivel=nivelJugador;
		}
		public int getPuntuacion() {
			return puntuacion;
		}
		public void setPuntuacion(int puntuacionJugador) {
			puntuacion=puntuacionJugador;
		}
		public int getTiempo() {
			return tiempo;
		}		
		public void setTiempo(int tiempoJugador) {
			tiempo=tiempoJugador;
		}
		public int getId() {
			return id;
		}		
		public void setId(int idJugador) {
			id=idJugador;
		}
	//M�todo para comprobar los campos vac�os
	public boolean sonEspacios(String cad)
	{
		for(int i =0; i<cad.length(); i++)
		if(cad.charAt(i) != ' ')
		return false;
		
		return true;
	}
	//M�todo para comprobar que una cadena introducida es un n�mero
	public boolean isNumeric(String cadena){
		try{
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
	}
	}
		
		
	//Constructor
	//Punto de entrada que se ejecuta al crear un objeto de tipo Jugador
		
		public Jugador() {
			System.out.println("Creo un objeto de tipo Jugador");
		}	
}
