package domain;

/**
 * ============================================================
 *  CLASE Pelicula   (hija de Contenido)
 * ============================================================
 *  "extends Contenido" significa que una Pelicula ES un Contenido:
 *  ya tiene título, género, año, sinopsis, valoración y soloVip
 *  sin tener que volver a escribirlos.
 *
 *  Lo único que añade es la DURACIÓN en minutos.
 * ============================================================
 */
public class Pelicula extends Contenido {

	// Atributo propio de las películas
	private int duracionMinutos;

	/**
	 * Constructor.
	 * super(...) llama al constructor de Contenido para rellenar
	 * los datos comunes. Después guardamos la duración.
	 */
	public Pelicula(String titulo, Genero genero, int anyo, String sinopsis,
			double valoracion, boolean soloVip, int duracionMinutos) {
		super(titulo, genero, anyo, sinopsis, valoracion, soloVip);
		this.duracionMinutos = duracionMinutos;
	}

	// --- Métodos obligatorios (eran abstractos en Contenido) ---

	@Override
	public TipoContenido getTipo() {
		return TipoContenido.PELICULA;
	}

	@Override
	public String getDuracionTexto() {
		return duracionMinutos + " min";
	}

	// --- Getter y setter propios ---

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
}