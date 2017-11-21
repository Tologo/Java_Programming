package Ejercicio6;

class DosHilosR implements Runnable {

	// 1� Presentamos las variables que vamos a utilizar, una para el nombre de los hilos y otra para los propios hilos
		String name;
		Thread t;
		
	// 2� Desarrollamos la clase EjemploHilos, donde tomamos un nombre (por par�metro), creamos el hilo y lo iniciamos
		DosHilosR (String threadname) {
		    name = threadname;
		    t = new Thread(this, name);
		    t.start(); // Con start() invocamos al m�todo run()

		}

	// 3� Desarrollamos las acciones a realizar por los hilos en el m�todo run()
		public void run() {
			try {
			      for(int i = 10; i > 0; i--) { // Establecemos los ciclos que queremos realizar
			    	// Muestra por pantalla el mensaje con el nombre del hilo y el n� de ciclo.
			        System.out.println("bienvenido, soy el " + name + " y estoy en la iteraci�n " + i);
			        Thread.sleep(1000); // Realiza una espera antes del ciclo siguiente
			      }
			    } catch (InterruptedException e) {
			      	System.out.println(name + "Interrupci�n del hilo" +name);
			    }
			    
			    System.out.println("Finaliza el " + name); // Indicamos que ha finalizado la ejecuci�n del hilo
			
			    // El try/catch lo incluimos para controlar las posibles excepciones
		}

	}

	// 4� En la clase main designamos los objetos que vamos a crear (�stos se inician en su constructor)

	class MultiThreadDemo {
		  public static void main(String args[]) {
			    new DosHilosR("Hilo 1");
			    new DosHilosR("Hilo 2");
			
			    try {
			      Thread.sleep(11000); // Establecemos una espera en el hilo principal (superior a la empleada por
			      // el run() de los hilos creados) antes de mostrar el mensaje final
			    } catch (InterruptedException e) {
			      System.out.println("Interrupci�n del hilo principal");
		    	}
		    	System.out.println("Main terminado.");
		  }
	}
