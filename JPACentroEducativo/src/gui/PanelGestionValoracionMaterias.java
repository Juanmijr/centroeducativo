package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modelo.Materia;
import modelo.Profesor;


public class PanelGestionValoracionMaterias extends JPanel {
	/**
	 * @wbp.nonvisual location=342,47
	 */
	private final JLabel label = new JLabel("New label");
	public PanelGestionValoracionMaterias() {
		this.add(getCabecera(), BorderLayout.NORTH);
		this.add(centrada(), BorderLayout.CENTER);
		
		
	
		
		
	}

	

	private JPanel getCabecera () {
		setLayout(new BorderLayout(0, 0));
		JPanel cabecera = new JPanel();
		cabecera.setBackground(Color.RED);
		add(cabecera, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 253, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		cabecera.setLayout(gbl_panel);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		cabecera.add(lblMateria, gbc_lblMateria);
		
		JComboBox <Materia>jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		cabecera.add(jcbMateria, gbc_comboBox);
		
		JLabel jlbProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		cabecera.add(jlbProfesor, gbc_lblProfesor);
		
		JComboBox <Profesor> jcbProfesor = new JComboBox <Profesor>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		cabecera.add(jcbProfesor, gbc_comboBox_1);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.anchor = GridBagConstraints.EAST;
		gbc_btnRefrescar.gridx = 1;
		gbc_btnRefrescar.gridy = 2;
		cabecera.add(btnRefrescar, gbc_btnRefrescar);
	
	
	
		return cabecera;

	
	}
	
	private JPanel centrada () {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		
		
		return panel;
	}
	
	
	
}
