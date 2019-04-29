package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import gui.utils.CacheImagenes;
import modelo.Curso;
import modelo.controladores.CursoControlador;

public class PanelGestionCursosAcademicos extends JPanel {

	public static int PRIMERO = 0;
	public static int ANTERIOR = 1;
	public static int SIGUIENTE = 2;
	public static int ULTIMO = 3;
	public static int NUEVO = 4;
	public static int GUARDAR = 5;
	public static int ELIMINAR = 6;
	
	
	public PanelGestionCursosAcademicos () {
		super();
		// Establezco el panel principal de la aplicaci�n y la barra de herramientas
		this.setLayout(new BorderLayout());
		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(getPanelGestion(), BorderLayout.CENTER);
		this.actual = CursoControlador.getControlador().findFirst();	
		cargarDatosActual();
		
		
	}
	
	JTextField jtfId = new JTextField(5);
	JTextField jtfDescripcion = new JTextField(15);
	private Dimension minimaDimensionJTextField = new Dimension (150, 20);

	Curso actual = null;
	

	/**
	 * 
	 */
	private JPanel getPanelGestion () {
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(Color.pink);
		panelGestion.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Inclusi�n del JTextField para el Id
		c.gridx = 0;
	    c.gridy = 0;
	    c.insets = new Insets(5, 5, 5, 5);
	    c.anchor = GridBagConstraints.EAST;
	    panelGestion.add(new JLabel("Identificador: "), c);
		
		c.gridx = 1;
	    jtfId.setEnabled(false);
	    jtfId.setMinimumSize(minimaDimensionJTextField);
	    c.anchor = GridBagConstraints.WEST;
	    panelGestion.add(jtfId, c);

		// Inclusi�n del JTextField para la descripci�n
		c.gridx = 0;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.EAST;
	    panelGestion.add(new JLabel("Descripci�n: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    jtfDescripcion.setMinimumSize(minimaDimensionJTextField);
	    panelGestion.add(jtfDescripcion, c);

	    return panelGestion;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private JToolBar getBarraHerramientas() {
		JToolBar toolBar = new JToolBar();
		
		JButton jbtPrimero = new JButton();
		asignarFuncion(jbtPrimero, "gotostart.png", PRIMERO);
		toolBar.add(jbtPrimero);

		JButton jbtPrevio = new JButton();
		asignarFuncion(jbtPrevio, "previous.png", ANTERIOR);
		toolBar.add(jbtPrevio);

		JButton jbtSiguiente = new JButton();
		asignarFuncion(jbtSiguiente, "next.png", SIGUIENTE);
		toolBar.add(jbtSiguiente);

		JButton jbtUltimo = new JButton();
		asignarFuncion(jbtUltimo, "gotoend.png", ULTIMO);
		toolBar.add(jbtUltimo);

		JButton jbtNuevo = new JButton();
		asignarFuncion(jbtNuevo, "nuevo.png", NUEVO);
		toolBar.add(jbtNuevo);

		JButton jbtGuardar = new JButton();
		asignarFuncion(jbtGuardar, "guardar.png", GUARDAR);
		toolBar.add(jbtGuardar);

		JButton jbtEliminar = new JButton();
		asignarFuncion(jbtEliminar, "eliminar.png", ELIMINAR);
		toolBar.add(jbtEliminar);

		return toolBar;
	}
	
	

	
	/**
	 * 
	 */
	private void nuevo () {
		limpiarPantalla();
		JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
	}
	

	/**
	 * 
	 */
	private void limpiarPantalla() {
		this.jtfId.setText("");
		this.jtfDescripcion.setText("");
		
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		Curso nuevoRegistro = new Curso();
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		
		nuevoRegistro.setDescripcion(this.jtfDescripcion.getText());
		
		
		if (nuevoRegistro.getId() == 0) {
			CursoControlador.getControlador().persist(nuevoRegistro);
		}
		else {
			CursoControlador.getControlador().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Curso eliminar () {
		String respuestas[] = new String[] {"S�", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"�Realmente desea eliminar el registro?", "Eliminaci�n del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Curso nuevoAMostrar = CursoControlador.getControlador().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = CursoControlador.getControlador().findNext(actual);
	    	}
	    	CursoControlador.getControlador().remove(actual);
			JOptionPane.showMessageDialog(this, "Eliminaci�n correcta");

	    	if (nuevoAMostrar != null) {
	    		actual = nuevoAMostrar;
	    	}
	    	else {
	    		limpiarPantalla();
	    	} 
	    }
	    return actual;
	}
	
	
	
	/**
	 * 
	 * @param jbt
	 * @param funcion
	 */
	private void asignarFuncion (JButton jbt, String icono, final int funcion) {
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		jbt.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				
				Curso obtenido = null;
				if (funcion == PRIMERO) 
					obtenido = CursoControlador.getControlador().findFirst();
				if (funcion == ANTERIOR) 
					obtenido = CursoControlador.getControlador().findPrevious(actual);
				if (funcion == SIGUIENTE) 
					obtenido = CursoControlador.getControlador().findNext(actual);
				if (funcion == ULTIMO) 
					obtenido = CursoControlador.getControlador().findLast();
				if (funcion == NUEVO) 
					nuevo();
				if (funcion == GUARDAR) 
					guardar();
				if (funcion == ELIMINAR) 
					obtenido = eliminar();
				
				if (obtenido != null) {
					actual = obtenido;
					cargarDatosActual();
				}
			}});
	}
	

	/**
	 * 
	 */
	private void cargarDatosActual () {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfDescripcion.setText(this.actual.getDescripcion());
		}
	}
	
	
	
}
