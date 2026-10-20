package gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBuscador extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelBuscador(){

	setLayout(new BorderLayout());
		
	JPanel panelBuscador = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
	JTextField textobuscador = new JTextField("Buscar...", 20);
	textobuscador.setPreferredSize(new Dimension(450, 40));
	
	ImageIcon iconoLupa = new ImageIcon(getClass().getResource("/images/Lupa.png"));
	iconoLupa = imageResize(iconoLupa, 30, 30);
	JButton botonLupa = new JButton(iconoLupa);
	botonLupa.setPreferredSize(new Dimension(50, 40));
	
	panelBuscador.add(textobuscador);
	panelBuscador.add(botonLupa);	
	
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
	
	JPanel panelVacioIzq = new JPanel();
	panelVacioIzq.setPreferredSize(panelNotificacion.getPreferredSize());
	
	add(panelBuscador, BorderLayout.CENTER);
	add(panelNotificacion, BorderLayout.EAST);
	add(panelVacioIzq, BorderLayout.WEST);
	
	
	}
	
	private ImageIcon imageResize(ImageIcon m,int width, int height) {
		//----IA cambiar tamaño de imagen----(x,y, image.scale_smooth)
		Image imagen = m.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(imagen);
		//----IA cambiar tamaño de imagen----
		return icono;
		
	}
}
