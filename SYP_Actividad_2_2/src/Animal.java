
public class Animal {
	
	// Definimos una única variable
	
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
	
	
	
	// Método print: Muestra la información del animal
	
	public void print() {
		System.out.println("Nombre: " + nombre);
	}
	

}
