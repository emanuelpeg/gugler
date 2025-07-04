package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 * Representa a una persona en el sistema académico.
 * 
 * Esta clase es abstracta y sirve como base para entidades como Alumno y
 * Profesor. Contiene atributos comunes como nombre, apellido, documento y fecha
 * de nacimiento,etc, y define la estructura que deben seguir las subclases.
 * 
 * Las subclases deben implementar el método abstracto
 * {@code mostrarformacion()} para retornar una representación específica de la
 * persona.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String numeroDocumento;
	private String apellido;
	private String nombres;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String telefono;
	private String correoElectronico;

	/**
	 * Constructor: Crea una nueva instancia de Persona con los datos básicos
	 * obligatorios.
	 *
	 * @param numeroDocumento   Documento nacional de identidad de la persona.
	 * @param apellido          Apellido de la persona.
	 * @param nombres           Nombres de la persona.
	 * @param fechaNacimiento   Fecha de nacimiento (no puede ser nula).
	 * @param domicilio         Dirección completa de la persona.
	 * @param telefono          Número de teléfono de contacto.
	 * @param correoElectronico Dirección de correo electrónico válida.
	 */
	public Persona(String numeroDocumento, String apellido, String nombres, LocalDate fechaNacimiento, String domicilio,
			String telefono, String correoElectronico) {

		this.numeroDocumento = numeroDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	/**
	 * Constructor : vacío
	 */
	public Persona() {

	}

	/**
	 * Devuelve el número de documento de la persona
	 * 
	 * @return número de documento como Cadena
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Establece el número de documento de la persona
	 * 
	 * @param numeroDocumento Número de documento
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * Devuelve el apellido de la persona
	 * 
	 * @return Apellido como cadena
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido de la persona
	 * 
	 * @param apellido Apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve el o los nombres de la persona
	 * 
	 * @return Nombre/s como cadena
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Establece el o los nombres de la persona
	 * 
	 * @param nombres Nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Devuelve la fecha de nacimiento de la persona
	 * 
	 * @return Fecha de nacimiento como LocalDate
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece la fecha de nacimiento de la persona
	 * 
	 * @param fechaNacimiento Fecha de Nacimiento
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Devuelve el domicilio de la persona
	 * 
	 * @return Domicilio como cadena
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * Establece el domicilio de la persona
	 * 
	 * @param domicilio Domicilio
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * Devuelve el teléfono de la persona
	 * 
	 * @return Teléfono como cadena
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el teléfono de la persona
	 * 
	 * @param telefono Teléfono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve el correo electrónico de la persona
	 * 
	 * @return Correo Electrónico como cadena
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * Establece el correo electrónico de la persona
	 * 
	 * @param correoElectronico Correo Electrónico
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public long getId() {
		return id;
	}

	/**
	 * Método abstracto para mostrar información de la persona Requiere ser
	 * implementado por las clases que hereden de Persona
	 * @return cadena con información de Persona
	 */
	public abstract String mostrarInformacion();

	/**
	 * Devuelve una representación en texto de la persona, incluyendo sus datos
	 * principales.
	 *
	 * @return Cadena con la información de la persona.
	 */
	@Override
	public String toString() {
		return "Persona [numeroDocumento=" + numeroDocumento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + "]";
	}

	/**
	 * Calcula el código hash para esta persona.
	 * 
	 * Este método considera los atributos principales de identidad (apellido,
	 * nombres, número de documento, etc.) para garantizar que objetos iguales
	 * produzcan el mismo valor hash.
	 *
	 * @return un valor hash entero que representa este objeto.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(apellido, correoElectronico, domicilio, fechaNacimiento, nombres, numeroDocumento,
				telefono);
	}

	/**
	 * Compara esta persona con otro objeto para determinar si son iguales.
	 * 
	 * Dos personas se consideran iguales si tienen los mismos valores en los
	 * atributos: número de documento, nombres, apellido, fecha de nacimiento,
	 * domicilio, teléfono y correo electrónico.
	 *
	 * @param obj el objeto con el que se va a comparar.
	 * @return {@code true} si el objeto es una instancia de Persona y tiene los
	 *         mismos valores; {@code false} en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(correoElectronico, other.correoElectronico)
				&& Objects.equals(domicilio, other.domicilio) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(numeroDocumento, other.numeroDocumento)
				&& Objects.equals(telefono, other.telefono);
	}

}
