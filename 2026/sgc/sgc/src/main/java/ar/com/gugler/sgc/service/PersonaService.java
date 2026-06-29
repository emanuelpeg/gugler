package ar.com.gugler.sgc.service;

import java.util.List;
import java.util.Optional;

import ar.com.gugler.sgc.dto.AlumnoDTO;
import ar.com.gugler.sgc.dto.AlumnoNewDTO;

public interface PersonaService {

	AlumnoDTO guardar(AlumnoNewDTO alumnoDTO);

	List<AlumnoDTO> getAllAlumno();

	Optional<AlumnoDTO> getAlumnoBy(Long id);

	Optional<AlumnoDTO> update(AlumnoDTO alumno);
}