package Juego;

public class Jugador {
	
	//Propiedades
		private String nombre; //Definirá el nombre del jugador 
		private String apellidos; //Definirá los apellidos del jugador
		private String nick; //Definirá el nick empleado por el jugador
		private int edad; //Definirá la edad del jugador
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
		public void setEdad(int edadJugador){
			edad=edadJugador;
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
	
	//Constructor
	//Punto de entrada que se ejecuta al crear un objeto de tipo Jugador
		
		public Jugador() {
			System.out.println("Creo un objeto de tipo Jugador");
		}	
}
