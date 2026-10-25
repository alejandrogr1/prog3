package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterfazUpAndComing extends JFrame {

	/**
	 * En esta ventana se veran peliculas que aun no han salido
	 */
	private static final long serialVersionUID = 1L;

	private JTable tabla;
	
	private ImageIcon imagen1,imagen2,imagen3;
	
	public InterfazUpAndComing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		
//		JButton test = new JButton("ventana de up and coming");
//		this.add(test, BorderLayout.CENTER);
		
		DefaultTableModel modelo = new DefaultTableModel(2, 3) {
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        if (columnIndex == 0) { 
		            return ImageIcon.class; 
		        }if(columnIndex == 1) { 
		            return ImageIcon.class; 
		        }if(columnIndex == 2) { 
			            return ImageIcon.class; 
		        }
		        return Object.class;
		    }
		};
		
		
		tabla = new JTable(modelo);
		tabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabla.setRowHeight(700); 
		add(tabla,BorderLayout.CENTER);
		
		imagen1 = new ImageIcon(getClass().getResource("/images/pelis.png"));
		
		imagen2 = new ImageIcon(getClass().getResource("/images/pelis.png"));
		
		imagen3 = new ImageIcon(getClass().getResource("/images/pelis.png"));
		
		tabla.setValueAt(imagen1, 0, 0);
		
		tabla.setValueAt(imagen2, 0, 1);
		
		tabla.setValueAt(imagen3, 0, 2);
		
		
		
		
		
		
		
		
		setVisible(true);
	}

}
