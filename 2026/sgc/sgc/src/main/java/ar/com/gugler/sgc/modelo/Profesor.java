package ar.com.gugler.sgc.modelo;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Profesor extends Persona {
	private String cuil;
	private Date fechaIngreso;

	public Profesor(String numeroDocumento, String apellido, String nombres, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String cuil, Date fechaIngreso) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}

	public Profesor() {
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String mostrarInformacion() {
		return (getNombres() + " " + getApellido()).toUpperCase() + " - CUIL: " + cuil;
	}

	@Override
	public String toString() {
		return "Profesor (cuil=" + cuil + ", " + super.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
