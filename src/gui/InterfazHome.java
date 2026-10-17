package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfazHome extends JFrame {

	private static final long serialVersionUID = 1L;	
	public InterfazHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		this.setJMenuBar(new BarraMenu().añadirMenu());
		
		JButton test = new JButton("ventana de home");
		this.add(test, BorderLayout.CENTER);
		setVisible(true);
	}

}
