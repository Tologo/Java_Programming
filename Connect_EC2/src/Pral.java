import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class Pral {

	public static void main(String[] args) {

		Connection conexion;
		
		String url = "jdbc:mysql://mydatabase.c2fqi4n8yu5q.us-west-2.rds.amazonaws.com";
		String user = "admin";
		String pw = "11vlado22";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Obtenemos la conexión con el DriverManager
		try {
			conexion = DriverManager.getConnection(url, user, pw);
			System.out.println("Conexión correcta con Driver Manager");
			Statement instruccion = (Statement) conexion.createStatement();
			
			ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM Personas");
			while (conjuntoResultados.next())
				System.out.println("Nombre: "+ conjuntoResultados.getObject("Nombre") + " Edad: "+ conjuntoResultados.getObject("Edad"));
			conexion.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Obtenemos el driver del controlador desde el DriverManager
		try {
			Driver driver = DriverManager.getDriver(url);
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", pw);
			conexion = driver.connect(url, properties);
			System.out.println("Conexión realizada correctamente usando Driver");
			conexion.close();
		} catch (SQLException ex) {
			System.err.println("Error " + ex.getMessage());
		}
		
	}

}
