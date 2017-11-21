
public class Animal {
	
	// Definimos una �nica variable
	
	private String nombre = null;
	
	// Establecemos el constructor de la clase
	
	public Animal(){
	}
	
	public Animal(String n) {
		nombre = n;
		
	}
	
	// Definimos getters y Setters
	
	public String getNombre() {
		return nombre;
	}
	

	public void setNombre(String n) {
		nombre = n;
	}
	
	
	
	// M�todo print: Muestra la informaci�n del animal
	
	public void print() {
		System.out.println("Nombre: " + nombre);
	}
	

}
