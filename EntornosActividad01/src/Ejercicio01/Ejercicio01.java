package Ejercicio01;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables que utilizamos
		int nota;
		String F1="Sistemas", F2="Electrónica", F3="Industrial", F4="Administración";
		
		//Activamos entrada por teclado
		Scanner teclado=new Scanner(System.in);
		
		//Entrada de datos
		System.out.println("Introduce tu nota de acceso ");
		nota=teclado.nextInt();
		
		//Proceso condicional y salida de datos
		System.out.println("Para tu nota de acceso...");
		if (nota<80 && nota>69) { System.out.println("Puedes acceder a la facultad de " + F4);
		} else if (nota<90 && nota>79) { System.out.println("Puedes acceder a las facultades de " + F4 + " e " + F3);
		} else if (nota<100 && nota>89) { System.out.println("Puedes acceder a las facultades de " + F4 + ", " + F3 + " y " + F2);
		} else if (nota>=100) { System.out.println("Puedes acceder a las facultades de " + F4 + ", " + F3 + ", " + F2 + " y " + F1);
		} else if (nota<70) { System.out.println("No puedes acceder a ninguna facultad"); 

		teclado.close();
	}

}}
