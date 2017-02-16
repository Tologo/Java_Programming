package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

public class Juego extends JFrame {

	private JPanel contentPane;
	private JLabel lblBienvenida;
	private Jugador gamer; //Etiqueta que recogerá los datos del jugador de la ventana Inicio_Login

	
	/**
	 * Create the frame.
	 */
	public Juego() {
		setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		setTitle("Ventana de Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenida = new JLabel("New label");
		lblBienvenida.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblBienvenida.setBounds(10, 11, 414, 25);
		contentPane.add(lblBienvenida);
	}

	//Setter
	public void setJugador (Jugador gamer){
		this.gamer=gamer;
		lblBienvenida.setText("Hola "+gamer.getNick()+", Welcome to the game!");
	}
}