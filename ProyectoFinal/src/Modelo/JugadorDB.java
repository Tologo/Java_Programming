package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;


public class JugadorDB {
		
		// Campos de la tabla 'usuarios'
	
			private int id;
			private Jugador gamer;
	
		// Conexi�n a la base de datos
		
			private Connection conexion;
		
		//Objeto para ejecutar una orden sobre la base de datos
		
			private Statement orden = null;
			private ResultSet rs=null;
			private Statement instruccion = null;
			private String sentencia = "";
		
		
		//Constructor: recoge la conexi�n establecida para la base de datos
		
		public JugadorDB(Connection c) {
			this.conexion=c;
		}
		
		// M�todo para insertar un jugador en la base de datos mathdice y en la tabla usuarios
		
		public void nuevoUsuario(String Nombre,String Apellidos,String Nick,int Edad){
			int id=0;
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
				      }
			   }
				
		// Una vez introducimos el jugador, rescatamos su id
		// Esto se hace recorriendo la lista de id hasta la �ltima posici�n
			public int devolverID() {
				try{			
					ResultSet miResultSet=orden.executeQuery("SELECT MAX(id) FROM usuarios");
					while (miResultSet.next()){
						System.out.println(miResultSet.getInt(1));
						id = miResultSet.getInt(1);
					}
				}catch(Exception e){ 
					System.out.println("Error en la conexi�n");
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
				return id;
		}
		
			
			
			//M�todo que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
			//Busca los usuarios por el nombre y devuelve todos los que tienen el mismo nombre
			//M�todo sobrecargado
				public void buscarUsuario(String nombreBuscar,JComboBox jc){
					ResultSet rs;
					try{
						orden = conexion.createStatement();
						  /*Si quisi�semos que devolviese todos los usuarios de la BBDD en el COMBOX har�amos
						   * String sql = "SELECT id,nombre, apellidos, nick, edad FROM usuario";
						   * y eliminar�amos el input de nombreBuscar en el m�todo
						   */
					      String sql = "SELECT id,nombre, apellidos, nick, edad FROM usuarios WHERE nombre='"+nombreBuscar+"'";
					      rs = orden.executeQuery(sql);
						//Cogemos los usuarios
						      while(rs.next()){
						    	  gamer=new Jugador(); // Se generar� un usuario por cada coincidencia
						    	  gamer.setId(rs.getInt("id"));
						    	  gamer.setNombre(rs.getString("nombre"));
						    	  gamer.setApellidos(rs.getString("apellidos"));
						    	  gamer.setNick(rs.getString("nick"));
						    	  gamer.setEdad(rs.getInt("edad"));
							      //A�adimos el usuario encontrado al JComboBox
							      //El usuario no "ser� destruido" al salir del m�todo porque se almacena en un objeto
							      //superior que lo guarda, que es el jc (un objeto ComboBox)
							      jc.addItem(gamer);
							      //Comprobaci�n por monitor
							      System.out.println("Coincidencias: "+gamer.toString()+"\n");
						      }
						    //Debemos cerrar la conexion
						      rs.close();
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
							      }
							      try{
							         if(conexion!=null)
							        	 conexion.close();
							      	 }catch(SQLException se){
							         se.printStackTrace();
							      	 }//end finally try
							}
				}	

			//M�todo que permite actualizar un usuario en la base de datos usando la
			//sentencia SQL UPDATE
						public void actualizarUsuario(Jugador gamer){
							try{
							  orden = conexion.createStatement();
							  //Configuramos la sentencia sql para actualizar el usuario en la tabla usuario
							  //El usuario se busca por su clave primaria, que es �nica.
						      String sql = "UPDATE usuarios " +
					                       "SET nombre = '"+gamer.getNombre()+"'"+
					                       ",apellidos = '"+gamer.getApellidos()+"'"+
					                       ",nick = '"+gamer.getNick()+"'"+
					                       ",edad = "+gamer.getEdad()+" "+
						    		       "WHERE id = "+gamer.getId();
						      
						      orden.executeUpdate(sql); //Ejecutamos la sentencia SQL de UPDATE
						      //Comprobaci�n por monitor
						      System.out.println(sql+"\n");
						      System.out.println("Actualizado: "+gamer.toString()+"\n");
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
							      }
							      try{
							         if(conexion!=null)
							        	 conexion.close();
							      	 }catch(SQLException se){
							         se.printStackTrace();
							      	 }//end finally try
							}			
				}
						
						//M�todo para actualizar la puntuaci�n de un jugador
						public void actualizarPuntuacion(Jugador gamer, int punt){
							try{
								instruccion = conexion.createStatement();
								sentencia = "UPDATE usuarios SET puntuacion=" + punt + " WHERE id=" + gamer.getId();
								instruccion.executeUpdate(sentencia);
								System.out.println("Nueva puntuaci�n m�xima para " + gamer.getNombre());
							}
							catch(SQLException excepcionSQL){
								excepcionSQL.printStackTrace();
							}
							catch(Exception e){
								e.printStackTrace();
							}
							finally{
								try{
									instruccion.close();
									conexion.close();
								}
								catch(SQLException e){
									e.printStackTrace();
								}
							}
						}
				
}