package Main;

import javax.swing.JFrame;

import gui.InterfazHome;
import gui.VentanaLogin;

public class Main extends JFrame {

	public static void main(String[] args) {
		//En la ventana login al dar a iniciar sesión abre la interfaz Home
		new VentanaLogin();
	}

}
