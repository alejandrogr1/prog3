package test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaLogin extends JFrame {

	/**
	 * Esta ventana se hace cargo del Inicio de sesion
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pCentro;
	
	
	public VentanaLogin() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 400, 600, 400);
		setTitle("Inicio Sesion");
		
	
		
		//PANELES
		JPanel pCentro = new JPanel();
		pCentro.setBackground(Color.CYAN);
		add(pCentro,BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaLogin();
	}

}
