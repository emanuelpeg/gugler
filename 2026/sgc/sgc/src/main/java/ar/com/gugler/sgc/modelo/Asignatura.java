package ar.com.gugler.sgc.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String nombre;
	private Integer codigo;

	@ManyToMany
	@JoinTable(name = "asignatura_alumno", joinColumns = @JoinColumn(name = "asignatura_id"), 
	inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private List<Alumno> alumnos;
	
	@ManyToOne
    @JoinColumn(name="profesor_id")
	private Profesor profesores;

	public Asignatura() {
	}

	public Asignatura(Integer codigo, String nombre, Profesor profesores) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.profesores = profesores;
		this.alumnos = new ArrayList<>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Profesor getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesor profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Asignatura (codigo=" + codigo + ", nombre=" + nombre + ", profesores="
				+ (profesores != null ? profesores.getNombres() + " " + profesores.getApellido() : "sin asignar")
				+ ", totalAlumnos=" + alumnos.size() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return this.codigo.equals(other.codigo);
	}

}
