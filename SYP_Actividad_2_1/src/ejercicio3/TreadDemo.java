package ejercicio3;

class ThreadDemo implements Runnable  {
	ThreadDemo()  {
		Thread ct = Thread.currentThread(); // currentThread() devuelve el objeto Thread que representa al hilo
		// de ejecución que se está ejecutando actualmente, es decir, el hilo principal
		
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
		for (int i = 5; i > 0; i--)  { // Iniciamos un contador recursivo del 5 al 1 el cual recorrerá la salida por pantalla indicada a continuación.
			System.out.println(Thread.currentThread().getName()+" " + i);
			Thread.sleep(1000);
	 	}
	}  catch (InterruptedException e)  {
		System.out.println("hijo interrumpido");
	}
	System.out.println("saliendo del hilo hijo");
    }
    	
    	
    public static void main (String args [])  { // El método main crea dos objetos, un ThreadDemo y un Thread
    	 // que tiene como parámetro al objeto anterior
    	ThreadDemo hilo = new ThreadDemo();
    	Thread h = new Thread(hilo);
    	
    }
}

/*
 * Al ejecutar el programa el main hace que se creen 2 hilos, donde el 
 * segundo pasa como parámetro a l primero.
 * Volvemos al inicio del código para realizar el ThreadDemo(), y vemos 
 * como se define un hilo principal (que representa la ejecución en curso)
 * y otro hilo creado a partir de él (tal y como se especifica en el main())
 * Se muestra un mensaje para cada hilo y se inicia el ‘secundario’.
 * Al mismo tiempo se inicia una espera en el hilo principal antes de indicar
 * que se sale de él.
 * El desarrollo del hilo secundario realiza una iteración recursiva con
 * espera de 1 segundo entre mensajes antes de finalizar.
 * La salida del programa será: La presentación de los hilos creados, el
 * inicio del hilo secundario y la salida de ambos hilos, donde el principal
 * finalizará antes de terminar las iteraciones del secundario.
 */

