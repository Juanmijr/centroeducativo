package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import gui.utils.CacheImagenes;
import modelo.Curso;
import modelo.Materia;
import modelo.controladores.CursoControlador;
import modelo.controladores.MateriaControlador;



public class PanelGestionMateria extends JPanel {
	
	public static int PRIMERO = 0;
	public static int ANTERIOR = 1;
	public static int SIGUIENTE = 2;
	public static int ULTIMO = 3;
	public static int NUEVO = 4;
	public static int GUARDAR = 5;
	public static int ELIMINAR = 6;

	public PanelGestionMateria() {
		super();
		// Establezco el panel principal de la aplicaci�n y la barra de herramientas
				this.setLayout(new BorderLayout());
				this.add(getBarraHerramientas(), BorderLayout.NORTH);
				this.add(getPanelGestion(), BorderLayout.CENTER);
				this.actual = MateriaControlador.getControlador().findFirst();	
				cargarDatosActual();	
		
	}
	
	Materia actual = null;
	JTextField jtfId = new JTextField(5);
	JTextField jtfNombre = new JTextField(40);
	JTextField jtfAcrónimo = new JTextField(40);
	JComboBox<Curso> jcbMateria = new JComboBox<Curso>();
	private Dimension minimaDimensionJTextField = new Dimension (150, 20);
	
	
	/**
	 * 
	 */
	private JPanel getPanelGestion () {
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(Color.PINK);
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

	 // Inclusi�n del JTextField para el Id
	 		c.gridx = 0;
	 	    c.gridy = 1;
	 	    c.insets = new Insets(5, 5, 5, 5);
	 	    c.anchor = GridBagConstraints.EAST;
	 	    panelGestion.add(new JLabel("Nombre: "), c);
	 		
	 		c.gridx = 1;
	 	    jtfId.setMinimumSize(minimaDimensionJTextField);
	 	    c.anchor = GridBagConstraints.WEST;
	 	    panelGestion.add(jtfNombre, c);
	    
	 	// Inclusi�n del JTextField para el Id
			c.gridx = 0;
		    c.gridy = 2;
		    c.insets = new Insets(5, 5, 5, 5);
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Acrónimo: "), c);
			
			c.gridx = 1;
		    jtfAcrónimo.setMinimumSize(minimaDimensionJTextField);
		    c.anchor = GridBagConstraints.WEST;
		    
		    panelGestion.add(jtfAcrónimo, c);
	 	    
		 // Inclusi�n del JTextField para el Id
			c.gridx = 0;
		    c.gridy = 3;
		    c.insets = new Insets(5, 5, 5, 5);
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Id Curso "), c);
			
			c.gridx = 1;
		    jtfId.setMinimumSize(minimaDimensionJTextField);
		    inicializaComboBoxFabricante();
		    c.anchor = GridBagConstraints.WEST;
		    panelGestion.add(jcbMateria, c);
		    
		
	    return panelGestion;
	}
	/**
	 * 
	 */
	private void inicializaComboBoxFabricante () {
		List<Curso> cursos = CursoControlador.getControlador().findAllTipologiaSexo();
		for (Curso curso : cursos) {
			jcbMateria.addItem(curso);
		}
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
		this.jtfNombre.setText("");
		this.jtfAcrónimo.setText("");
		this.jcbMateria.setSelectedIndex(0);		
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		Materia nuevoRegistro = new Materia();
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		
		nuevoRegistro.setNombre(this.jtfNombre.getText());
		nuevoRegistro.setAcronimo(this.jtfAcrónimo.getText());
		
		
		if (nuevoRegistro.getId() == 0) {
			MateriaControlador.getControlador().persist(nuevoRegistro);
		}
		else {
			MateriaControlador.getControlador().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Materia eliminar () {
		String respuestas[] = new String[] {"S�", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"�Realmente desea eliminar el registro?", "Eliminaci�n del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Materia nuevoAMostrar = MateriaControlador.getControlador().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = MateriaControlador.getControlador().findNext(actual);
	    	}
	    	MateriaControlador.getControlador().remove(actual);
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
				
				Materia obtenido = null;
				if (funcion == PRIMERO) 
					obtenido = MateriaControlador.getControlador().findFirst();
				if (funcion == ANTERIOR) 
					obtenido = MateriaControlador.getControlador().findPrevious(actual);
				if (funcion == SIGUIENTE) 
					obtenido = MateriaControlador.getControlador().findNext(actual);
				if (funcion == ULTIMO) 
					obtenido = MateriaControlador.getControlador().findLast();
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
			this.jtfId.setText("" +  this.actual.getId());
			this.jtfNombre.setText(this.actual.getNombre());
			this.jtfAcrónimo.setText(this.actual.getAcronimo());
			 //Cargo el valor del JComboBox del fabricante
			for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
				if (actual.getCurso().getId() == this.jcbMateria.getItemAt(i).getId()) {
					this.jcbMateria.setSelectedIndex(i);
					break;
				}
			}		
			
			

		}
	}
	
}
