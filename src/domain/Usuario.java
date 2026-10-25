package domain;

import java.util.ArrayList;

/**
 * ============================================================
 *  CLASE Usuario   (el perfil de cada persona)
 * ============================================================
 *  Guarda:
 *   - Los DATOS del perfil: nombre de usuario, contraseña,
 *     nombre real, email y si es VIP o no.
 *   - Sus LISTAS personales: favoritos, ver más tarde (pendientes)
 *     y ya vistos.
 *
 *  Las listas son ArrayList<Contenido>: como Pelicula y Serie
 *  son Contenido, en la misma lista caben películas y series.
 *  
 *  SI SE OS OCURRE ALGUNA COSA MAS QU EME HAYA FALATDO CONSIDERAR COEMENTARLO AQUI ABAJO
 *  COMMENT:
 * ============================================================
 */
public class Usuario {

	// ------------------------------------------------------------
	//  1. DATOS DEL PERFIL
	//  "private" = solo esta clase puede tocarlos directamente.
	//  Desde fuera se usan los getters/setters (encapsulación).
	// ------------------------------------------------------------
	private String nombreUsuario;   // el que se usa para iniciar sesión (no se repite)
	private String contrasenya;
	private String nombre;          // nombre real, para mostrar en el perfil
	private String email;
	private boolean vip;            // true = tiene suscripción VIP

	// ------------------------------------------------------------
	//  2. LISTAS DEL USUARIO
	// ------------------------------------------------------------
	private ArrayList<Contenido> favoritos;
	private ArrayList<Contenido> pendientes;   // "Ver más tarde"
	private ArrayList<Contenido> vistos;

	// ------------------------------------------------------------
	//  3. CONSTRUCTOR
	//  Un usuario nuevo empieza como NO VIP y con las listas vacías.
	// ------------------------------------------------------------
	public Usuario(String nombreUsuario, String contrasenya, String nombre, String email) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.email = email;
		this.vip = false;

		// Hay que crear las listas con "new"; si no, valdrían null
		// y el programa fallaría al intentar añadir algo.
		this.favoritos = new ArrayList<>();
		this.pendientes = new ArrayList<>();
		this.vistos = new ArrayList<>();
	}

	// ------------------------------------------------------------
	//  4. INICIO DE SESIÓN
	// ------------------------------------------------------------

	/**
	 * Comprueba si la contraseña escrita es la correcta.
	 * Se usará en la ventana de login.
	 *
	 * @param contrasenyaEscrita lo que el usuario ha tecleado
	 * @return true si coincide, false si no
	 */
	public boolean comprobarContrasenya(String contrasenyaEscrita) {
		// equals compara el TEXTO. (Con == se compararía si son el
		// mismo objeto en memoria, que no es lo que queremos).
		return contrasenya.equals(contrasenyaEscrita);
	}

	// ------------------------------------------------------------
	//  5. FAVORITOS
	// ------------------------------------------------------------

	/**
	 * Añade un contenido a favoritos, SOLO si no estaba ya.
	 * @return true si se ha añadido, false si ya estaba
	 */
	public boolean añadirFavorito(Contenido c) {
		if (favoritos.contains(c)) {
			return false;              // ya estaba: no lo repetimos
		}
		favoritos.add(c);
		return true;
	}

	/** Quita un contenido de favoritos. Devuelve true si estaba y se ha quitado. */
	// con remove al elimianrlo si no me equivoco te pasa el valor
	// en un futro si se ordena bein quizas se pdoria hacer ocn RemoveFirst
	public boolean eliminarFavorito(Contenido c) {
		return favoritos.remove(c);
	}

	/** Dice si un contenido está en favoritos (útil para pintar el botón de "corazón"). */
	public boolean esFavorito(Contenido c) {
		return favoritos.contains(c);
	}

	// ------------------------------------------------------------
	//  6. PENDIENTES ("Ver más tarde")
	// ------------------------------------------------------------

	public boolean añadirPendiente(Contenido c) {
		if (pendientes.contains(c)) {
			return false;
		}
		pendientes.add(c);
		return true;
	}

	public boolean eliminarPendiente(Contenido c) {
		return pendientes.remove(c);
	}

	// ------------------------------------------------------------
	//  7. VISTOS
	// ------------------------------------------------------------

	/**
	 * Marca un contenido como visto.
	 * Si estaba en "pendientes", lo quitamos de ahí, porque ya
	 * no está pendiente de ver.
	 */
	public boolean marcarComoVisto(Contenido c) {
		pendientes.remove(c);
		if (vistos.contains(c)) {
			return false;
		}
		vistos.add(c);
		return true;
	}

	// ------------------------------------------------------------
	//  8. VIP
	//  Que solo se pueda ver lo VIP siendo VIP.
	// ------------------------------------------------------------

	/**
	 * Dice si este usuario puede ver un contenido:
	 *  - Si el contenido es gratuito  -> siempre puede.
	 *  - Si el contenido es solo VIP  -> solo si el usuario es VIP.
	 */
	public boolean puedeVer(Contenido c) {
		return !c.isSoloVip() || vip;
	}

	// ------------------------------------------------------------
	//  9. GETTERS Y SETTERS
	// ------------------------------------------------------------
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public ArrayList<Contenido> getFavoritos() {
		return favoritos;
	}

	public ArrayList<Contenido> getPendientes() {
		return pendientes;
	}

	public ArrayList<Contenido> getVistos() {
		return vistos;
	}

	// ------------------------------------------------------------
	//  10. equals()
	//  Dos usuarios son "el mismo" si tienen el MISMO nombre de
	//  usuario (sin importar mayúsculas). Esto servirá después
	//  para detectar nombres de usuario repetidos al registrarse.
	// ------------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;                         // es exactamente el mismo objeto
		}
		if (!(obj instanceof Usuario)) {
			return false;                        // no es un Usuario
		}
		Usuario otro = (Usuario) obj;
		return nombreUsuario.equalsIgnoreCase(otro.nombreUsuario);
	}

	// Regla de Java: si se sobrescribe equals, también hashCode.
	@Override
	public int hashCode() {
		return nombreUsuario.toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		return nombreUsuario + (vip ? " [VIP]" : "");
	}
}