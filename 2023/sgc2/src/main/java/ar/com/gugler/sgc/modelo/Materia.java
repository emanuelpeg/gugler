package ar.com.gugler.sgc.modelo;

import jakarta.persistence.Entity;

/**
 * Representa a una materia en el sistema académico.
 * 
 * Esta clase sirve como base para entidades como Materia. Hereda de la clase
 * Asignatura y contiene atributo propios como año.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
@Entity
public class Materia extends Asignatura {

	private int anio;

	/**
	 * Constructor: Crea una nueva instancia de Materia con los datos básicos
	 * obligatorios.
	 * 
	 * @param codigo   Código de la materia
	 * @param nombre   Nombre de la materia
	 * @param profesor Profesor de la materia
	 * @param anio     Año de la materia
	 */
	public Materia(int codigo, String nombre, Profesor profesor, int anio) {
		super(codigo, nombre, profesor);
		this.anio = anio;
	}

	/**
	 * Constructor: vacío
	 */
	public Materia() {
		super();
	}

	/**
	 * Devuelve el año de la materia
	 * 
	 * @return Año como entero
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Establece el año de la materia
	 * 
	 * @param anio Año
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

}
