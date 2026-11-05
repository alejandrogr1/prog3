package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Contenido;
import domain.Genero;

public class ModeloMatrizContenido extends DefaultTableModel{

	/**
	 * TODO
	 * Este archivo se hace cargo del modelo de la JTable de Up&Coming 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	 private List<String> lTitulos = Arrays.asList("", "90+", "80+", "70+", "50+");
	    private Object[][] matriz;

	    public ModeloMatrizContenido(List<Contenido> listaContenidos) {
	        // 1 fila por cada género, 1 + 4 columnas (género + rangos)
	        matriz = new Object[Genero.values().length][lTitulos.size()];

	        // Columna 0: nombre del género
	        for (int f = 0; f < matriz.length; f++) {
	            matriz[f][0] = Genero.values()[f];
	        }

	        // Rellenar celdas según género y rango de valoración
	        for (Contenido c : listaContenidos) {
	            int fila = c.getGenero().ordinal(); // A->0, B->1...
	            int columna = obtenerColumnaValoracion(c.getValoracion());
	            if (columna != -1) {
	                // Si ya hay uno en esa celda, puedes concatenar o guardar en lista.
	                // Aquí guardamos el primero que aparezca:
	                if (matriz[fila][columna] == null) {
	                    matriz[fila][columna] = c;
	                }
	            }
	        }
	    }

	    /**
	     * Devuelve el índice de columna según la valoración.
	     * 90+ -> 1, 80+ -> 2, 70+ -> 3, 50+ -> 4
	     */
	    private int obtenerColumnaValoracion(double valoracion) {
	        if (valoracion >= 90) return 1;
	        if (valoracion >= 80) return 2;
	        if (valoracion >= 70) return 3;
	        if (valoracion >= 50) return 4;
	        return -1; // por debajo de 50 no se muestra
	    }

	    @Override
	    public int getRowCount() {
	        if (matriz == null) return 0;
	        return matriz.length;
	    }

	    @Override
	    public int getColumnCount() {
	        return lTitulos.size();
	    }

	    @Override
	    public String getColumnName(int column) {
	        return lTitulos.get(column);
	    }

	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }

	    @Override
	    public Object getValueAt(int row, int column) {
	        return matriz[row][column];
	    }
	}