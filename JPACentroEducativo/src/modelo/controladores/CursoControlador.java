package modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Curso;
import modelo.Entidad;
import modelo.Materia;
import modelo.TipologiaSexo;
import modelo.Curso;

public class CursoControlador extends Controlador {

	private static CursoControlador controlador = null;

	public CursoControlador () {
		super("Curso");
	}
	
	/**
	 * 
	 * @return
	 */
	public static CursoControlador getControlador () {
		if (controlador == null) {
			controlador = new CursoControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Curso find (int id) {
		return (Curso) super.find(id);
	}
	
	/**
	 * 
	 */
	public Curso findFirst () {
		return (Curso) super.findFirst();
	}

	@Override
	public Curso findLast() {
		// TODO Auto-generated method stub
		return (Curso)super.findLast();
	}

	@Override
	public Curso findNext(Entidad e) {
		// TODO Auto-generated method stub
		return (Curso) super.findNext(e);
	}

	@Override
	public Curso findPrevious(Entidad e) {
		// TODO Auto-generated method stub
		return (Curso) super.findPrevious(e);
	}


	/**
	 * 
	 */
	public List<Curso> findAllTipologiaSexo() {
		List<Curso> resultado = new ArrayList<Curso>();
		for (Entidad entidad : super.findAll()) {
			resultado.add((Curso) entidad);
		}
		return resultado;
	}


	
//	public static String toString (Curso curso) {
//		return "Id: " + curso.getId() + " - Descripcion: " + curso.getDescripcion();
//	}

}


