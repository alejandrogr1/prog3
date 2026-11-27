package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class InterfazHerramientas extends JFrame {

	//Variable para guardar la ventana actual
	private JFrame ventanaActual;

	// Guarda las ventanas ya creadas, static es que lo comparten todas las ventanas
	// Para luego poder coger datos de esas ventanas
	private static HashMap<String, JFrame> ventanas = new HashMap<String, JFrame>();

	// Método para añadir el menuBar, con funcionalidad
	public JMenuBar añadirMenu(JFrame ventanaActual) {
		// Guarda la ventana actual para luego poder esconderla al cambiar de interfaz
		this.ventanaActual = ventanaActual;
		// Se apunta en la lista con su nombre, como "InterfazVIP"
		ventanas.put(ventanaActual.getClass().getSimpleName(), ventanaActual);

		JMenuBar menuBar = new JMenuBar();

		// Menu
		JMenu menu = new JMenu("");
		ImageIcon menuIcon = new ImageIcon(getClass().getResource("/images/menu.png"));
		// Cambia el tamaño de boton del icono a altura 60 y anchura 60
		menuIcon = imageResize(menuIcon, 60, 60);
		menu.setIcon(menuIcon);
		menu.add(panelMenu());
		// La barra de menu adapta el tamaño del boton menu que es el icono
		menuBar.add(menu);

		// Contador de duración VIP, a la derecha de la barra
		final JLabel duracionVIP = new JLabel("VIP: ninguno");
		duracionVIP.setFont(new Font("Georgia", Font.BOLD, 20));
		// Foreground es color del texto
		duracionVIP.setForeground(new Color(212, 175, 55)); // Gold
		duracionVIP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20)); // espacio en la deracha para que se quede bonito
		menuBar.add(Box.createHorizontalGlue()); // hace que el duraciónVIOP este en la derecha
		menuBar.add(duracionVIP);

		actualizarContador(duracionVIP);
		//Hilo que actualiza el texto cada segundo
		Thread reloj = new Thread(() -> {
		    while (true) {
		        try {
		            Thread.sleep(1000);

		            // SwingUtilities.invokeLater para el hilo poder modificar
		            SwingUtilities.invokeLater(() -> {
		                actualizarContador(duracionVIP);
		            });

		        } catch (InterruptedException e) {
		        	// termina el hilo si es interrumpido
		            break;
		        }
		    }
		});

		reloj.start();

		return menuBar;
	}

	// Lee el tiempo de la ventana InterfazVIP y actualiza el label
	private void actualizarContador(JLabel label) {
		// Coge el interfazVIP ya creada y guardada en el hashmap
		InterfazVIP vip = (InterfazVIP) ventanas.get("InterfazVIP");
		// Con el dato de esa interfazVIP para actualiza el label
		if (vip == null || vip.vipComprado.equals("none")) {
			label.setText("VIP: ninguno");
		} else {
			label.setText(vip.vipComprado + "  " + vip.formatoTiempo(vip.segundos));
		}
	}

	// En vez de cerrar la ventana (dispose), lo pone invisible y muestra otra.
	// Para que la ventana y el hilo de InterfazVIP siguen abierto y no se termine ql hilo.
	private void abrirVentana(String nombre) {
		// Si ya estás en esa ventana, no hace nada
		if (ventanaActual.getClass().getSimpleName().equals(nombre)) {
			return;
		}
		
		// Coge la ventana si ya esta guardada en hasmap
		JFrame destino = ventanas.get(nombre);

		// Si no hay, la crea 
		if (destino == null) {
			if (nombre.equals("InterfazHome")) {
				destino = new InterfazHome();
			} else if (nombre.equals("InterfazPeli")) {
				destino = new InterfazPeli();
			} else if (nombre.equals("InterfazSerie")) {
				destino = new InterfazSerie();
			} else if (nombre.equals("InterfazUpAndComing")) {
				destino = new InterfazUpAndComing();
			} else if (nombre.equals("InterfazVerMasTarde")) {
				destino = new InterfazVerMasTarde();
			} else if (nombre.equals("InterfazFavoritos")) {
				destino = new InterfazFavoritos();
			} else if (nombre.equals("InterfazVIP")) {
				destino = new InterfazVIP();
			}
		}

		destino.setVisible(true);
		// Lo esconde pero no lo cierra
		ventanaActual.setVisible(false); 
	}

	// Crea una fila del menu, botón icono + botón texto, los dos hacen lo mismo
	private JPanel crearFila(String texto, String icono, final String nombreVentana) {
		JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		// Boton icono
		JButton botonIcono = new JButton("");
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + icono));
		icon = imageResize(icon, 65, 65);
		botonIcono.setIcon(icon);
		
		// Boton texto
		JButton botonTexto = new JButton(texto);
		botonTexto.setPreferredSize(new Dimension(120, 40));


		// Lo que hace ambos botones
		ActionListener accion = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirVentana(nombreVentana);
			}
		};
		botonIcono.addActionListener(accion);
		botonTexto.addActionListener(accion);


		// Orden boton icono boton texto
		fila.add(botonIcono);
		fila.add(botonTexto);
		return fila;
	}


	// Botones del menu
	private JPanel panelMenu() {
		// Panel principal
		JPanel panel = new JPanel();

		// Añadir los filas en orden
		panel.add(crearFila("Home", "home.png", "InterfazHome"));
		panel.add(crearFila("Películas", "pelis.png", "InterfazPeli"));
		panel.add(crearFila("Series", "serie.png", "InterfazSerie"));
		panel.add(crearFila("Up and Coming", "up.png", "InterfazUpAndComing"));
		panel.add(crearFila("Ver más tarde", "vermast.png", "InterfazVerMasTarde"));
		panel.add(crearFila("Favoritos", "fav.png", "InterfazFavoritos"));
		panel.add(crearFila("VIP", "vip.png", "InterfazVIP"));


		// Cambia el tamaño del panel principal para que quede bonito, no afecta a paneles dentro de el
		panel.setPreferredSize(new Dimension(250, 850));
		return panel;
	}

		// Método para añadir boton de noticicafión y perfil (flowlayout.right)
		public JPanel añadirPerfilyNotificacion() {
			//Panel principal
			JPanel panelNotificacion = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
			
			// Boton de imagen notificación
			ImageIcon iconoNotificacion = new ImageIcon(getClass().getResource("/images/notis.png"));
			iconoNotificacion = imageResize(iconoNotificacion, 50, 50);
			JButton botonNotificacion = new JButton(iconoNotificacion);
			botonNotificacion.setPreferredSize(new Dimension(70, 60));
			
			// Boton de imagen perfil
			ImageIcon iconoPerfil = new ImageIcon(getClass().getResource("/images/Perfil.png"));
			iconoPerfil = imageResize(iconoPerfil, 50, 50);
			JButton botonPerfil = new JButton(iconoPerfil);
			botonPerfil.setPreferredSize(new Dimension(70, 60));
			
			// Añadir a panel principal, derecha
			panelNotificacion.add(botonNotificacion);
			panelNotificacion.add(botonPerfil);

			return panelNotificacion;
		}
		
		// Método para añadir Caracteristicas
		public JPanel añadirCaracteristica() {
			
			// Panel principal
			JPanel panelp = new JPanel(new GridLayout(5,1));
			
			// Primera linea de característica en panel1
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
			JRadioButton nuevo = new JRadioButton("Nuevos");
			nuevo.setFont(new Font("Verdana", Font.PLAIN, 15));
			JRadioButton popular = new JRadioButton("Más Populares");
			popular.setFont(new Font("Verdana", Font.PLAIN, 15));
			JRadioButton valorado = new JRadioButton("Mejor Valorados");
			valorado.setFont(new Font("Verdana", Font.PLAIN, 15));
			JRadioButton az = new JRadioButton("A-Z");
			az.setFont(new Font("Verdana", Font.PLAIN, 15));
			
			panel1.add(nuevo);
			panel1.add(popular);
			panel1.add(valorado);
			panel1.add(az);
			
			// Segunda linea de caracteristica en panel2, genero
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			String[] generos = {"Todos los Géneros", "Acción", "Aventura", "Comedia", "Drama", "Fantasía", "Horror", "Romance"};
				
			// Bucle que crea el boton con nombre de String[] generos, background blanco, negrita | modelo italic e 15 de tamaño
				for (String s : generos) {
					
					JButton botones = new JButton("" + s);
					botones.setBackground(Color.WHITE);
					botones.setFont(new Font("courier", Font.BOLD | Font.ITALIC, 15 ));
					panel2.add(botones);
				}
			
				// Tercera linea de caracteristica en panel3, lugar
				JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
				String[] lugar = {"Todos los Lugares", "Europa", "África", "América", "Asia", "Polo Norte", "Polo Sur"};
				// Bucle que crea el boton con nombre de String[] Lugar, background blanco, negrita | modelo italic e 15 de tamaño	
					for (String s : lugar) {
						
						JButton botones = new JButton("" + s);
						botones.setBackground(Color.WHITE);
						botones.setFont(new Font("courier", Font.BOLD | Font.ITALIC, 15 ));
						panel3.add(botones);
					}
				// Cuarta linea de caracteristica en panel4, idioma	
				JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
					
				String[] idioma = {"Todos los Idiomas", "Inglés", "Castellano", "Francés", "Italiano", "Chino", "Japones", "Koreano", "Otros"};
				// Bucle que crea el boton con nombre de String[] idioma, background blanco, negrita | modelo italic e 15 de tamaño		
					for (String s : idioma) {
							
						JButton botones = new JButton("" + s);
						botones.setBackground(Color.WHITE);
						botones.setFont(new Font("courier", Font.BOLD | Font.ITALIC, 15 ));
						panel4.add(botones);
					}
						
				// Quinta linea de caracteristica en panel5, vip y free			
				JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
					
				JRadioButton VIP = new JRadioButton("VIP");
				VIP.setFont(new Font("Verdana", Font.PLAIN, 15));
				JRadioButton FREE = new JRadioButton("FREE");
				FREE.setFont(new Font("Verdana", Font.PLAIN, 15));

				panel5.add(VIP);
				panel5.add(FREE);

				// Añadir en orden panel1-5
				panelp.add(panel1);
				panelp.add(panel2);
				panelp.add(panel3);
				panelp.add(panel4);
				panelp.add(panel5);
				
			return panelp;
		}
		
		// Método para añadir un panel que contiene imagen de peli y su titulo, visual
		public JPanel añadirPanelPeli() {
			// panel principal
			JPanel panelPeli = new JPanel(new BorderLayout(0,20));
			
			// Boton de imagen
			JButton imagePeli = new JButton();
			ImageIcon peliIcon = new ImageIcon(getClass().getResource("/images/pelis.png"));
			peliIcon = imageResize(peliIcon,180,180);
			imagePeli.setIcon(peliIcon);
			
			// Boton de titulo
			JButton tituloPeli = new JButton("Titulo de película");
			
			// Añadir a su posición
			panelPeli.add(imagePeli, BorderLayout.CENTER);
			panelPeli.add(tituloPeli, BorderLayout.SOUTH);
			
			
			return panelPeli;
		}
		
		// Método para añadir una figura que contiene imagen de serie y su titulo, visual
		public JPanel añadirPanelSerie() {
			//panel principal
			JPanel panelSerie= new JPanel(new BorderLayout(0,20));
			
			// Boton de imagen
			JButton imageSerie = new JButton();
			ImageIcon serieIcon = new ImageIcon(getClass().getResource("/images/serie.png"));
			serieIcon = imageResize(serieIcon,180,180);
			imageSerie.setIcon(serieIcon);
			
			// Boton de titulo
			JButton tituloSerie = new JButton("Titulo de Serie");
			
			// Añadir a su posición
			panelSerie.add(imageSerie, BorderLayout.CENTER);
			panelSerie.add(tituloSerie, BorderLayout.SOUTH);
			
			
			return panelSerie;
		}
		
		// Método para modificar tamaño de imagen
		public ImageIcon imageResize(ImageIcon m, int width, int height) {
			//-Comienzo------IA cambiar tamaño de imagen----(x,y, image.scale_smooth)
			Image imagen = m.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon icono = new ImageIcon(imagen);
			//-Fin-----------IA cambiar tamaño de imagen----
			return icono;
			
		}
		
}
