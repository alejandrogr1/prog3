package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class InterfazPeli extends JFrame {

	private static final long serialVersionUID = 1L;


	public InterfazPeli() {
		
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		
		//Localizado en medio de pantalla
		setLocationRelativeTo(null);
		
		//Añadir menuBar ya hecha en otra clase
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		
		//Panel principal
		JPanel panelprincipal = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//Panel con titulo en la izquierda y botones de notificación y perfil en la derecha, añadido a la ventana
		JPanel panelCabecera = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("                                                                  Películas");
		titulo.setFont(new Font("Verdana", Font.BOLD, 35));
		panelCabecera.add(titulo,BorderLayout.WEST);
		
		//Añadir botones de notificación y perfil desde otra clase
		panelCabecera.add(new InterfazHerramientas().añadirPerfilyNotificacion(), BorderLayout.EAST);
		this.add(panelCabecera, BorderLayout.NORTH);
		
		//Panel que contiene caraterísticas, añadido a panel principal
		JPanel caracter = new JPanel(new FlowLayout(FlowLayout.LEFT));
		caracter.add(new InterfazHerramientas().añadirCaracteristica());
		panelprincipal.add(caracter, BorderLayout.NORTH);
		
		//Panel que contiene paneles formadas por un boton de imagen y un boton de titulo, 14 paneles, añadido a panel principal
		JPanel panelPelis = new JPanel(new GridLayout(2,7,20,60));
		
		//Bucle que repite 14 veces, añade panel desde otra clase
		for(int i=0; i<=13; i++) {
			panelPelis.add(new InterfazHerramientas().añadirPanelPeli());
		}
		panelprincipal.add(panelPelis, BorderLayout.CENTER);
		
		//Añadir panel principal a la ventana
		this.add(panelprincipal);
		


		
		setVisible(true);
	}

}
