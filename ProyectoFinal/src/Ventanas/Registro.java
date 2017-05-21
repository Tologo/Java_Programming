package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.ConexionDB;
import Modelo.Jugador;
import Modelo.JugadorDB;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JComboBox;

public class Registro extends JFrame {

// Definimos las variables
	
	private JPanel contentPane;
	
	private JTextField txtNombre,txtApellidos,txtNick,txtEdad,txtMensaje;
	private JLabel lblNombre,lblApellidos,lblNick,lblEdad,lblUsuarios;
	
	private JButton btnComprobar;
	private JButton btnBuscar;
	private JButton btnActualizar;
	
	private JComboBox comboBox;
	private int numeroItems; // Será el número de elementos en el ComboBox
	
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
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	// Configuración de las etiquetas
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNombre.setBounds(10, 57, 70, 20);
		contentPane.add(lblNombre);
			
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblApellidos.setBounds(10, 89, 70, 20);
		contentPane.add(lblApellidos);
			
		lblNick = new JLabel("Nick");
		lblNick.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNick.setBounds(10, 120, 70, 20);
		contentPane.add(lblNick);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblEdad.setBounds(10, 149, 70, 20);
		contentPane.add(lblEdad);
		
		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblUsuarios.setBounds(10, 14, 53, 14);
		contentPane.add(lblUsuarios);
		
	// Configuración de las cajas de texto
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtNombre.setBounds(75, 57, 349, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
			
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(75, 88, 349, 20);
		contentPane.add(txtApellidos);
			
		txtNick = new JTextField();
		txtNick.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtNick.setColumns(10);
		txtNick.setBounds(75, 120, 349, 20);
		contentPane.add(txtNick);
			
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		txtEdad.setColumns(10);
		txtEdad.setBounds(75, 150, 70, 20);
		contentPane.add(txtEdad);
		
	// Caja de texto del mensaje a mostrar
		
		txtMensaje = new JTextField();
		txtMensaje.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		txtMensaje.setBounds(10, 251, 414, 59);
		txtMensaje.setText("Pon tu nombre y búscate en la BBDD de usuarios");
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
	
	// Botón de comprobación y asignación de los datos de las cajas al jugador
	// Mediante un listener que se desarrolla en una InnerClass (Comprobaciones)
		
		btnComprobar = new JButton("Comprueba, guarda y juega!");
		btnComprobar.addMouseListener(new Comprobaciones());
		btnComprobar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnComprobar.setBounds(10, 215, 414, 25);
		contentPane.add(btnComprobar);
		
	// Botón para buscar en BDD que indica la manera de efectuar la búsqueda
		
		btnBuscar = new JButton("Buscate en la BDD...");
		btnBuscar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnBuscar.setBounds(10, 181, 200, 23);
		btnBuscar.addActionListener(new miBotonBuscar());
		contentPane.add(btnBuscar);
		
	// Configuración del ComboBox y asignación de los datos de las cajas al jugador
	// Mediante un listener que se desarrolla en una InnerClass (ListadoComboBox)
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new miComboBox());
		comboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		comboBox.setBounds(75, 9, 349, 25);
		comboBox.setFocusable(true);
		comboBox.setFocusTraversalKeysEnabled(true);
		contentPane.add(comboBox);
		
		btnActualizar = new JButton("Actualiza tus datos...");
		btnActualizar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnActualizar.setBounds(224, 181, 200, 23);
		btnActualizar.addActionListener(new miBotonActualizar());
		contentPane.add(btnActualizar);
		
	// Conectamos con la BBDD
		
	Conectar();
			

	// Creamos la ventana de Juego
				
				vJuego = new VentanaGeneral();
				
	}
	
	
	// ------------------------ Métodos de la clase ------------------------------- //
	
	// Método para Conectar con la base de datos
		private void Conectar(){
			try{
				db=new ConexionDB("localhost","usuarios","root","");
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
				System.out.println( "Debe haber algún problema con la BBDD o con la conexión.");	
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
			
			//Conectamos con la BBDD
					Conectar();
			// Registramos al usuario en la Base de Datos
			
					jdb.nuevoUsuario(txtNombre.getText(), txtApellidos.getText(), txtNick.getText(), Integer.valueOf(txtEdad.getText()));		
					gamer.setId(jdb.devolverID());
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

	} 
	}
	
	//Método para comprobar los datos del usuario si se modifican
			private boolean ComprobarDatos()
			{   if (gamer==null)
			       {txtMensaje.setText(" No hay datos que actualizar.");return false;}		
			    else if (!gamer.isNumeric(txtEdad.getText()))
					{txtMensaje.setText("EDAD no correcta."); return false;}
				else if (gamer.sonEspacios(txtNombre.getText()))
					{txtMensaje.setText("Falta el nombre."); return false;}
				else if (gamer.sonEspacios(txtApellidos.getText()))
					{txtMensaje.setText("Faltan los apellidos."); return false;}
				else if (gamer.sonEspacios(txtNick.getText()))
					{txtMensaje.setText("Falta el Nick."); return false;}
				else{
				return true;}
			
			}
	
	
	// InnerClass para el Listener del ComboBox
		
		private class miComboBox implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Por defecto mostrará en pantalla la primera coincidencia con el
				//nombre encontrado en la BBDD
				//Seleccionando sobre el desplegable del JComboBox se podrá cambiar si hay varias coincidencias
				
				Jugador gamer=(Jugador)comboBox.getSelectedItem();
				
				if (gamer!=null) //Si la lista no del Combox no está vacía
				{
			    txtNombre.setText(gamer.getNombre());
				txtApellidos.setText(gamer.getApellidos());
				txtNick.setText(gamer.getNick());
				txtEdad.setText(String.valueOf(gamer.getEdad()));
				//Comprobacion
				System.out.println("El usuario seleccionado es: "+gamer.toString());}
				
			}

		}
	
	// InnerClass para el Listener del botón de actualizar datos
		
		private class miBotonActualizar implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				    //Antes de realizar la consulta a la base de datos debemos actualizar el objeto usuario
				    //Si los datos modificados son correctos
					
				if (ComprobarDatos())	
					{gamer.setNombre(txtNombre.getText());
					gamer.setApellidos(txtApellidos.getText());
					gamer.setNick(txtNick.getText());
					gamer.setEdad(Integer.valueOf(txtEdad.getText()));
					//Conectamos y actualizamos usuario
					Conectar();
					//udb.actualizarUsuario(u);
					jdb.actualizarUsuario(gamer);
					//Comprobacion
					txtMensaje.setText("Tu usuario se ha actualizado como: "+gamer.toString()+"\n Puedes hacer una nueva búsqueda");
					System.out.println("El usuario se ha actualizado a: "+gamer.toString());
					//Vaciamos el ComboBox u los campos de texto
					comboBox.removeAllItems();
					txtNombre.setText("");
					txtApellidos.setText("");
					txtNick.setText("");
					txtEdad.setText("");

			        }
				}
			}
		
		// InnerClass para el Listener del botón buscar
				private class miBotonBuscar implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {
						//Vaciamos el ComboBox
						comboBox.removeAllItems(); //Vaciamos los Items anteriores del ComboBox
						txtApellidos.setText("");
						txtNick.setText("");
						txtEdad.setText("");
						//Conectamos con la BBDD
						Conectar();
						//Buscamos el usuario por el nombre y las coincidencias van a un ComboBox
						jdb.buscarUsuario(txtNombre.getText(),comboBox);
						
						numeroItems=comboBox.getItemCount(); //Número de ítems en el ComboBox
						//Sirve para el caso en que el nombre buscado no esté en la lista
						if (numeroItems==0){
						txtApellidos.setText("Usuario no encontrado");
						txtNick.setText("Usuario no encontrado");
						txtEdad.setText("Usuario no encontrado");
						txtMensaje.setText(" Lo siento no estás registrado o no has introducido un nombre.\n Puedes volver a buscar con otro nombre.");
						}
						else txtMensaje.setText("");
						}
				}
		
}