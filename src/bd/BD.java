package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void closeBD() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}




















