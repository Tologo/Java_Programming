package Ejercicio02;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables que utilizamos
		String Colegio="", Nivel="";
				
		//Activamos entrada por teclado
		Scanner teclado=new Scanner(System.in);
				
		//Entrada de datos
		System.out.println("Introduce tu colegio de procedencia (Nacional/Particular)");
		Colegio=teclado.next();
		System.out.println("Introduce tu nivel socioeconómico (A, B o C)");
		Nivel=teclado.next();		
				
		//Proceso condicional y salida de datos
		System.out.println("Para tu colegio de procedencia y nivel socioeconómico...");
		if (Colegio.contains("Nacional") && Nivel.contains("A")) { System.out.println("El importe a pagar son 300€");
		} else if (Colegio.contains("Nacional") && Nivel.contains("B")) { System.out.println("El importe a pagar son 200€");
		} else if (Colegio.contains("Nacional") && Nivel.contains("C")) { System.out.println("El importe a pagar son 100€");
		} else if (Colegio.contains("Particular") && Nivel.contains("A")) { System.out.println("El importe a pagar son 400€");
		} else if (Colegio.contains("Particular") && Nivel.contains("B")) { System.out.println("El importe a pagar son 300€");
		} else if (Colegio.contains("Particular") && Nivel.contains("C")) { System.out.println("El importe a pagar son 200€"); 
		
		teclado.close();
	}
	}

}
