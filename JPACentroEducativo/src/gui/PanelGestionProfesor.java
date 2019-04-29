package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import gui.utils.CacheImagenes;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.TipologiaSexo;
import modelo.controladores.EstudianteControlador;
import modelo.controladores.ProfesorControlador;
import modelo.controladores.ProfesorControlador;

public class PanelGestionProfesor extends JPanel {
	
	
	public static int PRIMERO = 0;
	public static int ANTERIOR = 1;
	public static int SIGUIENTE = 2;
	public static int ULTIMO = 3;
	public static int NUEVO = 4;
	public static int GUARDAR = 5;
	public static int ELIMINAR = 6;
	
	private JPanelDatosPersonales panel = new JPanelDatosPersonales();

	public PanelGestionProfesor() {
				super();
		// Establezco el panel principal de la aplicaci�n y la barra de herramientas
				this.setLayout(new BorderLayout());
				this.add(getBarraHerramientas(), BorderLayout.NORTH);
				this.add(panel, BorderLayout.CENTER);
				this.actual = ProfesorControlador.getControlador().findFirst();	
				cargarDatosActual();	
		
	}
	
	

	Profesor actual = null;
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
		panel.getJtfColor().setText("#FFFFFF");

		
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		Profesor nuevoRegistro = new Profesor();
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
		nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		nuevoRegistro.setNombre(panel.getJtfNombre().getText());
		nuevoRegistro.setApellido1(panel.getJtf1Apellido().getText());
		nuevoRegistro.setApellido2(panel.getJtf2Apellido().getText());
		nuevoRegistro.setDni(panel.getJtfDni().getText());
		nuevoRegistro.setDireccion(panel.getJtfDireccion().getText());
		nuevoRegistro.setEmail(panel.getJtfEmail().getText());
		nuevoRegistro.setTelefono(panel.getJtfTelefono().getText());
		nuevoRegistro.setTipologiaSexo((TipologiaSexo)panel.getJcbSexo().getSelectedItem());
		nuevoRegistro.setColor(panel.getJtfColor().getText());
		
		byte[] imagenEnBytes=null;
		try {
			if(panel.getFichero()!=null) {
				imagenEnBytes = Files.readAllBytes(panel.getFichero().toPath());
				nuevoRegistro.setImagen(imagenEnBytes);
				panel.getJspImagen().setViewportView(new JLabel(new ImageIcon(imagenEnBytes)));
			}
			else {
				nuevoRegistro.setImagen(actual.getImagen());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (nuevoRegistro.getId() == 0) {
			ProfesorControlador.getControlador().persist(nuevoRegistro);
		}
		else {
			ProfesorControlador.getControlador().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	

	
	
	
	/**
	 * 
	 * @return
	 */
	private Profesor eliminar () {
		String respuestas[] = new String[] {"S�", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"�Realmente desea eliminar el registro?", "Eliminaci�n del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Profesor nuevoAMostrar = ProfesorControlador.getControlador().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = ProfesorControlador.getControlador().findNext(actual);
	    	}
	    	ProfesorControlador.getControlador().remove(actual);
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
				
				Profesor obtenido = null;
				if (funcion == PRIMERO) 
					obtenido = ProfesorControlador.getControlador().findFirst();
				if (funcion == ANTERIOR) 
					obtenido = ProfesorControlador.getControlador().findPrevious(actual);
				if (funcion == SIGUIENTE) 
					obtenido = ProfesorControlador.getControlador().findNext(actual);
				if (funcion == ULTIMO) 
					obtenido = ProfesorControlador.getControlador().findLast();
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
			panel.getJtfId().setText(""+ this.actual.getId());
			panel.getJtfNombre().setText(this.actual.getNombre());
			panel.getJtf1Apellido().setText(this.actual.getApellido1());
			panel.getJtf2Apellido().setText(this.actual.getApellido2());
			panel.getJtfDni().setText(this.actual.getDni());
			panel.getJtfDireccion().setText(this.actual.getDireccion());
			panel.getJtfEmail().setText( this.actual.getEmail());
			panel.getJtfTelefono().setText(this.actual.getTelefono());
			
			if(actual.getImagen()!=null) {
				byte[] imagenAMostrar = actual.getImagen();
				ImageIcon icono = new ImageIcon(imagenAMostrar);
				JLabel lblImagen = new JLabel (icono);
				panel.getJspImagen().setViewportView(lblImagen);
				panel.getJspImagen().setPreferredSize(new Dimension(110, 110));
			}
			else {
				panel.getJspImagen().setViewportView(new JLabel());
			}
					
			//Cargo el valor del JComboBox del fabricante
			for (int i = 0; i < panel.getJcbSexo().getItemCount(); i++) {
				if (actual.getTipologiaSexo().getId() == panel.jcbSexo.getItemAt(i).getId()) {
					panel.jcbSexo.setSelectedIndex(i);
					break;
				}
			}	

		}
	}

}
