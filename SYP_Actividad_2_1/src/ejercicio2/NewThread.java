package ejercicio2;

class NewThread implements Runnable {
	String name; // Creamos una variable String para nombrar a los hilos que creemos a continuaci�n
	Thread t;
	  
	NewThread(String threadname) {
	    name = threadname;
	    t = new Thread(this, name);
	    System.out.println("Nuevo hilo: " + t);
	    t.start(); // En estas l�neas hemos definido la clase NewThread.
	    // Con su par�metro 'name', la creaci�n del Thread (obligatorio al implementar de la clase Runnable
	    // Una salida por pantalla de un texto (Nuevo hilo) m�s el hilo creado
	    // Y el inicio del hilo
	    
	}
	// Hasta aqu� hemos definido la clase NewThread y sus variables.
	  
	public void run() { 
	    try {
	      for(int i = 5; i > 0; i--) {
	        System.out.println(name + ": " + i); // Imprimimos el nombre del hilo seguido de la iteraci�n definida en el 'for' anterior
	        Thread.sleep(1000);
	      }
	    } catch (InterruptedException e) {
	      	System.out.println(name + "Interrupci�n del hilo hijo" +name);
	    }
	    
	    System.out.println("Sale del hilo hijo " + name);
	}
}
	
class MultiThreadDemo {
	  public static void main(String args[]) {
		    new NewThread("Uno"); // Crea un objeto de la clase NewThread definida al inicio del c�digo indicando su par�metro de entrada
		    new NewThread("Dos");
		    new NewThread("Tres");
		    try {
	      		// Hasta aqu� se han creado los 3 hilos y se han ejecutado conforme lo indicado en el m�todo run(), ya que la misma clase NewThread los inicia con start().
		      Thread.sleep(10000);
		    } catch (InterruptedException e) { // Se establece un control de excepciones por si se interrumpe el proceso general antes de indicar que se sale del hilo principal.
		      System.out.println("Interrupci�n del hilo principal");
	    	}
	    	System.out.println("Sale del hilo principal.");
	  }
}
