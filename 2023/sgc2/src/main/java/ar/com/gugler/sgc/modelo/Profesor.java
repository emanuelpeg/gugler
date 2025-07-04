package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;

/**
 * Representa a un profesor en el sistema académico.
 * 
 * Esta clase sirve como base para entidades como Profesor. Hereda de la clase
 * Persona y contiene atributo propios como CUIL y fecha de ingreso,
 * 
 * Debe implementar el método abstracto {@code mostrarformacion()} para retornar
 * una representación específica del profesor.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
@Entity
public class Profesor extends Persona {

	private String cuil;
	private LocalDate fechaIngreso;

	/**
	 * Constructor: Crea una nueva instancia de Profesor con los datos básicos
	 * obligatorios.
	 * 
	 * @param numeroDocumento   Documento nacional de identidad de la persona.
	 * @param apellido          Apellido de la persona.
	 * @param nombres           Nombres de la persona.
	 * @param fechaNacimiento   Fecha de nacimiento (no puede ser nula).
	 * @param domicilio         Dirección completa de la persona.
	 * @param telefono          Número de teléfono de contacto.
	 * @param correoElectronico Dirección de correo electrónico válida.
	 * @param cuil              CUIL del profesor
	 * @param fechaIngreso      Fecha de ingreso del profesor
	 */
	public Profesor(String numeroDocumento, String apellido, String nombres, LocalDate fechaNacimiento,
			String domicilio, String telefono, String correoElectronico, String cuil, LocalDate fechaIngreso) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * Constructor: vacío
	 */
	public Profesor() {
		super();
	}

	/**
	 * Devuelve el CUIL del profesor
	 * 
	 * @return Número de CUIL como cadena
	 */
	public String getCuil() {
		return cuil;
	}

	/**
	 * Establece el CUIL del profesor
	 * 
	 * @param cuil Número de CUIL
	 */
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	/**
	 * Devuelve la fecha de ingreso del profesor
	 * 
	 * @return Fecha de ingreso como LocalDate
	 */
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * Establece la fecha de ingreso del profesor
	 * 
	 * @param fechaIngreso Fecha de Ingreso
	 */
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * Implementación del método mostrarInformación. Devuelve una cadena con el
	 * nombre, apellido en mayúsculas y número de CUIL.
	 */
	@Override
	public String mostrarInformacion() {

		return this.getNombres().toUpperCase() + " " + this.getApellido().toUpperCase() + " -  CUIL: " + this.getCuil();

	}

}
