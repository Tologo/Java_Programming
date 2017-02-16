import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proyecto02 extends JFrame {
	
	//Definimos el panel y las cajas de texto
	private JPanel contentPane;
	private JTextField TextoIzquierda;
	private JTextField TextoDerecha;

	/**
	 * Lanzamos la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto02 frame = new Proyecto02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creamos y configuramos la ventana.
	 */
	public Proyecto02() {
		setResizable(false);
		setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		setTitle("P02. Bailando texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 235);
		//Configuramos el Panel de la ventana
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos las Cajas Izquierda y Derecha
		TextoIzquierda = new JTextField();
		TextoIzquierda.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		TextoIzquierda.setBounds(10, 90, 150, 30);
		contentPane.add(TextoIzquierda);
		TextoIzquierda.setColumns(10);
		
		TextoDerecha = new JTextField();
		TextoDerecha.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		TextoDerecha.setBounds(220, 90, 150, 30);
		contentPane.add(TextoDerecha);
		TextoDerecha.setColumns(10);
		
		//Creamos los botones superior e inferior
		JButton BotonSuperior = new JButton(">>>>");
		BotonSuperior.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		BotonSuperior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//La primera acción toma el contenido de la izquierda y lo lleva a la derecha
			TextoDerecha.setText(TextoIzquierda.getText());
			//La segunda acción establece el texto de la izquierda en blanco
			TextoIzquierda.setText("");
			}
		});
		BotonSuperior.setBounds(145, 40, 90, 30);
		contentPane.add(BotonSuperior);
		
		JButton BotonInferior = new JButton("<<<<");
		BotonInferior.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		BotonInferior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//La primera acción toma el contenido de la derecha y lo lleva a la izquierda
			TextoIzquierda.setText(TextoDerecha.getText());
			//La segunda acción establece el texto de la derecha en blanco
			TextoDerecha.setText("");
			}
		});
		BotonInferior.setBounds(145, 140, 90, 30);
		contentPane.add(BotonInferior);
	}
}