package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfazSerie extends JFrame {
	public InterfazSerie() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		this.setJMenuBar(new BarraMenu().añadirMenu());
		
		JButton test = new JButton("ventana de serie");
		this.add(test, BorderLayout.CENTER);
		setVisible(true);
	}

}
