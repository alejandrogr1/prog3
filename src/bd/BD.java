package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Contenido;
import domain.Pelicula;
import domain.Serie;
import domain.Usuario;

/*
 * 
Para poder conectarnos y ejecutar sentencias SQL sobre la BBDD necesitamos un objeto Connection
3 formas:
	- Declarado como atributo no static
	- Declarado como atributo static
	- No declarado como atributo -> Declarado de forma local en cada método
	                              Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
 * 
 * */
public class BD {

	private Connection con; // Nos sirve para conectarnos con la base de datos

	/**
	 * Método que realiza la conexión con la base de datos
	 * 
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void initBD(String nombreBD) {
		con = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que cierra la conexion con con la base de datos
	 */
	public void closeBD() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("No hay conexión con la BD");
		}
	}
	
	/**
	 * Metodo que crea una tabla para Peliculas
	 */
	public void crearTablaPeliculas() {
		String sql = "CREATE TABLE IF NOT EXISTS Peliculas ("
				   + "nombre String PRIMARY KEY NOT NULL,"
				   + "genero String,"
				   + "anyo int,"
				   + "descripcion String,"
				   + "rating double,"
				   + "VIP Integer,"
				   + "duracion int);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo que crea una tabla para Series
	 */
	public void crearTablaSeries() {
		String sql = "CREATE TABLE IF NOT EXISTS Series ("
				+ "nombre String PRIMARY KEY NOT NULL,"
				+ "genero String,"
				+ "anyo int,"
				+ "descripcion String,"
				+ "rating double,"
				+ "VIP Integer,"
				+ "temporadas int,"
				+ "episodios int);";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que crea una tabla para Usuarios
	 */
	public void crearTablaUsuarios() {
		String sql = "CREATE TABLE IF NOT EXISTS Usuarios ("
				+ "Usuario String PRIMARY KEY NOT NULL,"
				+ "contrasenya String," 
				+ "nombre String,"
				+ "email String);";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * Metodo que inserta Peliculas en la tabla Peliculas
	 * 
	 * @param p
	 */
	public void insertarCatalogoPeliculas(ArrayList<Contenido>l) {
		
		for (Contenido c : l) {
			
			if(c instanceof Pelicula) {
			
				Pelicula p = (Pelicula) c;
		
				String sql = "INSERT INTO Peliculas(nombre,genero,anyo,descripcion,rating,VIP,duracion)"
						+ " VALUES (?,?,?,?,?,?,?);";
				
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, p.getTitulo());
					ps.setString(2, p.getGenero().toString());
					ps.setInt(3, p.getAnyo());
					ps.setString(4, p.getSinopsis());
					ps.setDouble(5, p.getValoracion());
					ps.setInt(6, p.isSoloVip() ? 1:0);
					ps.setInt(7, p.getDuracionMinutos());
					
					ps.execute();
					ps.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metodo que inserta Series en la tabla Series
	 * @param l
	 */
	public void insertarCatalogoSeries(ArrayList<Contenido>l) {
			
			for (Contenido c : l) {
				
				if(c instanceof Serie) {
				
					Serie s = (Serie) c;
			
					String sql = "INSERT INTO Series(nombre,genero,anyo,descripcion,rating,VIP,temporadas,episodios)"
							+ " VALUES (?,?,?,?,?,?,?,?);";
					
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, s.getTitulo());
						ps.setString(2, s.getGenero().toString());
						ps.setInt(3, s.getAnyo());
						ps.setString(4, s.getSinopsis());
						ps.setDouble(5, s.getValoracion());
						ps.setInt(6, s.isSoloVip() ? 1:0);
						ps.setInt(7, s.getTemporadas());
						ps.setInt(8, s.getEpisodios());
						
						ps.execute();
						ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	
	/**
	 * Metodo que inserta Usuarios en la tabla Usuarios
	 * TODO: no hay catalogo de usuarios por lo que hay que meterlos uno a uno? TODO
	 * @param u
	 */
	public void insertarUsuarios(Usuario u) {
		
		String sql = "INSERT INTO Usuarios(Usuario,contrasenya,nombre,email) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombreUsuario());
//			ps.setString(2, null); TODO: POR QUE NO HAY UN GET PARA ESTO??????
			ps.setString(2, u.getContrasenyaEXCLUSIVOBD());
			ps.setString(3, u.getNombre());
			ps.setString(4, u.getEmail());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
