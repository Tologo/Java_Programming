package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class VentanaGeneral extends JFrame {

	// Variables que incluye la ventana:
	
	private JPanel contentPane;
	// Clase que almacene al jugador
	private Jugador gamer;
	// Clase para mostrar la ventana de juego
	private Juego ventanaJuego= new Juego();
	// Clase para mostrar la ventana de perfil
	private Perfil ventanaPerfil =new Perfil();
	// Añadimos identificadores para cada clase de "ventanas"
	final static String VENTANAJ = "Ventana de juego";
	final static String VENTANAP = "Ventana de perfil";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGeneral frame = new VentanaGeneral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaGeneral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 550);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		mnOpciones.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		menuBar.add(mnOpciones);
		
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mntmJuego.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		mnOpciones.add(mntmJuego);
		mntmJuego.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cl = (CardLayout)(contentPane.getLayout());
			cl.show(contentPane, VENTANAJ);
			ventanaPerfil.setJugador(gamer);
		}
		});
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		mnOpciones.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, VENTANAP);
				ventanaPerfil.setJugador(gamer);
			}
			});
		
		// Panel de la ventana general
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		// Añadimos las "ventanas" juego y perfil al ContentPane
		contentPane.add(ventanaJuego,VENTANAJ);
		contentPane.add(ventanaPerfil,VENTANAP);
		
	}
	
	// Actualizamos los datos del jugador en la ventana de juego
	
			public void setJugador (Jugador gamer){
				this.gamer=gamer;
				ventanaJuego.setJugador(gamer);
		}

}
