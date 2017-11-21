package Actividad_1_2;
/*
 * Realizar un programa que muestre por pantalla los numero naturales
 * hasta un valor final introducido por teclado por el usuario, este mismo ejemplo
 * lo usaremos para ver la estructura do-while, y for
 */

import java.util.Scanner;

public class Supuesto_03 {
	
	public static void main(String[] args) {
		
		try{
	
		// Inicializamos las variables que vamos a utilizar
			int valor=0, i=1;
			
		//Activamos entrada por teclado
			Scanner teclado=new Scanner(System.in);
					
		//Entrada de datos
			System.out.println("Indica un valor de referencia...");
			valor=teclado.nextInt();
			
		//Proceso
			do{
				System.out.println(i);
				i++;
			} while (i<valor);
				
				System.out.println(valor);
			
			teclado.close();
		}
		catch (Exception e) {
			System.out.println("ERROR CAPTURADO:"+e.toString());
	}
}
}
