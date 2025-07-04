package ar.com.gugler.sgc.modelo;

/**
 * Clase que representa a una Universidad.
 * Esta clase incluye atributos y métodos específicos para una Universidad.
 * 
 * @author Fabrizio Aguilar
 * @version 1.0
 */
public class Universidad {
	
	/**
	 * Método que imprime los datos de un Objeto Persona pasado por parámetro.
	 * Usando los método de Get de Persona, imprime cadenas concatenadas con sus datos.
	 * @param persona Objeto Persona.
	 */
	public static void mostrarDatos(Persona persona) {
		System.out.println("___________________________________");
		System.out.println("- Datos persona -");
		System.out.println("Nombre: "+persona.getNombres());
		System.out.println("Apellido: "+persona.getApellido());
		System.out.println("Numero de documento: "+persona.getNumeroDocumento());
		System.out.println("Fecha de nacimiento: "+persona.getFechaNacimiento());
		System.out.println("Domicilio: "+persona.getDomicilio());
		System.out.println("Telefono: "+persona.getTelefono());
		System.out.println("Correo electronico: "+persona.getCorreoElectronico());
		if (persona instanceof Alumno) {
			Alumno a = (Alumno) persona;
			System.out.println("Legajo: "+a.getLegajo());
		}
		else if(persona instanceof Profesor) {
			Profesor p = (Profesor) persona;
			System.out.println("CUIL: "+p.getCuil());
			System.out.println("Fecha de ingreso: "+p.getFechaIngreso());
		}
		System.out.println("___________________________________");
	}
}
