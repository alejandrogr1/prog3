package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ============================================================
 *  CLASE Catalogo
 * ============================================================
 *  Guarda TODAS las películas y series de la plataforma en una
 *  sola lista, y ofrece métodos para sacar solo lo que queremos:
 *
 *   - getPeliculas()        -> solo películas
 *   - getSeries()           -> solo series
 *   - filtrar(tipo, genero) -> lo que elija el usuario en los filtros
 *   - buscar(texto)         -> lo que escriba en el buscador
 *   - ordenarPorTitulo / ordenarPorValoracion / ordenarPorAnyo
 *
 *  La interfaz NO tiene que saber cómo se filtra: solo le pide
 *  la lista al catálogo y la pinta.
 * ============================================================
 */
public class Catalogo {

	// Lista con todo el contenido (películas y series mezcladas)
	private ArrayList<Contenido> contenidos;

	// ------------------------------------------------------------
	//  1. CONSTRUCTOR: empieza con el catálogo vacío
	// ------------------------------------------------------------
	public Catalogo() {
		contenidos = new ArrayList<>();
	}

	// ------------------------------------------------------------
	//  2. AÑADIR Y CONSULTAR
	// ------------------------------------------------------------

	public void añadirContenido(Contenido c) {
		//lo vamos añadiendo a contenidos
		contenidos.add(c);
	}

	/** Devuelve todo el catálogo. */
	public ArrayList<Contenido> getTodos() {
		return contenidos;
	}

	/** Número total de contenidos. */
	public int getTamanyo() {
		return contenidos.size();
	}

	// ------------------------------------------------------------
	//  3. FILTRAR POR TIPO  (película o serie)
	//  Aquí es donde usamos el enum TipoContenido.
	// ------------------------------------------------------------

	/**
	 * Devuelve solo los contenidos del tipo pedido.
	 * Ej: getPorTipo(TipoContenido.SERIE) -> solo series.
	 */
	public ArrayList<Contenido> getPorTipo(TipoContenido tipo) {
		ArrayList<Contenido> resultado = new ArrayList<>();
		// Recorremos el catálogo y nos quedamos con los del tipo pedido
		for (Contenido c : contenidos) {
			if (c.getTipo() == tipo) {
				resultado.add(c);
			}
		}
		return resultado;
	}

	/** Atajo: solo películas. */
	public ArrayList<Contenido> getPeliculas() {
		return getPorTipo(TipoContenido.PELICULA);
	}

	/** Atajo: solo series. */
	public ArrayList<Contenido> getSeries() {
		return getPorTipo(TipoContenido.SERIE);
	}

	// ------------------------------------------------------------
	//  4. FILTRO COMBINADO  (lo que usarán los JComboBox)
	// ------------------------------------------------------------

	/**
	 * Filtra por tipo y género a la vez.
	 * Si un parámetro es null, significa "Todos" (no se filtra por él).
	 *
	 * Ejemplos:
	 *   filtrar(null, null)                       -> todo
	 *   filtrar(TipoContenido.SERIE, null)        <- todas las series
	 *   filtrar(null, Genero.COMEDIA)             <- todas las comedias
	 *   filtrar(TipoContenido.PELICULA, Genero.DRAMA) -> películas de drama
	 */
	public ArrayList<Contenido> filtrar(TipoContenido tipo, Genero genero) {
		ArrayList<Contenido> resultado = new ArrayList<>();
		for (Contenido c : contenidos) {
			boolean cumpleTipo = (tipo == null) || (c.getTipo() == tipo);
			boolean cumpleGenero = (genero == null) || (c.getGenero() == genero);

			if (cumpleTipo && cumpleGenero) {
				resultado.add(c);
			}
		}
		return resultado;
	}

	// ------------------------------------------------------------
	//  5. BUSCADOR
	// ------------------------------------------------------------

	/**
	 * Busca dentro de una lista los contenidos cuyo título CONTIENE
	 * el texto escrito, sin importar mayúsculas o las minúsculas.
	 * Ej: "the" encuentra "The Office" y "The Mandalorian".
	 *
	 */
	public static ArrayList<Contenido> buscar(ArrayList<Contenido> lista, String texto) {
		ArrayList<Contenido> resultado = new ArrayList<>();
		// Pasamos todo a minúsculas para que "STAR" y "star" sean iguales
		String textoMinus = texto.trim().toLowerCase();

		for (Contenido c : lista) {
			if (c.getTitulo().toLowerCase().contains(textoMinus)) {
				resultado.add(c);
			}
		}
		return resultado;
	}

	// ------------------------------------------------------------
	//  6. ORDENAR
	//  Collections.sort ordena una lista usando un Comparator,
	//  que es la "regla" que dice cuál va antes.
	//  Son "static" porque no dependen del catálogo: ordenan
	//  cualquier lista que les pasemos.
	// ------------------------------------------------------------

	/** Ordena de la A a la Z por título. */
	public static void ordenarPorTitulo(ArrayList<Contenido> lista) {
		Collections.sort(lista, new Comparator<Contenido>() {
			@Override
			public int compare(Contenido a, Contenido b) {
				return a.getTitulo().compareToIgnoreCase(b.getTitulo());
			}
		});
	}

	/** Ordena de MEJOR a PEOR valoración (5 estrellas primero). */
	public static void ordenarPorValoracion(ArrayList<Contenido> lista) {
		Collections.sort(lista, new Comparator<Contenido>() {
			@Override
			public int compare(Contenido a, Contenido b) {
				// b antes que a -> orden descendente (de mayor a menor)
				return Double.compare(b.getValoracion(), a.getValoracion());
			}
		});
	}

	/** Ordena de MÁS NUEVO a más antiguo. */
	public static void ordenarPorAnyo(ArrayList<Contenido> lista) {
		Collections.sort(lista, new Comparator<Contenido>() {
			@Override
			public int compare(Contenido a, Contenido b) {
				return Integer.compare(b.getAnyo(), a.getAnyo());
			}
		});
	}

	// ------------------------------------------------------------
	//  7. DATOS DE EJEMPLO
	//  Mientras no tengamos fichero o base de datos, creamos el
	//  catálogo "a mano" para poder probar la interfaz.
	//  Uso:  Catalogo catalogo = Catalogo.crearCatalogoDeEjemplo();
	// ------------------------------------------------------------
	public static Catalogo crearCatalogoDeEjemplo() {
		Catalogo cat = new Catalogo();

		// ---------- PELÍCULAS ----------
		// new Pelicula(título, género, año, sinopsis, valoración, soloVip, minutos)
		cat.añadirContenido(new Pelicula("Interstellar", Genero.AVENTURA, 2014,
				"Un grupo de astronautas viaja por un agujero de gusano para buscar un nuevo hogar para la humanidad.",
				4.8, false, 169));
		cat.añadirContenido(new Pelicula("Mad Max: Fury Road", Genero.ACCION, 2015,
				"En un desierto postapocalíptico, una guerrera huye de un tirano con la ayuda de un vagabundo.",
				4.5, true, 120));
		cat.añadirContenido(new Pelicula("Superbad", Genero.COMEDIA, 2007,
				"Dos amigos inseparables intentan conseguir bebida para una fiesta antes de acabar el instituto.",
				4.0, false, 113));
		cat.añadirContenido(new Pelicula("Cadena perpetua", Genero.DRAMA, 1994,
				"Un banquero condenado injustamente forja una amistad en prisión a lo largo de los años.",
				4.9, true, 142));
		cat.añadirContenido(new Pelicula("El viaje de Chihiro", Genero.FANTASIA, 2001,
				"Una niña queda atrapada en un mundo de espíritus y debe trabajar en una casa de baños para salvar a sus padres.",
				4.7, false, 125));
		cat.añadirContenido(new Pelicula("Expediente Warren", Genero.HORROR, 2013,
				"Dos investigadores de lo paranormal ayudan a una familia aterrorizada en su nueva granja.",
				4.1, false, 112));
		cat.añadirContenido(new Pelicula("La La Land", Genero.ROMANCE, 2016,
				"Una actriz y un pianista de jazz se enamoran mientras persiguen sus sueños en Los Ángeles.",
				4.4, true, 128));

		// ---------- SERIES ----------
		// new Serie(título, género, año, sinopsis, valoración, soloVip, temporadas, episodios)
		cat.añadirContenido(new Serie("Breaking Bad", Genero.DRAMA, 2008,
				"Un profesor de química con cáncer se convierte en fabricante de droga para asegurar el futuro de su familia.",
				4.9, true, 5, 62));
		cat.añadirContenido(new Serie("Stranger Things", Genero.HORROR, 2016,
				"Un grupo de niños busca a su amigo desaparecido y descubre experimentos secretos y un mundo paralelo.",
				4.6, false, 5, 42));
		cat.añadirContenido(new Serie("The Office", Genero.COMEDIA, 2005,
				"El día a día de los empleados de una oficina de papel, grabado como un falso documental.",
				4.5, false, 9, 201));
		cat.añadirContenido(new Serie("Juego de Tronos", Genero.FANTASIA, 2011,
				"Varias familias nobles luchan por el control del Trono de Hierro de los Siete Reinos.",
				4.7, true, 8, 73));
		cat.añadirContenido(new Serie("La casa de papel", Genero.ACCION, 2017,
				"Un misterioso profesor reúne a un grupo de atracadores para el mayor golpe de la historia de España.",
				4.3, false, 5, 41));
		cat.añadirContenido(new Serie("The Mandalorian", Genero.AVENTURA, 2019,
				"Un cazarrecompensas solitario recorre la galaxia protegiendo a una misteriosa criatura.",
				4.4, true, 3, 24));
		cat.añadirContenido(new Serie("Normal People", Genero.ROMANCE, 2020,
				"Dos jóvenes de un pueblo irlandés mantienen una relación intermitente desde el instituto hasta la universidad.",
				4.2, false, 1, 12));

		return cat;
	}
}