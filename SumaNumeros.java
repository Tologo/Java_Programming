import java.util.Scanner;

public class SumaNumeros {
	
	//Vamos a pedir un n�mero y queremos que se realice la suma de todos los valores inferiores o iguales a �l

	public static void main(String[] args) {
		
		Scanner teclado= new Scanner(System.in);
	
		//Variables
		int i,numero,suma; //i es una varible contadora, controlar� hasta cuando se realiza la repetici�n.
		
		suma=0;	//Inicializamos las variables (se puede hacer directamente al declararlas arriba)
				
		//Entrada de datos
		System.out.println("Dame un n�mero");
		numero=teclado.nextInt();
		
		//Proceso utilizando el bucle While para estructuras repetitivas.
		i=1; //Inicializamos i, se pod�a hacer antes, pero queda m�s claro aqu� al relacionarlo con el while
		
		while(i<=numero){
			suma=suma+i;
			i=i+1;
		//Estos 2 c�lculos se ejecutar�n mientras i sea menor o igual al numero. Despu�s pasar� a la siguiente orden
		}
		//Salidad de datos
		System.out.println("La suma total es: "+suma);
		
	}

}
