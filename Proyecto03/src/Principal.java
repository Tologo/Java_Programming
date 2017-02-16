import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

public class Principal extends JFrame {

	//Variables
	private JPanel contentPane;

	// La entrada a nuestro programa (main)
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor
	
	public Principal() {
		//Configuración del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	//Nuestro código

		Jugador player01=new Jugador();
			player01.setNombre("Tomás");
			player01.setApellidos("López Gómez");
			player01.setNick("Tologo");
			player01.setEdad(37);
			player01.setNivel(20);
			player01.setPuntuacion(211);
			player01.setTiempo(2);
			player01.setId(1);
			System.out.println("Jugador: "+player01.getNombre()+" "+player01.getApellidos()+". Con Nick: "+player01.getNick());
	}

}
