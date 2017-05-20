import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanasYVariables extends JFrame {

	private JPanel contentPane; //DEFINIMOS EL CONTENEDOR
	private JTextField CAJA; //DEFINIMOS LA CAJA
	private JTextField Caja2;
	String nombre="Tomás López";
	int edad=37;
	
	/**
	 * LANZAR LA VENTANA.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanasYVariables frame = new VentanasYVariables();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * CONFIGURAR NUESTRA VENTANA.
	 */
	public VentanasYVariables() {
		//CONFIGURACION DE MI VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//CONTENEDOR
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//GENERAR LA PRIMERA CAJA
		CAJA = new JTextField();
		CAJA.setBounds(10, 40, 200, 20);
		contentPane.add(CAJA);
		CAJA.setText(nombre);
		CAJA.setColumns(10);
		
		JLabel Etiqueta1 = new JLabel("Etiqueta");
		Etiqueta1.setBounds(10, 11, 46, 14);
		contentPane.add(Etiqueta1);
		
		//GENERAR LA SEGUNDA CAJA CON SU ETIQUETA
		
		JLabel Etiqueta2 = new JLabel("Etiqueta");
		Etiqueta2.setBounds(10, 91, 46, 14);
		contentPane.add(Etiqueta2);
		
		Caja2 = new JTextField();
		Caja2.setColumns(10);
		Caja2.setBounds(10, 120, 200, 20);
		Caja2.setText(String.valueOf(edad));
		contentPane.add(Caja2);
		
	}
}
