package modelo.controladores;



import modelo.Materia;
import modelo.ValoracionMateria;

import java.util.ArrayList;
import java.util.List;

import modelo.Curso;
import modelo.Entidad;

public class ValoracionMateriasControlador extends Controlador {

	private static ValoracionMateriasControlador controlador = null;

	public ValoracionMateriasControlador () {
		super("ValoracionMateria");
	}
	
	/**
	 * 
	 * @return
	 */
	public static ValoracionMateriasControlador getControlador () {
		if (controlador == null) {
			controlador = new ValoracionMateriasControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public ValoracionMateria find (int id) {
		return (ValoracionMateria) super.find(id);
	}
	
	/**
	 * 
	 */
	public ValoracionMateria findFirst () {
		return (ValoracionMateria) super.findFirst();
	}

	@Override
	public ValoracionMateria findLast() {
		// TODO Auto-generated method stub
		return (ValoracionMateria)super.findLast();
	}

	@Override
	public ValoracionMateria findNext(Entidad e) {
		// TODO Auto-generated method stub
		return (ValoracionMateria) super.findNext(e);
	}

	@Override
	public ValoracionMateria findPrevious(Entidad e) {
		// TODO Auto-generated method stub
		return (ValoracionMateria) super.findPrevious(e);
	}
	
	


	


	
//	public static String toString (Curso curso) {
//		return "Id: " + curso.getId() + " - Descripcion: " + curso.getDescripcion();
//	}

}


