package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import gui.utils.CacheImagenes;

public class BarraHerramientasDentro extends JToolBar {

		JButton primero;
		JButton anterior;
		JButton siguiente;
		JButton ultimo;
		JButton nuevo;
		JButton guardar;
		JButton eliminar;

		private static final long serialVersionUID = 1L;
		private static BarraHerramientasDentro instancia = null;
		
		public static BarraHerramientasDentro getInstancia () {
			if (instancia == null) {
				instancia = new BarraHerramientasDentro();
			}
			return instancia;
		}
		
		
		
		 public BarraHerramientasDentro() {
			 primero = creadorBotones("gotostart.png", "Primero");
			 addBotones(primero);
			 anterior = creadorBotones("previous.png", "Anterior");
			 addBotones(anterior);
			 siguiente = creadorBotones("next.png", "Siguiente");
			 addBotones(siguiente);
			 ultimo = creadorBotones("gotoend.png", "Ultimo");
			 addBotones(ultimo);
			 nuevo = creadorBotones("nuevo.png", "nuevo");
			 addBotones(nuevo);
			 guardar = creadorBotones("guardar.png", "guardar");
			 addBotones(guardar);
			 eliminar = creadorBotones("eliminar.png", "eliminar");
			 addBotones(eliminar);
			
			
			
			
		}

		 
		 public JButton creadorBotones( String icono, String texto) {
			 JButton boton = new JButton("");
			 boton.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
			 boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed (ActionEvent e) {
					System.out.print(texto);
				}
			 });
			 
			 return boton;
		 }
		 
		 public void addBotones (JButton boton) {
			 this.add(boton);
			
		 }
		 
			
}
		 
		 



