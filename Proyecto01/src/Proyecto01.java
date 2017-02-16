import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Proyecto01 extends JFrame {

	//Definimos el panel y las cajas
	private JPanel contentPane;
	private JTextField Caja01;
	private JTextField Caja02;
	private JTextField Caja03;
	private JTextField Caja04;
	private JTextField Caja05;
	//Definimos las variables a emplear
	String nombre="Tomás";
	String apellidos="López Gómez";
	String dni="20000000X";
	int edad=37;
	String mail="tologo.topo@gmail.com";

	/**
	 * Punto de entrada a la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto01 frame = new Proyecto01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configuración de la ventana.
	 */
	public Proyecto01() {
		setTitle("P01 Mi Perfil");
		//Configuración de la Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 260);
		//Configuración del panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creación de las etiquetas
		JLabel Etiqueta01 = new JLabel("Nombre");
		Etiqueta01.setHorizontalAlignment(SwingConstants.LEFT);
		Etiqueta01.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Etiqueta01.setBounds(10, 10, 60, 20);
		contentPane.add(Etiqueta01);
		
		JLabel Etiqueta02 = new JLabel("Apellidos");
		Etiqueta02.setHorizontalAlignment(SwingConstants.LEFT);
		Etiqueta02.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Etiqueta02.setBounds(125, 10, 60, 20);
		contentPane.add(Etiqueta02);
		
		JLabel Etiqueta03 = new JLabel("DNI");
		Etiqueta03.setHorizontalAlignment(SwingConstants.LEFT);
		Etiqueta03.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Etiqueta03.setBounds(10, 60, 60, 20);
		contentPane.add(Etiqueta03);
		
		JLabel Etiqueta04 = new JLabel("Edad");
		Etiqueta04.setHorizontalAlignment(SwingConstants.LEFT);
		Etiqueta04.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Etiqueta04.setBounds(10, 110, 60, 20);
		contentPane.add(Etiqueta04);
		
		JLabel Etiqueta05 = new JLabel("Correo electr\u00F3nico");
		Etiqueta05.setHorizontalAlignment(SwingConstants.LEFT);
		Etiqueta05.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Etiqueta05.setBounds(10, 160, 143, 20);
		contentPane.add(Etiqueta05);
		
		//Creación de Cajas con los valores de las variables definidas a través de setText
		Caja01 = new JTextField();
		Caja01.setHorizontalAlignment(SwingConstants.LEFT);
		Caja01.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Caja01.setBounds(10, 35, 90, 25);
		Caja01.setText(nombre);
		contentPane.add(Caja01);
		Caja01.setColumns(10);
		
		Caja02 = new JTextField();
		Caja02.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Caja02.setBounds(125, 35, 100, 25);
		Caja02.setText(apellidos);
		contentPane.add(Caja02);
		Caja02.setColumns(10);
		
		Caja03 = new JTextField();
		Caja03.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Caja03.setBounds(10, 85, 90, 25);
		Caja03.setText(dni);
		contentPane.add(Caja03);
		Caja03.setColumns(10);
		
		Caja04 = new JTextField();
		Caja04.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Caja04.setBounds(10, 135, 35, 25);
		Caja04.setText(String.valueOf(edad));
		contentPane.add(Caja04);
		Caja04.setColumns(10);
		
		Caja05 = new JTextField();
		Caja05.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		Caja05.setBounds(10, 185, 215, 25);
		Caja05.setText(mail);
		contentPane.add(Caja05);
		Caja05.setColumns(10);
		
	}

}