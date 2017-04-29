package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.ConexionDB;
import Modelo.Jugador;
import Modelo.JugadorDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class Registro extends JFrame {

// Definimos las variables
	
	private JPanel contentPane;
	
	private JTextField txtNombre,txtApellidos,txtNick,txtEdad,txtMensaje;
	
	private JButton btnComprobar;
	
	private Registro referencia; // Creamos una etiqueta de referencia a un objeto de tipo Registro
	private VentanaGeneral vJuego; // Creamos la variable Juego y la denominamos vJuego (etiqueta)
	
	// Creamos la variable de tipo jugador (nuevo jugador) y lo denominamos 'gamer'
	private Jugador gamer=new Jugador();
	
	// Las variable de conexión a la base de datos son:
	private ConexionDB db;
	private JugadorDB jdb;
	private Connection conexion;
	private boolean connected = false;
	
/**
 * Constructor de Registro
 */
	public Registro(VentanaGeneral vJ) { // Pasamos el objeto vJuego a través del constructor
		setTitle("Registro del Jugador / Login");
	// Asociamos la referencia al objeto de tipo Registro que estamos creando	
		referencia=this;
	// Asociamos la etiqueta creada de ventana juego al objeto que hemos pasado a través del constructor
		vJuego=vJ;
		
	// Inicalizamos los valores de gamer
		
		gamer.setNombre("");
		gamer.setApellidos("");
		gamer.setNick("");
		gamer.setEdad(0);
		gamer.setPuntuacion(0);

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
	// Mediante un listener que se desarrolla en una InnerClass (Comprobaciones)
		
		btnComprobar = new JButton("Comprueba, guarda y juega!");
		btnComprobar.addMouseListener(new Comprobaciones());
		btnComprobar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnComprobar.setBounds(10, 144, 414, 25);
		contentPane.add(btnComprobar);
		
	// Conectamos con la BBDD
		
		Conectar();	

	// Creamos la ventana de Juego
				
				vJuego = new VentanaGeneral();
				
	}
	
	
	// ------------------------ Métodos de la clase ------------------------------- //
	
	// Método para Conectar con la base de datos
		private void Conectar(){
			try{
				db=new ConexionDB("localhost","mathdice","root","");
				//Establecemos la conexion
				connected=db.connectDB();
				//Asignamos con el getter la conexion establecida
				conexion=db.getConexion();
				//Pasamos la conexión a un nuevo objeto UsuariosDB para insertar datos.
				jdb=new JugadorDB(conexion);
				
				if(connected==false) {
					System.out.println("SIN EXITO EN LA CONEXION");
				}
				else System.out.println("EXITO EN LA CONEXION");
				
				}
			catch(Exception e)
			{
				System.out.println( " Debe haber algún problema con la BBDD o con la conexión.");	
			}
		}
		

	// Implementamos una InnerClass para las acciones a realizar con el botón 'btnComprobar'
	
	private class Comprobaciones implements MouseListener {

		// Formato obligatorio en una inner class de un mouseListener
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		//MousseListener que vamos a emplear
		@Override
		public void mousePressed(MouseEvent arg0) {
			
			// Guardamos nombre, apellidos y nick
			
			gamer.setNombre(txtNombre.getText());
			gamer.setApellidos(txtApellidos.getText());
			gamer.setNick(txtNick.getText());
			
			// Comprueba si el dato de la edad es numérico y guarda la edad
			
			if(gamer.isNumeric(txtEdad.getText())==true){
				gamer.setEdad(Integer.parseInt(txtEdad.getText()));
			}	else	{
					gamer.setEdad(999); // Si no es numérico lo establece en 999
			}
			
			// Introducimos las comprobaciones a realizar
			
			if (gamer.sonEspacios(gamer.getNombre())){
			txtMensaje.setText("Campo de Nombre vacío. Introduce un nombre");
				}else if (gamer.sonEspacios(gamer.getApellidos())){
					txtMensaje.setText("Campo de Apellidos vacío. Introduce un Apellido");
				}else if (gamer.sonEspacios(gamer.getNick())){
					txtMensaje.setText("Campo de Nick vacío. Introduce un Nick");
				}else if (gamer.getEdad()==999){
					txtMensaje.setText("Edad incorrecta o campo vacío. Introduce una Edad válida");
				}else	{
					
			// Registramos al usuario en la Base de Datos
			
					jdb.nuevoUsuario(txtNombre.getText(), txtApellidos.getText(), txtNick.getText(), Integer.valueOf(txtEdad.getText()));		
			
					txtMensaje.setText("New gamer: "+gamer.getNombre()+" "+gamer.getApellidos()+" de "+gamer.getEdad()+" años. Con Nick: "+gamer.getNick());
		
			//Enviamos un Mensaje para hacer saber al Jugador si se ha registrado en la BBDD o no//
				if(connected==true){
					JOptionPane.showMessageDialog(null,"Jugador Registrado con éxito en la BBDD");
				}else {
					JOptionPane.showMessageDialog(null, "Fallo en el Registro, comprueba la Conexión");
				}
						
					
			vJuego.setJugador(gamer); // Pasamos los datos del "gamer" a la ventana del juego
			
			vJuego.setVisible(true); // Abrimos la ventana del juego
	
			referencia.dispose(); // Cerramos la ventana de Registro
	
		}

	} // Fin de la InnerClass
	}
}