package Juego;

public class Jugador {
	
	//Propiedades
		private String nombre; //Definirá el nombre del jugador 
		private String apellidos; //Definirá los apellidos del jugador
		private String nick; //Definirá el nick empleado por el jugador
		private int edad; //Definirá la edad del jugador [1-99]
		private int nivel; //Definirá el nivel alcanzado por el jugador
		private int puntuacion; //Definirá la puntuación acumulada del jugador
		private int tiempo; //Indicará el tiempo de juego acumulado.
		private int id; //Definirá el indentificador del jugador
	
	//Métodos
		
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
				edad=0; //Si la edad es menor que 1 mostrará 1
			}else if(edad>99){
				edad=99; //Si la edad es mayor a 99 mostrará 99
			}
			edad=edadJugador; //En el resto de casos mostrará la edad introducida.
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
	//Método para comprobar los campos vacíos
	public boolean sonEspacios(String cad)
	{
		for(int i =0; i<cad.length(); i++)
		if(cad.charAt(i) != ' ')
		return false;
		
		return true;
	}
	//Método para comprobar que una cadena introducida es un número
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
