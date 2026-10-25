package domain;

/**
 * ============================================================
 *  CLASE Serie   (hija de Contenido)
 * ============================================================
 *  Igual que Pelicula, hereda todo lo común de Contenido.
 *  Lo que añade es el número de TEMPORADAS y de EPISODIOS.
 * ============================================================
 */
public class Serie extends Contenido {

	// Atributos propios de las series
	private int temporadas;
	private int episodios;

	/**
	 * Constructor.
	 * super(...) rellena los datos comunes (los de Contenido)
	 * y después guardamos temporadas y episodios.
	 */
	public Serie(String titulo, Genero genero, int anyo, String sinopsis,
			double valoracion, boolean soloVip, int temporadas, int episodios) {
		super(titulo, genero, anyo, sinopsis, valoracion, soloVip);
		this.temporadas = temporadas;
		this.episodios = episodios;
	}

	// --- Métodos obligatorios (eran abstractos en Contenido) ---

	@Override
	public TipoContenido getTipo() {
		return TipoContenido.SERIE;
	}

	@Override
	public String getDuracionTexto() {
		// Si solo hay 1 temporada escribimos "temporada" en singular
		String palabra = (temporadas == 1) ? "temporada" : "temporadas";
		return temporadas + " " + palabra + " (" + episodios + " episodios)";
	}

	// --- Getters y setters propios ---

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getEpisodios() {
		return episodios;
	}

	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}
}