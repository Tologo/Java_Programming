package Ventanas;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Modelo.Jugador;

public class Perfil extends JPanel {
	
	// Variables de la clase
	
	// Cajas de texto para los datos del Jugador
	
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;
	private JTextField textFieldNick;
	private JTextField textFieldEdad;
	private JTextField textFieldPuntuacion;
	private JTextArea textComentarios;
	
	// Clase que almacena al jugador
	
	private Jugador gamer;
	
	// Etiquetas
	
	private JLabel lblPuntuacion;
	private JLabel lblCabecera;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblNick;
	private JLabel lblEdad;
	private JLabel lblComentarios;
	
	// Botón para actualizar los datos
	
	private JButton btnActualizarDatos;

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
		btnActualizarDatos.addMouseListener(new listenerActualizarDatos());
		btnActualizarDatos.setBounds(97, 231, 146, 29);
		add(btnActualizarDatos);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setForeground(Color.BLUE);
		lblComentarios.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(lblComentarios);
		
		textComentarios = new JTextArea();
		textComentarios.setForeground(Color.DARK_GRAY);
		textComentarios.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		add(textComentarios);
		textComentarios.setColumns(26);

	} // Final del constructor!

// Setter del jugador en los jTextfields
		
		public void setJugador (Jugador gamer){
			this.gamer=gamer;
			textFieldNombre.setText(gamer.getNombre());
			textFieldApellidos.setText(gamer.getApellidos());
			textFieldNick.setText(gamer.getNick());
			textFieldEdad.setText(String.valueOf(gamer.getEdad()));
			textFieldPuntuacion.setText(String.valueOf(gamer.getPuntuacion()));	
		}
		
// InnerClass del botón para actualizar datos
		private class listenerActualizarDatos implements MouseListener {
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
				// Almaceno los nuevos datos del jugador
				gamer.setNombre(textFieldNombre.getText());
				gamer.setApellidos(textFieldApellidos.getText());
				gamer.setNick(textFieldNick.getText());
				int nuevaEdad = Integer.valueOf(textFieldEdad.getText());
				gamer.setEdad(nuevaEdad);
				textComentarios.setText("Cambios guardados con éxito para el jugador "+gamer.getNombre()+" "+gamer.getApellidos()+" con Nick "+gamer.getNick()+" de "+gamer.getEdad()+" años.");
			}
			}
		
}
