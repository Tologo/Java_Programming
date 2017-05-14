package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

import Modelo.Jugador;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Juego extends JPanel {

	// Definimos las variables
	
	// Variable que recoge los datos del jugador indicados en la ventana Registro
	private Jugador gamer;
	
	private JLabel lblBienvenida;
	private JLabel lblPuntuacion;
	
	// Array para guardar las im�genes de los dados
	
	private ImageIcon[] dados3=new ImageIcon[3]; 	// Pueden contener tres valores
	private ImageIcon[] dados6=new ImageIcon[6]; 	// Pueden contener seis valores
	private ImageIcon[] dados12=new ImageIcon[12]; 	// Puede contener doce valores
	private ImageIcon dadogris;
	
	// Variable random de los dados
	
	private Random dado=new Random(); 
	
	// Almacenado de n�meros aleatorios para realizar los c�lculos
	
	private int[] numAlmacenadosDado3=new int[3];
	private int[] numAlmacenadosDado6=new int[2];
	private int numAlmacenadoDado12;
	
	// Etiquetas para incrustar las im�genes de los dados
	
	private JLabel dado1,dado2,dado3;
	private JLabel dado4,dado5;
	private JLabel dado6;
	
	// Los botones
	
	private JButton btnSuma,btnResta,btnCompruebaResultado,btnRepetir;
	
	// Caja de operaciones
	
	private JTextField cajaOperaciones;
	
	// Variables para realizar el control de lo que toca realizar
	
	private boolean tocaNumero=true; // Siempre comenzamos con n�mero por lo que se establece de inicio en true
	private Object operacion=null; // Valor inicial de la operaci�n que vamos a realizar
			
	// Caja de los resultados
	
	private JLabel lblResultado;
	
		
	
	/**
	 * Constructor
	 */
	
	public Juego() {
		
		setLayout(null);
		
		/** Configuraci�n de la antigua ventana y el antiguo panel
		
		setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		setTitle("Ventana de Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 550);
				
		// Configuraci�n del panel
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		
		//Texto de bienvenida del Judador
		
		lblBienvenida = new JLabel("Bienvenid@");
		lblBienvenida.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblBienvenida.setBounds(510, 5, 460, 40);
		add(lblBienvenida);
		
		// Caja de puntuaci�n
		
		lblPuntuacion = new JLabel("Tu puntuaci�n es: 0");
		lblPuntuacion.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblPuntuacion.setBounds(510, 35, 460, 30);
		add(lblPuntuacion);
		
		// Configuramos las etiquetas que contienen a los dados
		
		dado1 = new JLabel ("");
		dado1.setBounds (10, 10, 150, 150);
		dado1.addMouseListener(new ListenerDados());
		add(dado1);

		dado2 = new JLabel ("");
		dado2.setBounds (160, 10, 150, 150);
		dado2.addMouseListener(new ListenerDados());
		add(dado2);

		dado3 = new JLabel ("");
		dado3.setBounds (310, 10, 150, 150);
		dado3.addMouseListener(new ListenerDados());
		add(dado3);

		dado4 = new JLabel ("");
		dado4.setBounds (10, 160, 150, 150);
		dado4.addMouseListener(new ListenerDados());
		add(dado4);

		dado5 = new JLabel ("");
		dado5.setBounds (160, 160, 150, 150);
		dado5.addMouseListener(new ListenerDados());
		add(dado5);

		dado6 = new JLabel ("");
		dado6.setBounds (149, 310, 170, 170);
		add(dado6);

		// Configuramos los Botones de suma y resta
		
		btnSuma = new JButton("+");
		btnSuma.addMouseListener(new listenerSuma());
		btnSuma.setFont(new Font("Arial Narrow", Font.PLAIN, 40));
		btnSuma.setBounds(510, 78, 195, 63);
		add(btnSuma);
		
		btnResta = new JButton("-");
		btnResta.addMouseListener(new listenerResta());
		btnResta.setFont(new Font("Arial Narrow", Font.PLAIN, 40));
		btnResta.setBounds(779, 78, 195, 63);
		add(btnResta);
		
		
		// Caja de operaciones
		
		cajaOperaciones = new JTextField(""); // Se inicializa sin contenido
		cajaOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		cajaOperaciones.setEditable(false);
		cajaOperaciones.setBounds(510, 160, 460, 60);
		cajaOperaciones.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		cajaOperaciones.setColumns(10); // As� limitamos la cantidad de caracteres a introducir
		add(cajaOperaciones);
		
		// Configuramos el bot�n para comprobar el resultado
		
		btnCompruebaResultado = new JButton("Comprueba tu operaci�n...");
		btnCompruebaResultado.addMouseListener(new listenerCompruebaResultado());
		btnCompruebaResultado.setEnabled(true);
		btnCompruebaResultado.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnCompruebaResultado.setBounds(510, 235, 460, 60);
		add(btnCompruebaResultado);
		
		// Configuramos la caja de resultado
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblResultado.setBounds(510, 400, 460, 40);
		add(lblResultado);
		
		// Configuramos el bot�n para reiniciar los valores
		
		btnRepetir = new JButton("Vu�lvelo a intentar!");
		btnRepetir.addMouseListener(new listenerRepetir());
		btnRepetir.setEnabled(false);
		btnRepetir.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnRepetir.setBounds(510, 310, 460, 60);
		add(btnRepetir);
		
		// Ejecutamos el m�todo reiniciarValores al abrir el constructor
		reiniciarValores();
		
	} // Aqu� finaliza el constructor!

	//Setter del jugador y mensaje de bienvenida al juego
	
	public void setJugador (Jugador gamer){
		this.gamer=gamer;
		lblBienvenida.setText("Hola "+gamer.getNick()+", Welcome to the game!");
		lblPuntuacion.setText("Tu puntuaci�n es: "+gamer.getPuntuacion());
	}
	
	// M�todo para reiniciar valores (se usa al iniciar el juego o reiniciarlo)
	
	private void reiniciarValores(){
		//Cargamos las imagenes en los arrays
		for(int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("Imagenes/dado"+String.valueOf(i+1)+"_3.png"));
		}
		for(int i=0;i<dados6.length;i++){
			dados6[i]=new ImageIcon(getClass().getResource("Imagenes/dado"+String.valueOf(i+1)+"_6.png"));
		}
		for(int i=0;i<dados12.length;i++){
			dados12[i]=new ImageIcon(getClass().getResource("Imagenes/dadodoce_"+String.valueOf(i+1)+".png"));
		}
		dadogris=new ImageIcon(getClass().getResource("Imagenes/dadogris.png"));
	
	
		//Colocamos los dados de 3 caras
		
		for(int i=0;i<numAlmacenadosDado3.length;i++) numAlmacenadosDado3[i]=dado.nextInt(3); //Obtenemos los n�meros aleatorios
		dado1.setIcon(dados3[numAlmacenadosDado3[0]]); //Es la imagen a colocar en los jLabel
		dado1.setName("1");
		dado2.setIcon(dados3[numAlmacenadosDado3[1]]); 
		dado2.setName("2");
		dado3.setIcon(dados3[numAlmacenadosDado3[2]]); 
		dado3.setName("3");
		
		//Colocamos los dados de 6 caras
		
		for(int i=0;i<numAlmacenadosDado6.length;i++) numAlmacenadosDado6[i]=dado.nextInt(6); //Obtenemos los n�meros aleatorios
		dado4.setIcon(dados6[numAlmacenadosDado6[0]]);
		dado4.setName("4");
		dado5.setIcon(dados6[numAlmacenadosDado6[1]]); 
		dado5.setName("5");
		
		//Colocamos el dado de 12 caras
		
		numAlmacenadoDado12=dado.nextInt(12); //N�mero aleatorio
		dado6.setIcon(dados12[numAlmacenadoDado12]);
		
		//Reseteamos cajas y botones
		
		lblResultado.setText("");
		cajaOperaciones.setText("");
		btnCompruebaResultado.setEnabled(true);
		btnRepetir.setEnabled(false);
		
		//Reseteamos valores
		
		tocaNumero=true;
		operacion=null;
		
	}

	//Final del m�todo de reiniciar
	
	
	
	// Implementamos el mouse-listener necesario para la acci�n realizada por los 
	// dados al ser presionados, a trav�s de un Inner class
		
		private class ListenerDados implements MouseListener{
			
		@Override
		public void mousePressed(MouseEvent arg0) {

	  //Identificamos el dado que hemos seleccionado
		JLabel dado = (JLabel) arg0.getSource();

		//Recuperamos el nombre del label para tomar el valor del array

		int numeroDado=Integer.valueOf(dado.getName());

		      //A partir de ah� decidimos que vamos a hacer despu�s de clickar
		      //S�lo si realmente tocaba escoger un n�mero (porque estamos al
		      //principo o porque antes hemos escogido una operaci�n hacemos
		      //algo. Lo podemos controlar con un �sem�foro�

		 if(tocaNumero){
			 
			 dado.removeMouseListener(this);
			 dado.setEnabled(false);
			 
			 switch (numeroDado){
				case 1: cajaOperaciones.setText( cajaOperaciones.getText() + String.valueOf(numAlmacenadosDado3[0]+1) ); break;
				case 2: cajaOperaciones.setText( cajaOperaciones.getText() + String.valueOf(numAlmacenadosDado3[1]+1) ); break;
				case 3: cajaOperaciones.setText( cajaOperaciones.getText() + String.valueOf(numAlmacenadosDado3[2]+1) ); break;
				case 4: cajaOperaciones.setText( cajaOperaciones.getText() + String.valueOf(numAlmacenadosDado6[0]+1) ); break;
				case 5: cajaOperaciones.setText( cajaOperaciones.getText() + String.valueOf(numAlmacenadosDado6[1]+1) ); break;
				}
			 
			 // Pasamos la imagen del dado a gris para no volverlo a utilizar
			 
			 dado.setIcon(dadogris);			 
			 
		     // Cambiamos el valor del "sem�foro" para que se introduzca un operador
			 
			 tocaNumero=false;
          
		                 }
		}
		//M�todos necesarios en la InnerClass aunque no hagan nada
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {} 
		
		} // Aqu� termina la inner class de los dados
		
		
		// Inner Class para el bot�n Suma
		
		private class listenerSuma implements MouseListener {
			//Formato que tiene que aparecer en una inner class de un mouseListener
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			//MousseListener que vamos a utilizar
			@Override
			public void mousePressed(MouseEvent e) {
					if(!tocaNumero){
						cajaOperaciones.setText(cajaOperaciones.getText()+"+");
						tocaNumero=true;
					}
				}
		}
		
		// Inner Class para el bot�n Resta
				private class listenerResta implements MouseListener {
					//Formato que tiene que aparecer en una inner class de un mouseListener
					@Override
					public void mouseClicked(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					//MousseListener que vamos a utilizar
					@Override
					public void mousePressed(MouseEvent e) {
						if(!tocaNumero){
							cajaOperaciones.setText(cajaOperaciones.getText()+"-");
							tocaNumero=true;
						}
					}
				}
				
		// Inner Class para el bot�n compruebaResultado
				private class listenerCompruebaResultado implements MouseListener {
					//Formato que tiene que aparecer en una inner class de un mouseListener
					@Override
					public void mouseClicked(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					//MousseListener que vamos a utilizar
					@Override
					public void mousePressed(MouseEvent e) {
						dado1.removeMouseListener(this);
						dado2.removeMouseListener(this);
						dado3.removeMouseListener(this);
						dado4.removeMouseListener(this);
						dado5.removeMouseListener(this);					
						// Recoge los datos de la caja de operaciones y devuelve el resultado en el objeto operacion
						ScriptEngineManager manager = new ScriptEngineManager(); 
						ScriptEngine engine = manager.getEngineByName("js"); 
						try {
							operacion = engine.eval(cajaOperaciones.getText());
							
							if((numAlmacenadoDado12+1)==(Integer)operacion){
								lblResultado.setText("Muy bien!"); //El resultado es correcto
								// Actualizamos la puntuaci�n
								gamer.setPuntuacion(gamer.getPuntuacion()+5);
								lblPuntuacion.setText("Llevas: "+gamer.getPuntuacion()+" Puntos");
								btnRepetir.setEnabled(true);//Habilitamos bot�n de reinicio
							}else{
								lblResultado.setText("Prueba otra vez...");//El resultado es incorrecto
								// Actualiza los valores de la puntuaci�n
								gamer.setPuntuacion(gamer.getPuntuacion()-1);
								lblPuntuacion.setText("Llevas: "+gamer.getPuntuacion()+" Puntos");
								btnRepetir.setEnabled(true); //Habilitamos bot�n de reinicio						
							}
								
						// Excepci�n por si no puede realizarse la operaci�n que aparece en la caja de operaciones	
						} catch (ScriptException e1) {
							e1.printStackTrace();
						}
						// Desactivamos el bot�n
						btnCompruebaResultado.setEnabled(false);
					}
				}
				
			// Inner Class para el bot�n Reset
				
				private class listenerRepetir implements MouseListener {
					//Formato que tiene que aparecer en una inner class de un mouseListener
					@Override
					public void mouseClicked(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					//MousseListener que vamos a utilizar
					@Override
					public void mousePressed(MouseEvent e) {
							reiniciarValores();
							// Al presionar invocamos al m�todo reiniciarValores
							btnCompruebaResultado.setEnabled(true);
							btnRepetir.setEnabled(false);
							// Comprobacci�n de listeners en los dados
							estaActivo();
					}
				}	
				
		//M�TODO PARA SABER SI HEMOS DADO AL ACTION LISTENER Y DE ESTA FORMA QUE HAGA DE S�MAFORO A LA HORA DE ACTIVAR LOS MOUSELISTENER
			private void estaActivo (){
				
				if (dado1.isEnabled()){
					//NO HACE NADA 
				}else{
					dado1.addMouseListener(new ListenerDados());
					dado1.setEnabled(true);
				}
				
				if (dado2.isEnabled()){
					//NO HACE NADA
				}else{
					dado2.addMouseListener(new ListenerDados());
					dado2.setEnabled(true);
				}
				
				if (dado3.isEnabled()){
					//NO HACE NADA
				}else{
					dado3.addMouseListener(new ListenerDados());
					dado3.setEnabled(true);
				}	
				
				if (dado4.isEnabled()){
					//NO HACE NADA
				}else{
					dado4.addMouseListener(new ListenerDados());
					dado4.setEnabled(true);
				}
				
				if (dado5.isEnabled()){
					//NO HACE NADA
				}else{
					dado5.addMouseListener(new ListenerDados());
					dado5.setEnabled(true);
				}
			}
		
} //Aqu� termina la clase Juego
	
