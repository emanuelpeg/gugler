package ar.com.gugler.sgc.modelo;

import jakarta.persistence.Entity;

@Entity
public class Materia extends Asignatura {
	private Integer anio;

	public Materia() {
	}

	public Materia(Integer codigo, String nombre, Profesor profesor, Integer anio) {
		super(codigo, nombre, profesor);
		this.anio = anio;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Materia (anio=" + anio + ", " + super.toString() + ")";
	}
}
