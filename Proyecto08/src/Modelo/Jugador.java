package Modelo;

public class Jugador {
	
	// Definimos los atributos/variables de la clase Jugador
	
		private String nombre; 		//Definir� el nombre del jugador 
		private String apellidos; 	//Definir� los apellidos del jugador
		private String nick; 		//Definir� el nick empleado por el jugador
		private int edad; 			//Definir� la edad del jugador [1-99]
		private int puntuacion; 	//Definir� la puntuaci�n acumulada del jugador
	
	//M�todos Getters y Setters de los atributos de la clase
		
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
		
		// Condicionamos la edad a valores entre 1 y 99. Si la edad es menor que 1 mostrar� 1
		// Si la edad es mayor a 99 mostrar� 99. En el resto de casos mostrar� la edad introducida.
		
		public void setEdad(int edadJugador){
			if(edad<1){
				edad=1;
			}else if(edad>99){
				edad=99;
			}
			edad=edadJugador;
		}
		
		public int getPuntuacion() {
			return puntuacion;
		}
		public void setPuntuacion(int puntuacionJugador) {
			puntuacion=puntuacionJugador;
		}
		
	
		// Constructor. Punto de entrada que se ejecuta al crear un objeto de tipo Jugador
		
		public Jugador() {
		}
				
		// M�todo para comprobar los campos vac�os. Si hay caracteres que no son espacios en blanco
		// Devuelve 'False', en caso contrario devuelve 'True'
		
		public boolean sonEspacios(String cad)
		{
			for(int i=0; i<cad.length(); i++) 
			if(cad.charAt(i) != ' ') 
			return false;

			return true;
		}
		
		// M�todo para comprobar que una cadena introducida sea un n�mero
		
		public boolean isNumeric(String cadena){
			try{
				Integer.parseInt(cadena);
				return true;
			} catch (NumberFormatException nfe){
				return false;
			}
			}
		
// Final de la clase Jugador		
}
