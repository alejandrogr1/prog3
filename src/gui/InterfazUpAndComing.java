package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfazUpAndComing extends JFrame {

	public InterfazUpAndComing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		
		JButton test = new JButton("ventana de up and coming");
		this.add(test, BorderLayout.CENTER);
		setVisible(true);
	}

}
