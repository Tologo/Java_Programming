package ejercicio1;
import java.lang.Math;
public class EjemploThread extends Thread{	 // La clase EjemploThread extiende de la clase Thread, lo que quiere decir que hereda sus propiedades.
	int numero;		
	public void run() {
		try {
			while (true){
				System.out.println(this.getName());
				sleep((long)(10000*Math.random())); // El método run() contiene el bloque de ejecución del hilo
				// getName() devuelve el nombre del hilo. Con sleep definimos un tiempo en milisegundos en los que
				// el hilo en curso será pausado
			}
		} catch (InterruptedException ex) {
			return;
	}				
}
public static void main(String[] args) {
	for (int i=0;i<10;i++) {
		EjemploThread hilos = new EjemploThread(); // Define el objeto ‘hilos’ (de tipo EjemploThread) y lo crea (‘=new Ej…’).
		hilos.start();} // start hace que se cree el hilo 'hilos' y se llama al método run()
	}
}

/*
 * Al ejecutar el programa iniciamos un contador de 0 a 10 (declarado en el 'for') que crea un hilo y lo inicia
 * para mostrar su nombre y realizar una espera definida en el run()
 */
