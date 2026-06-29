package ar.com.gugler.sgc.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String numeroDocumento;
	private String apellido;
	private String nombres;
	private Date fechaNacimiento;
	private String domicilio;
	private String telefono;
	private String correoElectronico;

	public Persona(String numeroDocumento, String apellido, String nombres, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico) {
		this.numeroDocumento = numeroDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	public Persona() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract String mostrarInformacion();

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		return "Persona (DNI=" + numeroDocumento + ", nombres=" + nombres + ", apellido=" + apellido + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return this.numeroDocumento.equals(other.numeroDocumento);
	}

}