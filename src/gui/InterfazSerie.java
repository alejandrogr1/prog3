package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfazSerie extends JFrame {

	private static final long serialVersionUID = 1L;


	public InterfazSerie() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
			
		JPanel panelprincipal = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
		JPanel panelCabecera = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("                                                                  Series");
		titulo.setFont(new Font("Verdana", Font.BOLD, 35));
		panelCabecera.add(titulo,BorderLayout.WEST);
			
		panelCabecera.add(new InterfazHerramientas().añadirPerfilyNotificacion(), BorderLayout.EAST);
		this.add(panelCabecera, BorderLayout.NORTH);
		
		JPanel generos = new JPanel(new FlowLayout(FlowLayout.LEFT));
		generos.add(new InterfazHerramientas().añadirGeneros());
		panelprincipal.add(generos, BorderLayout.NORTH);
			
		JPanel panelSeries = new JPanel(new GridLayout(2,7,20,60));
			
		for(int i=0; i<=13; i++) {
			panelSeries.add(new InterfazHerramientas().añadirPanelSerie());
		}
		panelprincipal.add(panelSeries, BorderLayout.CENTER);
			
		this.add(panelprincipal);
			
		setVisible(true);
	}

}
