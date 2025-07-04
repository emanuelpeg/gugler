package ar.com.gugler.sgc.modelo;

/**
 * Esta interface representa una entidad Administable.
 * Las clases que implementen esta interfaz deben proporcionar una implementación
 * para el método {@link #admiteInscripciones()}.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
public interface Administrable {
	
	/**
	 * Este método debe ser implementado por las clases que implementen esta interface.
	 * @return true si admite inscripciones, de lo contrario false.
	 */
	public boolean admiteInscripciones();
	
}
