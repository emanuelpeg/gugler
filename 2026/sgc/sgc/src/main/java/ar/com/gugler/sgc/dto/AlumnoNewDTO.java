package ar.com.gugler.sgc.dto;

import java.util.Date;

public record AlumnoNewDTO(
		String numeroDocumento,
		String legajo,
		String apellido,
		String nombres,
		Date fechaNacimiento,
		String domicilio,
		String telefono,
		String correoElectronico
		) {

}
