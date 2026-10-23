package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfazVIP extends JFrame {

	public InterfazVIP() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		
		JButton test = new JButton("ventana de vip");
		this.add(test, BorderLayout.CENTER);
		setVisible(true);
	}
}
