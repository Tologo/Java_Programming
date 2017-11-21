package Actividad_1_2;

/*
 * Realizar un programa que dado un d�a de la semana (entre 1 y 7) 
 * muestre por pantalla el nombre del d�a.
 */

import java.util.Scanner;

public class Supuesto_02 {
	
	public static void main(String[] args) {
	
	try{
		// Inicializamos las variables que vamos a utilizar
			int dia=0;
			String nombre="";
			
		//Activamos entrada por teclado
			Scanner teclado=new Scanner(System.in);
					
		//Entrada de datos
			System.out.println("Indica un n�mero entre el 1 y el 7...");
			dia=teclado.nextInt();
			
		//Proceso
			switch(dia){
			case 1: nombre="Lunes";break;
			case 2: nombre="Martes";break;
			case 3: nombre="Mi�rcoles";break;
			case 4: nombre="Jueves";break;
			case 5: nombre="Viernes";break;
			case 6: nombre="S�bado";break;
			case 7: nombre="Domingo";break;
			default: nombre="Ninguno. Has introducido un n�mero no v�lido";}
		teclado.close();
		
		//Resultado
			System.out.println("El d�a de la semana relacionado con tu cifra es "+nombre);
	}
	catch (Exception e) {
		System.out.println("ERROR CAPTURADO:"+e.toString());
	}
}
}
