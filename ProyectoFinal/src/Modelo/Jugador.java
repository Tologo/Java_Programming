package Modelo;

public class Jugador {
	
	// Definimos los atributos/variables de la clase Jugador
	
		private String nombre; 		// Nombre del jugador 
		private String apellidos; 	// Apellidos del jugador
		private String nick; 		// Nick empleado por el jugador
		private int edad; 			// Edad del jugador [1-99]
		private int puntuacion; 	// Puntuaci�n acumulada del jugador
		private int id;				// Identificador �nico para el jugador
	
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
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
	
		// El siguiente m�todo permite mostrar todos los campos de usuario
		// Sobreescribimos el m�todo toString que se hereda autom�ticamente por se un objeto de java
		//Es un m�todo que "transforma" un objeto en una cadena
				public String toString(){
					return this.id+" - "+this.nombre+" "+this.apellidos+" "+this.nick+" "+this.edad;
				}
		
// Final de la clase Jugador		
}
