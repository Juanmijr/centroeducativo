package modelo.controladores;



import modelo.Estudiante;
import modelo.Entidad;

public class EstudianteControlador extends Controlador {

	private static EstudianteControlador controlador = null;

	public EstudianteControlador () {
		super("Estudiante");
	}
	
	/**
	 * 
	 * @return
	 */
	public static EstudianteControlador getControlador () {
		if (controlador == null) {
			controlador = new EstudianteControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Estudiante find (int id) {
		return (Estudiante) super.find(id);
	}
	
	/**
	 * 
	 */
	public Estudiante findFirst () {
		return (Estudiante) super.findFirst();
	}

	@Override
	public Estudiante findLast() {
		// TODO Auto-generated method stub
		return (Estudiante)super.findLast();
	}

	@Override
	public Estudiante findNext(Entidad e) {
		// TODO Auto-generated method stub
		return (Estudiante) super.findNext(e);
	}

	@Override
	public Estudiante findPrevious(Entidad e) {
		// TODO Auto-generated method stub
		return (Estudiante) super.findPrevious(e);
	}
	
	


	
//	public static String toString (Curso curso) {
//		return "Id: " + curso.getId() + " - Descripcion: " + curso.getDescripcion();
//	}

}


