package ejercicio2;

class NewThread implements Runnable {
	String name; // Creamos una variable String para nombrar a los hilos que creemos a continuación
	Thread t;
	  
	NewThread(String threadname) {
	    name = threadname;
	    t = new Thread(this, name);
	    System.out.println("Nuevo hilo: " + t);
	    t.start(); // En estas líneas hemos definido la clase NewThread.
	    // Con su parámetro 'name', la creación del Thread (obligatorio al implementar de la clase Runnable
	    // Una salida por pantalla de un texto (Nuevo hilo) más el hilo creado
	    // Y el inicio del hilo
	    
	}
	// Hasta aquí hemos definido la clase NewThread y sus variables.
	  
	public void run() { 
	    try {
	      for(int i = 5; i > 0; i--) {
	        System.out.println(name + ": " + i); // Imprimimos el nombre del hilo seguido de la iteración definida en el 'for' anterior
	        Thread.sleep(1000);
	      }
	    } catch (InterruptedException e) {
	      	System.out.println(name + "Interrupción del hilo hijo" +name);
	    }
	    
	    System.out.println("Sale del hilo hijo " + name);
	}
}
	
class MultiThreadDemo {
	  public static void main(String args[]) {
		    new NewThread("Uno"); // Crea un objeto de la clase NewThread definida al inicio del código indicando su parámetro de entrada
		    new NewThread("Dos");
		    new NewThread("Tres");
		    try {
	      		// Hasta aquí se han creado los 3 hilos y se han ejecutado conforme lo indicado en el método run(), ya que la misma clase NewThread los inicia con start().
		      Thread.sleep(10000);
		    } catch (InterruptedException e) { // Se establece un control de excepciones por si se interrumpe el proceso general antes de indicar que se sale del hilo principal.
		      System.out.println("Interrupción del hilo principal");
	    	}
	    	System.out.println("Sale del hilo principal.");
	  }
}
