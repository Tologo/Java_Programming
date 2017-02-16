package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador; //Importamos la clase Jugador porque está en otro paquete.
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Registro extends JFrame {

//Definimos las variables
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtNick;
	private JTextField txtEdad;
	private JTextField txtMensaje;
	private JButton btnComprobar;
	private Registro referencia; //Creamos una etiqueta de referencia a un objeto de tipo Registro
	private Juego vJuego; //Creamos la variable Juego y la denominamos vJuego (etiqueta)
	private Jugador gamer=new Jugador(); //Creamos la variable de tipo jugador y la denominamos gamer
	
/**
 * Constructor de Registro
 */
	public Registro(Juego vJ) { //pasamos el objeto vJuego a través del constructor
		setTitle("Registro del Jugador / Login");
	//Asociamos la referencia al objeto de tipo Registro que estamos creando	
		referencia=this;
	//Asociamos la etiqueta creada de ventana juego al objeto que hemos pasado a través del constructor
		vJuego=vJ;
		
	//Inicalizamos los valores de gamer
		
		gamer.setNombre("");
		gamer.setApellidos("");
		gamer.setNick("");
		gamer.setEdad(0);
		gamer.setNivel(0);
		gamer.setPuntuacion(0);
		gamer.setTiempo(0);
		gamer.setId(0);

	// Configuración del panel
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	// Configuración de las etiquetas
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNombre.setBounds(10, 11, 70, 20);
		contentPane.add(lblNombre);
			
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblApellidos.setBounds(10, 43, 70, 20);
		contentPane.add(lblApellidos);
			
		JLabel lblNick = new JLabel("Nick");
		lblNick.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNick.setBounds(10, 74, 70, 20);
		contentPane.add(lblNick);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblEdad.setBounds(10, 103, 70, 20);
		contentPane.add(lblEdad);		
		
	// Configuración de las cajas de texto
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtNombre.setBounds(75, 11, 349, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
			
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(75, 42, 349, 20);
		contentPane.add(txtApellidos);
			
		txtNick = new JTextField();
		txtNick.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtNick.setColumns(10);
		txtNick.setBounds(75, 74, 349, 20);
		contentPane.add(txtNick);
			
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtEdad.setColumns(10);
		txtEdad.setBounds(75, 104, 70, 20);
		contentPane.add(txtEdad);
		
	// Caja de texto del mensaje a mostrar
		
		txtMensaje = new JTextField();
		txtMensaje.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		txtMensaje.setBounds(10, 178, 414, 39);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
	
	// Botón de comprobación y asignación de los datos de las cajas al jugador
		
		btnComprobar = new JButton("Guarda y Comprueba");
		// Creamos el listener que contendrá las acciones a realizar tras presionar el botón
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guarda nombre, apellidos y nick
				gamer.setNombre(txtNombre.getText());
				gamer.setApellidos(txtApellidos.getText());
				gamer.setNick(txtNick.getText());
				
				// Comprueba si el dato de la edad es numérico y guarda la edad
				
				if(gamer.isNumeric(txtEdad.getText())==true){
					gamer.setEdad(Integer.parseInt(txtEdad.getText()));
				}	else	{
						gamer.setEdad(999); //Si no es numérico lo establece en 999
				}
				
				//Introducimos las comprobaciones a realizar
				
				if (gamer.sonEspacios(gamer.getNombre())){
				txtMensaje.setText("Campo de Nombre vacío. Introduce un nombre");
					}else if (gamer.sonEspacios(gamer.getApellidos())){
						txtMensaje.setText("Campo de Apellidos vacío. Introduce un Apellido");
					}else if (gamer.sonEspacios(gamer.getNick())){
						txtMensaje.setText("Campo de Nick vacío. Introduce un Nick");
					}else if (gamer.getEdad()==999){
						txtMensaje.setText("Edad incorrecta o campo vacío. Introduce una Edad válida");
					}else	{
						txtMensaje.setText("New gamer: "+gamer.getNombre()+" "+gamer.getApellidos()+" de "+gamer.getEdad()+" años. Con Nick: "+gamer.getNick());
					
				
						vJuego.setJugador(gamer); //Pasamos los datos del "gamer" a la ventana del juego
				
						vJuego.setVisible(true); // Abrimos la ventana del juego
				
						referencia.dispose(); //Cerramos la ventana de Registro
					
				}				
			
			}});
		
		btnComprobar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnComprobar.setBounds(10, 144, 414, 25);
		contentPane.add(btnComprobar);
		
		vJuego = new Juego();
		
	}

}

