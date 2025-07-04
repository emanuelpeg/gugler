package ar.com.gugler.sgc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
/**
 * Representa a una asignatura en el sistema académico.
 * 
 * Esta clase sirve como base para entidades como Curso y Materia. 
 * Contiene atributos comunes como codigo, nombre, lista de alumnos y profesor, 
 * y define la estructura que deben seguir las subclases.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int codigo;
	private String nombre;
	
	@ManyToMany
	@JoinTable(
	        name = "alumno_asignatura",
	        joinColumns = @JoinColumn(name = "asignatura_id"),
	        inverseJoinColumns = @JoinColumn(name = "alumno_id")
	    )
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;
	
	/**
	 * Constructor: Crea una instancia de Asignatura con los datos básicos obligatorios
	 * @param codigo Código de la asignatura
	 * @param nombre Nombre de la asignatura
	 * @param profesor Profesor de la asignatura
	 */
	public Asignatura(int codigo, String nombre, Profesor profesor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.profesor = profesor;

	}
	
	/**
	 * Constructor: vacío 
	 */
	public Asignatura() {

	}
	
	/**
	 * Devuelve el código de la asignatura
	 * @return Código como entero
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Establece el código de la asignatura
	 * @param codigo Código 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Devuelve el nombre de la asignatura
	 * @return Nombre como cadena
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre de la asignatura
	 * @param nombre Nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la lista de alumnos de tipo Alumno de la asignatura
	 * @return Alumnos como Lista de tipo Alumno
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * Establece la lista de alumnos de la asignatura
	 * @param alumnos Alumnos como List de tipo Alumno
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	/**
	 * Devuelve el profesor de la asignatura
	 * @return Profesor como objeto de tipo Profesor
	 */
	public Profesor getProfesor() {
		return profesor;
	}
	
	/**
	 * Establece el profesor de la asignatura
	 * @param profesor como tipo objeto Profesor
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public long getId() {
		return id;
	}

	/**
	 * Devuelve una representación en texto de la asignatura, incluyendo sus datos principales.
	 *
	 * @return Cadena con la información de la asignatura.
	 */
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", alumnos=" + alumnos + ", profesor=" + profesor
				+ "]";
	}
	
	/**
	 * Calcula el código hash para esta asignatura.
	 * 
	 * Este método considera los atributos principales de identidad (alumnos,codigo,nombre,profesor.)
	 *  para garantizar que objetos iguales produzcan el mismo valor hash.
	 *
	 * @return un valor hash entero que representa este objeto.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(alumnos, codigo, nombre, profesor);
	}
	
	/**
	 * Compara esta asinatura con otro objeto para determinar si son iguales.
	 * 
	 * Dos asignaturas se consideran iguales si tienen los mismos valores en los atributos:
	 * alumnos, codigo, nombre, profesor.
	 *
	 * @param obj el objeto con el que se va a comparar.
	 * @return {@code true} si el objeto es una instancia de Asignatura y tiene los mismos valores;
	 *         {@code false} en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(alumnos, other.alumnos) && codigo == other.codigo && Objects.equals(nombre, other.nombre)
				&& Objects.equals(profesor, other.profesor);
	}

}
