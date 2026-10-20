package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BarraMenu extends JFrame {
	//programa de menu
	private JFrame ventanaActual;
		public JMenuBar añadirMenu(JFrame ventanaActual) {
			this.ventanaActual = ventanaActual;
			JMenuBar menuBar = new JMenuBar();
			
			JMenu menu = new JMenu("");
			ImageIcon menuIcon = new ImageIcon(getClass().getResource("/images/menu.png"));
			menuIcon = imageResize(menuIcon);
			menu.setIcon(menuIcon);
			menu.setOpaque(true);
			menu.add(panelMenu());
			
			menuBar.setPreferredSize(new Dimension(70,70));
			menuBar.add(menu);
			
			return menuBar;
		}
		private void cerrarVentanaActual() {
			ventanaActual.dispose();
		}
		private JPanel panelMenu() {
			JPanel panel = new JPanel();
			JPanel panel1 = new JPanel(new FlowLayout(5,10,0));
			JPanel panel2 = new JPanel(new FlowLayout(5,10,0));
			JPanel panel3 = new JPanel(new FlowLayout(5,10,0));
			JPanel panel4 = new JPanel(new FlowLayout(5,10,0));
			JPanel panel5 = new JPanel(new FlowLayout(5,10,0));
			JPanel panel6 = new JPanel(new FlowLayout(5,10,0));
			JPanel panel7 = new JPanel(new FlowLayout(5,10,0));
			

				JButton botonHome = new JButton("Home");
				botonHome.setPreferredSize(new Dimension(120,40));
				JButton botonHomeIcon = new JButton("");
				ImageIcon homeIcon = new ImageIcon(getClass().getResource("/images/home.png"));
				homeIcon = imageResize(homeIcon);
				botonHomeIcon.setIcon(homeIcon);
				botonHome.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazHome().setVisible(true);
						cerrarVentanaActual();
						
					}
					
				});
				botonHomeIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazHome().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				JButton botonPeliculas = new JButton("Películas");
				botonPeliculas.setPreferredSize(new Dimension(120,40));
				JButton botonPeliculasIcon = new JButton("");
				ImageIcon peliIcon = new ImageIcon(getClass().getResource("/images/pelis.png"));
				peliIcon = imageResize(peliIcon);
				botonPeliculasIcon.setIcon(peliIcon);
				botonPeliculas.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazPeli().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonPeliculasIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazPeli().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				JButton botonSeries = new JButton("Series");
				botonSeries.setPreferredSize(new Dimension(120,40));
				JButton botonSeriesIcon = new JButton("");
				ImageIcon serieIcon = new ImageIcon(getClass().getResource("/images/serie.png"));
				serieIcon = imageResize(serieIcon);
				botonSeriesIcon.setIcon(serieIcon);
				botonSeries.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazSerie().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonSeriesIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazSerie().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				JButton botonUpandcoming = new JButton("Up and Coming");
				botonUpandcoming.setPreferredSize(new Dimension(120,40));
				JButton botonUpandcomingIcon = new JButton("");
				ImageIcon updIcon = new ImageIcon(getClass().getResource("/images/up.png"));
				updIcon = imageResize(updIcon);
				botonUpandcomingIcon.setIcon(updIcon);
				botonUpandcoming.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazUpAndComing().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonUpandcomingIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazUpAndComing().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				JButton botonVermastarde = new JButton("Ver más tarde");
				botonVermastarde.setPreferredSize(new Dimension(120,40));
				JButton botonVermastardeIcon = new JButton("");
				ImageIcon verIcon = new ImageIcon(getClass().getResource("/images/vermast.png"));
				verIcon = imageResize(verIcon);
				botonVermastardeIcon.setIcon(verIcon);
				botonVermastarde.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazVerMasTarde().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonVermastardeIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazVerMasTarde().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				JButton botonFavoritos = new JButton("Favoritos");
				botonFavoritos.setPreferredSize(new Dimension(120,40));
				JButton botonFavoritosIcon = new JButton("");
				ImageIcon favIcon = new ImageIcon(getClass().getResource("/images/fav.png"));
				favIcon = imageResize(favIcon);
				botonFavoritosIcon.setIcon(favIcon);
				botonFavoritos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazFavoritos().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonFavoritosIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazFavoritos().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				JButton botonVIP = new JButton("VIP");
				botonVIP.setPreferredSize(new Dimension(120,40));
				JButton botonVIPIcon = new JButton("");
				ImageIcon vIcon = new ImageIcon(getClass().getResource("/images/vip.png"));
				vIcon = imageResize(vIcon);
				botonVIPIcon.setIcon(vIcon);
				botonVIP.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazVIP().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				botonVIPIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazVIP().setVisible(true);
						cerrarVentanaActual();
					}
					
				});
				
				
				panel1.add(botonHomeIcon);
				panel1.add(botonHome);
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
				
				panel.setPreferredSize(new Dimension(250,850));
				
			return panel;
			}

		private ImageIcon imageResize(ImageIcon m) {
			//----IA cambiar tamaño de imagen----(x,y, image.scale_smooth)
			Image imagen = m.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
			ImageIcon icono = new ImageIcon(imagen);
			//----IA cambiar tamaño de imagen----
			return icono;
			
		}
		
}
