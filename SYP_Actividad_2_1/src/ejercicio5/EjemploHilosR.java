package ejercicio5;

class EjemploHilosR implements Runnable {

// 1º Presentamos las variables que vamos a utilizar, una para el nombre de los hilos y otra para los propios hilos
	String name;
	Thread t;
	
// 2º Desarrollamos la clase EjemploHilos, donde tomamos un nombre (por parámetro), creamos el hilo y lo iniciamos
	EjemploHilosR(String threadname) {
	    name = threadname;
	    t = new Thread(this, name);
	    t.start(); // Con start() invocamos al método run()

	}

// 3º Desarrollamos las acciones a realizar por los hilos en el método run()
	public void run() {
		try {
		      for(int i = 5; i > 0; i--) { // Establecemos los ciclos que queremos realizar
		        System.out.println(i + ": " + name); // Muestra por pantalla el nº de ciclo y el nombre del hilo
		        Thread.sleep(1000); // Realiza una espera antes del ciclo siguiente
		      }
		    } catch (InterruptedException e) {
		      	System.out.println(name + "Interrupción del hilo" +name);
		    }
		
		    // El try/catch lo incluimos para controlar las posibles excepciones
	}

}

// 4º En la clase main designamos los objetos que vamos a crear (éstos se inician en su constructor)

class MultiThreadDemo {
	  public static void main(String args[]) {
		    new EjemploHilosR("Hola");
		    new EjemploHilosR("Adiós");
	  }
}
