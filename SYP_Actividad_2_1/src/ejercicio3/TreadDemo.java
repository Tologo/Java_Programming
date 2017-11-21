package ejercicio3;

class ThreadDemo implements Runnable  {
	ThreadDemo()  {
		Thread ct = Thread.currentThread(); // currentThread() devuelve el objeto Thread que representa al hilo
		// de ejecuci�n que se est� ejecutando actualmente, es decir, el hilo principal
		
		Thread t = new Thread(this);
		t.setName("demo Thread"); // Se crea un Thread con nombre 'demo Thread' a partir del hilo principal
		System.out.println("hilo actual: " + ct);
		System.out.println("Hilo creado: " + t);
		t.start();
		try  {
			Thread.sleep(3000);
		}  catch (InterruptedException e)  {
		   	System.out.println("Interrumpido");
		}
		System.out.println("saliendo del hilo main");
    }
	
    public void run()  {
	try  {
		for (int i = 5; i > 0; i--)  { // Iniciamos un contador recursivo del 5 al 1 el cual recorrer� la salida por pantalla indicada a continuaci�n.
			System.out.println(Thread.currentThread().getName()+" " + i);
			Thread.sleep(1000);
	 	}
	}  catch (InterruptedException e)  {
		System.out.println("hijo interrumpido");
	}
	System.out.println("saliendo del hilo hijo");
    }
    	
    	
    public static void main (String args [])  { // El m�todo main crea dos objetos, un ThreadDemo y un Thread
    	 // que tiene como par�metro al objeto anterior
    	ThreadDemo hilo = new ThreadDemo();
    	Thread h = new Thread(hilo);
    	
    }
}

/*
 * Al ejecutar el programa el main hace que se creen 2 hilos, donde el 
 * segundo pasa como par�metro a l primero.
 * Volvemos al inicio del c�digo para realizar el ThreadDemo(), y vemos 
 * como se define un hilo principal (que representa la ejecuci�n en curso)
 * y otro hilo creado a partir de �l (tal y como se especifica en el main())
 * Se muestra un mensaje para cada hilo y se inicia el �secundario�.
 * Al mismo tiempo se inicia una espera en el hilo principal antes de indicar
 * que se sale de �l.
 * El desarrollo del hilo secundario realiza una iteraci�n recursiva con
 * espera de 1 segundo entre mensajes antes de finalizar.
 * La salida del programa ser�: La presentaci�n de los hilos creados, el
 * inicio del hilo secundario y la salida de ambos hilos, donde el principal
 * finalizar� antes de terminar las iteraciones del secundario.
 */

