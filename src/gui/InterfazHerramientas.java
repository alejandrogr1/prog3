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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class InterfazHerramientas extends JFrame {

	//Variable para guardar la ventana actual
	private JFrame ventanaActual;
	
		// Método para añadir el menuBar, con funcionalidad
		public JMenuBar añadirMenu(JFrame ventanaActual) {
			//Guarda la ventana actual para luego poder cerrarlo al cambiar de interfaz
			this.ventanaActual = ventanaActual;
			
			JMenuBar menuBar = new JMenuBar();
			
			//Menu
			JMenu menu = new JMenu("");
			ImageIcon menuIcon = new ImageIcon(getClass().getResource("/images/menu.png"));
			//Cambia el tamaño de boton del icono a altura 60y anchura 60
			menuIcon = imageResize(menuIcon,60,60);
			menu.setIcon(menuIcon);
			menu.add(panelMenu());
			
			//La barra de menu adapta automáticamente el tamaño del boton menu que es el icono
			menuBar.add(menu);
			
			return menuBar;
		}
		
		//Método para cerrar la ventana actual que estaba guardado
		private void cerrarVentanaActual() {
			ventanaActual.dispose();
		}
		
		//Botones del menu
		private JPanel panelMenu() {
			
			//Panel principal
			JPanel panel = new JPanel();
			
			//7 paneles para 14 botones, 2 en cada----FlowLayout(alineación, separación horizontal, separación vertical)
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
			
				//Boton de Home
				JButton botonHome = new JButton("Home");
				botonHome.setPreferredSize(new Dimension(120,40));
				
				//Boton de Icono Home
				JButton botonHomeIcon = new JButton("");
				ImageIcon homeIcon = new ImageIcon(getClass().getResource("/images/home.png"));
				homeIcon = imageResize(homeIcon,65,65);
				botonHomeIcon.setIcon(homeIcon);
				
				//Lo que hace ambos botones
				botonHome.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazHome().setVisible(true);
						cerrarVentanaActual();
						
					}
					
				});
				botonHomeIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazHome().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Boton de Películas
				JButton botonPeliculas = new JButton("Películas");
				botonPeliculas.setPreferredSize(new Dimension(120,40));
				
				//Boton de Icono Películas
				JButton botonPeliculasIcon = new JButton("");
				ImageIcon peliIcon = new ImageIcon(getClass().getResource("/images/pelis.png"));
				peliIcon = imageResize(peliIcon,65,65);
				botonPeliculasIcon.setIcon(peliIcon);
				
				//Lo que hace ambos botones
				botonPeliculas.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazPeli().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonPeliculasIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazPeli().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Boton Series
				JButton botonSeries = new JButton("Series");
				botonSeries.setPreferredSize(new Dimension(120,40));
				
				//Botno Icono Series
				JButton botonSeriesIcon = new JButton("");
				ImageIcon serieIcon = new ImageIcon(getClass().getResource("/images/serie.png"));
				serieIcon = imageResize(serieIcon,65,65);
				botonSeriesIcon.setIcon(serieIcon);
				
				//Lo que hace ambos botones
				botonSeries.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazSerie().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonSeriesIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazSerie().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Boton de Up And Coming
				JButton botonUpandcoming = new JButton("Up and Coming");
				botonUpandcoming.setPreferredSize(new Dimension(120,40));
				
				//Boton de Icono Up And Coming
				JButton botonUpandcomingIcon = new JButton("");
				ImageIcon updIcon = new ImageIcon(getClass().getResource("/images/up.png"));
				updIcon = imageResize(updIcon,65,65);
				botonUpandcomingIcon.setIcon(updIcon);
				
				//Lo que hace amnbos botones
				botonUpandcoming.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazUpAndComing().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonUpandcomingIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazUpAndComing().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Boton de Ver Más Tarde
				JButton botonVermastarde = new JButton("Ver más tarde");
				botonVermastarde.setPreferredSize(new Dimension(120,40));
				
				//Boton de Icono Ver Más Tarde
				JButton botonVermastardeIcon = new JButton("");
				ImageIcon verIcon = new ImageIcon(getClass().getResource("/images/vermast.png"));
				verIcon = imageResize(verIcon,65,65);
				botonVermastardeIcon.setIcon(verIcon);
				
				//lo que hace ambos botones
				botonVermastarde.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazVerMasTarde().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonVermastardeIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazVerMasTarde().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Boton de Favoritos
				JButton botonFavoritos = new JButton("Favoritos");
				botonFavoritos.setPreferredSize(new Dimension(120,40));
				
				//Boton de Icono Favoritos
				JButton botonFavoritosIcon = new JButton("");
				ImageIcon favIcon = new ImageIcon(getClass().getResource("/images/fav.png"));
				favIcon = imageResize(favIcon,65,65);
				botonFavoritosIcon.setIcon(favIcon);
				
				//Lo que hace ambos botones
				botonFavoritos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazFavoritos().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonFavoritosIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazFavoritos().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Boton de VIP
				JButton botonVIP = new JButton("VIP");
				botonVIP.setPreferredSize(new Dimension(120,40));
				
				//Boton de Icono VIP
				JButton botonVIPIcon = new JButton("");
				ImageIcon vIcon = new ImageIcon(getClass().getResource("/images/vip.png"));
				vIcon = imageResize(vIcon,65,65);
				botonVIPIcon.setIcon(vIcon);
				
				//Lo que hace ambos botones
				botonVIP.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazVIP().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonVIPIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						
						//Abre la interfaz determinado y cierra la ventana actual
						new InterfazVIP().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				//Añadir de orden BotonIcono--BotonTexto a un panel
				panel1.add(botonHomeIcon);
				panel1.add(botonHome);
				
				//Añadir al panel principal, por orden
				panel.add(panel1,BorderLayout.NORTH);
				
				panel2.add(botonPeliculasIcon);
				panel2.add(botonPeliculas);
				panel.add(panel2,BorderLayout.NORTH);
				
				panel3.add(botonSeriesIcon);
				panel3.add(botonSeries);
				panel.add(panel3,BorderLayout.NORTH);
				
				panel4.add(botonUpandcomingIcon);
				panel4.add(botonUpandcoming);
				panel.add(panel4,BorderLayout.NORTH);
				
				panel5.add(botonVermastardeIcon);
				panel5.add(botonVermastarde);
				panel.add(panel5,BorderLayout.NORTH);
				
				panel6.add(botonFavoritosIcon);
				panel6.add(botonFavoritos);
				panel.add(panel6,BorderLayout.NORTH);
				
				panel7.add(botonVIPIcon);
				panel7.add(botonVIP);
				panel.add(panel7,BorderLayout.NORTH);
				
				//Cambia el tamaño del panle principal para que quede bonito, no afecta a paneles dentro de él
				panel.setPreferredSize(new Dimension(250,850));
				
			return panel;
			}
		//Método para añadir boton de noticicafión y perfil (flowlayout.right)
		public JPanel añadirPerfilyNotificacion() {
			//Panel principal
			JPanel panelNotificacion = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
			
			//Boton de imagen notificación
			ImageIcon iconoNotificacion = new ImageIcon(getClass().getResource("/images/notis.png"));
			iconoNotificacion = imageResize(iconoNotificacion, 50, 50);
			JButton botonNotificacion = new JButton(iconoNotificacion);
			botonNotificacion.setPreferredSize(new Dimension(70, 60));
			
			//Boton de imagen perfil
			ImageIcon iconoPerfil = new ImageIcon(getClass().getResource("/images/Perfil.png"));
			iconoPerfil = imageResize(iconoPerfil, 50, 50);
			JButton botonPerfil = new JButton(iconoPerfil);
			botonPerfil.setPreferredSize(new Dimension(70, 60));
			
			//Añadir a panel principal, derecha
			panelNotificacion.add(botonNotificacion);
			panelNotificacion.add(botonPerfil);

			return panelNotificacion;
		}
		
		//Método para añadir Caracteristicas
		public JPanel añadirCaracteristica() {
			
			//Panel principal
			JPanel panelp = new JPanel(new GridLayout(5,1));
			
			//Primera linea de característica en panel1
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
			
			//Segunda linea de caracteristica en panel2, genero
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			String[] generos = {"Todos los Géneros", "Acción", "Aventura", "Comedia", "Drama", "Fantasía", "Horror", "Romance"};
				
			//Bucle que crea el boton con nombre de String[] generos, background blanco, negrita | modelo italic e 15 de tamaño
				for (String s : generos) {
					
					JButton botones = new JButton("" + s);
					botones.setBackground(Color.WHITE);
					botones.setFont(new Font("courier", Font.BOLD | Font.ITALIC, 15 ));
					panel2.add(botones);
				}
			
				//Tercera linea de caracteristica en panel3, lugar
				JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
				String[] lugar = {"Todos los Lugares", "Europa", "África", "América", "Asia", "Polo Norte", "Polo Sur"};
				//Bucle que crea el boton con nombre de String[] Lugar, background blanco, negrita | modelo italic e 15 de tamaño	
					for (String s : lugar) {
						
						JButton botones = new JButton("" + s);
						botones.setBackground(Color.WHITE);
						botones.setFont(new Font("courier", Font.BOLD | Font.ITALIC, 15 ));
						panel3.add(botones);
					}
				//Cuarta linea de caracteristica en panel4, idioma	
				JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
					
				String[] idioma = {"Todos los Idiomas", "Inglés", "Castellano", "Francés", "Italiano", "Chino", "Japones", "Koreano", "Otros"};
				//Bucle que crea el boton con nombre de String[] idioma, background blanco, negrita | modelo italic e 15 de tamaño		
					for (String s : idioma) {
							
						JButton botones = new JButton("" + s);
						botones.setBackground(Color.WHITE);
						botones.setFont(new Font("courier", Font.BOLD | Font.ITALIC, 15 ));
						panel4.add(botones);
					}
						
				//Quinta linea de caracteristica en panel5, vip y free			
				JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
					
				JRadioButton VIP = new JRadioButton("VIP");
				VIP.setFont(new Font("Verdana", Font.PLAIN, 15));
				JRadioButton FREE = new JRadioButton("FREE");
				FREE.setFont(new Font("Verdana", Font.PLAIN, 15));

				panel5.add(VIP);
				panel5.add(FREE);

				//Añadir en orden panel1-5
				panelp.add(panel1);
				panelp.add(panel2);
				panelp.add(panel3);
				panelp.add(panel4);
				panelp.add(panel5);
				
			return panelp;
		}
		
		//Método para añadir un panel que contiene imagen de peli y su titulo, visual
		public JPanel añadirPanelPeli() {
			//panel principal
			JPanel panelPeli = new JPanel(new BorderLayout(0,20));
			
			//Boton de imagen
			JButton imagePeli = new JButton();
			ImageIcon peliIcon = new ImageIcon(getClass().getResource("/images/pelis.png"));
			peliIcon = imageResize(peliIcon,180,180);
			imagePeli.setIcon(peliIcon);
			
			//Boton de titulo
			JButton tituloPeli = new JButton("Titulo de película");
			
			//Añadir a su posición
			panelPeli.add(imagePeli, BorderLayout.CENTER);
			panelPeli.add(tituloPeli, BorderLayout.SOUTH);
			
			
			return panelPeli;
		}
		
		//Método para añadir una figura que contiene imagen de serie y su titulo, visual
		public JPanel añadirPanelSerie() {
			//panel principal
			JPanel panelSerie= new JPanel(new BorderLayout(0,20));
			
			//Boton de imagen
			JButton imageSerie = new JButton();
			ImageIcon serieIcon = new ImageIcon(getClass().getResource("/images/serie.png"));
			serieIcon = imageResize(serieIcon,180,180);
			imageSerie.setIcon(serieIcon);
			
			//Boton de titulo
			JButton tituloSerie = new JButton("Titulo de Serie");
			
			//Añadir a su posición
			panelSerie.add(imageSerie, BorderLayout.CENTER);
			panelSerie.add(tituloSerie, BorderLayout.SOUTH);
			
			
			return panelSerie;
		}
		
		//Método para modificar tamaño de imagen
		public ImageIcon imageResize(ImageIcon m, int width, int height) {
			//-Comienzo------IA cambiar tamaño de imagen----(x,y, image.scale_smooth)
			Image imagen = m.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon icono = new ImageIcon(imagen);
			//-Fin-----------IA cambiar tamaño de imagen----
			return icono;
			
		}
		
}
