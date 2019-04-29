package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import gui.utils.CacheImagenes;





public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	public ToolBar () {
       
		JButton jbtCursosAcademicos = new JButton("");
		jbtCursosAcademicos.setIcon(CacheImagenes.getCacheImagenes().getIcono("ruedadentada.png"));
		jbtCursosAcademicos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Usuario quiere abrir el panel del curso academico");
				
			}
		});
		this.add(jbtCursosAcademicos);
	}


}
