package gui;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import domain.Catalogo;
import domain.Contenido;



public class InterfazUpAndComing extends JFrame {

	/**
	 * TODO 
	 * En esta ventana se veran peliculas que aun no han salido
	 */
	
	private static final long serialVersionUID = 1L;
	
	private InterfazHerramientas herramientas = new InterfazHerramientas();

	public InterfazUpAndComing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		
		 setJMenuBar(herramientas.añadirMenu(this));
	     setLayout(new BorderLayout());
		
	     JLabel titulo = new JLabel("Up & Coming - Proximas Peliculas");
	     titulo.setFont(new Font("Verdana", Font.BOLD, 35));
	     titulo.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
	     add(titulo, BorderLayout.NORTH);
	     
	     Catalogo catalogo = Catalogo.crearCatalogoDeEjemplo();
	     ArrayList<Contenido> c = catalogo.getTodos();
		
	     ModeloMatrizContenido modelo = new ModeloMatrizContenido(c);
	     JTable tabla = new JTable(modelo);
	     tabla.setRowHeight(70);
	     tabla.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 16));
	     tabla.setFont(new Font("Verdana", Font.PLAIN, 14));
	     
	     tabla.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
	     
	     RendererContenido renderer = new RendererContenido();
	        for (int i = 1; i < tabla.getColumnCount(); i++) {
	            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
	            tabla.getColumnModel().getColumn(i).setPreferredWidth(250);
	        }
	        
	     JScrollPane scrollPane = new JScrollPane(tabla);
	     scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 30, 30, 30));
	     add(scrollPane, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	private class RendererContenido extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
        		boolean isSelected, boolean hasFocus, int row, int column) {

            if (column == 0 || value == null || !(value instanceof Contenido)) {
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }

            Contenido c = (Contenido) value;

            String textoHtml =
                    "<html><div style='text-align:center;'>"
                    + "<b>" + c.getTitulo() + "</b><br>"
                    + c.getAnyo() + " · " + c.getValoracion() + "/5<br>"
                    + "<i>" + c.getTipo().getNombreVisible() + "</i>"
                    + "</div></html>";

            JLabel label = new JLabel(textoHtml, JLabel.CENTER);
            label.setOpaque(true);
            label.setToolTipText(c.getTitulo() + " - " + c.getSinopsis());

            
//            TODO: CUANDO HAYA BASE DE DATOS E IMÁGENES REALES,
//            DESCOMENTAR ESTE BLOQUE Y BORRAR EL TEXTO DE ARRIBA:
//            
//            String ruta = c.getRutaImagen();
//            java.net.URL url = InterfazUpAndComing.class.getResource(ruta);
//            if (url != null) {
//                javax.swing.ImageIcon icono = new javax.swing.ImageIcon(url);
//                icono = herramientas.imageResize(icono, 100, 70);
//                label.setIcon(icono);
//                label.setText("<html><center><b>" + c.getTitulo() + "</b></center></html>");
//                label.setHorizontalTextPosition(JLabel.CENTER);
//                label.setVerticalTextPosition(JLabel.BOTTOM);
//            }

            if (isSelected) {
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
            } else {
                label.setBackground(table.getBackground());
                label.setForeground(table.getForeground());
            }

            return label;
        }
    }

//    Test
//    public static void main(String[] args) {
//        new InterfazUpAndComing();
//    }

}
