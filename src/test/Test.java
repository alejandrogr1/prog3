package test;

import javax.swing.JFrame;

public class Test extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	public Test() {
		setBounds(600,400,600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test();
	}

}
