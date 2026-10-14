package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame {

	/**
	 * Esta ventana se hace cargo del Inicio de sesion
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pCentro,pNorte,pSur;
	private JLabel lNombre,lContraseña;
	private JTextField tNombre,tContraseña;
	
	
	public VentanaLogin() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 400, 600, 400);
		setTitle("Inicio Sesion");
		setResizable(false);
	
		
		//PANELES
		pCentro = new JPanel(new GridLayout(2,1));
		pCentro.setBackground(Color.GRAY);
		add(pCentro,BorderLayout.CENTER);
		
		pNorte = new JPanel();
		add(pNorte,BorderLayout.NORTH);
		
		pSur = new JPanel();
		add(pSur,BorderLayout.SOUTH);
		
		lNombre  = new JLabel("Usuario");
		tNombre = new JTextField();		
		lContraseña = new JLabel("Contraseña");
		tContraseña = new JTextField();
		
		pCentro.add(lNombre,BorderLayout.CENTER);
		pCentro.add(tNombre);
		pCentro.add(lContraseña);
		pCentro.add(tContraseña);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaLogin();
		System.out.println();
	}

}
