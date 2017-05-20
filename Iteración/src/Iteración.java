import java.util.Scanner;

public class Iteración {

	public Iteración() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado=new Scanner(System.in);
		
		int numero,digito=0,cubo=0,compara;
		
		System.out.println("dame un número");
		numero=teclado.nextInt();
		compara=numero;
		
		while (numero>0){
			digito=(numero%10)*(numero%10)*(numero%10);
			cubo=cubo+digito;
			numero=numero/10;
		}
		
		if (cubo == compara){
			System.out.println("El numero es perfecto");
		}else System.out.println("El numero no es perfecto");
		
		
		
		
	}

}
