package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;




public class Menu extends JMenuBar {

	/**
	 * 
	 */
	public Menu () {
		//Menñu Archivo de la aplicacion
		JMenu menuArchivo = new JMenu("Entidades");
		
		JMenuItem miCursoAcademico = new JMenuItem("Cursos académicos");
		miCursoAcademico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog() ;
				dialogo.setResizable(false);
				dialogo.setTitle("Gestión de cursos académicos");
				dialogo.setBounds(100, 100, 450, 229);
				dialogo.setContentPane(new PanelGestionCursosAcademicos());
				dialogo.setModal(true);
				dialogo.setVisible(true);
				
			}
		});
		menuArchivo.add(miCursoAcademico);
		
		
		JMenuItem miEstudiante = new JMenuItem ("Estudiantes");
		miEstudiante.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog() ;
				dialogo.setResizable(false);
				dialogo.setTitle("Gestión de estudiantes");
				dialogo.setBounds(100, 100, 1000, 600);
				dialogo.setContentPane(new PanelGestionEstudiante());
				dialogo.setModal(true);
				dialogo.setVisible(true);
				
			}
		});
		menuArchivo.add(miEstudiante);
		
		
		JMenuItem miMateria = new JMenuItem ("Materia");
		miMateria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog() ;
				dialogo.setResizable(false);
				dialogo.setTitle("Gestión de materias");
				dialogo.setBounds(100, 100, 700, 400);
				dialogo.setContentPane(new PanelGestionMateria());
				dialogo.setModal(true);
				dialogo.setVisible(true);
				
			}
		});
		menuArchivo.add(miMateria);
		
		JMenuItem miProfesor = new JMenuItem ("Profesores");
		miProfesor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog() ;
				dialogo.setResizable(false);
				dialogo.setTitle("Gestión de profesores");
				dialogo.setBounds(100, 100, 1000, 600);
				
				dialogo.setContentPane(new PanelGestionProfesor());
				dialogo.setModal(true);
				dialogo.setVisible(true);
				
			}
		});
		menuArchivo.add(miProfesor);
		
		JMenuItem miValoracionMaterias = new JMenuItem ("Valoraciones Materias");
		miValoracionMaterias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog() ;
				dialogo.setResizable(false);
				dialogo.setTitle("Valoracion Materias");
				dialogo.setBounds(100, 100, 1000, 600);
				
				dialogo.setContentPane(new PanelGestionValoracionMaterias());
				dialogo.setModal(true);
				dialogo.setVisible(true);
				
			}
		});
		menuArchivo.add(miValoracionMaterias);
		
		
		this.add(menuArchivo);
	}
	
	
	

}
