

public class Actividad_2_2 extends Thread {
	
	// 1º Indicamos en el constructor que se le pasa un parámetro
			public Actividad_2_2 (String str) {
				super(str);

			}

		
	// 3º Desarrollamos las acciones a realizar por los hilos en el método run()
			public void run() {
				
				    System.out.println(getName()+ " Inicia la carrera");
				    
				    System.out.println(getName()+ " con prioridad "+getPriority()+" Acaba la carrera"); // Indicamos que ha finalizado la ejecución del hilo
				
			}

		}

		// 3º En la clase main designamos los objetos que vamos a crear y los iniciamos (lanzando start())
		
			class Hilos {
				  public static void main(String args[]) {
					  
				// Creamos 3 objetos de la clase animal
					  
					  Animal tortuga = new Animal ("tortuga");
					  Animal liebre = new Animal ("liebre");
					  Animal guepardo = new Animal ("guepardo");
				
				// Y a continuación los hilos asignados a cada una de ellos
					  
					  Actividad_2_2 a1 = new Actividad_2_2(tortuga.getNombre());
					  Actividad_2_2 a2 = new Actividad_2_2(liebre.getNombre());
					  Actividad_2_2 a3 = new Actividad_2_2(guepardo.getNombre());
					    
				// Establecemos las prioridades
					    
					  a1.setPriority(Thread.MIN_PRIORITY);
					  a2.setPriority(Thread.NORM_PRIORITY);
					  a3.setPriority(Thread.MAX_PRIORITY);
					  
				// Iniciamos los hilos
					  a1.start();
					  a2.start();
					  a3.start();
				
				// Establecemos una espera en el hilo principal (superior a la empleada por el run() de los hilos creados) antes de mostrar el mensaje final
					    try {
					      Thread.sleep(3000); 
					    } catch (InterruptedException e) {
					      System.out.println("Interrupción del hilo principal");
				    	}
				    	System.out.println("Main terminado.");
				  }
			}
			



