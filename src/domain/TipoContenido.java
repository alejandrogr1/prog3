package domain;

/**
 * ============================================================
 *  ENUMERADO TipoContenido
 * ============================================================
 *  Hacemos un· "enum" ne evz de un String ya que si el usuario escirbe mal al 
 *  buscar peliculas y pone PELI o peLi o peliculas en un String no saldira nada sin emabrgo el enumerador
 *  te avisa en rojo de que lo escribas de cierta manera para que te aparezcan
 *  
 *  Por eso hacemos TipoContenido.Película y TipoContenido.Serie
 *  
 * ============================================================
 */
public enum TipoContenido {

	// Cada valor lleva entre paréntesis el texto que se
	// mostrará en la interfaz (con tilde y mayúscula inicial).
	PELICULA("Película"),
	SERIE("Serie");

	// Atributo donde se guarda el textoq ue hemso dicho
	private final String nombreVisible;

	// Java lo llama automáticamente a el constructor del ENUM
	// por cada valor de arriba (PELICULA y SERIE)
	TipoContenido(String nombreVisible) {
		this.nombreVisible = nombreVisible;
	}

	// Devuelve el texto para enseñarlo en pantalla. por Ejemplo: "Película"
	public String getNombreVisible() {
		return nombreVisible;
	}

	// toString() es lo que Java usa al imprimir el objeto
	@Override
	public String toString() {
		return nombreVisible;
	}
}