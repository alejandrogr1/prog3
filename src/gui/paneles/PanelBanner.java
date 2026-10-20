package gui.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.GrayFilter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBanner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelBanner() {
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(750, 150));
		setBackground(new Color(230, 230, 230));;
		
		
		JPanel panelTexto = new JPanel(new GridLayout(2,1,0,8));
		
		 
		
		 JLabel labelTitulo = new JLabel("Destacados");
		 labelTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		 
		 JLabel labelSubtitulo = new JLabel("Saber más...");
		 labelSubtitulo.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		 
		 panelTexto.add(labelTitulo);
		 panelTexto.add(labelSubtitulo);
		 
		 JButton botonExplorar = new  JButton("Explorar");
		 botonExplorar.setFont(new Font("Verdana", Font.BOLD, 13));
		 
		 add(panelTexto, BorderLayout.CENTER);
		 add(botonExplorar, BorderLayout.EAST);
		 
	}
	
}
