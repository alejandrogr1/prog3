package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InterfazHome extends JFrame {

	private static final long serialVersionUID = 1L;	
	public InterfazHome() {
		
		//--------VENTANA--------
		
	//Estructura de la ventana, tamaño fijo, centrada en la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
	//Añadir el MenuBar
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		setLayout(new BorderLayout());
		
		//--------BUSCADOR--------
		
		JPanel panelBuscador = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		JTextField textobuscador = new JTextField("Buscar...", 20);
		textobuscador.setPreferredSize(new Dimension(450, 40));
		
		ImageIcon iconoLupa = new ImageIcon(getClass().getResource("/images/Lupa.png"));
		iconoLupa = imageResize(iconoLupa, 30, 30);
		JButton botonLupa = new JButton(iconoLupa);
		botonLupa.setPreferredSize(new Dimension(50, 40));
		
		panelBuscador.add(textobuscador);
		panelBuscador.add(botonLupa);	
		
		//--------NOTIFICACIONES Y PERFIL--------
		
	//Panel con los botones notificación y perfil alineados a la derecha
		JPanel panelNotificacion = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
		
		ImageIcon iconoNotificacion = new ImageIcon(getClass().getResource("/images/notis.png"));
		iconoNotificacion = imageResize(iconoNotificacion, 50, 50);
		JButton botonNotificacion = new JButton(iconoNotificacion);
		botonNotificacion.setPreferredSize(new Dimension(70, 60));
		
		ImageIcon iconoPerfil = new ImageIcon(getClass().getResource("/images/Perfil.png"));
		iconoPerfil = imageResize(iconoPerfil, 50, 50);
		JButton botonPerfil = new JButton(iconoPerfil);
		botonPerfil.setPreferredSize(new Dimension(70, 60));
		
		panelNotificacion.add(botonNotificacion);
		panelNotificacion.add(botonPerfil);
		
	//Panel vacio a la izquierda para alinear correctamente el buscador,
	//con el mismo ancho que el panel notificaciones
		JPanel panelVacioIzq = new JPanel();
		panelVacioIzq.setPreferredSize(panelNotificacion.getPreferredSize());
		
		//--------FILTROS--------
		
		JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));	
		JLabel labelGenero = new JLabel("Género: ");
		String[] generos = {"Todos", "Acción", "Aventura", "Comedia", "Drama", "Fantasía", "Horror", "Romance"};
		JComboBox<String> comboGeneros = new JComboBox<>(generos);
		
		JLabel labelTipo = new JLabel("Tipo: ");
		String[] tipos = {"Todos", "Serie", "Película"};
		JComboBox<String> comboTipos = new JComboBox<>(tipos);
		
		JLabel labelOrden = new JLabel("Ordenar por: ");
		String[] orden = {"Más populares", "Mejor valorados", "Título(A-Z)", "Nuevos"};
		JComboBox<String> comboOrden = new JComboBox<>(orden);
		
		
		panelFiltros.add(labelGenero);
		panelFiltros.add(comboGeneros);
		panelFiltros.add(labelTipo);
		panelFiltros.add(comboTipos);
		panelFiltros.add(labelOrden);
		panelFiltros.add(comboOrden);
		
		//--------CABECERA--------
		
	//Panel contenedor de paneles buscador en el centro, notificacion y perfil a la derecha
		JPanel panelSuperior = new JPanel(new BorderLayout());
		panelSuperior.add(panelBuscador, BorderLayout.CENTER);
		panelSuperior.add(panelNotificacion, BorderLayout.EAST);
		panelSuperior.add(panelVacioIzq, BorderLayout.WEST);
		
	//Panel contenedor de panel superior arriba y filtros abajo; todo colocado en la parte superior
	//de la ventana
		JPanel panelCabecera = new JPanel(new BorderLayout());
		panelCabecera.add(panelSuperior, BorderLayout.NORTH);
		panelCabecera.add(panelFiltros, BorderLayout.CENTER);
		
		add(panelCabecera, BorderLayout.NORTH);
		
		
		//--------BANNER--------
		
	//CardLayout que muestra un solo panel a la vez, les llamo "cartas"
		CardLayout cartas = new CardLayout();
		JPanel panelCartas = new JPanel(cartas);
		
		panelCartas.add(crearCarta("Película 1", Color.RED), "carta 1");
		panelCartas.add(crearCarta("Película 2", Color.BLUE), "carta 2");
		panelCartas.add(crearCarta("Película 3", Color.GREEN), "carta 3");
	//Flechas izquierda y derecha para pasar a la siguiente carta o a la anterior	
		JButton flechaIzquierda = new JButton("<");
		JButton flechaDerecha = new JButton(">");
		flechaIzquierda.addActionListener(e -> cartas.previous(panelCartas));
		flechaDerecha.addActionListener(e -> cartas.next(panelCartas));
	//Panel del banner, cartas en el centro y flechas a los lados
		JPanel panelBanner = new JPanel(new BorderLayout());
		panelBanner.setPreferredSize(new Dimension(1800, 400));
		panelBanner.add(flechaIzquierda, BorderLayout.WEST);
		panelBanner.add(flechaDerecha, BorderLayout.EAST);
		panelBanner.add(panelCartas, BorderLayout.CENTER);
		
	//Panel contenedor, banner arriba y seguir viendo debajo
		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.add(panelBanner, BorderLayout.NORTH);
		
		add(panelCentro, BorderLayout.CENTER);
		//--------SEGUIR VIENDO--------
		
	//Panel de Seguir viendo con fila de peliculas que reutiliza añadirPanelPeli de InterfazHerramientas
		JPanel panelSeguirViendo = new JPanel(new BorderLayout());
		
		JLabel labelSeguirViendo = new JLabel("Seguir viendo");
		labelSeguirViendo.setFont(new Font("Verdana", Font.BOLD, 22));
		
		JPanel panelFilaPelis = new JPanel(new GridLayout(1, 6, 15, 0));
		
		for (int i = 0; i < 6; i++) {
			panelFilaPelis.add(new InterfazHerramientas().añadirPanelPeli());
		}
		
		panelSeguirViendo.add(labelSeguirViendo, BorderLayout.NORTH);
		panelSeguirViendo.add(panelFilaPelis, BorderLayout.CENTER);
	//Añadimos seguir viendo al panel contenedor junto con el banner
		panelCentro.add(panelSeguirViendo, BorderLayout.CENTER);
		
		
		setVisible(true);
	}	
	
	//--------FUNCION PARA CREAR CARTA EN EL CARDLAYOUT--------
	//Las cartas son un panel que contienen un boton de color que ocupa el espacio entero de la carta
	private JPanel crearCarta(String titulo, Color color) {
		JPanel carta = new JPanel(new BorderLayout());
		
		JButton boton = new JButton(titulo);
		boton.setBackground(color);
		
		
		carta.add(boton, BorderLayout.CENTER);
		
		
		return carta;
	}
	
	
	
	//--------FUNCION PARA AJUSTAR IMAGEN--------
	
	private ImageIcon imageResize(ImageIcon m,int width, int height) {
		//----IA cambiar tamaño de imagen----(x,y, image.scale_smooth)
		Image imagen = m.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(imagen);
		//----IA cambiar tamaño de imagen----
		return icono;
		
	}
		
}
