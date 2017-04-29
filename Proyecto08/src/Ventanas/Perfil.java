package Ventanas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Modelo.Jugador;

import java.awt.Component;
import java.awt.Color;

public class Perfil extends JPanel {
	
	// Variables de la clase
	
	// Cajas de texto para los datos del Jugador
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;
	private JTextField textFieldNick;
	private JTextField textFieldEdad;
	private JTextField textFieldPuntuacion;
	
	// Clase que almacena al jugador
	private Jugador gamer;
	
	// Etiquetas
	private JLabel lblPuntuacion;
	private JLabel lblCabecera;

	/**
	 * Constructor.
	 */
	public Perfil() {
		setBackground(SystemColor.activeCaption);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20, 20);
		setLayout(flowLayout);
		
		lblCabecera = new JLabel("Perfil del jugador activo en Mathdice");
		lblCabecera.setForeground(Color.DARK_GRAY);
		lblCabecera.setFont(new Font("Arial Narrow", Font.PLAIN, 70));
		add(lblCabecera);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.DARK_GRAY);
		textFieldNombre.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(textFieldNombre);
		textFieldNombre.setColumns(7);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.BLUE);
		lblApellidos.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setForeground(Color.DARK_GRAY);
		textFieldApellidos.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(textFieldApellidos);
		textFieldApellidos.setColumns(13);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setForeground(Color.BLUE);
		lblNick.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(lblNick);
		
		textFieldNick = new JTextField();
		textFieldNick.setForeground(Color.DARK_GRAY);
		textFieldNick.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.BLUE);
		lblEdad.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setForeground(Color.DARK_GRAY);
		textFieldEdad.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(textFieldEdad);
		textFieldEdad.setColumns(9);
		
		lblPuntuacion = new JLabel("Puntuaci\u00F3n");
		lblPuntuacion.setForeground(Color.BLUE);
		lblPuntuacion.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(lblPuntuacion);
		
		textFieldPuntuacion = new JTextField();
		textFieldPuntuacion.setEditable(false);
		textFieldPuntuacion.setForeground(Color.DARK_GRAY);
		textFieldPuntuacion.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(textFieldPuntuacion);
		textFieldPuntuacion.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNombre, textFieldNombre, lblApellidos, textFieldApellidos, lblNick, textFieldNick, lblEdad, textFieldEdad}));
		
		// Botón de actualizar
		JButton btnActualizarDatos = new JButton("Actualizar datos");
		btnActualizarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Almaceno los nuevos datos del jugador
				gamer.setNombre(textFieldNombre.getText());
				gamer.setApellidos(textFieldApellidos.getText());
				gamer.setNick(textFieldNick.getText());
				int nuevaEdad = Integer.valueOf(textFieldEdad.getText());
				gamer.setEdad(nuevaEdad);

				// Actualiza nombre en el juego (No funciona!)
				// Juego.setJugador(gamer.getNick());
				}
		});
		btnActualizarDatos.setBounds(97, 231, 146, 29);
		add(btnActualizarDatos);

	} // Final del constructor!

		// Setter del jugador en los jTextfields
		
		public void setJugador (Jugador gamer){
			this.gamer=gamer;
			textFieldNombre.setText(gamer.getNombre());
			textFieldApellidos.setText(gamer.getApellidos());
			textFieldNick.setText(gamer.getNick());
			textFieldEdad.setText(String.valueOf(gamer.getEdad()));
			textFieldPuntuacion.setText(String.valueOf(gamer.getPuntuacion()));;
			
		}
		public void setPuntosText (int puntos){
			textFieldPuntuacion.setText(String.valueOf(gamer.getPuntuacion()));
		}
		
}
