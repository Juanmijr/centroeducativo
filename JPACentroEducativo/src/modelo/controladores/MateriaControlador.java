package modelo.controladores;



import modelo.Materia;
import modelo.Entidad;

public class MateriaControlador extends Controlador {

	private static MateriaControlador controlador = null;

	public MateriaControlador () {
		super("Materia");
	}
	
	/**
	 * 
	 * @return
	 */
	public static MateriaControlador getControlador () {
		if (controlador == null) {
			controlador = new MateriaControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Materia find (int id) {
		return (Materia) super.find(id);
	}
	
	/**
	 * 
	 */
	public Materia findFirst () {
		return (Materia) super.findFirst();
	}

	@Override
	public Materia findLast() {
		// TODO Auto-generated method stub
		return (Materia)super.findLast();
	}

	@Override
	public Materia findNext(Entidad e) {
		// TODO Auto-generated method stub
		return (Materia) super.findNext(e);
	}

	@Override
	public Materia findPrevious(Entidad e) {
		// TODO Auto-generated method stub
		return (Materia) super.findPrevious(e);
	}
	
	


	
//	public static String toString (Curso curso) {
//		return "Id: " + curso.getId() + " - Descripcion: " + curso.getDescripcion();
//	}

}


