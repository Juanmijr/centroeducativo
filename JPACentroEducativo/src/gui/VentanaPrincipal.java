package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import gui.utils.Apariencia;



public class VentanaPrincipal extends JFrame {
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * 
	 */
	public VentanaPrincipal () {
		super ("JComponents Avanzados");
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Men� de la aplicaci�n
		this.setJMenuBar(new Menu());
		
		// Establezco el panel principal de la aplicaci�n y la barra de herramientas
		this.setLayout(new BorderLayout());
		this.add(new ToolBar(), BorderLayout.NORTH);
		
	}

}
