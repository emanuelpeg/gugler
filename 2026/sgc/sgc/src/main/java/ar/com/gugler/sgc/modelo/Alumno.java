package ar.com.gugler.sgc.modelo;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Alumno extends Persona {
	private String legajo;

	public Alumno(String numeroDocumento, String apellido, String nombres, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String legajo) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.legajo = legajo;
	}

	public Alumno() {
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	@Override
	public String mostrarInformacion() {
		return getNombres() + " " + getApellido() + " - DNI: " + getNumeroDocumento();
	}

	@Override
	public String toString() {
		return "Alumno (legajo=" + legajo + ", " + super.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
