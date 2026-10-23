package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.paneles.*;

public class InterfazHome extends JFrame {

	private static final long serialVersionUID = 1L;	
	public InterfazHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		setLayout(new BorderLayout());
		PanelCentral panelCentral = new PanelCentral();
		add(panelCentral);
		
		
		setVisible(true);
	}	
}
