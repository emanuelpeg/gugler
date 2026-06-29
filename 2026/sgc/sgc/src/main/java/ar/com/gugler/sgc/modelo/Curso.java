package ar.com.gugler.sgc.modelo;

import jakarta.persistence.Entity;

@Entity
public class Curso extends Asignatura implements Administrable {
	private Integer cupo;

	private static final int MAXIMO_ALUMNOS = 24;

	public Curso() {
	}
	
	public Curso(Integer codigo, String nombre, Profesor profesor, Integer cupo) {
		super(codigo, nombre, profesor);
		this.cupo = cupo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public void agregarAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
	}

	public void eliminarAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
	}

	@Override
	public boolean admiteInscripciones() {
		return getAlumnos().size() < MAXIMO_ALUMNOS;
	}

	@Override
	public String toString() {
		return "Curso (cupo=" + cupo + ", inscriptos=" + getAlumnos().size() + ", admiteInscripciones="
				+ admiteInscripciones() + ", " + super.toString() + ")";
	}
}
