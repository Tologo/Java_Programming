package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class JugadorDB {
		
		// Campos de la tabla 'usuarios'
	
			private int id;
			private String nombre;
			private String apellidos;
			private String nick;
			private String edad;
			private String puntuacion;
			// private String User;
			private Jugador gamer=new Jugador();
	
		// Conexión a la base de datos
		
			private Connection conexion;
		
		//Objeto para ejecutar una orden sobre la base de datos
		
			private Statement orden = null;		
		
		
		//Constructor: recoge la conexión establecida para la base de datos
		
		public JugadorDB(Connection c) {
			this.conexion=c;
		}
		
		// Método para insertar un jugador en la base de datos mathdice y en la tabla usuarios
		
		public void nuevoUsuario(String Nombre,String Apellidos,String Nick,int Edad){

			try{
				orden = conexion.createStatement();
				// Sentencia SQL para ejecutar sobre la BDD
			    String sql = "INSERT INTO usuarios (nombre,apellidos,nick,edad) " +
			                   "VALUES ('"+Nombre+"', '"+Apellidos+"', '"+Nick+"', "+Edad+")";
			    orden.executeUpdate(sql);
			    System.out.println("Nuevo Jugador registrado correctamente");


			   }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
			   }finally{
				      //Cerramos los recursos
				      try{
				         if(orden!=null)
				        	 orden.close();
				      }catch(SQLException se){
				    	  se.printStackTrace();
				      }
				      try{
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      }
				}
		}

}