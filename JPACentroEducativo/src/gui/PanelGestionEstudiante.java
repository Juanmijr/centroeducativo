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
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import gui.utils.CacheImagenes;
import modelo.Estudiante;
import modelo.Materia;
import modelo.TipologiaSexo;
import modelo.controladores.CursoControlador;
import modelo.controladores.EstudianteControlador;
import modelo.controladores.TipologiaSexoControlador;


public class PanelGestionEstudiante extends JPanel{
	
	public static int PRIMERO = 0;
	public static int ANTERIOR = 1;
	public static int SIGUIENTE = 2;
	public static int ULTIMO = 3;
	public static int NUEVO = 4;
	public static int GUARDAR = 5;
	public static int ELIMINAR = 6;
	
	private JPanelDatosPersonales panel = new JPanelDatosPersonales();

	public PanelGestionEstudiante() {
		super();
		// Establezco el panel principal de la aplicaci�n y la barra de herramientas
				this.setLayout(new BorderLayout());
				this.add(getBarraHerramientas(), BorderLayout.NORTH);
				this.add(panel, BorderLayout.CENTER);
				this.actual = EstudianteControlador.getControlador().findFirst();	
				cargarDatosActual();	
		
	}
	
	

	Estudiante actual = null;
	JTextField jtfId = new JTextField(5);
	
	
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
		panel.getJtfId().setText("");
		panel.getJtfNombre().setText("");
		panel.getJtf1Apellido().setText("");
		panel.getJtf2Apellido().setText("");
		panel.getJtfDni().setText("");
		panel.getJtfDireccion().setText("");
		panel.getJtfEmail().setText("");
		panel.getJtfTelefono().setText("");
		panel.getJcbSexo().setSelectedIndex(0);
		panel.getJtfColor().setText("");
		

		
	}
	
	
	private void guardar () {
		Estudiante nuevoRegistro = new Estudiante();
		
		if (panel.getJtfId().getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else { 
		nuevoRegistro.setId(Integer.parseInt(panel.getJtfId().getText()));
		
		nuevoRegistro.setNombre(panel.getJtfNombre().getText());
		nuevoRegistro.setApellido1(panel.getJtf1Apellido().getText());
		nuevoRegistro.setApellido2(panel.getJtf2Apellido().getText());
		nuevoRegistro.setDni(panel.getJtfDni().getText());
		nuevoRegistro.setDireccion(panel.getJtfDireccion().getText());
		nuevoRegistro.setEmail(panel.getJtfEmail().getText());
		nuevoRegistro.setTelefono(panel.getJtfTelefono().getText());
		nuevoRegistro.setTipologiaSexo((TipologiaSexo) panel.getJcbSexo().getSelectedItem());
	//	nuevoRegistro.setColor(panel.getJtfColor().getText());
		byte[] imagenAMostrar = null;
		if (panel.getFichero()!=null) {
			try {
				imagenAMostrar = Files.readAllBytes(panel.getFichero().toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nuevoRegistro.setImagen(imagenAMostrar);
			panel.getJspImagen().setViewportView(new JLabel(new ImageIcon(imagenAMostrar)));
		} else {
			nuevoRegistro.setImagen(actual.getImagen());
		}
		
		if (nuevoRegistro.getId() == 0) {
			EstudianteControlador.getControlador().persist(nuevoRegistro);
		}
		else {
			EstudianteControlador.getControlador().merge(nuevoRegistro);
		}
		
		panel.getJtfId().setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Estudiante eliminar () {
		String respuestas[] = new String[] {"S�", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"�Realmente desea eliminar el registro?", "Eliminaci�n del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Estudiante nuevoAMostrar = EstudianteControlador.getControlador().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = EstudianteControlador.getControlador().findNext(actual);
	    	}
	    	EstudianteControlador.getControlador().remove(actual);
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
				
				Estudiante obtenido = null;
				if (funcion == PRIMERO) 
					obtenido = EstudianteControlador.getControlador().findFirst();
				if (funcion == ANTERIOR) 
					obtenido = EstudianteControlador.getControlador().findPrevious(actual);
				if (funcion == SIGUIENTE) 
					obtenido = EstudianteControlador.getControlador().findNext(actual);
				if (funcion == ULTIMO) 
					obtenido = EstudianteControlador.getControlador().findLast();
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
			panel.getJtfId().setText("" + this.actual.getId());
			panel.getJtfNombre().setText(this.actual.getNombre());
			panel.getJtf1Apellido().setText(this.actual.getApellido1());
			panel.getJtf2Apellido().setText(this.actual.getApellido2());
			panel.getJtfDni().setText(this.actual.getDni());
			panel.getJtfDireccion().setText(this.actual.getDireccion());
			panel.getJtfEmail().setText(this.actual.getEmail());
			panel.getJtfTelefono().setText(this.actual.getTelefono());
//			panel.getJtfColor().setText(this.actual.getColor());
			//Cargo JComboBox
			for (int i = 0; i < panel.getJcbSexo().getItemCount(); i++) {
				if (actual.getTipologiaSexo().getId() == panel.getJcbSexo().getItemAt(i).getId()) {
					panel.getJcbSexo().setSelectedIndex(i);
					break;
				}
			}
//			panel.setBackground(Color.decode("#" + panel.getJtfColor().getText()));
			cargaImagen();
		}
	}

	public void cargaImagen() {
		byte[] imagenAMostrar = actual.getImagen();
		ImageIcon icono = new ImageIcon(imagenAMostrar);
		JLabel lblImagen = new JLabel (icono);
		
		
		panel.getJspImagen().setViewportView(lblImagen);
	}
	
}
