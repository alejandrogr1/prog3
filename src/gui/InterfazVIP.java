package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class InterfazVIP extends JFrame {
	
	String vipComprado = "None";
	String fechaInicio = "None";
	String fechaCaducidad = "None";
	double totalPagado = 0;
	double pagoPendiente = 0;
	
	// Long para poner numeros grandes y volatile long para que el valor pueda ser cambiado por hilos
	volatile long segundos = 0;
	JLabel contador;
	JTabbedPane tabs = new JTabbedPane();

	public InterfazVIP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800, 1000);
		setResizable(false);
		setLocationRelativeTo(null);

		// Añadir menubar, botones de notificación y perfil desde otra clase
		this.setJMenuBar(new InterfazHerramientas().añadirMenu(this));
		JPanel panelCabecera = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel(" VIP ");
		titulo.setFont(new Font("Georgia", Font.BOLD, 42));
		// Foreground es color del texto
		titulo.setForeground(new Color(212, 175, 55)); // Gold
		panelCabecera.add(titulo, BorderLayout.WEST);
		panelCabecera.add(new InterfazHerramientas().añadirPerfilyNotificacion(), BorderLayout.EAST);
		this.add(panelCabecera, BorderLayout.NORTH);
		this.add(tabs, BorderLayout.CENTER);

		tabs.addTab("", panelVip("SEMANAL"));
		JLabel cabecera1 = new JLabel("SEMANAL");
		cabecera1.setFont(new Font("Georgia", Font.BOLD, 25));
		cabecera1.setPreferredSize(new Dimension(180, 50));
		tabs.setTabComponentAt(0, cabecera1);

		tabs.addTab("", panelVip("MENSUAL"));
		JLabel cabecera2 = new JLabel("MENSUAL");
		cabecera2.setFont(new Font("Georgia", Font.BOLD, 25));
		cabecera2.setPreferredSize(new Dimension(180, 50));
		tabs.setTabComponentAt(1, cabecera2);

		tabs.addTab("", panelVip("ANUAL"));
		JLabel cabecera3 = new JLabel("ANUAL");
		cabecera3.setFont(new Font("Georgia", Font.BOLD, 25));
		cabecera3.setPreferredSize(new Dimension(180, 50));
		tabs.setTabComponentAt(2, cabecera3);

		tabs.addTab("", panelMiEstado());
		JLabel cabecera4 = new JLabel("MI ESTADO");
		cabecera4.setFont(new Font("Georgia", Font.BOLD, 25));
		cabecera4.setPreferredSize(new Dimension(180, 50));
		tabs.setTabComponentAt(3, cabecera4);

		// Hilo que cuenta segundos, si segundos mayor qu e 0 y resta 1 cada segundo
		Thread hilo = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}

				if (segundos > 0) {
					segundos--;
					if (segundos == 0) {
						
						// Cuando termina el tiempo actualiza el estado
						String caducado = vipComprado;
						vipComprado = "None";
						fechaInicio = "None";
						fechaCaducidad = "None";
						totalPagado = 0;
						pagoPendiente = 0;
						
						// Pestaña que salta cuando termina el tiempo para decir que ha caducado
						 // SwingUtilities.invokeLater para el hilo poder modificar
						SwingUtilities.invokeLater(() -> {
							tabs.setComponentAt(3, panelMiEstado());
							JOptionPane.showMessageDialog(this, "Su " + caducado + " ha caducado");
						});
					}
				}
				
				// Actucalizar el contar que se demuestra
				SwingUtilities.invokeLater(() -> {
					if (contador != null) {
						contador.setText(formatoTiempo(segundos));
					}
				});
			}
		});
		hilo.setDaemon(true); // se cierra cuando se cierra el ventana
		hilo.start();

		setVisible(true);
	}
	
	// Concierte Segundos a tiempo horas : minustos : segundos
	public String formatoTiempo(long s) {
		// %02d, %d hace que muestre entero, 2 que muestre al menos 2 caracteres y 0 que se rellene con 0 la izquirda
		return String.format("%02d:%02d:%02d", s / 3600, (s % 3600) / 60, s % 60);
	}
	
	// Método que crea ventana para probar el hilo sumando y restando tiempo
	public void abrirVentanaTiempo() {
		
		// true hace que no puede interactuar con otra cosa hasta cerrar esta ventana
		JDialog ventana = new JDialog(this, "Test Duarción", true);
		ventana.setLayout(new GridLayout(4, 2, 10, 10));

		String[] nombres = {"1 año", "1 mes", "1 semana", "24 horas"};
		long[] segundos = {31536000L, 2592000L, 604800L, 86400L};
		
		// Bucle que pone 8 botones para sumar y restar tiempo que cuenta el hilo
		for (int i = 0; i < 4; i++) {
			long s = segundos[i];
			
			JButton mas = new JButton("+ " + nombres[i]);
			mas.addActionListener(e -> cambiarTiempo(s));
			
			JButton menos = new JButton("- " + nombres[i]);
			menos.addActionListener(e -> cambiarTiempo(-s));
			
			ventana.add(mas);
			ventana.add(menos);
		}
		
		ventana.setSize(350, 250);
		ventana.setLocationRelativeTo(this);
		ventana.setVisible(true);
	}
	
	// Método que actualiza el fecha de caducidad
	public void actualizarCaducidad() {
		// LocalDateTime.now() es fecha inicio, con ello sumar el tiempo y toSting para mostrar
		fechaCaducidad = LocalDateTime.now().plusSeconds(segundos).toLocalDate().toString();
	}
	
	// Método para cambiar el tiempo
	public void cambiarTiempo(long segundos1) {
		
		// Si no hay vip, demustra un mensaje de que no hay y no hace nada mas
		if (vipComprado.equals("none")) {
			JOptionPane.showMessageDialog(this, "No tienes ningún VIP");
			return;
		}
		
		segundos += segundos1;
		
		// Para que no hay negativos
		if (segundos < 1) {
			segundos = 1; // si restas de más, caduca en 1 segundo
		}
		
		actualizarCaducidad();
		tabs.setComponentAt(3, panelMiEstado());
	}
	
	// Método que hace el panel segun un string
	public JPanel panelVip(String tiempo) {
		// Si es semanal no cambia
		double precio = 50;
		
		if ("MENSUAL".equals(tiempo)) {
			precio = precio * 3;
			
		} else if ("ANUAL".equals(tiempo)) {
			precio = precio * 9;
		}

		Color gold = new Color(212, 175, 55);
		Color verde = new Color(46, 160, 67);
		Color rojo = new Color(200, 50, 50);
		
		// Panel principal
		JPanel panelp = new JPanel(new BorderLayout());
		
		// 4 paneles vacios para que el contenido se quede en el medio
		JPanel panelvacio1 = new JPanel();
		panelvacio1.setPreferredSize(new Dimension(0, 40));
		JPanel panelvacio2 = new JPanel();
		panelvacio2.setPreferredSize(new Dimension(0, 40));
		JPanel panelvacio3 = new JPanel();
		panelvacio3.setPreferredSize(new Dimension(50, 50));
		JPanel panelvacio4 = new JPanel();
		panelvacio4.setPreferredSize(new Dimension(50, 50));
		JPanel paneljunto = new JPanel(new GridLayout(1, 3, 80, 0));

		String[] titulos = {"Sin Suscripción", "Con Suscripción", "Suscripción VIP+"};
		String[] propiedades = {"Pago Único", "Pago Consecutivo", "Contenido VIP",
				"Sin Anuncios", "Nombre Especial en Perfil"};

		// Una fila por por titulo, 3 paneles y con sus propiedades
		boolean[][] tiene = {
			{true,  false, true, false, false}, // Sin Suscripción
			{false, true,  true, true,  false}, // Con Suscripción
			{false, true,  true, true,  true }  // VIP+
		};
		
		double[] precios = {precio, precio * 0.9, precio * 1.2};

		// Buvle que hace 3 paneles
		for (int i = 0; i <= 2; i++) {
			JPanel panel = new JPanel(new BorderLayout(0, 20));
			
			// Combianr dos borders
			panel.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(gold, 4), // la linea border que lo rodea, 4px grosor
					BorderFactory.createEmptyBorder(25, 25, 25, 25))); // espacio entre lo que hay dentro con el border
			panel.setPreferredSize(new Dimension(500, 700));

			// Título con subrayado
			JLabel titulo = new JLabel(titulos[i], SwingConstants.CENTER);
			titulo.setFont(new Font("Georgia", Font.BOLD, 28));
			titulo.setBorder(BorderFactory.createCompoundBorder(
					
					// Border(arriba, izquierda, abajo, derecha)
					BorderFactory.createMatteBorder(0, 0, 3, 0, gold), // subrayado/borde 3px abajo, grosor, 0 es que no hay
					BorderFactory.createEmptyBorder(0, 0, 10, 0)));    // espacio entre lo que hay dentro con el border
			panel.add(titulo, BorderLayout.NORTH);

			//Propiedades
			//propiedades.length + 1 para minPagos en 2 de 3 paneles
			JPanel props = new JPanel(new GridLayout(propiedades.length + 1, 1, 0, 10));
			
			// Segundo bucle que corre propiedades por fila de un panel
			for (int j = 0; j < propiedades.length; j++) {
				
				// Una fila
				JPanel fila = new JPanel(new BorderLayout());
				JLabel nombre = new JLabel(propiedades[j]);
				nombre.setFont(new Font("Georgia", Font.PLAIN, 20));

				// \u2714 es tick y \u2718 es cruz
				JLabel tick = new JLabel(tiene[i][j] ? "\u2714" : "\u2718", SwingConstants.CENTER); // SwingConstants.CENTER para que se ponga en el medio
				tick.setFont(new Font("Dialog", Font.BOLD, 26));
				// Foreground es color del texto
				tick.setForeground(tiene[i][j] ? verde : rojo);

				fila.add(nombre, BorderLayout.WEST);
				fila.add(tick, BorderLayout.EAST);
				props.add(fila);
			}
			// si es la segunado y la tercera panel poner minPagos
			JLabel minPagos = new JLabel(i >= 1 ? "Mínimo 2 pagos" : "", SwingConstants.CENTER);
			minPagos.setFont(new Font("Georgia", Font.ITALIC, 18));
			// Foreground es color del texto
			minPagos.setForeground(gold);
			props.add(minPagos);
			panel.add(props, BorderLayout.CENTER);

			// Precio
			JPanel abajo = new JPanel(new GridLayout(2, 1, 0, 15));
			JLabel labelPrecio = new JLabel("Precio: " + precios[i] + " €", SwingConstants.CENTER);
			labelPrecio.setFont(new Font("Georgia", Font.BOLD, 26));
			
			// Boton comprar
			JButton comprar = new JButton("Comprar");
			comprar.setFont(new Font("Georgia", Font.BOLD, 22));
			comprar.setBackground(gold);
			// Foreground es color del texto
			comprar.setForeground(Color.BLACK);
			
			// Lo que hace el boton comprar, actualiza MI ESTADO
			int n = i; // copia de i para usarla dentro del botón, sino da error
			comprar.addActionListener(e -> {
				
				long duracion = 7 * 24 * 3600L;
			
				if ("MENSUAL".equals(tiempo)) {
					duracion = 30 * 24 * 3600L;
				} else if ("ANUAL".equals(tiempo)) {
					duracion = 365 * 24 * 3600L;
				}

				double pagado = precios[n];
				
				// Para la segunda y la tercera panel que se paga dos veces
				double pendiente = (n == 0) ? 0 : precios[n] * 2 - pagado;

				if (vipComprado.equals(titulos[n])) {   
					// Si es mismo VIP se suma
					segundos += duracion;
					totalPagado += pagado;
					pagoPendiente += pendiente;
				} else {
					// Si es VIP distinto empieza de nuevo
					vipComprado = titulos[n];
					fechaInicio = LocalDate.now().toString();
					segundos = duracion;
					totalPagado = pagado;
					pagoPendiente = pendiente;
				}
				
				actualizarCaducidad();
				// Actualiza MI ESTADO
				tabs.setComponentAt(3, panelMiEstado());
			});

			abajo.add(labelPrecio);
			abajo.add(comprar);
			panel.add(abajo, BorderLayout.SOUTH);

			paneljunto.add(panel);
		}

		// 4 paneles vacios para que el contenido se quede en el medio
		panelp.add(panelvacio1, BorderLayout.NORTH);
		panelp.add(panelvacio2, BorderLayout.SOUTH);
		panelp.add(panelvacio3, BorderLayout.WEST);
		panelp.add(panelvacio4, BorderLayout.EAST);
		
		panelp.add(paneljunto, BorderLayout.CENTER);

		return panelp;
	}

	public JPanel panelMiEstado() {
		Color gold = new Color(212, 175, 55);

		// Panel principal
		JPanel panelp = new JPanel(new BorderLayout());
		// 4 paneles vacios para que el contenido se quede en el medio
		JPanel vacio1 = new JPanel(); 
		vacio1.setPreferredSize(new Dimension(0, 40));
		JPanel vacio2 = new JPanel(); 
		vacio2.setPreferredSize(new Dimension(0, 40));
		JPanel vacio3 = new JPanel(); 
		vacio3.setPreferredSize(new Dimension(300, 50));
		JPanel vacio4 = new JPanel(); 
		vacio4.setPreferredSize(new Dimension(300, 50));

		//panel con el contenido y border
		JPanel panel = new JPanel(new BorderLayout(0, 20));
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(gold, 4), // la linea border que lo rodea, 4px grosor
				BorderFactory.createEmptyBorder(25, 25, 25, 25))); // espacio entre lo que hay dentro con el border

		// Título con Subrayado
		JLabel titulo = new JLabel("MI ESTADO", SwingConstants.CENTER);
		titulo.setFont(new Font("Georgia", Font.BOLD, 28));
		titulo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 3, 0, gold), // subrayado/borde 3px abajo, grosor, 0 es que no hay
				BorderFactory.createEmptyBorder(0, 0, 10, 0))); // espacio entre lo que hay dentro con el border
		panel.add(titulo, BorderLayout.NORTH);

		// 	Propiedades y valor, misma longitud
		String[] propiedades = {"VIP Comprado", "Fecha de Inicio", "Fecha de Caducidad",
				"Total Pagado", "Pago Pendiente", "Tiempo Restante"};
		String[] valores = {vipComprado, fechaInicio, fechaCaducidad, totalPagado + " €",
				pagoPendiente + " €", formatoTiempo(segundos)};

		JPanel props = new JPanel(new GridLayout(propiedades.length, 1, 0, 10));
		
		// Bucle que corre las propiedades por fila
		for (int j = 0; j < propiedades.length; j++) {
			JPanel fila = new JPanel(new BorderLayout());

			JLabel nombre = new JLabel(propiedades[j]);
			nombre.setFont(new Font("Georgia", Font.PLAIN, 20));

			//SwingConstants.RIGHT para que se ponga en la derecha
			JLabel valor = new JLabel(valores[j], SwingConstants.RIGHT);
			valor.setFont(new Font("Georgia", Font.BOLD, 22));
			
			// VIP color gold
			if (j == 0) valor.setForeground(gold);
			
			// si hay pendiente se pone en rojo y si no hay en verde
			if (j == 4) valor.setForeground(pagoPendiente > 0 ? new Color(200, 50, 50)  // rojo
			                                                  : new Color(46, 160, 67)); // verde
			// El hilo lo actualiza
			if (j == 5) contador = valor;

			fila.add(nombre, BorderLayout.WEST);
			fila.add(valor, BorderLayout.EAST);
			props.add(fila);
		}
		panel.add(props, BorderLayout.CENTER);

		// Boton de test duración
		JButton botonTiempo = new JButton("Test duración");
		botonTiempo.setFont(new Font("Georgia", Font.BOLD, 18));
		botonTiempo.setBackground(gold);
		// Foreground es color del texto
		botonTiempo.setForeground(Color.BLACK);
		
		// Abre una ventana para modificar tiempo, Test duración
		botonTiempo.addActionListener(e -> abrirVentanaTiempo());
		
		// Abajo a la aderecha
		JPanel derecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		derecha.add(botonTiempo);
		panel.add(derecha, BorderLayout.SOUTH);

		// 4 paneles vacios para que el contenido se quede en el medio
		panelp.add(vacio1, BorderLayout.NORTH);
		panelp.add(vacio2, BorderLayout.SOUTH);
		panelp.add(vacio3, BorderLayout.WEST);
		panelp.add(vacio4, BorderLayout.EAST);
		
		panelp.add(panel, BorderLayout.CENTER);
		
		return panelp;
	}

}
	
