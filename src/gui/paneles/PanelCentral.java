package gui.paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelCentral extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public PanelCentral(){
		setLayout(new BorderLayout());
		
		JPanel panelCabecera = new JPanel(new GridLayout(2,1));
		
		PanelBuscador buscador = new PanelBuscador();
		PanelFiltros  filtros = new PanelFiltros();
		
		panelCabecera.add(buscador);
		panelCabecera.add(filtros);
		
		add(panelCabecera, BorderLayout.NORTH);
	}
	
	
}
