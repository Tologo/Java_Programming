package Ejercicio03;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables que utilizamos
		int D1,D2,D3;
						
		//Activamos entrada por teclado
		Scanner teclado=new Scanner(System.in);
				
		//Entrada de datos
		System.out.println("Lanza el primer dado y apunta el resultado...");
		D1=teclado.nextInt();
		System.out.println("Lanza el segundo dado y apunta el resultado...");
		D2=teclado.nextInt();
		System.out.println("Lanza el tercer dado y apunta el resultado...");
		D3=teclado.nextInt();
				
		//Proceso condicional y salida de datos
		System.out.println("Con tus lanzamientos tu premio es...");
		if ((D1^D2^D3)==6) { System.out.println("Medalla de Oro!");
		} else if (D1==6 && D2==6 && D3!=6) { System.out.println("Medalla de Plata!");
		} else if (D1==6 && D3==6 && D2!=6) { System.out.println("Medalla de Plata!");
		} else if (D2==6 && D3==6 && D1!=6) { System.out.println("Medalla de Plata!");
		} else if (D1!=6 && D2!=6 && D3==6) { System.out.println("Medalla de Bronce!");
		} else if (D1!=6 && D3!=6 && D2==6) { System.out.println("Medalla de Bronce!");
		} else if (D2!=6 && D3!=6 && D1==6) { System.out.println("Medalla de Bronce!");
		} else if ((D1^D2^D3)!=6) { System.out.println("Ninguno! Eres un loser!");
		teclado.close();
	}}

}
