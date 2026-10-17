package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class InterfazHome extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenu menu;
	private JMenuBar menuBar;
	
	public InterfazHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		
		
		//menu
		menuBar = new JMenuBar();
		
		menu = new JMenu("");
		ImageIcon menuIcon = new ImageIcon(getClass().getResource("/images/menu.png"));
		menuIcon = imageResize(menuIcon);
		menu.setIcon(menuIcon);
		menu.setOpaque(true);
		menu.add(panelMenu());
		
		menuBar.setPreferredSize(new Dimension(70,70));
		menuBar.add(menu);
		
		this.setJMenuBar(menuBar);
		setVisible(true);
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
			
			JButton botonPeliculas = new JButton("Películas");
			botonPeliculas.setPreferredSize(new Dimension(120,40));
			JButton botonPeliculasIcon = new JButton("");
			ImageIcon peliIcon = new ImageIcon(getClass().getResource("/images/pelis.png"));
			peliIcon = imageResize(peliIcon);
			botonPeliculasIcon.setIcon(peliIcon);
			botonPeliculasIcon.setOpaque(true);
			
			JButton botonSeries = new JButton("Series");
			botonSeries.setPreferredSize(new Dimension(120,40));
			JButton botonSeriesIcon = new JButton("");
			ImageIcon serieIcon = new ImageIcon(getClass().getResource("/images/serie.png"));
			serieIcon = imageResize(serieIcon);
			botonSeriesIcon.setIcon(serieIcon);
			botonSeriesIcon.setOpaque(true);
			
			JButton botonUpandcoming = new JButton("Up and Coming");
			botonUpandcoming.setPreferredSize(new Dimension(120,40));
			JButton botonUpandcomingIcon = new JButton("");
			ImageIcon updIcon = new ImageIcon(getClass().getResource("/images/up.png"));
			updIcon = imageResize(updIcon);
			botonUpandcomingIcon.setIcon(updIcon);
			botonUpandcomingIcon.setOpaque(true);
			
			JButton botonVermastarde = new JButton("Ver más tarde");
			botonVermastarde.setPreferredSize(new Dimension(120,40));
			JButton botonVermastardeIcon = new JButton("");
			ImageIcon verIcon = new ImageIcon(getClass().getResource("/images/vermast.png"));
			verIcon = imageResize(verIcon);
			botonVermastardeIcon.setIcon(verIcon);
			botonVermastardeIcon.setOpaque(true);
			
			JButton botonFavoritos = new JButton("Favoritos");
			botonFavoritos.setPreferredSize(new Dimension(120,40));
			JButton botonFavoritosIcon = new JButton("");
			ImageIcon favIcon = new ImageIcon(getClass().getResource("/images/fav.png"));
			favIcon = imageResize(favIcon);
			botonFavoritosIcon.setIcon(favIcon);
			botonFavoritosIcon.setOpaque(true);
			
			JButton botonVIP = new JButton("VIP");
			botonVIP.setPreferredSize(new Dimension(120,40));
			JButton botonVIPIcon = new JButton("");
			ImageIcon vIcon = new ImageIcon(getClass().getResource("/images/vip.png"));
			vIcon = imageResize(vIcon);
			botonVIPIcon.setIcon(vIcon);
			botonVIPIcon.setOpaque(true);
			
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
			
			setVisible(true);
			
		return panel;
	}
	
	private ImageIcon imageResize(ImageIcon m) {
		//----AI cambiar tamaño de imagen----(x,y, image.scale_smooth)
		Image imagen = m.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(imagen);
		//----AI cambiar tamaño de imagen----
		return icono;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InterfazHome();
	}

}
