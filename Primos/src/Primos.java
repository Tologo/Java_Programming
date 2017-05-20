import java.util.Scanner;

public class Primos {

	public Primos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		
		int numero,i=1,total=0;
		
		System.out.println("Dame un numero");
		numero=teclado.nextInt();
		
		for (i=1;i<=numero;i++){
			if(numero%i==0){
				total+=i;
			}
		}
		
		if(total==numero+1){
			System.out.println("El numero es primo");
		}else{
			System.out.println("El numero no es primo");
		}
	}

}
