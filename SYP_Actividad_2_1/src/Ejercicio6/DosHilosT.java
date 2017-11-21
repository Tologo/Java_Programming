package Ejercicio6;

class DosHilosT extends Thread {

	// 1º Indicamos en el constructor que se le pasa un parámetro
		public DosHilosT(String str) {
			super(str);

		}

	// 2º Desarrollamos las acciones a realizar por los hilos en el método run()
		public void run() {
			try {
			      for(int i = 10; i > 0; i--) { // Establecemos los ciclos que queremos realizar
			    	// Muestra por pantalla el mensaje con el nombre del hilo y el nº de ciclo.
			        System.out.println("bienvenido, soy el " + getName() + " y estoy en la iteración " + i);
			        Thread.sleep(1000); // Realiza una espera antes del ciclo siguiente
			      }
			    } catch (InterruptedException e) {
			      	System.out.println("Interrupción del " +getName());
			    }
			    
			    System.out.println("Finaliza el " + getName()); // Indicamos que ha finalizado la ejecución del hilo
			
			    // El try/catch lo incluimos para controlar las posibles excepciones
		}


	// 3º En la clase main designamos los objetos que vamos a crear y los iniciamos (lanzando start())

	  public static void main(String args[]) {
			  	new DosHilosT("Hilo 1").start();
			    new DosHilosT("Hilo 2").start();
			
			    try {
			      Thread.sleep(11000); // Establecemos una espera en el hilo principal (superior a la empleada por
			      // el run() de los hilos creados) antes de mostrar el mensaje final
			    } catch (InterruptedException e) {
			      System.out.println("Interrupción del hilo principal");
		    	}
		    	System.out.println("Main terminado.");
		  }
	
}