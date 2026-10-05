package default1;

import javax.swing.JFrame;

public class TestVentana extends JFrame {
	

	private static final long serialVersionUID = 1L;



	public TestVentana() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 400);
		
		
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new TestVentana();
	}

}
