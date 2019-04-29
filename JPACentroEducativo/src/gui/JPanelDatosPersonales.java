package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

import com.sun.codemodel.JOp;

import modelo.Entidad;
import modelo.Estudiante;
import modelo.TipologiaSexo;
import modelo.controladores.EstudianteControlador;
import modelo.controladores.TipologiaSexoControlador;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class JPanelDatosPersonales extends JPanel {
	private JTextField jtfNombre;
	private JTextField jtf1Apellido;
	private JTextField jtf2Apellido;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JTextField jtfId;
	JComboBox<TipologiaSexo> jcbSexo = new JComboBox<TipologiaSexo>();
	private JScrollPane jspImagen;
	JButton btnCargaFoto;
	JButton btnCambiaColor;
	JFileChooser jfileChooser;
	JColorChooser jColorChooser;
	JTextField jtfColor;
	JPanel jpPanelParaColorear = new JPanel();
	byte[] imagenAMostrar ;
	private JLabel lblColor;
	private JTextField textField;
	File fichero;
	int seleccionUsuario;
	String Default = new String("");
	

	


	/**
	 * Create the panel.
	 */
	public JPanelDatosPersonales() {
		
		
			
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 185, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_txtCambiaColor = new GridBagConstraints();
		gbc_txtCambiaColor.anchor = GridBagConstraints.WEST;
		gbc_txtCambiaColor.insets = new Insets(0, 0, 5, 5);
		gbc_txtCambiaColor.gridx = 1;
		gbc_txtCambiaColor.gridy = 0;
		jtfId.setEnabled(false);
		add(jtfId, gbc_txtCambiaColor);
		jtfId.setColumns(10);
					    
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.anchor = GridBagConstraints.WEST;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		 btnCargaFoto = new JButton("Carga foto");
		GridBagConstraints gbc_btnCargaFoto = new GridBagConstraints();
		gbc_btnCargaFoto.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargaFoto.gridx = 2;
		gbc_btnCargaFoto.gridy = 1;
		imagen();
		add(btnCargaFoto, gbc_btnCargaFoto);
		
		
		
		JLabel lblNewLabel = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtf1Apellido = new JTextField();
		GridBagConstraints gbc_jtf1Apellido = new GridBagConstraints();
		gbc_jtf1Apellido.anchor = GridBagConstraints.WEST;
		gbc_jtf1Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtf1Apellido.gridx = 1;
		gbc_jtf1Apellido.gridy = 2;
		add(jtf1Apellido, gbc_jtf1Apellido);
		jtf1Apellido.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 3;
		add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		jtf2Apellido = new JTextField();
		GridBagConstraints gbc_jtf2Apellido = new GridBagConstraints();
		gbc_jtf2Apellido.anchor = GridBagConstraints.WEST;
		gbc_jtf2Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtf2Apellido.gridx = 1;
		gbc_jtf2Apellido.gridy = 3;
		add(jtf2Apellido, gbc_jtf2Apellido);
		jtf2Apellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.anchor = GridBagConstraints.WEST;
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblDireccinm = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccinm = new GridBagConstraints();
		gbc_lblDireccinm.anchor = GridBagConstraints.EAST;
		gbc_lblDireccinm.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccinm.gridx = 0;
		gbc_lblDireccinm.gridy = 5;
		add(lblDireccinm, gbc_lblDireccinm);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.anchor = GridBagConstraints.WEST;
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.anchor = GridBagConstraints.WEST;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 7;
		add(lblTelefono, gbc_lblTelefono);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.anchor = GridBagConstraints.WEST;
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		 btnCambiaColor = new JButton("Cambia color");
		GridBagConstraints gbc_btnCambiaColor = new GridBagConstraints();
		gbc_btnCambiaColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiaColor.gridx = 2;
		gbc_btnCambiaColor.gridy = 7;
		color();
		add(btnCambiaColor, gbc_btnCambiaColor);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 8;
		add(lblSexo, gbc_lblSexo);
		
		
		jcbSexo = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.anchor = GridBagConstraints.WEST;
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 8;
		inicializaComboBoxTipologiaSexo();
		add(jcbSexo, gbc_jcbSexo);
		
		jspImagen = new JScrollPane();
		GridBagConstraints gbc_jspImagen = new GridBagConstraints();
		gbc_jspImagen.insets = new Insets(0, 0, 5, 0);
		//gbc_jspImagen.fill = GridBagConstraints.BOTH;
		gbc_jspImagen.gridx = 2;
		gbc_jspImagen.gridy = 0;
		jspImagen.setPreferredSize(new Dimension(100,100));
		add(jspImagen, gbc_jspImagen);
		
		lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 9;
		add(lblColor, gbc_lblColor);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 9;
		add(textField, gbc_textField);
		textField.setColumns(10);
		

	}
	
	/**
	 * 
	 */
	private void inicializaComboBoxTipologiaSexo () {
		List<TipologiaSexo> fabricantes = TipologiaSexoControlador.getControlador().findAllTipologiaSexo();
		for (TipologiaSexo fabricante : fabricantes) {
			getJcbSexo().addItem(fabricante);
		}
	}
	
	private void color () {
		// Funcionalidad al bot�n
				btnCambiaColor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						seleccionaColor();
					}
				});
	}
	
	private void imagen () {
		// Funcionalidad al bot�n
		btnCargaFoto.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						seleccionaImagen();
					}
				});
	}
	
	private void seleccionaImagen() {
		this.jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Establecimiento de la carpeta de inicio
		this.jfileChooser.setCurrentDirectory(new File("C:\\"));
		
		// Tipo de selecci�n que se hace en el di�logo
		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos  *.jpg";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isFile() && f.getAbsolutePath().endsWith(".jpg")) 
					return true;
				return false;
			}
		});
		
		// Abro el di�logo para la elecci�n del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = this.jfileChooser.getSelectedFile();
			
			// Vuelco el nombre del fichero sobre el JTextField
			this.jtfNombre.setText(fichero.getAbsolutePath());
			
//			if (fichero.isFile()) {
//				try {
//					FileReader fileReader = new FileReader(fichero);
//					BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
//					StringBuffer sb = new StringBuffer();
//					String lineaDelFichero;
//			
//					// Lectura del fichero l�nea a l�nea
//					while ((lineaDelFichero = bufferedReader.readLine()) != null) {
//						sb.append(lineaDelFichero + "\n");
//					}
//					
//					// Volcamos el contenido del fichero al JTextArea
//					this.jtaContenidoFichero.setText(sb.toString());
//				}
//				catch (Exception ex) {
//					ex.printStackTrace();
//				}
//			}
			
			byte[] imagenAMostrar = null;
			try {
				imagenAMostrar = Files.readAllBytes(fichero.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImageIcon icono = new ImageIcon(imagenAMostrar);
			JLabel lblImagen = new JLabel (icono);
			
			
			this.getJspImagen().setViewportView(lblImagen);
		}
	}
	
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = JColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			String strColor = ""+ Integer.toHexString(color.getRGB()).substring(2);
			jtfColor.setText(strColor);
			this.setBackground(Color.decode("#"+ jtfColor.getText()));
		} 
	}
	
	

	

	public JFileChooser getJfileChooser() {
			return jfileChooser;
		}

		public void setJfileChooser(JFileChooser jfileChooser) {
			this.jfileChooser = jfileChooser;
		}

	public int getSeleccionUsuario() {
			return seleccionUsuario;
		}

		public void setSeleccionUsuario(int seleccionUsuario) {
			this.seleccionUsuario = seleccionUsuario;
		}

	public File getFichero() {
			return fichero;
		}

		public void setFichero(File fichero) {
			this.fichero = fichero;
		}

	public JTextField getJtfColor() {
			return jtfColor;
		}

		public void setJtfColor(JTextField jtfColor) {
			this.jtfColor = jtfColor;
		}

	public JTextField getJtfNombre() {
		return jtfNombre;
	}

	public JTextField getJtf1Apellido() {
		return jtf1Apellido;
	}

	public JTextField getJtf2Apellido() {
		return jtf2Apellido;
	}

	public JTextField getJtfDni() {
		return jtfDni;
	}

	public JTextField getJtfDireccion() {
		return jtfDireccion;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public JTextField getJtfTelefono() {
		return jtfTelefono;
	}

	public void setJtfNombre(JTextField jtfNombre) {
		this.jtfNombre = jtfNombre;
	}

	public void setJtf1Apellido(JTextField jtf1Apellido) {
		this.jtf1Apellido = jtf1Apellido;
	}

	public void setJtf2Apellido(JTextField jtf2Apellido) {
		this.jtf2Apellido = jtf2Apellido;
	}

	public void setJtfDni(JTextField jtfDni) {
		this.jtfDni = jtfDni;
	}

	public void setJtfDireccion(JTextField jtfDireccion) {
		this.jtfDireccion = jtfDireccion;
	}

	public void setJtfEmail(JTextField jtfEmail) {
		this.jtfEmail = jtfEmail;
	}

	public void setJtfTelefono(JTextField jtfTelefono) {
		this.jtfTelefono = jtfTelefono;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}
	public JComboBox<TipologiaSexo> getJcbSexo() {
		return jcbSexo;
	}

	public void setJcbSexo(JComboBox<TipologiaSexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	public JScrollPane getJspImagen() {
		return jspImagen;
	}

	public void setJspImagen(JScrollPane jspImagen) {
		this.jspImagen = jspImagen;
	}
	

	
	
	
	
	

}
