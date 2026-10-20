package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaLogin extends JFrame {

	/**
	 * Esta ventana se hace cargo del Inicio de sesion
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pCentro,pNorte,pSur,pUsuario,pContrasenya,pCampoNombre,pCampoContraseña;
	private JLabel lNombre,lContraseña,lVentana;
	private JTextField tNombre,tContraseña;
	private JButton iniciarSesion;
	
	public VentanaLogin() {
		
		//PROPIEDADES
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 400, 300, 300);
		setTitle("Inicio Sesion");
		setResizable(false);
		
		//PANELES
		pCentro = new JPanel(new GridLayout(2,1,20,20));
		pUsuario = new JPanel(new GridLayout(2,1,10,10));
		pContrasenya = new JPanel(new GridLayout(2,1,10,10));
		add(pCentro,BorderLayout.CENTER);

		pNorte = new JPanel();
		add(pNorte,BorderLayout.NORTH);

		pSur = new JPanel();
		add(pSur,BorderLayout.SOUTH);

		iniciarSesion = new JButton("INICIAR SESIÓN");
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazHome().setVisible(true);
			        dispose();
				// cierra la ventanalogin y abre home
			}
		});
		
		pSur.add(iniciarSesion);

		lVentana = new JLabel("INICIO DE SESION");

		lNombre = new JLabel("Nombre de usuario");
		lNombre.setHorizontalAlignment(JLabel.CENTER);
		tNombre = new JTextField(15);
		
		lContraseña = new JLabel("Contraseña");
		lContraseña.setHorizontalAlignment(JLabel.CENTER);
		tContraseña = new JTextField(15);

		pCampoNombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pCampoNombre.add(tNombre);

		pCampoContraseña = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pCampoContraseña.add(tContraseña);

		pNorte.add(lVentana);
		
		pUsuario.add(lNombre);
		pUsuario.add(pCampoNombre);
		
		pContrasenya.add(lContraseña);
		pContrasenya.add(pCampoContraseña);
		
		pCentro.add(pUsuario);
		pCentro.add(pContrasenya);

		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaLogin();
		
	}
	
	
}
