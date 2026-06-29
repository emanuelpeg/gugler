package ar.com.gugler.sgc.dto;

import java.util.Date;

public record AlumnoDTO(
		Long id,
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
