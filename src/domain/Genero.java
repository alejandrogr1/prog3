package domain;

/**
 * ============================================================
 *  ENUMERADO Genero
 * ============================================================
 *  Igual que TipoContenido, pero para los géneros.
 *  Son los MISMOS géneros que ya aparecen en el JComboBox de
 *  InterfazHome ("Acción", "Aventura", "Comedia"...), para que
 *  luego sea fácil conectar los filtros de la interfaz con el
 *  catálogo.
 * ============================================================
 */
public enum Genero {

	ACCION("Acción"),
	AVENTURA("Aventura"),
	COMEDIA("Comedia"),
	DRAMA("Drama"),
	FANTASIA("Fantasía"),
	HORROR("Horror"),
	ROMANCE("Romance");

	// Texto que se enseña en la interfaz
	private final String nombreVisible;

	Genero(String nombreVisible) {
		this.nombreVisible = nombreVisible;
	}

	public String getNombreVisible() {
		return nombreVisible;
	}

	/**
	 * Convierte un texto de la interfaz (ej: "Comedia") en el valor
	 * del enum (Genero.COMEDIA).
	 * Sirve para cuando el usuario elige un género en un JComboBox
	 * de Strings y queremos filtrar el catálogo con él.
	 *
	 * @param texto  el texto elegido en la interfaz
	 * @return el Genero que corresponde, o null si no existe
	 *         (por ejemplo "Todos", que no es un género real)
	 */
	public static Genero desdeTexto(String texto) {
		// values() devuelve un array con TODOS los valores del enum
		for (Genero g : values()) {
			// equalsIgnoreCase compara sin importar mayúsculas/minúsculas
			// muy importante para que no haya probelam si el ussuario escribe mal en el buscador
			if (g.nombreVisible.equalsIgnoreCase(texto)) {
				return g;
			}
		}
		return null; // no se ha encontrado ninguno como aviso
		// podriamos poner aqui un texto de aviso con algo mas visual en un futuro
	}

	@Override
	public String toString() {
		return nombreVisible;
	}
}