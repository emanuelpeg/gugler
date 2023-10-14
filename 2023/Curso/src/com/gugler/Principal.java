package com.gugler;

public class Principal {

	public static void main(String[] args) {
		var unAlumno = new Alumno(5443255L);
		unAlumno.setNombre("Juan");
		unAlumno.setNota1(80);
		unAlumno.setNota2(70); 
		unAlumno.setNota3(60);
		
		System.out.println(" Alumno : " + unAlumno.getNombre() + " " + unAlumno.promedio());
		
		var otroAlumno = new Alumno(6443255L, "Pedro", 70, 56, 45);
		System.out.println(" Alumno : " + otroAlumno.getNombre() + " " + otroAlumno.promedio());
		
		System.out.println(unAlumno.equals(otroAlumno));
		var unAlumno2 = new Alumno(5443255L);
		System.out.println(unAlumno.equals(unAlumno2));
	}

}
