package bd;

import domain.Catalogo;
import domain.Usuario;

public class MainBD {
	public static void main(String[] args) {
		BD bd = new BD();
		Catalogo c = Catalogo.crearCatalogoDeEjemplo();
		
		bd.initBD("DATABASE.db");
		bd.crearTablaPeliculas();
		bd.crearTablaSeries();
		bd.crearTablaUsuarios();
		
		bd.insertarCatalogoPeliculas(c.getPeliculas());
		bd.insertarCatalogoSeries(c.getSeries());
		
		
		Usuario u1 = new Usuario("ADMIN", "1234", "EQUIPO21", "test@gmail.com");
		bd.insertarUsuarios(u1);
		
		
		
		
		
		bd.closeBD();
	}

}
