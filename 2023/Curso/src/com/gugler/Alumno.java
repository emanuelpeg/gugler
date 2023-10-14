package com.gugler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
	
	private long dni;
	
	private String nombre;
	
	private List<Integer> notas = new ArrayList<>();
	
	public Alumno(long dni) {
		this.dni = dni;
	}

	public Alumno(long dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public Alumno(long dni, String nombre, int nota1, int nota2, int nota3) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.notas.add(nota1);
		this.notas.add(nota2);
		this.notas.add(nota3);
	}
	
	public double promedio() {
		return (this.notas.get(0) + this.notas.get(1) + this.notas.get(2)) / 3.0;
	}

	public boolean aprobo() {
		return this.promedio() > 60;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota1() {
		return this.notas.get(0);
	}

	public void setNota1(int nota1) {
		this.notas.add(0, nota1);
	}

	public int getNota2() {
		return this.notas.get(1);
	}

	public void setNota2(int nota2) {
		this.notas.add(1, nota2);
	}

	public int getNota3() {
		return this.notas.get(2);
	}

	public void setNota3(int nota3) {
		this.notas.add(2, nota3);
	}

	public long getDni() {
		return dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return dni == other.dni;
	}	

	
	
}
