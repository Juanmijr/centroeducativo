package modelo.controladores;




import modelo.Entidad;
import modelo.Profesor;

public class ProfesorControlador extends Controlador {

	public ProfesorControlador(String nombreEntidad) {
		super("Profesor");
	}

	private static ProfesorControlador controlador = null;


	/**
	 * 
	 * @return
	 */
	public static ProfesorControlador getControlador () {
		if (controlador == null) {
			controlador = new ProfesorControlador("Profesor");
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Profesor find (int id) {
		return (Profesor) super.find(id);
	}
	
	/**
	 * 
	 */
	public Profesor findFirst () {
		return (Profesor) super.findFirst();
	}

	@Override
	public Profesor findLast() {
		// TODO Auto-generated method stub
		return (Profesor)super.findLast();
	}

	@Override
	public Profesor findNext(Entidad e) {
		// TODO Auto-generated method stub
		return (Profesor) super.findNext(e);
	}

	@Override
	public Profesor findPrevious(Entidad e) {
		// TODO Auto-generated method stub
		return (Profesor) super.findPrevious(e);
	}
	
	


	
//	public static String toString (Curso curso) {
//		return "Id: " + curso.getId() + " - Descripcion: " + curso.getDescripcion();
//	}

}


