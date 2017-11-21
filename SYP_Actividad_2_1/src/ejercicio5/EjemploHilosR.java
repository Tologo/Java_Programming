package ejercicio5;

class EjemploHilosR implements Runnable {

// 1� Presentamos las variables que vamos a utilizar, una para el nombre de los hilos y otra para los propios hilos
	String name;
	Thread t;
	
// 2� Desarrollamos la clase EjemploHilos, donde tomamos un nombre (por par�metro), creamos el hilo y lo iniciamos
	EjemploHilosR(String threadname) {
	    name = threadname;
	    t = new Thread(this, name);
	    t.start(); // Con start() invocamos al m�todo run()

	}

// 3� Desarrollamos las acciones a realizar por los hilos en el m�todo run()
	public void run() {
		try {
		      for(int i = 5; i > 0; i--) { // Establecemos los ciclos que queremos realizar
		        System.out.println(i + ": " + name); // Muestra por pantalla el n� de ciclo y el nombre del hilo
		        Thread.sleep(1000); // Realiza una espera antes del ciclo siguiente
		      }
		    } catch (InterruptedException e) {
		      	System.out.println(name + "Interrupci�n del hilo" +name);
		    }
		
		    // El try/catch lo incluimos para controlar las posibles excepciones
	}

}

// 4� En la clase main designamos los objetos que vamos a crear (�stos se inician en su constructor)

class MultiThreadDemo {
	  public static void main(String args[]) {
		    new EjemploHilosR("Hola");
		    new EjemploHilosR("Adi�s");
	  }
}
