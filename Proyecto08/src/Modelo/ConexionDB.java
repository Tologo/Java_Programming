package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	// Datos de la conexión
		static final String CONTROLADOR_MYSQL = "com.mysql.jdbc.Driver";
		
		// Datos de la Base de Datos
		private String host; // host donde está la base de datos
		private String bbdd; // nombre de la base de datos
		private String user; // nombre usuario para acceder base de datos
		private String pass; // password de usuario
		private String url;  // proporcionará al método DriverManager la dirección de conexión
		
		//Conexion
		private Connection conexion = null; // maneja la conexión
		
		
		//Constructor (le pasaremos los datos necesarios para la conexión)
		
		public ConexionDB(String HOST,String BBDD,String USER,String PASS) {
			this.host=HOST;
			this.bbdd=BBDD;
			this.user=USER;
			this.pass=PASS;
			this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
		}
		
		
		//Método para conectarse con la BBDD: Devuelve verdadero para una conexión sin fallos
		public boolean connectDB(){
			try{
				// Carga el controlador MySQL el cual automáticamente se registra
				Class.forName(CONTROLADOR_MYSQL);
				//Conectarnos a la BBDD
				conexion = DriverManager.getConnection(this.url,this.user,this.pass);
			}
			catch( SQLException excepcionSql ) //No encuentra la Base de Datos
			{
				excepcionSql.printStackTrace();
				return false;
	        }
			catch( ClassNotFoundException noFindClass) //No encuentra el driver para la conexión
			{
				noFindClass.printStackTrace();
				return false;
			}
			return true;
		}
		
		//Devuelve una instancia de la conexión
		public Connection getConexion(){
			return this.conexion;
		}

}