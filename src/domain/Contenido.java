package domain;

/**
 * ============================================================
 *  CLASE ABSTRACTA Contenido
 * ============================================================
 *  Representa CUALQUIER cosa que se puede ver en la plataforma:
 *  una película o una serie.
 *
 *  ¿Por qué "abstract"?
 *   - Porque nunca vamos a crear un "Contenido" a secas. Siempre
 *     será una Pelicula o una Serie.
 *   - Aquí ponemos lo que TIENEN EN COMÚN las dos (título, género,
 *     año, sinopsis...). Así no repetimos código.
 *   - Pelicula y Serie "heredan" (extends) de esta clase y solo
 *     añaden lo que es propio de cada una.
 *
 *        Contenido  (lo común)
 *          ├── Pelicula  (+ duración en minutos)
 *          └── Serie     (+ temporadas y episodios)
 * ============================================================
 */
public abstract class Contenido {

	// ------------------------------------------------------------
	//  1. ATRIBUTOS
	//  "protected" = los pueden usar esta clase y sus hijas
	//  (Pelicula y Serie), pero no el resto del programa.
	// ------------------------------------------------------------
	protected String titulo;
	protected Genero genero;          // enum Genero (ACCION, DRAMA...)
	protected int anyo;               // año de estreno
	protected String sinopsis;        // resumen corto
	protected double valoracion;      // nota media de 0 a 5 estrellas
	protected boolean soloVip;        // true = hace falta ser VIP para verlo

	// ------------------------------------------------------------
	//  2. CONSTRUCTOR
	//  Se ejecuta al hacer "new Pelicula(...)" o "new Serie(...)",
	//  porque las hijas lo llaman con super(...).
	// ------------------------------------------------------------
	public Contenido(String titulo, Genero genero, int anyo, String sinopsis,
		double valoracion, boolean soloVip) {
		this.titulo = titulo;
		this.genero = genero;
		this.anyo = anyo;
		this.sinopsis = sinopsis;
		this.valoracion = valoracion;
		this.soloVip = soloVip;
	}

	// ------------------------------------------------------------
	//  3. MÉTODOS ABSTRACTOS
	//  No tienen código aquí: cada hija los escribe a su manera. 
	// ------------------------------------------------------------

	/** Dice si es PELICULA o SERIE. */
	public abstract TipoContenido getTipo();

	/** Texto de la duración. Ej: "148 min" o "5 temporadas (62 episodios)". */
	public abstract String getDuracionTexto();

	// ------------------------------------------------------------
	//  4. GETTERS Y SETTERS
	//  Sirven para leer (get) o cambiar (set) los atributos desde
	//  fuera de la clase de forma controlada.
	// ------------------------------------------------------------
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public double getValoracion() {
		return valoracion;
	}

	/**
	 * Cambia la valoración, pero SOLO si está entre 0 y 5.
	 * Si nos pasan un valor fuera de rango, no hacemos nada.
	 */
	public void setValoracion(double valoracion) {
		if (valoracion >= 0 && valoracion <= 5) {
			this.valoracion = valoracion;
		}
	}

	public boolean isSoloVip() {
		return soloVip;
	}

	public void setSoloVip(boolean soloVip) {
		this.soloVip = soloVip;
	}

	// ------------------------------------------------------------
	//  5. toString()
	//  Es lo que se ve al hacer System.out.println(contenido)
	// ------------------------------------------------------------
	@Override
	public String toString() {
		return titulo + " (" + anyo + ")";
	}
}