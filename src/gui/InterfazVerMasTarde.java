package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfazVerMasTarde extends JFrame {

	public InterfazVerMasTarde() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		this.setJMenuBar(new BarraMenu().añadirMenu());
		
		JButton test = new JButton("ventana de ver mas tarde");
		this.add(test, BorderLayout.CENTER);
		setVisible(true);
	}

}
