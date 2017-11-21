package Actividad_1_2;

/*
 * Dados tres números realiza la multiplicación de los otros dos si el primer número es positivo
 * y la suma si dicho número es negativo
 */

import java.util.Scanner;

public class Supuesto_01 {
	
	public static void main(String[] args) {
	
		try{
			// Inicializamos las variables que vamos a utilizar
						int N1=0, N2=0, N3=0;
						int resultado=0;
						
					//Activamos entrada por teclado
						Scanner teclado=new Scanner(System.in);
								
					//Entrada de datos
						System.out.println("Indica el valor del primer número...");
						N1=teclado.nextInt();
						System.out.println("Indica el valor del segundo número...");
						N2=teclado.nextInt();
						System.out.println("Indica el valor del tercer número...");
						N3=teclado.nextInt();
						
					//Proceso
						if (N1>=0){
							 resultado=N2*N3;
							 }
						else resultado=N2+N3;
					
						teclado.close();
						
					//Resultado
						System.out.println("El resultado es "+resultado);
		}
		catch (Exception e) {
			System.out.println("ERROR CAPTURADO:"+e.toString());

	}
}
}
