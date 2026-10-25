package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.Catalogo;
import domain.Contenido;
import domain.Genero;
import domain.TipoContenido;
import domain.Usuario;

/**
 * ============================================================
 *  VENTANA VentanaCatalogo
 * ============================================================
 *  Ventana NUEVA que enseña cómo la interfaz usa las clases del
 *  paquete "domain" (Catalogo, Contenido, Usuario...).
 *  No modifica ninguna ventana que ya existía.
 *
 *  Qué hace:
 *   - Muestra el catálogo en tarjetas (imagen + título + datos).
 *   - Filtro "Tipo": eliges Serie -> salen solo series;
 *                    eliges Película -> salen solo películas.
 *   - Filtro "Género", buscador y "Ordenar por".
 *   - Al pulsar una tarjeta se ven sus detalles y se puede
 *     añadir a Favoritos o a Ver más tarde del usuario.
 *
 *  Se puede probar sola con su main() (Run As > Java Application).
 * ============================================================
 */
public class VentanaCatalogo extends JFrame {

	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------------
	//  1. DATOS (el "modelo")
	// ------------------------------------------------------------
	private Catalogo catalogo;   // todas las películas y series
	private Usuario usuario;     // el usuario que ha iniciado sesión

	// ------------------------------------------------------------
	//  2. COMPONENTES DE LA INTERFAZ que necesitamos leer o cambiar
	//     después (por eso son atributos y no variables locales)
	// ------------------------------------------------------------
	private JTextField campoBuscar;
	private JComboBox<String> comboTipo;
	private JComboBox<String> comboGenero;
	private JComboBox<String> comboOrden;
	private JPanel panelTarjetas;     // donde se pintan las tarjetas
	private JLabel labelResultados;   // "Mostrando 7 de 14"

	// Herramientas que ya hizo el grupo (menú, redimensionar imágenes...)
	private InterfazHerramientas herramientas = new InterfazHerramientas();

	// ------------------------------------------------------------
	//  3. CONSTRUCTOR: monta la ventana
	// ------------------------------------------------------------
	public VentanaCatalogo(Catalogo catalogo, Usuario usuario) {
		this.catalogo = catalogo;
		this.usuario = usuario;

		// Propiedades de la ventana (igual que el resto de interfaces)
		setTitle("Catálogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setJMenuBar(herramientas.añadirMenu(this));   // menú ya hecho por el grupo
		setLayout(new BorderLayout());

		// La ventana tiene 3 zonas: arriba, centro y abajo
		add(crearCabecera(), BorderLayout.NORTH);
		add(crearZonaTarjetas(), BorderLayout.CENTER);
		add(crearPie(), BorderLayout.SOUTH);

		// Pintamos el catálogo por primera vez (sin filtros)
		actualizarTarjetas();

		setVisible(true);
	}

	// ------------------------------------------------------------
	//  4. CABECERA: título, usuario y barra de filtros
	// ------------------------------------------------------------
	private JPanel crearCabecera() {
		// --- Fila de arriba: título a la izquierda, usuario a la derecha
		JLabel titulo = new JLabel("Catálogo");
		titulo.setFont(new Font("Verdana", Font.BOLD, 35));

		JLabel labelUsuario = new JLabel("Usuario: " + usuario.getNombre()
				+ (usuario.isVip() ? "  [VIP]" : "  (gratuito)"));
		labelUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));

		JPanel filaTitulo = new JPanel(new BorderLayout());
		filaTitulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
		filaTitulo.add(titulo, BorderLayout.WEST);
		filaTitulo.add(labelUsuario, BorderLayout.EAST);

		// --- Buscador
		campoBuscar = new JTextField(20);
		campoBuscar.setPreferredSize(new Dimension(300, 35));
		JButton botonBuscar = new JButton("Buscar");

		// --- Combo de TIPO, construido a partir del enum TipoContenido.
		//     Posición 0 = "Todos"; después Película, Serie...
		comboTipo = new JComboBox<>();
		comboTipo.addItem("Todos");
		for (TipoContenido t : TipoContenido.values()) {
			comboTipo.addItem(t.getNombreVisible());
		}

		// --- Combo de GÉNERO, igual pero con el enum Genero
		comboGenero = new JComboBox<>();
		comboGenero.addItem("Todos");
		for (Genero g : Genero.values()) {
			comboGenero.addItem(g.getNombreVisible());
		}

		// --- Combo de ORDEN
		comboOrden = new JComboBox<>(new String[] {
				"Título (A-Z)", "Mejor valorados", "Nuevos" });

		// --- Un único "escuchador" para todo: cuando cambia cualquier
		//     filtro o se pulsa Buscar/Enter, se vuelven a pintar las tarjetas.
		ActionListener alCambiarFiltro = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarTarjetas();
			}
		};
		botonBuscar.addActionListener(alCambiarFiltro);
		campoBuscar.addActionListener(alCambiarFiltro);   // al pulsar Enter
		comboTipo.addActionListener(alCambiarFiltro);
		comboGenero.addActionListener(alCambiarFiltro);
		comboOrden.addActionListener(alCambiarFiltro);

		// --- Colocamos todo en una fila
		JPanel filaFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
		filaFiltros.add(campoBuscar);
		filaFiltros.add(botonBuscar);
		filaFiltros.add(new JLabel("   Tipo:"));
		filaFiltros.add(comboTipo);
		filaFiltros.add(new JLabel("   Género:"));
		filaFiltros.add(comboGenero);
		filaFiltros.add(new JLabel("   Ordenar por:"));
		filaFiltros.add(comboOrden);

		// --- Juntamos las dos filas
		JPanel cabecera = new JPanel(new BorderLayout());
		cabecera.add(filaTitulo, BorderLayout.NORTH);
		cabecera.add(filaFiltros, BorderLayout.CENTER);
		return cabecera;
	}

	// ------------------------------------------------------------
	//  5. ZONA CENTRAL: rejilla de tarjetas con barra de scroll
	// ------------------------------------------------------------
	private JScrollPane crearZonaTarjetas() {
		// GridLayout(0, 7): 7 columnas y las filas que hagan falta (0 = automático)
		panelTarjetas = new JPanel(new GridLayout(0, 7, 20, 30));

		// Lo metemos arriba de otro panel para que las tarjetas no se
		// estiren hasta abajo cuando hay pocas.
		JPanel contenedor = new JPanel(new BorderLayout());
		contenedor.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		contenedor.add(panelTarjetas, BorderLayout.NORTH);

		JScrollPane scroll = new JScrollPane(contenedor);
		scroll.getVerticalScrollBar().setUnitIncrement(16);   // scroll más suave
		scroll.setBorder(null);
		return scroll;
	}

	// ------------------------------------------------------------
	//  6. PIE: cuántos resultados se están mostrando
	// ------------------------------------------------------------
	private JPanel crearPie() {
		labelResultados = new JLabel();
		labelResultados.setFont(new Font("Verdana", Font.ITALIC, 14));
		JPanel pie = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 8));
		pie.add(labelResultados);
		return pie;
	}

	// ------------------------------------------------------------
	//  7. EL MÉTODO IMPORTANTE: leer filtros -> pedir lista -> pintar
	// ------------------------------------------------------------
	private void actualizarTarjetas() {

		// PASO 1: traducir lo elegido en los combos a los enum.
		//         Posición 0 es "Todos" -> null (= no filtrar).
		TipoContenido tipo = null;
		int posTipo = comboTipo.getSelectedIndex();
		if (posTipo > 0) {
			// -1 porque en el combo hay "Todos" delante de los valores del enum
			tipo = TipoContenido.values()[posTipo - 1];
		}

		// Para el género usamos el método que ya tiene el enum
		// ("Todos" no es un género, así que desdeTexto devuelve null)
		Genero genero = Genero.desdeTexto((String) comboGenero.getSelectedItem());

		// PASO 2: pedir al catálogo la lista filtrada
		ArrayList<Contenido> lista = catalogo.filtrar(tipo, genero);

		// PASO 3: aplicar el buscador (si hay algo escrito)
		String texto = campoBuscar.getText();
		if (!texto.trim().isEmpty()) {
			lista = Catalogo.buscar(lista, texto);
		}

		// PASO 4: ordenar según lo elegido
		String orden = (String) comboOrden.getSelectedItem();
		if (orden.equals("Mejor valorados")) {
			Catalogo.ordenarPorValoracion(lista);
		} else if (orden.equals("Nuevos")) {
			Catalogo.ordenarPorAnyo(lista);
		} else {
			Catalogo.ordenarPorTitulo(lista);
		}

		// PASO 5: borrar las tarjetas viejas y pintar las nuevas
		panelTarjetas.removeAll();
		for (Contenido c : lista) {
			panelTarjetas.add(crearTarjeta(c));
		}

		// Si no hay nada, lo decimos
		if (lista.isEmpty()) {
			JLabel vacio = new JLabel("No hay resultados");
			vacio.setFont(new Font("Verdana", Font.ITALIC, 18));
			panelTarjetas.add(vacio);
		}

		labelResultados.setText("Mostrando " + lista.size() + " de " + catalogo.getTamanyo());

		// Avisar a Swing de que el contenido ha cambiado para que lo repinte
		panelTarjetas.revalidate();
		panelTarjetas.repaint();
	}

	// ------------------------------------------------------------
	//  8. UNA TARJETA = imagen + título + datos de un contenido
	//     (mismo estilo que añadirPanelPeli() de InterfazHerramientas,
	//      pero con datos reales del catálogo)
	// ------------------------------------------------------------
	private JPanel crearTarjeta(final Contenido c) {
		JPanel tarjeta = new JPanel(new BorderLayout(0, 5));

		// --- Imagen: la de películas o la de series según el tipo
		String rutaImagen = (c.getTipo() == TipoContenido.PELICULA)
				? "/images/pelis.png" : "/images/serie.png";
		ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
		icono = herramientas.imageResize(icono, 150, 150);

		JButton botonImagen = new JButton(icono);
		botonImagen.setPreferredSize(new Dimension(200, 190));
		botonImagen.setBackground(Color.WHITE);
		botonImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// --- Título (en negrita)
		JLabel labelTitulo = new JLabel(c.getTitulo(), SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 14));

		// --- Datos: "Serie · Drama · 2008 · 4.9/5"
		JLabel labelDatos = new JLabel(c.getTipo().getNombreVisible() + " · "
				+ c.getGenero() + " · " + c.getAnyo() + " · " + c.getValoracion() + "/5",
				SwingConstants.CENTER);
		labelDatos.setFont(new Font("Verdana", Font.PLAIN, 12));

		// --- Si es VIP, lo marcamos en dorado
		JLabel labelVip = new JLabel(c.isSoloVip() ? "VIP" : "GRATIS", SwingConstants.CENTER);
		labelVip.setFont(new Font("Verdana", Font.BOLD, 12));
		labelVip.setForeground(c.isSoloVip() ? new Color(200, 150, 0) : new Color(0, 130, 0));

		JPanel textos = new JPanel(new GridLayout(3, 1));
		textos.add(labelTitulo);
		textos.add(labelDatos);
		textos.add(labelVip);

		tarjeta.add(botonImagen, BorderLayout.CENTER);
		tarjeta.add(textos, BorderLayout.SOUTH);

		// --- Al pulsar la imagen se abren los detalles de ESTE contenido
		botonImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarDetalles(c);
			}
		});

		return tarjeta;
	}

	// ------------------------------------------------------------
	//  9. DETALLES de un contenido + botones Favoritos / Ver más tarde
	// ------------------------------------------------------------
	private void mostrarDetalles(Contenido c) {
		// Texto con los datos. getDuracionTexto() es POLIMORFISMO:
		// en una película da "169 min" y en una serie "5 temporadas (62 episodios)".
		String info = "Tipo: " + c.getTipo().getNombreVisible() + "\n"
				+ "Género: " + c.getGenero() + "\n"
				+ "Año: " + c.getAnyo() + "\n"
				+ "Duración: " + c.getDuracionTexto() + "\n"
				+ "Valoración: " + c.getValoracion() + " / 5\n"
				+ "Acceso: " + (c.isSoloVip() ? "Solo VIP" : "Gratuito") + "\n\n"
				+ c.getSinopsis();

		// Si es VIP y el usuario no lo es, se lo avisamos
		if (!usuario.puedeVer(c)) {
			info += "\n\nAVISO: Necesitas ser VIP para ver este contenido.";
		}

		// Ventana emergente con 3 botones. Devuelve la posición del pulsado.
		String[] opciones = { "Añadir a favoritos", "Ver más tarde", "Cerrar" };
		int eleccion = JOptionPane.showOptionDialog(this, info, c.getTitulo(),
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, opciones, opciones[2]);

		if (eleccion == 0) {
			boolean añadido = usuario.añadirFavorito(c);
			JOptionPane.showMessageDialog(this, añadido
					? "\"" + c.getTitulo() + "\" añadido a favoritos."
					: "Ya estaba en favoritos.");
		} else if (eleccion == 1) {
			boolean añadido = usuario.añadirPendiente(c);
			JOptionPane.showMessageDialog(this, añadido
					? "\"" + c.getTitulo() + "\" añadido a Ver más tarde."
					: "Ya estaba en Ver más tarde.");
		}
	}

	// ------------------------------------------------------------
	//  10. MAIN DE PRUEBA
	//  Crea un catálogo y un usuario de ejemplo y abre la ventana.
	//  En Eclipse: clic derecho en este archivo > Run As > Java Application
	// ------------------------------------------------------------
	public static void main(String[] args) {
		Catalogo catalogo = Catalogo.crearCatalogoDeEjemplo();
		Usuario usuario = new Usuario("xabier", "1234", "Xabier", "xabier@ejemplo.com");
		new VentanaCatalogo(catalogo, usuario);
	}
}