package ar.com.gugler.sgc.modelo;

import jakarta.persistence.Entity;

/**
 * Representa a un curso en el sistema académico.
 * 
 * Esta clase sirve como base para entidades como Curso. Hereda de la clase
 * Asignatura y contiene atributo propios como cupo y metodos propios como
 * agregar y eliminar alumno.,
 * 
 * Debe implementar el método de la interfaz Administrable
 * {@code admiteInscripciones()}
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
@Entity
public class Curso extends Asignatura implements Administrable {

	private int cupo = 24; // Cupo para 24 participantes.

	/**
	 * Constructor: Crea una nueva instancia de Curso con los datos básicos
	 * obligatorios.
	 * 
	 * @param codigo   Código del curso
	 * @param nombre   Nombre del curso
	 * @param profesor Profesor del curso
	 * @param cupo     Cupo del curso
	 */
	public Curso(int codigo, String nombre, Profesor profesor, int cupo) {
		super(codigo, nombre, profesor);
		this.cupo = cupo;
	}

	/**
	 * Constructor: vacío
	 */
	public Curso() {
		super();
	}

	/**
	 * Devuelve el cupo del curso
	 * 
	 * @return Cupo como entero
	 */
	public int getCupo() {
		return cupo;
	}

	/**
	 * Establece el cupo del curso
	 * 
	 * @param cupo Cupo
	 */
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	/**
	 * Permite agregar un alumno al curso. Si se puede admitir más inscripciones lo
	 * agrega y muestra mensaje por consola de confirmación. De lo contrario muestra
	 * mensaje por consola que no se pudo agregar.
	 * 
	 * @param alumno Objeto de tipo {@link Alumno}
	 */
	public void agregarAlumno(Alumno alumno) {

		if (this.admiteInscripciones()) {
			this.getAlumnos().add(alumno);
			System.out.println("Alumno agregado con exito");
		} else {
			System.out.println("No se pueden agregar mas alumnos");
		}

	}

	/**
	 * Permite eliminar un alumno del curso. Si la lista de alumnos no está vacía,
	 * se elimina el alumno antes guardandolo en variable booleana eliminado. Se
	 * confirma por consola si la eliminación fue exitosa o no existe el alumno. Si
	 * está vacía, muestra por consola que está vacía la lista.
	 * 
	 * @param alumno Objeto de tipo {@link Alumno}
	 */
	public void eliminarAlumno(Alumno alumno) {

		if (!this.getAlumnos().isEmpty()) {
			boolean eliminado = this.getAlumnos().remove(alumno);
			if (eliminado) {
				System.out.println("Alumno eliminado con exito");
			} else {
				System.out.println("El alumno no existe");
			}

		} else {
			System.out.println("No hay alumnos a eliminar");
		}

	}

	/**
	 * Implementación del método admiteInscripciones de la interface
	 * {@link Administrable} Si la lista de alumnos es nula, lanza una excepció que
	 * la lista no fue inicializada. Devuelve True si la cantidad de alumnos es
	 * menor al cupo, de lo contrario False.
	 */
	@Override
	public boolean admiteInscripciones() {

		if (this.getAlumnos() == null) {
			throw new IllegalStateException("La lista de alumnos no está inicializada");
		}

		return (this.getAlumnos().size() < this.getCupo()) ? true : false;
	}

}
