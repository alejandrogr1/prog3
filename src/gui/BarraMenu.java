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
	
		public JMenuBar añadirMenu() {
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
				botonHomeIcon.setOpaque(true);
				botonHome.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazHome().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonHome);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonHomeIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazHome().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonHomeIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
					}
					
				});
				
				
				JButton botonPeliculas = new JButton("Películas");
				botonPeliculas.setPreferredSize(new Dimension(120,40));
				JButton botonPeliculasIcon = new JButton("");
				ImageIcon peliIcon = new ImageIcon(getClass().getResource("/images/pelis.png"));
				peliIcon = imageResize(peliIcon);
				botonPeliculasIcon.setIcon(peliIcon);
				botonPeliculasIcon.setOpaque(true);
				botonPeliculas.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazPeli().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonPeliculas);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonPeliculasIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazPeli().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonPeliculasIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
					}
					
				});
				
				
				JButton botonSeries = new JButton("Series");
				botonSeries.setPreferredSize(new Dimension(120,40));
				JButton botonSeriesIcon = new JButton("");
				ImageIcon serieIcon = new ImageIcon(getClass().getResource("/images/serie.png"));
				serieIcon = imageResize(serieIcon);
				botonSeriesIcon.setIcon(serieIcon);
				botonSeriesIcon.setOpaque(true);
				botonSeries.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazSerie().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonSeries);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonSeriesIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazSerie().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonSeriesIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
					}
					
				});
				
				
				JButton botonUpandcoming = new JButton("Up and Coming");
				botonUpandcoming.setPreferredSize(new Dimension(120,40));
				JButton botonUpandcomingIcon = new JButton("");
				ImageIcon updIcon = new ImageIcon(getClass().getResource("/images/up.png"));
				updIcon = imageResize(updIcon);
				botonUpandcomingIcon.setIcon(updIcon);
				botonUpandcomingIcon.setOpaque(true);
				botonUpandcoming.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazUpAndComing().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonUpandcoming);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonUpandcomingIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazUpAndComing().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonUpandcomingIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
					}
					
				});
				
				
				JButton botonVermastarde = new JButton("Ver más tarde");
				botonVermastarde.setPreferredSize(new Dimension(120,40));
				JButton botonVermastardeIcon = new JButton("");
				ImageIcon verIcon = new ImageIcon(getClass().getResource("/images/vermast.png"));
				verIcon = imageResize(verIcon);
				botonVermastardeIcon.setIcon(verIcon);
				botonVermastardeIcon.setOpaque(true);
				botonVermastarde.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazVerMasTarde().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonVermastarde);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonVermastardeIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazVerMasTarde().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonVermastardeIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
					}
					
				});
				
				
				JButton botonFavoritos = new JButton("Favoritos");
				botonFavoritos.setPreferredSize(new Dimension(120,40));
				JButton botonFavoritosIcon = new JButton("");
				ImageIcon favIcon = new ImageIcon(getClass().getResource("/images/fav.png"));
				favIcon = imageResize(favIcon);
				botonFavoritosIcon.setIcon(favIcon);
				botonFavoritosIcon.setOpaque(true);
				botonFavoritos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazFavoritos().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonFavoritos);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonFavoritosIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazFavoritos().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonFavoritosIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
					}
					
				});
				
				
				JButton botonVIP = new JButton("VIP");
				botonVIP.setPreferredSize(new Dimension(120,40));
				JButton botonVIPIcon = new JButton("");
				ImageIcon vIcon = new ImageIcon(getClass().getResource("/images/vip.png"));
				vIcon = imageResize(vIcon);
				botonVIPIcon.setIcon(vIcon);
				botonVIPIcon.setOpaque(true);
				botonVIP.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new InterfazVIP().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonVIP);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
						
					}
					
				});
				botonVIPIcon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent a) {
						new InterfazVIP().setVisible(true);
						//--IA--cerrar ventana actual
					    JFrame ventanaActual =(JFrame) SwingUtilities.getWindowAncestor(botonVIPIcon);
					        ventanaActual.dispose();
					    //--IA--cerrar ventana actual
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
