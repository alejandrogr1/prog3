package gui.paneles;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFiltros extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelFiltros(){
		JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));	
		JLabel labelGenero = new JLabel("Género: ");
		String[] generos = {"Todos", "Acción", "Aventura", "Comedia", "Drama", "Fantasía", "Horror", "Romance"};
		JComboBox<String> comboGeneros = new JComboBox<>(generos);
		
		JLabel labelTipo = new JLabel("Tipo: ");
		String[] tipos = {"Todos", "Serie", "Película"};
		JComboBox<String> comboTipos = new JComboBox<>(tipos);
		
		JLabel labelOrden = new JLabel("Ordenar por: ");
		String[] orden = {"Más populares", "Mejor valorados", "Título(A-Z)", "Nuevos"};
		JComboBox<String> comboOrden = new JComboBox<>(orden);
		
		
		panelFiltros.add(labelGenero);
		panelFiltros.add(comboGeneros);
		panelFiltros.add(labelTipo);
		panelFiltros.add(comboTipos);
		panelFiltros.add(labelOrden);
		panelFiltros.add(comboOrden);
		
		
		add(panelFiltros);
	}
}
