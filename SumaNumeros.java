import java.util.Scanner;

public class SumaNumeros {
	
	//Vamos a pedir un número y queremos que se realice la suma de todos los valores inferiores o iguales a él

	public static void main(String[] args) {
		
		Scanner teclado= new Scanner(System.in);
	
		//Variables
		int i,numero,suma; //i es una varible contadora, controlará hasta cuando se realiza la repetición.
		
		suma=0;	//Inicializamos las variables (se puede hacer directamente al declararlas arriba)
				
		//Entrada de datos
		System.out.println("Dame un número");
		numero=teclado.nextInt();
		
		//Proceso utilizando el bucle While para estructuras repetitivas.
		i=1; //Inicializamos i, se podía hacer antes, pero queda más claro aquí al relacionarlo con el while
		
		while(i<=numero){
			suma=suma+i;
			i=i+1;
		//Estos 2 cálculos se ejecutarán mientras i sea menor o igual al numero. Después pasará a la siguiente orden
		}
		//Salidad de datos
		System.out.println("La suma total es: "+suma);
		
	}

}
