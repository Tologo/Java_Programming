package ejercicio5;

class EjemploHilosT extends Thread {

// 1� Indicamos en el constructor que se le pasa un par�metro
			public EjemploHilosT(String str) {
				super(str);

			}


// 2� Desarrollamos las acciones a realizar por los hilos en el m�todo run()
	public void run() {
		try {
		      for(int i = 5; i > 0; i--) { // Establecemos los ciclos que queremos realizar
		        System.out.println(i + ": " + getName()); // Muestra por pantalla el n� de ciclo y el nombre del hilo
		        Thread.sleep(1000); // Realiza una espera antes del ciclo siguiente
		      }
		    } catch (InterruptedException e) {
		      	System.out.println("Interrupci�n del hilo " + getName());
		    }
		
		    // El try/catch lo incluimos para controlar las posibles excepciones
	}


// 3� En la clase main designamos los objetos que vamos a crear y los iniciamos (lanzando start())

	  public static void main(String args[]) {
		    new EjemploHilosT("Hola").start();
		    new EjemploHilosT("Adi�s").start();
	  }
}
