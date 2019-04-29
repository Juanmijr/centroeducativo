package modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Entidad;
import modelo.TipologiaSexo;


public class TipologiaSexoControlador extends Controlador{

	private static TipologiaSexoControlador controlador = null;

	
	/**
	 * 
	 * @return
	 */
	public static TipologiaSexoControlador getControlador () {
		if (controlador == null) {
			controlador = new TipologiaSexoControlador("TipologiaSexo");
		}
		return controlador;
	}
	
	public TipologiaSexoControlador(String nombreEntidad) {
		super("TipologiaSexo");
	}
	
	/**
	 * 
	 */
	public List<TipologiaSexo> findAllTipologiaSexo() {
		List<TipologiaSexo> resultado = new ArrayList<TipologiaSexo>();
		for (Entidad entidad : super.findAll()) {
			resultado.add((TipologiaSexo) entidad);
		}
		return resultado;
	}
}
