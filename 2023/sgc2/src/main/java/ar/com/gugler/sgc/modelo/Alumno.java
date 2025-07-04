package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;

/**
 * Representa a un alumno en el sistema académico.
 * 
 * Esta clase sirve como base para entidades como Alumno. Hereda de la clase
 * Persona y contiene atributo propios como legajo,
 * 
 * Debe implementar el método abstracto {@code mostrarformacion()} para retornar
 * una representación específica del alumno.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
@Entity
public class Alumno extends Persona {

	private String legajo;

	/**
	 * Constructor: Crea una nueva instancia de Alumno con los datos básicos
	 * obligatorios.
	 * 
	 * @param numeroDocumento   Documento nacional de identidad del alumno.
	 * @param apellido          Apellido del alumno.
	 * @param nombres           Nombres del alumno.
	 * @param fechaNacimiento   Fecha de nacimiento (no puede ser nula).
	 * @param domicilio         Dirección completa del alumno.
	 * @param telefono          Número de teléfono de contacto.
	 * @param correoElectronico Dirección de correo electrónico válida.
	 * @param legajo            Legajo del alumno
	 */
	public Alumno(String numeroDocumento, String apellido, String nombres, LocalDate fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String legajo) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.legajo = legajo;
	}

	/**
	 * Constructor: vacío
	 */
	public Alumno() {
		super();
	}

	/**
	 * Devuelve el legajo del alumno
	 * 
	 * @return Legajo del alumno como cadena
	 */
	public String getLegajo() {
		return legajo;
	}

	/**
	 * Establece el legajo del alumno
	 * 
	 * @param legajo Legajo
	 */
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	/**
	 * Implementación del método mostrarInformación. Devuelve una cadena con el
	 * nombre, apellido y número de documento.
	 */
	@Override
	public String mostrarInformacion() {
		return this.getNombres() + " " + this.getApellido() + " - DNI: " + this.getNumeroDocumento();

	}

}
