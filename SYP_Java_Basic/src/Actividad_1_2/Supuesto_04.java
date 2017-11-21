package Actividad_1_2;
/*
 * Definir un vector de 10 enteros, lo rellenamos y después
 * nos muestra por pantalla los valores de dicho vector
 */

public class Supuesto_04 {
	
	public static void main(String[] args) {
		
		try{
	
		// Inicializamos las variables que vamos a utilizar.
		// Primero declaramos el Array. 
			int[] numeros;
			
		// y a continuación lo creamos en nuestro caso con 10 enteros y lo rellenamos.
			numeros = new int[10];
			
			numeros[0]=10;
			numeros[1]=9;
			numeros[2]=8;
			numeros[3]=7;
			numeros[4]=6;
			numeros[5]=5;
			numeros[6]=4;
			numeros[7]=3;
			numeros[8]=2;
			numeros[9]=1;
			
		// Proceso: Muestra por pantalla los datos del Array recorriéndolo mediante un 'for'
			System.out.println("Estos son los elementos del Array");
			for(int i=0; i<numeros.length; i++){ System.out.println(numeros[i]); }
		}
		catch (Exception e) {
			System.out.println("ERROR CAPTURADO:"+e.toString());
	}
}
}
